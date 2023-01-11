package org.example.Pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class P01_register {

    public P01_register() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy ( className = "ico-register")
    public WebElement registerBtn;

    @FindBy ( id = "gender-female")
    public WebElement genderBtn;

//    public By firstName(){
//        return By.cssSelector("input[id=\"FirstName\"]");
//    }

//    public WebElement lastName(){
//        return Hooks.driver.findElement(By.cssSelector("input[id=\"LastName\"]"));
//    }

    @FindBy (css = "input[id=\"FirstName\"]" )
    public WebElement firstName;

    @FindBy (css = "input[id=\"LastName\"]" )
    public WebElement lastName;

    @FindBy (css = "select[name=\"DateOfBirthDay\"]" )
    public WebElement dayBtn;

    @FindBy (css = "select[name=\"DateOfBirthMonth\"]" )
    public WebElement monthBtn;

    @FindBy (css = "select[name=\"DateOfBirthYear\"]" )
    public WebElement yearBtn;

    @FindBy (css = "input[id=\"Email\"]" )
    public WebElement emailField;

    @FindBy (css = "input[id=\"Password\"]" )
    public WebElement pass1Field;

    @FindBy (css = "input[id=\"ConfirmPassword\"]" )
    public WebElement pass2Field;

    @FindBy ( id = "register-button")
    public WebElement registerNow;

    @FindBy (css = "div[class=\"result\"]" )
    public WebElement successMsg;


    public void enteringDate (String day, String month,String year){
        Select selectDay = new Select(dayBtn);
        selectDay.selectByValue(day);

        Select selectMonth = new Select(monthBtn);
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(yearBtn);
        selectYear.selectByValue(year);
    }

    public void enteringPass (String pass1, String pass2){
        pass1Field.sendKeys(pass1);
        pass2Field.sendKeys(pass2);
    }

}



