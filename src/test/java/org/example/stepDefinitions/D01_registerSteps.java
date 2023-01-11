package org.example.stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_register;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class D01_registerSteps {

    P01_register register = new P01_register();

    @Given("user goes to registration page")
    public void registrationPage (){
        register.registerBtn.click();           //implementing POM pattern
    }

    @When("user select gender type")
    public void genderType (){
        register.genderBtn.click();           //implementing POM pattern
    }

    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void usernamePassword (String username, String password){
        register.firstName.sendKeys(username);
        register.lastName.sendKeys(password);
    }

    @And("^user enter date of birth day \"(.*)\" month \"(.*)\" year \"(.*)\"$")
    public void enterDate (String day, String month, String year){
        register.enteringDate(day, month, year);
    }

    @And("user enters email")
    public void enterEmail (){
        Faker fake = new Faker();
        String email = fake.internet().safeEmailAddress();
        register.emailField.sendKeys("lassunslaila24@example.com");
//        Or this statement instead
//        register.emailField.sendKeys(email);
    }

    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void enterPass (String pass1, String pass2){
        register.enteringPass(pass1, pass2);
    }

    @And("user clicks on register button")
    public void registerNow (){
        register.registerNow.click();
    }

    @Then("success message is displayed")
    public void registerSuccess(){
        String expectedMsg = "Your registration completed";
        String actualMsg = register.successMsg.getText();

        // **SOFT assertion
        SoftAssert soft = new SoftAssert();

        soft.assertTrue(actualMsg.contains(expectedMsg),"Success message is incorrect");

        String msgColor = register.successMsg.getCssValue("color");
        String expectedColor = "rgba(76, 177, 124";
        soft.assertTrue(msgColor.contains(expectedColor),"Success message's color is incorrect");

        soft.assertAll();

    }


}
