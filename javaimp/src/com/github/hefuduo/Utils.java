package com.github.hefuduo;

/**
 * com.github.hefuduo
 * Created by hefuduo on 2019-12-04.
 */
public class Utils {
    public static void callTheInlineFunction() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            inlineFunction();
        }
        long l2 = System.currentTimeMillis();

        System.out.println("cost=" + (l2 - l));
    }

    public final static void inlineFunction() {
        int c = 3 * 3;
        int m = c >> 4;
        int n = c * 3;
        System.out.println(n);
    }
}


