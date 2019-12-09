package com.restapiexample.dummy.employeeTest;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import com.restapiexample.dummy.util.TestUtil;

import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import static io.restassured.RestAssured.given;


/**
 * Created by : Divyesh Patel
 * since : Tuesday  03/12/2019
 * Time  : 16:55
 **/
@RunWith(SerenityRunner.class)
public class EmployeeCurdTest extends TestBase {


    static String name = "Oliver" + TestUtil.randomValue();
    static int salary = 26000;
    static int age = 29;
    static String empId;



@Title("Create New Employee")
    @Test
    public void test001() {
        EmployeePojo empPojo = new EmployeePojo();

        empPojo.setName(name);
        empPojo.setSalary(salary);
        empPojo.setAge(age);

        empId = given()
                .contentType(ContentType.JSON)
                .body(empPojo)
                .post("/create")
                .then().statusCode(200)
                .extract()
                .jsonPath()
                .get("id");

        System.out.println("New Employee ID is : " +empId);
    }


@Title("Update Employee Information")
    @Test
    public void test002()
    {

        EmployeePojo emppojo = new EmployeePojo();

        name = name + "_updated";
        emppojo.setName(name);
        emppojo.setSalary(salary);
        emppojo.setAge(age);

        String res_body = given()
                .contentType(ContentType.JSON)
                .body(emppojo)
                .put("/update/" +empId)
                .then().statusCode(200)
                .extract().asString();

        System.out.println("Employee Record Updated " +res_body );
    }

    @Title("Get Employee Information")
    @Test
    public void test003()
    {
        ValidatableResponse rep =  given()
                .contentType(ContentType.JSON)
                .get("/employee/"+empId)
                .then().log().all().statusCode(200);
    }

    @Title("Delete Employee Information")
    @Test
    public void test004()
    {
        SerenityRest.rest().given()
        .delete("/delete/" +empId)
                .then().log().all().statusCode(200);

        ValidatableResponse rep = given()
                .contentType(ContentType.JSON)
                .get("/employee/"+empId)
                .then().statusCode(200);

    }
}
