package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P06_homeSlider;
import org.example.Pages.P07_followUs;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class D07_followUsSteps {
    P07_followUs follow = new P07_followUs();

    @Given("user opens facebook link")
    public void facebook(){
        follow.facebook.click();
    }

    @Given("user opens twitter link")
    public void twitter(){
        follow.twitter.click();
    }

    @Given("user opens rss link")
    public void rss(){
        follow.rss.click();
    }

    @Given("user opens youtube link")
    public void youtube(){
        follow.youtube.click();
    }

    @Then("^\"(.*)\" is opened in new tab$")
    public void redirect(String URL) throws InterruptedException {
        Thread.sleep(3000);
        String mainPage = Hooks.driver.getWindowHandle();
        Set<String> taps = Hooks.driver.getWindowHandles();
        String actualURL="";

        for ( String tap : taps ){
            if( !tap.equals(mainPage) ){
                //switching to the new tap
                Hooks.driver.switchTo().window(tap);
                Thread.sleep(2000);
                actualURL = Hooks.driver.getCurrentUrl();
                Thread.sleep(3000);
                Hooks.driver.close();
            }
        }
        //switching back to the main tap
        Hooks.driver.switchTo().window(mainPage);

        SoftAssert soft =new SoftAssert();
        soft.assertTrue(actualURL.equals(URL),"The URL the user was directed to is incorrect");
        soft.assertAll();
    }
}
