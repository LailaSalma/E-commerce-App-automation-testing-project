package org.example.Pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P08_wishlist {
    public P08_wishlist() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy ( css = "div:nth-child(3) > div > div.details > div.add-info > div.buttons > button.button-2.add-to-wishlist-button")
    public WebElement wishIcon;

    @FindBy ( css = "p[class=\"content\"]" )
    public WebElement successMsg;

    @FindBy ( css = "div[class=\"bar-notification success\"]" )
    public WebElement msgColor;

    public By notificationBar(){
        return By.cssSelector("div[id=\"bar-notification\"]");
    }

    @FindBy ( css = "span[class=\"wishlist-label\"]" )
    public WebElement wishlistBtn;

    @FindBy ( css = "input[class=\"qty-input\"]" )
    public WebElement wishQnt;

}
