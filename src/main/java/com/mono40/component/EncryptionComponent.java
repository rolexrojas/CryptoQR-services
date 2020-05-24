package com.mono40.component;

import com.mono40.config.ApplicationProperties;
import com.mono40.util.ConstantsUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.*;
import java.security.cert.CertificateException;

import static com.mono40.util.ConstantsUtil.AES;
import static com.mono40.util.ConstantsUtil.ENCRYPTION_ALGORITHM_JWT_QR;

@Component
public class EncryptionComponent {

    @Autowired
    private ApplicationProperties applicationProperties;

    private SecretKeySpec secretKey;

    @PostConstruct
    private void postConstruct() throws NoSuchAlgorithmException, KeyStoreException,CertificateException, IOException, UnrecoverableKeyException  {
        this.secretKey = loadSecretKey();
    }

    public String encrypt(String textEncryp) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[12];
        secureRandom.nextBytes(iv);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM_JWT_QR);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.ENCRYPT_MODE, this.secretKey, parameterSpec);
        byte [] encryptedData = cipher.doFinal(textEncryp.getBytes());
        ByteBuffer byteBuffer = ByteBuffer.allocate(4 + iv.length + encryptedData.length);
        byteBuffer.putInt(iv.length);
        byteBuffer.put(iv);
        byteBuffer.put(encryptedData);
        byte[] resultBytes =  byteBuffer.array();
        return Base64.encodeBase64String(resultBytes);
    }

    public SecretKeySpec getSecretKey() {
        return secretKey;
    }

    public SecretKeySpec loadSecretKey() throws KeyStoreException , NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException {
       KeyStore ks = KeyStore.getInstance(ConstantsUtil.KEY_STORE_TYPE);
       ks.load(new FileInputStream(applicationProperties.getKeyStoreLocation()),applicationProperties.getKeyStorePassword().toCharArray() );
       Key keyLoad = ks.getKey(applicationProperties.getSecretKeyAlias(), applicationProperties.getKeyStorePassword().toCharArray());
       return new SecretKeySpec(keyLoad.getEncoded(), AES);
    }

}
