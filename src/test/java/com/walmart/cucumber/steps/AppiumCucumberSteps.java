package com.walmart.cucumber.steps;

import com.walmart.cucumber.steps.serenity.AppiumUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AppiumCucumberSteps {
	
	@Steps
	AppiumUser apppiumUser;
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Exception {
	  
	   System.out.println("login page is displayed");
	}


	@When("^Enter valid credentials$")
	public void enter_valid_credentials() throws Exception {
	    
		apppiumUser.setup();
		apppiumUser.enterCredentials();
	   
	}

	@Then("^User is logged in to the page$")
	public void user_is_logged_in_to_the_page() throws Exception {
	   
		apppiumUser.sigIn();
	   
	}

}
