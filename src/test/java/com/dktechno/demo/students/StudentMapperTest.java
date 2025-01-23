package com.dktechno.demo.students;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside the before all method");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Inside the after all method");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Inside the before each method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside the after each method");
    }


    @Test
    public void toStudent() {
        System.out.println("My fist test method");
    }

    @Test
    public void toStudentResponseDTO() {
        System.out.println("My fist test method");
    }
}