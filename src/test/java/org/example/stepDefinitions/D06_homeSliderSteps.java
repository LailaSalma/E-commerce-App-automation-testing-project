package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P06_homeSlider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D06_homeSliderSteps {
    P06_homeSlider slider = new P06_homeSlider();

    @Given("^user clicks on slider no. \"(.*)\" button$")
    public void firstSlider(String num){
        slider.sliderBtn(Integer.parseInt(num)).click();
    }

    @When("user clicks on the product shown in the slider")
    public void slider() throws InterruptedException {
        Thread.sleep(500);
        slider.sliderImage.click();
    }

    @Then("user is redirected to the page of the first product")
    public void firstSliderRedirection(){
        SoftAssert soft = new SoftAssert();

        String expectedURL = "https://demo.nopcommerce.com/iphone_14_pro";
        String actualURL = Hooks.driver.getCurrentUrl();

        soft.assertTrue(actualURL.equals(expectedURL),"The redirection URL is incorrect");
        soft.assertAll();
    }
    @Then("user is redirected to the page of the second product")
    public void secondSliderRedirection(){
        SoftAssert soft = new SoftAssert();

        String expectedURL = "https://demo.nopcommerce.com/galaxy_s22_ultra";
        String actualURL = Hooks.driver.getCurrentUrl();

        soft.assertTrue(actualURL.equals(expectedURL),"The redirection URL is incorrect");
        soft.assertAll();
    }
}
