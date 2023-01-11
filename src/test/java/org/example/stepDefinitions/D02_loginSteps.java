package org.example.stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P02_login;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;

public class D02_loginSteps {
    P02_login login = new P02_login();

    @Given("user go to login page")
    public void loginPage(){
        login.loginTap.click();
    }

    @When("^user logs in with the data \"(.*)\" and \"(.*)\"$")
    public void enterEmail_Pass(String email, String password){
        login.loginData(email, password);
    }

    @And("user press on login button")
    public void pressLogin(){
        login.loginNow.click();
    }

    @Then("user login to the system successfully")
    public void loginSuccessful(){
        String actualURL = Hooks.driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/";

        SoftAssert soft = new SoftAssert();

        soft.assertTrue(actualURL.equals(expectedURL), "The URL is incorrect");
        soft.assertTrue( login.myAccount.isDisplayed(), "The \"My account\" tap is not displayed");

        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void loginFailed(){
        SoftAssert soft = new SoftAssert();

        String expectedMsg = "Login was unsuccessful. Please correct the errors and try again.";
        String actualMsg = login.errorMsg.getText();
        soft.assertTrue(actualMsg.contains(expectedMsg),"Error message is incorrect");

        String msgColor = Color.fromString(login.errorMsg.getCssValue("color")).asHex();
        String expectedColor = Color.fromString("rgba(228, 67, 75, 1)").asHex();
        soft.assertTrue(msgColor.equals(expectedColor),"Error message's color is incorrect");

        soft.assertAll();
    }

}
