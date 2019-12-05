package com.restapiexample.dummy.employeeTest;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import com.restapiexample.dummy.util.TestUtil;
import cucumber.api.java.eo.Se;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

/**
 * Created by : Divyesh Patel
 * since : Tuesday  03/12/2019
 * Time  : 16:55
 **/
//@RunWith(SerenityRunner.class)
public class EmployeeCurdTest extends TestBase {


    static String name = "Oliver" + TestUtil.randomValue();
    static int salary = 26000;
    static int age = 29;
    static int empId;




    @Test
    public void createNewStudent() {
        EmployeePojo empPojo = new EmployeePojo();

        empPojo.setName(name);
        empPojo.setSalary(salary);
        empPojo.setAge(age);

        SerenityRest.rest().given()
                .contentType(ContentType.JSON)
                .body(empPojo)
                .post("/create")
                .then().log().all().statusCode(200);
    }



    @Test
    public void updateEmployeeinfo()
    {

        EmployeePojo emppojo = new EmployeePojo();

        name = name + "_updated";
        emppojo.setName(name);
        emppojo.setSalary(salary);
        emppojo.setAge(age);

        SerenityRest.rest().given()
                .contentType(ContentType.JSON)
                .body(emppojo)
                .put("/update/16141")
                .then().log().all().statusCode(200);
    }

    @Test
    public void getEmployeeInfo()
    {
        SerenityRest.rest().given()
                .contentType(ContentType.JSON)
                .get("/employee/1")
                .then().log().all().statusCode(200);
    }

    @Test
    public void deleteEmployeeInfo()
    {
        SerenityRest.rest().given()
        .delete("/delete/1")
                .then().log().all().statusCode(200);


    }
}
