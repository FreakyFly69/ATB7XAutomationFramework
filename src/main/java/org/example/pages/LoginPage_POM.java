package org.example.pages;

import org.example.base.CommonToAllPage;
import org.example.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_POM extends CommonToAllPage {

    WebDriver driver;

    public LoginPage_POM(WebDriver driver){
        this.driver = driver;
    }


    // Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signinButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");


    //Page Actions

    public String loginToVWOInvalidCred(String user, String pwd){

        driver.get(PropertyReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signinButton).click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException();
        }

        WebElement error_msg = driver.findElement(error_message);
        String error_msg_txt = error_msg.getText();
        String error_msg_attribute_data_qa = error_msg.getAttribute("data-qa");
        return error_msg_txt;

    }



}
