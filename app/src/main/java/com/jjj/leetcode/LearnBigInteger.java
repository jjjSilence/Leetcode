package com.jjj.leetcode;

import java.math.BigInteger;

/**
 * Learn from:
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1279767986831393
 */
public class LearnBigInteger {
    public static void main(String[] args) {
        System.out.print("ok\n");
        BigInteger bigInteger = new BigInteger("199999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
        bigInteger = bigInteger.add(new BigInteger("1"));
        System.out.println(bigInteger.toString());

        BigInteger n = new BigInteger("999999").pow(99);
        float f = n.floatValue();
        System.out.println(f);
    }
}
