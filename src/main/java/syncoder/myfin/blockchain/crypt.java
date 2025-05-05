package syncoder.myfin.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class crypt {
//    public static String sha256(String input)
//    {
//        try {
//            MessageDigest sha
//                    = MessageDigest
//                    .getInstance(
//                            "SHA-256");
//            int i = 0;
//
//            byte[] hash
//                    = sha.digest(
//                    input.getBytes(StandardCharsets.UTF_8));
//            StringBuilder hexHash
//                    = new StringBuilder();
//
//            while (i < hash.length) {
//                String hex
//                        = Integer.toHexString(
//                        0xff & hash[i]);
//                if (hex.length() == 1)
//                    hexHash.append('0');
//                hexHash.append(hex);
//                i++;
//            }
//
//            return hexHash.toString();
//        }
//        catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
public static String sha256(String input) {
    try {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] hash = sha.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexHash = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexHash.append('0');
            hexHash.append(hex);
        }

        return hexHash.toString();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}