package com.walmart.cucumber.steps;

import com.walmart.cucumber.steps.serenity.AppiumUser;
import com.walmart.cucumber.steps.serenity.SpringConfiguration;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;


@EnableRetry
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = SpringConfiguration.class)

public class AppiumCucumberSteps {

	private static Integer count = 4;

	@Autowired
	RetryTemplate retryTemplate;

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


//	@Retryable(maxAttempts = 3, backoff = @Backoff(delay = 2000))
//	@Given("^Get input from user and verify if retry mechanism kicks in\\.$")
//	public void get_input_from_user_and_verify_if_retry_mechanism_kicks_in() throws Throwable {
//
//		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
//		retryPolicy.setMaxAttempts(5);
//
//		FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
//		backOffPolicy.setBackOffPeriod(100); // 1.5 seconds
//
//		retryTemplate.registerListener(new CustomRetryListener());
//		retryTemplate.setBackOffPolicy(backOffPolicy);
//		retryTemplate.setRetryPolicy(retryPolicy);
//
//
//
//		retryTemplate.execute(new RetryCallback<Boolean, AssertionError>() {
//			@Override
//			public Boolean doWithRetry(RetryContext retryContext) throws AssertionError {
//				Assert.assertTrue("Failed as counter is ", --counter <= 0);
//				return false;
//			}
//		});
//
//
//
//
//
//
////		try{
////
////			Assert.assertTrue("Failed as counter is ", --counter <= 0);
////
////		}catch(Throwable t){
////			get_input_from_user_and_verify_if_retry_mechanism_kicks_in();
////		}
//
//
//	}



	@Given("^Get input from user and verify if retry mechanism kicks in\\.$")
	@Retryable(value = ArithmeticException.class, maxAttempts = 5)
	public void getInfo() throws Throwable {



//		RetryPolicy retryPolicy = new RetryPolicy()
//				.retryOn(Throwable.class)
//				.withDelay(1000, TimeUnit.MILLISECONDS)
//				.withMaxRetries(5);
//
//
//		Failsafe.with(retryPolicy).run(() -> {
//
//			System.out.println("************************ Retrying ********************");
//			Assert.assertTrue(--count <=0);
//
//		});





//		        try {
//            System.out.println("How many time will this be printed?");
//            SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
//            retryPolicy.setMaxAttempts(5);
//
//            FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
//            backOffPolicy.setBackOffPeriod(100); // 1.5 seconds
//
//            retryTemplate.setBackOffPolicy(backOffPolicy);
//            retryTemplate.setRetryPolicy(retryPolicy);
//
//
//            retryTemplate.execute(new RetryCallback<Boolean, Throwable>() {
//                @Override
//                public Boolean doWithRetry(RetryContext retryContext) throws Throwable {
//
//					System.out.println("**************** Hello World *****************");
//
//                    String rand = "";
//
//                    rand += "Hello" + 4 / 0;
//
//
//
//
//
//                                        return false;
//                }
//            });
//
//        } catch (Throwable ex) {
//            throw ex;
//        }



		try{
			System.out.println("**************** Hello World *****************");

			String rand = "";

			rand += "Hello" + 4 / 0;
		}catch(Throwable t){
			throw t;
		}

	}

}
