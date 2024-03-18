package ru.qa_guru3;

import org.junit.jupiter.api.*;

import java.util.concurrent.locks.Condition;

public class SimpleJUnitTest {

    @BeforeAll
    static void BeforeAll() {
        System.out.println("###      @BeforAll\n");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("###      @AfterAll\n");
    }

    @BeforeEach
    void BeforeEach() {
        System.out.println("###  @BeforeEach");
    }
    @AfterEach
    void AfterEach() {
        System.out.println("###  @AfterEach");
    }

    @Test
    void firstTest() {
        System.out.println("###  @Test firstTest");
        Assertions.assertTrue(2*2 ==4);
    }

    @Test
    void secondTest() {
        System.out.println("###  @Test secondTest");
        Assertions.assertTrue(2+2 ==4);
    }
}
