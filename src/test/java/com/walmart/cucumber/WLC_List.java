package com.walmart.cucumber;


import com.walmart.cucumber.steps.serenity.CustomSerenityRunner;
import com.walmart.cucumber.steps.serenity.SpringConfiguration;
import com.walmart.cucumber.steps.SpringDemoApplication;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.lang.reflect.Method;



@RunWith(CustomSerenityRunner.class)
@CucumberOptions(features={"src/test/resources/experiment/test.feature"}, glue = {"com/walmart/experiment"}, plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json","rerun:rerun.txt"})
@SpringBootTest(classes = SpringDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SpringConfiguration.class)
public class WLC_List {

    public static void main(String[] args) {
        SpringApplication.run(WLC_List.class, args);
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("***************** This line is printed before the class ********");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("********** This is printed after the class has executed *******");

        Method[] methods = CustomSerenityRunner.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if(methods[i].getName().contentEquals("run")){
                System.out.println(methods[i]);
            }
        }

        System.out.println();



    }



}


