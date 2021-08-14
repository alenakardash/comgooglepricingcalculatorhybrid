package com.google.hybrid.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YopInboxPage extends AbstractPage {
    private WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

    @FindBy(xpath = "//button[@id='refresh']")
    WebElement refreshInboxButton;

    YopInboxPage(WebDriver driver) {
        super(driver);
    }

    public void refreshInboxUntilEmailWithTextReceived(String text) {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='refresh']")));

        String xpath = String.format("//body[@class='bodyinbox yscrollbar']//div[contains(text(), '%s')]", text);

        for (int i = 0; i < 5; i++) {
            clickOnElement(refreshInboxButton);

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifinbox"));

            try {
                new WebDriverWait(driver, 2).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
                return;
            } catch (TimeoutException e) {

            } finally {
                driver.switchTo().defaultContent();
            }
        }
    }

    public String getEstimatedPriceFromLetter() {
        driver.switchTo().frame("ifmail");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[@class='bodymail yscrollbar']//h2")));

        Pattern pattern = Pattern.compile("USD(\\s[\\d,.]+)");
        Matcher matcher = pattern.matcher(driver.findElement(By.xpath("//body[@class='bodymail yscrollbar']//h2")).getText());
        matcher.find();
        return matcher.group();
    }
}