package com.mono40.controller;

import com.mono40.domain.Account;
import com.mono40.domain.*;
import com.mono40.exception.*;
import com.mono40.repository.*;
import com.mono40.types.*;
import com.mono40.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * Created by yarielinfante on 10/27/16.
 */
@RestController
@RequestMapping("/signup")
public class SignUpController {

    private static Logger logger = LogManager.getLogger(SignUpController.class);

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private PasswordStorage passwordStorage;

    @Autowired
    private JwtManager jwtManager;


    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity signUp(@RequestHeader(required = false, name = "version") String clientVersion,
                                 @RequestHeader(required = false, name = "os") String os,
                                 @RequestHeader(required = false, name = "device-token") String deviceToken,
                                 @RequestBody SignUpDTO signUpDTO) throws NeoAPIException {
        logger.info("Entering in signUp");
        logger.info("clientVersion "+clientVersion);
        logger.info("os "+os);
        logger.info("deviceToken "+deviceToken);
        logger.info("signUpDTO "+signUpDTO);

        try {

            logger.info("Validate general value...");
            //validateSignUpDTO(signUpDTO, os);
            logger.info("Validate general value...end");




            Account accountFound = accountRepository.findByEmail(signUpDTO.getEmail());

            if (accountFound != null) {
                throw new EmailExistsException(signUpDTO);
            }

            String hash = passwordStorage.createHash(signUpDTO.getPassword());

            Account account = new Account();
            //Device device = new Device();
            //Beneficiary beneficiary = new Beneficiary();

            account.setPassword(hash);

            SignUpUtil.setEntitiesProfile(signUpDTO,account);

            accountRepository.save(account);
            logger.info("account saved");

            //beneficiaryRepository.save(beneficiary);
            logger.info("own beneficiary saved");

            signUpDTO.setId(account.getId());
            signUpDTO.setPassword("*************************");
            signUpDTO.setPin("****");


            //device.setDateCreationDevice(new Date());

            logger.info("save device...");
            //deviceRepository.save(device);
            logger.info("save device...end");

            logger.info("save history device...");
           // deviceHistoryByMsisdn.save(new DeviceHistoryByMsisdn().deviceHistoryByMsisdn(device));
            logger.info("save history device...end");

            //mailSenderService.sendWelcomeEmail(account);

            String generatedToken = jwtManager.generateToken(account.getId());

            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).header("token", generatedToken).body(signUpDTO);

        } catch (Throwable e) {
            throw new NeoAPIException(e, signUpDTO);
        }
    }

    /**
     * Use this method to request a sms activation code.
     *
     * @param msisdn msisdn to send the sms to.
     * @return a ResponseEntity with an HTTP 200 status.
     */
    @GetMapping("/activation-code")
    public ResponseEntity requestActivationCode(@RequestParam(name = "msisdn") Long msisdn) {

        // logger.debug("sending activation code");
        // smsSenderService.sendActivationCodeSMS(msisdn);

        return ResponseEntity.ok().build();
    }


    @PostMapping("/verify-activation-code")
    public ResponseEntity verifyActivationCode(@RequestBody MsisdnActivationCode msisdnActivationCode) throws ActivationCodeIncorrectException {

        logger.debug("verifying activation code : " + msisdnActivationCode);
        //MsisdnActivationCode foundOne = msisdnActivationCodeRepository.findByMsisdn(msisdnActivationCode.getMsisdn());

        //  logger.info("foundOne "+ foundOne );

        //  if (foundOne == null) {
        //   logger.debug("msisdn not found");
        //   throw new ActivationCodeIncorrectException();
        //  }

        //   if (!foundOne.getActivationCode().equals(msisdnActivationCode.getActivationCode())) {
        //    logger.debug("invalid activation code");
        //     throw new ActivationCodeIncorrectException();
        // }

        //    int timeExpirationTime = applicationProperties.getTimeExpirationOtp();

        //  logger.info("Time expiration allow = "+ timeExpirationTime);
        //  long maxDurationOtpMilliSecond = MILLISECONDS.convert(timeExpirationTime, MINUTES);

        //  Date timeNow = new Date();

        //   long durationOtp =timeNow.getTime() - foundOne.getDateCreationOtp().getTime();

        //  if (durationOtp >= maxDurationOtpMilliSecond) {
        //   logger.info("otp was expired");
        //      throw new ActivationCodeIncorrectException();
        // }

        //   if (foundOne.isOtpValid()) {
        //    logger.info("the OTP was used in cellphone"+foundOne.getMsisdn());
        //      throw new ActivationCodeIncorrectException();
        //   }

        //   logger.debug("activation code success");

        //   foundOne.setOtpValid(true);
        //   foundOne.setValidUserDateOtp(new Date());
        //   foundOne.setVerifiedSignUp(false);
        //   msisdnActivationCodeRepository.save(foundOne);

        return ResponseEntity.ok().build();
    }
}
