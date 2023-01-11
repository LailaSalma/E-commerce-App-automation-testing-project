package org.example.Pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P07_followUs {
    public P07_followUs() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy ( css = "a[href=\"http://www.facebook.com/nopCommerce\"]")
    public WebElement facebook;

    @FindBy ( css = "a[href=\"https://twitter.com/nopCommerce\"]")
    public WebElement twitter;

    @FindBy ( css = "a[href=\"/news/rss/1\"]")
    public WebElement rss;

    @FindBy ( css = "a[href=\"http://www.youtube.com/user/nopCommerce\"]")
    public WebElement youtube;
}
