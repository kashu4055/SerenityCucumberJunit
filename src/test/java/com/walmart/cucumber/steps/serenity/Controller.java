package com.walmart.cucumber.steps.serenity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    @RestController
    public class JavaAllDataTypeController {

        @Autowired
        JavaAllDataTypeService JavaAllDataTypeService;


        @RequestMapping(
                value = "/springReTryTest",
                method = RequestMethod.GET
        )
        public ResponseEntity<String> springReTryTest() {

            System.out.println("springReTryTest controller");

            try {
                JavaAllDataTypeService.springReTryTest();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return new  ResponseEntity<String>("abcd", HttpStatus.OK);
        }

    }
}
