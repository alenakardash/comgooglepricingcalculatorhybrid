package com.google.hybrid.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingCalculatorPage extends AbstractPage {
    private WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

    @FindBy(xpath = "//md-tab-item//div[text()=\'Compute Engine\']")
    WebElement computeEngineTabItem;

    PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public ComputeEnginePage activateComputeEngineTab() {
        driver.switchTo().frame(0);

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-tab-item//div[text()='Compute Engine']")));

        computeEngineTabItem.click();
        return new ComputeEnginePage(driver);
    }
}
