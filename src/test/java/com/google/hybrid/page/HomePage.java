package com.google.hybrid.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    public static final String HOMEPAGE_URL = "https://cloud.google.com";
    private WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchField;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
       driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultsPage getSearchResults(String query) {
        searchField.click();
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Search results for')]")));
        return new SearchResultsPage(driver);
    }
}
