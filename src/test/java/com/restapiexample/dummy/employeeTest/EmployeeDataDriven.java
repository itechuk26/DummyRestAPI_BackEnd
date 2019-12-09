package com.restapiexample.dummy.employeeTest;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;

import com.restapiexample.dummy.util.TestUtil;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by : Divyesh Patel
 * since : Thursday  05/12/2019
 * Time  : 20:40
 **/

@UseTestDataFrom("src/test/java/com/restapiexample/dummy/resources/testdata/employeeinfo.csv")
//@RunWith(SerenityParameterizedRunner.class)

public class EmployeeDataDriven  extends TestBase {

    static String name;
    static int salary;
    static int age;


    @Title("Data Driven Test Create Multile Employee Recored using CSV file")
    @Test
    public void createMultipleEmployee()
    {
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
}
