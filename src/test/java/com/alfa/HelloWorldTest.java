package com.alfa;

import com.zebrunner.carina.core.IAbstractTest;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class HelloWorldTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testHelloWorld() {
        LOGGER.info("Hello world!");

        Allure.step("hello", Status.PASSED);
    }
}
