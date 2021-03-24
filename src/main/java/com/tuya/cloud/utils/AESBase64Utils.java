package com.tuya.cloud.utils;

import org.apache.pulsar.shade.org.apache.commons.codec.binary.Base64;
import org.apache.pulsar.shade.org.apache.commons.codec.binary.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class AESBase64Utils {

    private static final String AES = "AES";

    // the encryption algorithm
    private String ALGO;

    // The 16-bit encryption key
    private byte[] keyValue;

    /**
     * The operation used to encrypt
     *
     * @param data
     * @return
     * @throws Exception
     */
    public String encrypt(String data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(StringUtils.getBytesUtf8(data));
        String encryptedValue = Base64.encodeBase64String(encVal);
        return encryptedValue;
    }

    /**
     * The operation used to perform decryption
     *
     * @param encryptedData
     * @return
     * @throws Exception
     */
    public String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.decodeBase64(encryptedData);
        byte[] decValue = c.doFinal(decodedValue);
        String decryptedValue = StringUtils.newStringUtf8(decValue);
        return decryptedValue;
    }

    /**
     * Generate the Key based on the Key and algorithm
     *
     * @return
     * @throws Exception
     */
    private Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }

    public String getALGO() {
        return ALGO;
    }

    public void setALGO(String aLGO) {
        ALGO = aLGO;
    }

    public byte[] getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(byte[] keyValue) {
        this.keyValue = keyValue;
    }

    public static String decrypt(String data, String secretKey) throws Exception {
        // Create encryption and decryption
        AESBase64Utils aes = new AESBase64Utils();
        // Set the encryption and decryption algorithm
        aes.setALGO(AES);
        // Set the encryption and decryption key
        aes.setKeyValue(secretKey.getBytes());
        // The decrypted string
        return aes.decrypt(data);
    }

    public static String encrypt(String data, String secretKey) throws Exception {
        // Create encryption and decryption
        AESBase64Utils aes = new AESBase64Utils();
        // Set the encryption and decryption algorithm
        aes.setALGO(AES);
        // Set the encryption and decryption key
        aes.setKeyValue(secretKey.getBytes());
        // The decrypted string
        return aes.encrypt(data);
    }

}
