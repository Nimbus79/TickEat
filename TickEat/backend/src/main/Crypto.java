package main;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;



public class Crypto {

    public static KeyStore loadKeyStore(String password, String path) {
        char[] keyStorePassword = password.toCharArray();
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance("JCEKS");
            if (path.equals("")) {
                keyStore.load(null, keyStorePassword);
            }
            else {
                InputStream keyStoreData = new FileInputStream(path);
                keyStore.load(keyStoreData, keyStorePassword);
            }
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return keyStore;
    }

    public static KeyStore createSecretKey(String password, KeyStore keyStore, String alias) {
        char[] keyPassword = password.toCharArray();
        KeyGenerator keyGen = null;
        try {
            keyGen = KeyGenerator.getInstance("AES");
            SecureRandom secRandom = new SecureRandom();
            keyGen.init(secRandom);
            SecretKey secretKey = keyGen.generateKey();
            KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
            KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(keyPassword);
            keyStore.setEntry(alias , secretKeyEntry, entryPassword);
        } catch (NoSuchAlgorithmException | KeyStoreException e) {
            e.printStackTrace();
        }

        return keyStore;
    }

    public static SecretKey getSecretKey(String password, KeyStore keyStore, String alias) {
        char[] keyPassword = password.toCharArray();
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(keyPassword);
        KeyStore.SecretKeyEntry secretKeyEntry = null;
        try {
            secretKeyEntry = (KeyStore.SecretKeyEntry) keyStore.getEntry(alias, entryPassword);
        } catch (NoSuchAlgorithmException | UnrecoverableEntryException | KeyStoreException e) {
            e.printStackTrace();
        }
        SecretKey secretKey = secretKeyEntry.getSecretKey();
        return secretKey;
    }

    public static String encrypt(SecretKey secretKey, String text) {
        Cipher cipher = null;
        String encryptedText = null;
        try {
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(new byte[16]);
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] plainText  = text.getBytes("UTF-8");
            byte[] cipherText = cipher.doFinal(plainText);
            encryptedText = Base64.encodeBase64String(cipherText);
        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | InvalidKeyException | UnsupportedEncodingException | BadPaddingException | NoSuchPaddingException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return encryptedText;
    }

    public static String decrypt(SecretKey secretKey, String text) {
        Cipher cipher = null;
        String encryptedText = null;
        try {
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(new byte[16]);
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
            byte[] plainText  = Base64.decodeBase64(text);
            byte[] cipherText = cipher.doFinal(plainText);
            encryptedText = new String(cipherText);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return encryptedText;
    }

    public static void pairGenerator() {
        KeyPairGenerator kpg = null;
        try {
            kpg = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        kpg.initialize(1024);
        KeyPair kp = kpg.generateKeyPair();

        Key pub = kp.getPublic();
        Key pvt = kp.getPrivate();

        FileOutputStream out;

        try {
            out = new FileOutputStream("data/private.key");
            out.write(pvt.getEncoded());
            out.close();

            out = new FileOutputStream("data/public.pub");
            out.write(pub.getEncoded());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static PrivateKey loadPrivateKey() {
        Path path = Paths.get("../../TickEat/backend/data/private.key");
        byte[] bytes = new byte[0];

        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
        KeyFactory kf = null;

        try {
            kf = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        PrivateKey pvt = null;

        try {
            pvt = kf.generatePrivate(ks);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return pvt;
    }

    public static PublicKey loadPublicKey() {
        Path path = Paths.get("../../TickEat/backend/data/public.pub");
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        X509EncodedKeySpec ks = new X509EncodedKeySpec(bytes);
        KeyFactory kf = null;
        try {
            kf = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        PublicKey pub = null;
        try {
            pub = kf.generatePublic(ks);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return pub;
    }

    public static byte[] encryptTokenString(String token) {
        String key = "mZq4t7w!z%C&F)J@";
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = null;
        byte[] encrypted = null;

        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            encrypted = cipher.doFinal(token.getBytes());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return encrypted;
    }

    public static String decryptTokenString(byte[] encrypted) {
        String key = "mZq4t7w!z%C&F)J@";
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = null;
        String decrypted = null;

        try {
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            decrypted = new String(cipher.doFinal(encrypted));
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return decrypted;
    }


    // Runs only one time to generate the keystore
    /*public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, IOException, CertificateException {
        // Load keystore
        KeyStore keyStore = loadKeyStore("tickeat-pei-1920","");
        // Create QR Code secret key
        keyStore = createSecretKey("62798789106115117129", keyStore, "MNBJFBFK");

        char[] keyStorePassword = "tickeat-pei-1920".toCharArray();
        FileOutputStream keyStoreOutputStream = new FileOutputStream("data/keystore.ks");
        keyStore.store(keyStoreOutputStream, keyStorePassword);
    }*/
}
