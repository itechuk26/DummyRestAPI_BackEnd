package com.restapiexample.dummy.util;

import java.util.Random;

/**
 * Created by : Divyesh Patel
 * since : Wednesday  04/12/2019
 * Time  : 16:31
 **/

public class TestUtil {

    public static String randomValue() {
        Random random = new Random();
        int ran_int = random.nextInt(100000);
        return  Integer.toString(ran_int);
    }

}
