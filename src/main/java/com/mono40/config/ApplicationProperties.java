package com.mono40.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yinfante on 11/16/17.
 * <p>
 * Application scope config properties
 */
@Component
public class ApplicationProperties {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${time.expiration.token.minute}")
    private int timeExpirationToken;

    @Value("${neo.qr.jwt.sign.algorithm}")
    private String jwtQrAlgorithmSign;

    @Value("${neo.qr.jwt.sign.key.size}")
    private String jwtQrAlgorithmSizeSign;

    @Value("${neo.qr.jwt.sign.key}")
    private String jwtQrSignKey;

    @Value("${neo.qr.key.store.password}")
    private String keyStorePassword;

    @Value("${neo.qr.secret.key.password}")
    private String secretKeyPassword;

    @Value("${neo.qr.secret.key.alias}")
    private String secretKeyAlias;

    @Value("${neo.qr.secret.key.location}")
    private String keyStoreLocation;

    @Value("${time.expiration.token.minute.qr}")
    private int timeExpirationTokenQr;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }


    public int getTimeExpirationToken() {
        return timeExpirationToken;
    }

    public void setTimeExpirationToken(int timeExpirationToken) {
        this.timeExpirationToken = timeExpirationToken;
    }

    public String getJwtQrAlgorithmSign() {
        return jwtQrAlgorithmSign;
    }

    public void setJwtQrAlgorithmSign(String jwtQrAlgorithmSign) {
        this.jwtQrAlgorithmSign = jwtQrAlgorithmSign;
    }

    public String getJwtQrAlgorithmSizeSign() {
        return jwtQrAlgorithmSizeSign;
    }

    public void setJwtQrAlgorithmSizeSign(String jwtQrAlgorithmSizeSign) {
        this.jwtQrAlgorithmSizeSign = jwtQrAlgorithmSizeSign;
    }

    public String getJwtQrSignKey() {
        return jwtQrSignKey;
    }

    public void setJwtQrSignKey(String jwtQrSignKey) {
        this.jwtQrSignKey = jwtQrSignKey;
    }

    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }

    public String getSecretKeyPassword() {
        return secretKeyPassword;
    }

    public void setSecretKeyPassword(String secretKeyPassword) {
        this.secretKeyPassword = secretKeyPassword;
    }

    public String getSecretKeyAlias() {
        return secretKeyAlias;
    }

    public void setSecretKeyAlias(String secretKeyAlias) {
        this.secretKeyAlias = secretKeyAlias;
    }

    public String getKeyStoreLocation() {
        return keyStoreLocation;
    }

    public void setKeyStoreLocation(String keyStoreLocation) {
        this.keyStoreLocation = keyStoreLocation;
    }

    public int getTimeExpirationTokenQr() {
        return timeExpirationTokenQr;
    }

    public void setTimeExpirationTokenQr(int timeExpirationTokenQr) {
        this.timeExpirationTokenQr = timeExpirationTokenQr;
    }
}
