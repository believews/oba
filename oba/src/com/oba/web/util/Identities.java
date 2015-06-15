package com.oba.web.util;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * @author keke
 *
 */
public class Identities {

    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间有-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid2() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 使用SecureRandom随机生成经销商账户流水表订单号  yzp 2013年3月14日15:00:23
     */
    public static long randOwnerFundsOrderNumber () {
        return Math.abs(random.nextLong());
    }
    
    
    /**
     * 使用SecureRandom随机生成Long.
     */
    public static long randomLong() {
        return Math.abs(random.nextLong());
    }

}
