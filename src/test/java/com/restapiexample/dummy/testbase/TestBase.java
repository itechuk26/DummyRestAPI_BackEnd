package com.restapiexample.dummy.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by : Divyesh Patel
 * since : Tuesday  03/12/2019
 * Time  : 15:01
 **/

public class TestBase {

@BeforeClass
    public static void inIt(){
    RestAssured.baseURI = "http://dummy.restapiexample.com";
    RestAssured.basePath = "/api/v1";
}
}
