package com.lingfeng.camundastudy.common.util;

public class NumberUtils {
    public static boolean isNull(Number number) {
        return number == null;
    }

    public static boolean isNotNull(Number number) {
        return !isNull(number);
    }
}
