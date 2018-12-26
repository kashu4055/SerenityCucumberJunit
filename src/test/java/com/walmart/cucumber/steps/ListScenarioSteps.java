package com.walmart.cucumber.steps;

import com.walmart.cucumber.steps.serenity.SpringConfiguration;
import com.walmart.cucumber.steps.serenity.WL3CSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import static net.serenitybdd.rest.SerenityRest.when;
import static org.assertj.core.api.Assertions.assertThat;


@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = SpringConfiguration.class)
public class ListScenarioSteps {

	@Autowired
	RetryTemplate retryTemplate;

	@Steps
	WL3CSteps wlCucumberSteps;
		
	@Given("User log-in to WL")
	public void loginToWL(){
		wlCucumberSteps.open_WL3_home_page();
		wlCucumberSteps.login_to_WL3();
	}
	
	@Given("User is in List View")
	public void listView(){
		wlCucumberSteps.isListView();
	}
	
	@When("User Creates New List")
	public void createNewList(){
		wlCucumberSteps.create_new_list_WL3();
	}
	  
	@When("User tries to create new list")
	public void createNewListFirstStep() {
	    wlCucumberSteps.create_new_list_first_step();
	}
	
	@Then("User should be able to cancel the list creation action")
	public void userCancelsListCreationAction() {
	    wlCucumberSteps.create_new_list_cancel_step();
	}
	
	@Then("New List Gets Created At Bottom of List View")
	public void checkListPosition(){
		assertThat(wlCucumberSteps.isListPresent()).isNotEqualTo(0);		
	}

	@Given("^I hit the IBD enpoint and download the delivery document$")
	public void i_am_an_active_trader() {
		Response response = when().get("http://lb-node.cluster6.cloud.s06000.us.wal-mart.com/us-32899/inbound-document-manager/document/deliveries/20905711")
				.thenReturn();

		System.out.println(response.asString());
	}

		
}
