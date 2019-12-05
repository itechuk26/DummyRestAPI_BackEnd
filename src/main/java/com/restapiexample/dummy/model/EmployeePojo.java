package com.restapiexample.dummy.model;

import com.google.inject.internal.util.$Objects;

/**
 * Created by : Divyesh Patel
 * since : Tuesday  03/12/2019
 * Time  : 14:57
 **/

public class EmployeePojo {

private int id;
private String name;
private int salary;
private int age;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
