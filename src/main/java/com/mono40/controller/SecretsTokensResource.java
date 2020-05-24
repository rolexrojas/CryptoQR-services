package com.mono40.controller;

import com.mono40.component.EncryptionComponent;
import com.mono40.domain.CarServiceInformation;
import com.mono40.domain.Maintenance;
import com.mono40.util.CryptoQrUtil;
import com.mono40.util.JwtManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static com.mono40.util.ConstantsUtil.*;
import com.mono40.types.*;

@RestController
@RequestMapping("/secrets")
public class SecretsTokensResource {

    private Logger logger = LogManager.getLogger(SecretsTokensResource.class);

    @Autowired
    private EncryptionComponent encryptionComponent;

    @Autowired
    private JwtManager jwtManager;

    @GetMapping
    public ResponseEntity getSecrets(){
        logger.info("Entering in getSecrets");
        SecretKeySpec secretKey = encryptionComponent.getSecretKey();
        String responsePrivateKey = CryptoQrUtil.encodedToBase64(secretKey.getEncoded());
        logger.info("Exiting in getSecrets...");
        return ResponseEntity.ok(new SecretsResponseType(responsePrivateKey));
    }

    @PostMapping(value = "/tokens/customers/encrypt")
    public ResponseEntity tokensCustomersEncrypt(@RequestHeader("Authorization") String token) throws Exception {
        logger.info("Entering in tokensCustomersEncrypt");
        Long msisdn = 8492656223L;
        logger.info("msisdn : "+ msisdn);
        String jwtCustomer =  jwtManager.generateJWTQr(JWT_TYPE.JWT_CUSTOMER,msisdn.toString());
        try {
            logger.info("beginning  encrypt customer");
            String jwtEncryp = encryptionComponent.encrypt(jwtCustomer);
            jwtEncryp = String.format("type=%s;data=%s", TRANSFER_TPAGO_CUSTOMER_CODE ,jwtEncryp);
            return ResponseEntity.ok(new TokensCustomersEncryptResponse(jwtEncryp));
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException e) {
            logger.error("error in tokensCustomersEncrypt" + e);
            throw new Exception();
        }
    }

}
