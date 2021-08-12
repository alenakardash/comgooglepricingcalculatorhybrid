package com.google.hybrid.test;

import com.google.hybrid.driver.DriverSingleton;
import com.google.hybrid.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod
    public void browserSetUp() {
       driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
       DriverSingleton.closeDriver();
    }
}
