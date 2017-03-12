package com.baoolinliu.config;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by richey on 17-3-12.
 */
public class MyTest {

    public static void main(String[] args) {
        Set<String> mySet = new LinkedHashSet<String>();
        mySet.add("aa");
        mySet.add("bb");
        mySet.add("cc");
        mySet.add("dd");

        String[] strs = mySet.toArray(new String[mySet.size()]);
        System.out.println(mySet);
        System.out.println(strs);
        strs = Arrays.copyOf(strs, strs.length);
        System.out.println(strs);
        for (String str : strs) {

            System.out.println(str);
        }
    }



}
