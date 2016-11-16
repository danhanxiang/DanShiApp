package com.danshi.danhanxinag.utils;

/**
 * Created by 20939 on 2016/11/16.
 */
public class TimeUtil {
    public static String getDateBySplit(String str) {
        String[] strings = str.split(" ");
        return strings[0];
    }
}
