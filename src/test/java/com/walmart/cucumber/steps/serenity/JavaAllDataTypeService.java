package com.walmart.cucumber.steps.serenity;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

    @Service
    @Transactional
    public class JavaAllDataTypeService {

        // try the method 9 times with 2 seconds delay.
        @Retryable(maxAttempts=9,value=Exception.class,backoff=@Backoff(delay = 2000))
        public void springReTryTest() throws Exception {

            System.out.println("try!");
            throw new Exception();
        }

    }
