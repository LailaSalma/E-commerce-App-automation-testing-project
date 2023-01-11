package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P08_wishlist;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_wishlistSteps {

    P08_wishlist wishlist = new P08_wishlist();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    @Given("user click on heart icon below the product image")
    public void wishlistIcon(){
        wishlist.wishIcon.click();
    }

    @Then("user is able to see a successful message")
    public void wishlistMsg(){
        SoftAssert soft = new SoftAssert();

        String actualMsg = wishlist.successMsg.getText();
        String expectedMsg = "The product has been added to your wishlist";

        String msgColor = Color.fromString(wishlist.msgColor.getCssValue("background-color")).asHex();
        String expectedColor = Color.fromString("rgba(75, 176, 122, 1)").asHex();

        soft.assertTrue(actualMsg.contains(expectedMsg),"The success message is incorrect");
        soft.assertTrue(msgColor.equals(expectedColor),"Successful message's color is incorrect");
        soft.assertAll();
    }

    @And("user clicks on wishlist button after the success message disappears")
    public void wishlistBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(wishlist.notificationBar()));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(wishlist.notificationBar()));
        wishlist.wishlistBtn.click();
    }

    @Then("user could see item added successfully in wishlist")
    public void wishlistItem(){
        SoftAssert soft = new SoftAssert();
        int qntInt = Integer.parseInt(wishlist.wishQnt.getAttribute("value"));
        boolean boolValue;

        if( qntInt>0 )
            boolValue = true;
        else
            boolValue=false;

        soft.assertTrue( boolValue, "There is no item in the wishlist" );
        soft.assertAll();
    }
}
