package com.mono40.controller;

import com.mono40.component.EncryptionComponent;
import com.mono40.domain.AccountEventInsurance;
import com.mono40.domain.CarServiceInformation;
import com.mono40.domain.CrashRepair;
import com.mono40.domain.Maintenance;
import com.mono40.repository.IAccountEventRepository;
import com.mono40.repository.ICarServiceInformation;
import com.mono40.repository.IMaintenance;
import com.mono40.types.TokenMerchantEncryptRequest;
import com.mono40.types.TokensCustomersEncryptResponse;
import com.mono40.util.ConstantsUtil;
import com.mono40.util.JwtManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import static com.mono40.util.ConstantsUtil.CRASHR_OUT;
import static com.mono40.util.ConstantsUtil.MAINTENANCE_OUT;

@RestController
@RequestMapping("/serviceReport")
public class ServiceReportController {

    private Logger logger = LogManager.getLogger(ServiceReportController.class);

    @Autowired
    private JwtManager jwtManager;

    @Autowired
    private EncryptionComponent encryptionComponent;

    @Autowired
    private ICarServiceInformation carServiceInformationRepository;

    @Autowired
    private IMaintenance maintenanceRepository;

    @Autowired
    private IAccountEventRepository accountEventRepository;

    @PostMapping(value = "maintenance/encrypt")
    public ResponseEntity reportMaintenanceEncrypt(@RequestHeader("Authorization") String token, @RequestHeader("insuranceNo") String insuranceNo, @RequestHeader("model") String model, @RequestHeader("make") String make,@RequestHeader("year") String year,@RequestHeader("miles") String miles, @RequestBody Maintenance maintenance) throws Exception {
        String eventKey = UUID.randomUUID().toString();
        logger.info("Entering in reportMaintenanceEncrypt");
        CarServiceInformation carServiceInformation = new CarServiceInformation(eventKey, miles, year, make, model, insuranceNo);
        maintenance.setEventKey(eventKey);
        Long accountId = jwtManager.parseTokenToModel(token).getAccountId();
        logger.info("idCuenta : "+ accountId);

        CarServiceInformation serviceInformation = carServiceInformationRepository.save(carServiceInformation);
        maintenanceRepository.save(maintenance);

        AccountEventInsurance aInsurance = new AccountEventInsurance(carServiceInformation.getInsuranceNo(), accountId, eventKey);
        accountEventRepository.save(aInsurance);

        /**
         * Entrare en este punto y almacenare en base de datos data que llega del mantenimiento
         * */

        String jwtCustomer =  JwtManager.generateJwtPayloadQR(ConstantsUtil.JWT_TYPE.JWT_MAINTENANCE, accountId.toString(), serviceInformation, maintenance, eventKey);

        try {
            logger.info("beginning  encrypt");
            String jwtEncryp = encryptionComponent.encrypt(jwtCustomer);
            jwtEncryp = String.format("type=%s;data=%s", MAINTENANCE_OUT ,jwtEncryp);
            return ResponseEntity.ok(new TokensCustomersEncryptResponse(jwtEncryp));
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
            logger.error("error in reportMaintenanceEncrypt" + e);
            throw new Exception();
        }
    }



    @PostMapping(value = "crashrepair/encrypt")
    public ResponseEntity reportCrashRepairEncrypt(@RequestHeader("Authorization") String token, @RequestHeader CarServiceInformation carServiceInformation, @RequestBody CrashRepair crashRepair) throws Exception {
        logger.info("Entering in reportCrashRepairEncrypt");
        Long accountId = jwtManager.parseTokenToModel(token).getAccountId();
        logger.info("idCuenta : "+ accountId);
        String jwtMerchant =  jwtManager.generateJWTQr(ConstantsUtil.JWT_TYPE.JWT_ACCIDENT,accountId.toString());
        try {
            logger.info("beginning  encrypt merchant");
            String encriptJwtToken = encryptionComponent.encrypt(jwtMerchant);
            encriptJwtToken = String.format("type=%s;data=%s", CRASHR_OUT ,encriptJwtToken);
            return ResponseEntity.ok(new TokensCustomersEncryptResponse(encriptJwtToken));
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
            logger.error("error in tokensCustomersEncrypt" + e);
            throw new Exception();
        }
    }

}
