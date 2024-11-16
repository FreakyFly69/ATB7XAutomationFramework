package org.example.tests.vwoTests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.base.CommonToAllPage;
import org.example.driver.DriverManager;
import org.example.pages.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_POM extends CommonToAllPage {

    public static final Logger logger = LogManager.getLogger(TestVWOLogin_POM.class);



    @Test
    public void testLoginNegativeVWO(){

        logger.info("Starting the Testcase");
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        logger.info("Opening the url");
        String error_msg_txt = loginPagePom.loginToVWOInvalidCred(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));
        logger.info("Verifying the user is the " +error_msg_txt);

        assertThat(error_msg_txt).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(error_msg_txt, PropertyReader.readKey("error_message"));

    }

}
