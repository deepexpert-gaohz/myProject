package com.example.fertilizerManage.util;

import java.util.Random;

/**
 * 系统辅助工具
 *
 * @author hejk
 * @date 2019/3/29 15:28
 */

public class SystemUtils {

    private SystemUtils(){}

    /**
     * 有歧义的验证码
     */
    private static final String CODE_AMBIGUITY = "O0oLl1Ii";

    /**
     * 随机生成验证码
     *
     * @param length
     *         验证码的长度
     *
     * @return
     */
    public static String getRandomCode(int length) {

        StringBuilder sb=new StringBuilder();
        int[] codes = new int[3];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(getChar(random, codes));
        }

        return sb.toString();
    }

    private static char getChar(Random random, int[] codes) {

        int num = random.nextInt(10) + 48;
        int uppercase = random.nextInt(26) + 65;
        int lowercase = random.nextInt(26) + 97;
        codes[0] = num;
        codes[1] = uppercase;
        codes[2] = lowercase;
        char code = (char) codes[random.nextInt(3)];
        if (CODE_AMBIGUITY.contains(code + "")) {
            return getChar(random, codes);
        }
        return code;
    }

    public static String tokenReplace(String token) {

        return token.replaceAll(" ", "+");
    }
}
