package com.dktechno.demo;

public class MyFirstClass {

    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hello from my first Application ===> myVar = " + myVar;
    }
}
