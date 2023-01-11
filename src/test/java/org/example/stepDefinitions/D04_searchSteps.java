package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P04_search;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchSteps {
    P04_search search = new P04_search();

    @Given("^user types the product \"(.*)\" in the search bar$")
    public void search (String productName){
        search.searchField.sendKeys(productName);
    }

    @When("user press on search button")
    public void pressSearch (){
        search.searchBtn.click();
    }

    @Then("^the relevant results of \"(.*)\" are displayed$")
    public void searchSuccessful(String productName){
        SoftAssert soft = new SoftAssert();

        String actualURL = Hooks.driver.getCurrentUrl();
        String expectedURL = "https://demo.nopcommerce.com/search?q="+productName;
        soft.assertTrue(actualURL.equals(expectedURL), "The URL is incorrect");

        System.out.println("The number of results: "+search.results().size());

        for ( int i=0; i<search.searchWord().size(); i++ ){
            String actualTitle = search.searchWord().get(i).getText().toLowerCase();
            soft.assertTrue(actualTitle.contains(productName),"The resulted product no. "+ i +" does not contain the searched keyword: "+productName);
        }
        soft.assertAll();
    }

    @And("user clicks on the product displayed in the results")
    public void clickItem(){
        search.item.click();
    }

    @Then("^the relevant result of \"(.*)\" are displayed$")
    public void checkSku(String sku){
        String actualSKU = search.sku.getText();
        //Hard assertion
        Assert.assertTrue(actualSKU.equals(sku),"The result does not match the searched sku: "+sku);
    }
}
