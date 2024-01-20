package com.mdx.hubing.utils;

import java.util.Random;

/**
 * Author: Meng
 * Date: 2023-11-23
 * Desc:
 */
public class IdUtils {

//    public static void main(String[] args) {
//        long num = createNewId(5);
//        String code = createCode(6);
//        System.out.println(num);
//        System.out.println(code);
//    }
//    public static long createNewId(int len) {
//        StringBuilder num = new StringBuilder(((int)Math.floor(Math.random() * 9) + 1) + "");
//        for (int i = 0; i < len; i++) {
//            num.append((int) (Math.random() * 10));
//        }
//        return Long.parseLong(num.toString());
//    }

    public static long createNewId(int len) {
        Random ran = new Random();
        int one = ran.nextInt(10);
        StringBuilder num = new StringBuilder();
        num.append(one > 0 ? one : 1);
        for (int i = 0; i < len; i++) {
            num.append(ran.nextInt(10));
        }
        return Long.parseLong(num.toString());
    }

    public static int createIntId(int len) {
        Random ran = new Random();
        int one = ran.nextInt(10);
        StringBuilder num = new StringBuilder();
        num.append(one > 0 ? one : 1);
        for (int i = 0; i < len; i++) {
            num.append(ran.nextInt(10));
        }
        return Integer.parseInt(num.toString());
    }

    public static String createCode(int len) {
        StringBuilder num = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < len; i++) {
            num.append(ran.nextInt(10));
        }
        return num.toString();
    }
}
