/*****************************************************************************************************************
 * JTRCryptoSuite.java                                                                               			 *
 * Initial Version                                                                                               *
 *****************************************************************************************************************
 * John The Ripper Cryptograpghy Suite                                                                           *
 * (c) 2019 Composite Computing Company                                                                          *
 *****************************************************************************************************************
 * Created By: Matt Ferlaino                                                                                     *
 * Date:       Dec, 3rd 2019                                                                                     *
 *****************************************************************************************************************/

// Packages
package Entities;

// Imports
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class JTRCryptoSuite {
    // Variables
    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static Cipher jonnysCipher;

    // No-arg Constructor
    public JTRCryptoSuite (String masterKey) {
        // Setup
        MessageDigest sha = null;

        try {
            // Instantiate
            jonnysCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            key = masterKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");

            // Generate key
            secretKey = new SecretKeySpec(Arrays.copyOf(sha.digest(key), 16), "AES");
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * --- JTRCryptoSuite Methods ---
     * 1. JTREncrypt()
     * 2. JTRDecrypt()
     */

    // JTREncrypt()
    public String JTREncrypt(String plainText) {
        try {
            // Set mode
            jonnysCipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt
            return Base64.getEncoder().encodeToString(jonnysCipher.doFinal(plainText.getBytes("UTF-8"))).toString();
        }

        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    // JTRDecrypt()
    public String JTRDecrypt(String encryptedText) {
        try {
            // Set Mode
            jonnysCipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Decrypt
            return new String(jonnysCipher.doFinal(Base64.getDecoder().decode(encryptedText)));
        }

        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
