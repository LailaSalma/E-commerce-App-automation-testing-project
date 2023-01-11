package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.P03_currencies;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesSteps {

    P03_currencies currency = new P03_currencies();

    @Given("user selects Euro currency from the dropdown list on the top left of home page")
    public void currency(){
        Select select = new Select(currency.currenciesList);
        select.selectByVisibleText("Euro");
    }

    @Then("the currency of products is changed")
    public void changedCurrency(){
        char currSign;
        for ( int i=0; i<currency.currencies().size(); i++ ){
            currSign = currency.currencies().get(i).getText().charAt(0);
            Assert.assertEquals(currSign, '€');
        }
    }
}
