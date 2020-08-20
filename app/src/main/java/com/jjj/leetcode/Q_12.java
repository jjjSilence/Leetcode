package com.jjj.leetcode;

public class Q_12 {
    public static void main(String[] args) {
        System.out.print("ok\n");

        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            if (num >= 1000) {
                stringBuilder.append("M");
                num -= 1000;
            } else if (num >= 100) {
                if (num >= 900) {
                    stringBuilder.append("CM");
                    num -= 900;
                } else if (num >= 500) {
                    stringBuilder.append("D");
                    num -= 500;
                } else if (num >= 400) {
                    stringBuilder.append("CD");
                    num -= 400;
                } else {
                    stringBuilder.append("C");
                    num -= 100;
                }
            } else if (num >= 10) {
                if (num >= 90) {
                    stringBuilder.append("XC");
                    num -= 90;
                } else if (num >= 50) {
                    stringBuilder.append("L");
                    num -= 50;
                } else if (num >= 40) {
                    stringBuilder.append("XL");
                    num -= 40;
                } else {
                    stringBuilder.append("X");
                    num -= 10;
                }
            } else {
                if (num >= 9) {
                    stringBuilder.append("IX");
                    num -= 9;
                } else if (num >= 5) {
                    stringBuilder.append("V");
                    num -= 5;
                } else if (num >= 4) {
                    stringBuilder.append("IV");
                    num -= 4;
                } else if (num == 3) {
                    stringBuilder.append("III");
                    num -= 3;
                } else if (num == 2) {
                    stringBuilder.append("II");
                    num -= 2;
                } else if (num == 1) {
                    stringBuilder.append("I");
                    num -= 1;
                }
            }
        }
        return stringBuilder.toString();
    }
}
