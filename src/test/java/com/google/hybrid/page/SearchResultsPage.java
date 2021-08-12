package com.google.hybrid.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage {

    SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage navigateToQueryResult(String query) {
        String searchResultLink = String.format("//a[contains(text(), '%s')]", query);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResultLink)));

        driver.findElement(By.xpath(searchResultLink)).click();

        return new PricingCalculatorPage(driver);
    }
}