package org.example.Pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_login {
    public P02_login() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy( css = "a[class=\"ico-login\"]")
    public WebElement loginTap;

    @FindBy( css = "input[id=\"Email\"]")
    public WebElement emailField;

    @FindBy( id="Password")
    public WebElement passField;

    @FindBy( css = "button[class=\"button-1 login-button\"]" )
    public WebElement loginNow;

    @FindBy ( css = "a[class=\"ico-account\"]")
    public WebElement myAccount;

    @FindBy ( css = "div[class=\"message-error validation-summary-errors\"]")
    public WebElement errorMsg;

    public void loginData(String email, String password){
        emailField.sendKeys(email);
        passField.sendKeys(password);
    }
}
