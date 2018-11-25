package com.walmart.cucumber.steps.serenity;

import org.junit.Assert;
import org.springframework.retry.annotation.Retryable;

//@RunWith(SpringRunner.class)
public class JunitRetryTest {

    int count =2;

//    @Test
    @Retryable(value = AssertionError.class, maxAttempts = 5)
    public void retryOnException(){

        System.out.println("************************************ retried ***********************");
        Assert.assertTrue(--count <=0);
    }
}
