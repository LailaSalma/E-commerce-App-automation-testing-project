package org.example.Pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P05_hover {
    public P05_hover() {
        PageFactory.initElements(Hooks.driver, this);
    }

//    public List<WebElement> categories(){
//        return Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>ul[class=\"sublist first-level\"]"));
//    }

    @FindBy ( css = "ul[class=\"top-menu notmobile\"]>li>a" )
    public List<WebElement> categories;

    @FindBy ( css = "ul[class=\"top-menu notmobile\"]>li>ul[class=\"sublist first-level\"]")
    public List<WebElement> countMainCateg;

    public WebElement chosenSub(int random, int randomSub){
        return Hooks.driver.findElement(By.cssSelector("ul.top-menu.notmobile>li:nth-child("+ random +")>ul>li:nth-child("+ randomSub +")>a"));
    }

    @FindBy ( css = "div[class=\"page-title\"]")
    public WebElement pageTitle;


}
