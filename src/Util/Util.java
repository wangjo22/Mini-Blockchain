package Util;

import java.security.MessageDigest;

public class Util {
    public static String getHash(String input) {
        StringBuffer result = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(input.getBytes());
            byte bytes[] = md.digest();

            // This is a process converting input to byte using SHA-256 and converting them to string
            for(int i = 0; i < bytes.length; ++i) {
                result.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
