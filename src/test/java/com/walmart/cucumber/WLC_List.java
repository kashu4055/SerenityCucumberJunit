package com.walmart.cucumber;


import com.walmart.cucumber.steps.serenity.CustomSerenityRunner;
import com.walmart.cucumber.steps.serenity.SpringConfiguration;
import com.walmart.cucumber.steps.serenity.SpringDemoApplication;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.reflect.Method;



@RunWith(CustomSerenityRunner.class)
@CucumberOptions(features={"src/test/resources/features/List/create_new_list.feature"},  plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json","rerun:rerun.txt"})
@SpringBootTest(classes = SpringDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@WebAppConfiguration
@EnableRetry
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


