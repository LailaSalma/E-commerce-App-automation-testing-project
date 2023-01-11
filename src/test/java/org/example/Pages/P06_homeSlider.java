package org.example.Pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P06_homeSlider {
    public P06_homeSlider() {
        PageFactory.initElements(Hooks.driver, this);
    }

    public WebElement sliderBtn(int num){
        return Hooks.driver.findElement(By.cssSelector("a[rel=\""+ (num-1) +"\"]"));
    }

    @FindBy ( css = "div[id=\"nivo-slider\"]")
    public WebElement sliderImage;

}
