package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P05_hover;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class D05_hoverSteps {
    P05_hover hover= new P05_hover();
    Actions action= new Actions(Hooks.driver);
    int count= hover.countMainCateg.size();
    int min= 0, max= count-1;
    int random= (int)Math.floor(Math.random()*(max-min+1)+min);
    int randomSub= (int)Math.floor(Math.random()*(max-min+1)+min);


    @Given("user hovers on a random main category")
    public void hoverMain() throws InterruptedException {

        //hovering on a random main category
        action.moveToElement(hover.categories.get(random)).perform();

    }

    @When("user hovers on one of the displayed subcategories and clicks on it")
    public void hoverSub() throws InterruptedException {

        WebElement subCateg = hover.chosenSub(random+1, randomSub+1);

        //hovering on a random sub-category
        action.moveToElement(subCateg).perform();

        //clicking on the random sub-category
        action.doubleClick(subCateg).perform();
    }

    @Then("user is redirected to the chosen subcategory")
    public void redirectToSub(){
        String actualTitle = hover.pageTitle.getText().toLowerCase().trim();
        String expectedTitle = hover.chosenSub(random+1, randomSub+1).getText().toLowerCase().trim();

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(actualTitle.contains(expectedTitle),"The title of the subcategory is incorrect");
        soft.assertAll();

    }
}
