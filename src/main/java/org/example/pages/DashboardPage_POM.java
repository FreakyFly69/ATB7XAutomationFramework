package org.example.pages;

import org.example.base.CommonToAllPage;
import org.openqa.selenium.By;

public class DashboardPage_POM extends CommonToAllPage {

    public DashboardPage_POM(){

    }

    //page locators
    By userNameOnDashboard = By.cssSelector("[data-qa='lufexuloga']");

    //page actions
    public String loggedInUsername(){
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }


}
