package com.google.hybrid.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YopMailHomePage extends AbstractPage {
    public static final String YOPMAIL_HOME_PAGE_URL = "https://yopmail.com/en";

    @FindBy(xpath = "//main//a[@href='email-generator']")
    WebElement randomAddressGeneratorButton;

    public YopMailHomePage(WebDriver driver) {
        super(driver);
    }

    public YopMailHomePage openPage() {
        driver.get(YOPMAIL_HOME_PAGE_URL);
        return this;
    }

    public YopRandomAddressGeneratorPage selectRandomAddressGenerateOption() {
        randomAddressGeneratorButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Check Inbox']/parent::button")));
        return new YopRandomAddressGeneratorPage(driver);
    }
}
