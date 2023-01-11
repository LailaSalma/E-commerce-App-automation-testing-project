package org.example.Pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P04_search {
    public P04_search() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy ( id = "small-searchterms")
    public WebElement searchField;

    @FindBy ( css = "button[class=\"button-1 search-box-button\"]")
    public WebElement searchBtn;

//    @FindBy ( css = "div[class=\"product-item\"]")
//    public List<WebElement> results;

    public List<WebElement> results(){
        return Hooks.driver.findElements(By.cssSelector("div[class=\"product-item\"]"));
    }

    public List<WebElement> searchWord(){
        return Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]"));
    }

    @FindBy ( css = "div[class=\"picture\"]")
    public WebElement item;

    @FindBy ( css = "div[class=\"sku\"]>span[class=\"value\"]")
    public WebElement sku;

}
