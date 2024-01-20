package com.mdx.hubing.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Author: Meng
 * Date: 2023-04-07
 * Desc:
 */
public class TokenUtils {
    // 转换模式
    private static final String transformation = "AES";
    private static final String ENCODE_KEY = "wklsFO6enUdNhdgorFV/rjPK1dJexTHZJS897ptoOi0=";

//    public static void main(String[] strs) {
//
//        try {
//            String str = createToken(12313, "awdasdadsa");
//            parseToken(str);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static String createToken(int id, String account) {
        String token = null;

        String str = String.format("%d_%s", id, account);
        try {
            // 实例化密码对象
            Cipher cipher = Cipher.getInstance(transformation);
            SecretKeySpec secretKeySpec = new SecretKeySpec(ENCODE_KEY.getBytes(), transformation);
            // 设置模式（ENCRYPT_MODE：加密模式；DECRYPT_MODE：解密模式）和指定秘钥
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            // 加密
            byte[] encrypt = cipher.doFinal(str.getBytes());
            System.out.println("AES加密结果：" + Base64.getEncoder().encodeToString(encrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public static String parseToken(String token) {
        try {
            // 实例化密码对象
            Cipher cipher = Cipher.getInstance(transformation);
            SecretKeySpec secretKeySpec = new SecretKeySpec(ENCODE_KEY.getBytes(), transformation);
            // 设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decrypt = cipher.doFinal(token.getBytes());
            System.out.println("AES解密结果：" + new String(decrypt));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

}
