package com.walmart.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.walmart.cucumber.pages.*;

public class WL3CSteps extends ScenarioSteps{
    WLC_LoginPage loginPage;
    WLC_ListPage  listPage;
    String validEmail = "vikram.playdom11@rocketmail.com" , validPassword = "6W654321" ;	
    
    @Step
    public void open_WL3_home_page(){
    	loginPage.open();
    }
    
    @Step
    public void open_WL3_LoginPage(){
    	loginPage.open();
    	loginPage.bringUpLoginDialog();
    }
    
    @Step
    public void login_to_WL3(){
    	loginPage.bringUpLoginDialog();
    	loginPage.enterLoginField(validEmail);
    	loginPage.enterPasswordField(validPassword);
    	loginPage.clickLogInButton();
    }
    
    @Step
    public void create_new_list_WL3(){
    	listPage.clickOnAdd_a_list();
    	listPage.giveNametoNewList("Cucumber-list");
    	listPage.clickDoneButton();
    }
    
    @Step
    public void create_new_list_first_step() {
	listPage.clickOnAdd_a_list();
    }
    
    @Step
    public void create_new_list_cancel_step() {
	listPage.clickCancelButton();
    }
    
    @Step
    public void isListView(){
    	listPage.isListView();
    }
    
    @Step
    public int isListPresent(){
    	return listPage.searchList("Cucumber-list");
    }
    
    @Step
    public void enterEmailID(Boolean flag){
    	if(flag){
    		loginPage.enterLoginField("vikram.6w1@outlook.com");
    	}else{
    		loginPage.enterLoginField("vikram.WRONG@rocketmail.com");
    	}
    }
    
    @Step
    public void enterPassword(Boolean flag){
    	if(flag){
    		loginPage.enterPasswordField("654321");
    	}else{
    		loginPage.enterPasswordField("WRONG");
    	}
    }
    
    @Step
    public void clickSignInButton(){
    	loginPage.clickLogInButton();
    }
    
    @Step
    public void verifyErrorMessageForInvalidLoginInfo(){
        assertThat( loginPage.getDriver().getPageSource().contains("The email or password you entered was incorrect. Please try again.") ).isTrue();
    }
    
    @Step
    public void selectListAndDoTaskDragAndDrop(){
    	listPage.selectSpecifiedList("Cucumber-list");
    	try{
			listPage.DragAndDrop();
	}catch(Exception e){
			
			e.printStackTrace();
	}
    }
    
}
