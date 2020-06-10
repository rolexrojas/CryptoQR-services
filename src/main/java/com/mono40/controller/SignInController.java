package com.mono40.controller;

import com.mono40.domain.MsisdnActivationCode;
import com.mono40.exception.*;
import com.mono40.domain.Account;
import com.mono40.types.*;
import com.mono40.repository.IAccountRepository;
import com.mono40.service.ISignInService;
import com.mono40.util.JwtManager;
import com.mono40.util.KeyPairManager;
import com.mono40.util.PasswordStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by yarielinfante on 10/27/16.
 */
@RestController
@RequestMapping("/signin")
public class SignInController {

    private Logger logger = LogManager.getLogger(SignInController.class);


    @Autowired
    private PasswordStorage passwordStorage;

    @Autowired
    private JwtManager jwtManager;


    @Autowired
    private KeyPairManager keyPairManager;

    @Autowired
    private ISignInService signInService;

    @Autowired
    private IAccountRepository accountRepository;





    @PostMapping
    public ResponseEntity signIn(@RequestBody SignInDTO signInDTO) throws NeoAPIException {

       /* logger.info("Entering in signIn ");
        logger.info("clientVersion "+clientVersion);
        logger.info("os "+os);
        logger.info("deviceToken "+deviceToken);*/
        logger.info("signInDTO "+signInDTO);

        try {

           // if(signInDTO.getDeviceInformationType() == null){
             //   DeviceInformationType deviceInformation =  new DeviceInformationType();
             //   deviceInformation.setImei(signInDTO.getImei());
            //   signInDTO.setDeviceInformationType(deviceInformation);
           // }

            //validateVersionByClientOSComponent.validateVersionByClientOS(
               //     new ValidateVersionInformationObjectDTO(signInDTO,null,null,new HeaderValuesDTO(os,clientVersion,deviceToken)));

            //logger.info("Search otp valided for number "+signInDTO.getMsisdn());
            MsisdnActivationCode otpByMsisdn = new MsisdnActivationCode();
            otpByMsisdn.setOtpValid(true);
            otpByMsisdn.setDateCreationOtp(new Date());
            otpByMsisdn.setVerifiedSignUp(true);
            otpByMsisdn.setVerifiedSignUpDate(new Date());
                    //msisdnActivationCodeRepository.findByMsisdnAndOtpValid(signInDTO.getMsisdn(),true);

            logger.info("Search otp valided for number....end search.");

            logger.info("otp find by number "+otpByMsisdn);

            logger.info("otpByMsisdn"+otpByMsisdn);
            logger.info("validating otp in sign in for cellphone..."+otpByMsisdn);
            if(otpByMsisdn == null){
                logger.info("validating otp not working. It was used in other cellphone or never used process the OTP...");
                throw new NeoAPIException();
            }
            logger.info("Valided otp end");
            Account accountFound = accountRepository.findByUserNameIgnoreCase(signInDTO.getUsername());

            if (accountFound == null) {

                accountFound = accountRepository.findByEmail(signInDTO.getUsername());

                if(accountFound == null) {
                    logger.debug("not found: " + signInDTO.getUsername());
                    throw new InvalidUserException();
                }
            }

            if (!accountFound.isActive())
                throw new AccountUserInactiveException();

            //CustomerDetail customerDetail = customerInfoService.getCustomerStatus(signInDTO.getMsisdn());

            //logger.debug("validating msisdn status : {}", customerDetail);

            boolean success = passwordStorage.verifyPassword(signInDTO.getPassword(), accountFound.getPassword());

            logger.debug("valid password : " + success);

            success = true;
            if (success) {
                // if (validateDevice.validateDevice(new ValidateDeviceByMsisdnType(signInDTO.getMsisdn().toString(),
                //     signInDTO.getDeviceInformationType(),activeDevice,deviceToken,os,null,true,null))) {

                String generatedToken = jwtManager.generateToken(accountFound.getId());

                SignUpDTO signUpDTO = signInService.createSignUpDTO(accountFound);

                //signInService.updateValidUserAuthentication(accountFound, activeDevice);

                logger.debug("logged in :" + signInDTO);

                return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).header("token", generatedToken).body(signUpDTO);

                // } else {
                // throw new AnotherDeviceLinkedException(signInDTO);
                // }
            } else {
                signInService.updateInvalidUserAuthentication(accountFound);
            }

        } catch (Throwable e) {
            throw new NeoAPIException(e, signInDTO);
        }

        return ResponseEntity.badRequest().build();

    }
/*
    @PostMapping("/fingerprint")
    public ResponseEntity fingerPrintSignIn(@RequestBody TokenModel tokenModel) throws NeoAPIException {

        try {

          //  CustomerDetail customerDetail = customerInfoService.getCustomerStatus(tokenModel.getMsisdn());

          //  logger.debug("validating msisdn status : {}", customerDetail);

            logger.debug("sign in using fingerprint");

            AccountPublicKey accountPublicKey = accountPublicKeyRepository.findByAccount(new Account(tokenModel.getAccountId()));

            PublicKey publicKey = keyPairManager.readPublicKey(DatatypeConverter.parseBase64Binary(accountPublicKey.getPublicKey()));

            String jwtPayLoad = jwtManager.generateJwtPayload(tokenModel.getAccountId());

            boolean verified = keyPairManager.verifySignature(jwtPayLoad.getBytes(), publicKey, DatatypeConverter.parseBase64Binary(tokenModel.getPublicKey()));

            logger.debug("verified :" + verified);

            if (verified) {

                String token = jwtManager.generateToken(tokenModel.getAccountId());
                Account accountFound = accountRepository.findOne(tokenModel.getAccountId());

                SignUpDTO signUpDTO = signInService.createSignUpDTO(accountFound);

                signInService.updateValidUserAuthentication(accountFound);

                logger.debug("logged in: " + signUpDTO);

                return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).header("token", token).body(signUpDTO);

            } else {
                throw new NeoAPIException(tokenModel);
            }

        } catch (Exception e) {
            throw new NeoAPIException(e);
        }
    }*/
}
