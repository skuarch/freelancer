package model.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author skuarch
 */
public class MD5Util {

    //==========================================================================
    private MD5Util() {
    }

    //==========================================================================
    public static String getHash(String text) {

        if(text == null || text.length() < 1){
            throw new NullPointerException("text is null");
        }
        
        MessageDigest m = null;
        String hashtext = null;
        BigInteger bigInt = null;
        byte[] digest = null;
        
        try {
            
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(text.getBytes());
            digest = m.digest();
            bigInt = new BigInteger(1, digest);
            hashtext = bigInt.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            
        } catch (Exception e) {
            hashtext = null;
        }
        
        return hashtext;

    }

}
