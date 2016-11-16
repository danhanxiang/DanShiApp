package com.danshi.danhanxinag.utils;

/**
 * Created by JDD on 2016/4/23 0023.
 */
public class TimeUtil {
    public static String getDateBySplit(String str) {
        String[] strings = str.split(" ");
        return strings[0];
    }
}
