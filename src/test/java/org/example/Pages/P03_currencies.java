package org.example.Pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_currencies {
    public P03_currencies() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy ( id = "customerCurrency")
    public WebElement currenciesList;

//    @FindBy ( css = "span[class=\"price actual-price\"]")
//    public List<WebElement> currencies;

    public List<WebElement> currencies(){
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
    }

}
