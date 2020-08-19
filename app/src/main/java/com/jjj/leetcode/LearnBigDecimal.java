package com.jjj.leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Learn from:
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1279768011997217
 */
public class LearnBigDecimal {
    public static void main(String[] args) {
        System.out.print("ok\n");
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.multiply(bd)); // 15241.55677489
        System.out.print("\n");

        //scale()表示小数位数
        BigDecimal d1 = new BigDecimal("123.45");
        BigDecimal d2 = new BigDecimal("123.4500");
        BigDecimal d3 = new BigDecimal("1234500");
        System.out.println(d1.scale()); // 2,两位小数
        System.out.println(d2.scale()); // 4
        System.out.println(d3.scale()); // 0
        System.out.print("\n");

        //stripTrailingZeros()方法，可以将一个BigDecimal格式化为一个相等的，但去掉了末尾0的BigDecimal
        d1 = new BigDecimal("123.4500");
        d2 = d1.stripTrailingZeros();
        System.out.println(d1.scale()); // 4
        System.out.println(d2.scale()); // 2,因为去掉了00
        System.out.print("\n");

        d3 = new BigDecimal("1234500");
        BigDecimal d4 = d3.stripTrailingZeros();
        System.out.println(d3.scale()); // 0
        System.out.println(d4.scale()); // -2
        System.out.print("\n");

        d1 = new BigDecimal("123.456789");
        d2 = d1.setScale(4, RoundingMode.HALF_UP); // 四舍五入，123.4568
        d3 = d1.setScale(4, RoundingMode.DOWN); // 直接截断，123.4567
        System.out.println(d2);
        System.out.println(d3);
        System.out.print("\n");

        //对BigDecimal做加、减、乘时，精度不会丢失，但是做除法时，存在无法除尽的情况，这时，就必须指定精度以及如何进行截断：
        d1 = new BigDecimal("123.456");
        d2 = new BigDecimal("23.456789");
        d3 = d1.divide(d2, 10, RoundingMode.HALF_UP); // 保留10位小数并四舍五入
        d4 = d1.divide(d2, 0, RoundingMode.DOWN); // 报错：ArithmeticException，因为除不尽
        System.out.println(d3);
        System.out.println(d4);
        System.out.print("\n");

        //做除法的同时求余数：
        BigDecimal n = new BigDecimal("12.345");
        BigDecimal m = new BigDecimal("0.12");
        BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]); // 102
        System.out.println(dr[1]); // 0.105
    }
}
