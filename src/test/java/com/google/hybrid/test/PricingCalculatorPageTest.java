package com.google.hybrid.test;

import com.google.hybrid.model.ComputeEngine;
import com.google.hybrid.page.*;
import com.google.hybrid.service.ComputeEngineCreator;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PricingCalculatorPageTest extends CommonConditions {
    private static final String query = "Google Cloud Platform Pricing Calculator";

    ComputeEngine computeEngine = ComputeEngineCreator.withParamertersFromProperty();

    @Test(description = "Create indox using email generator, create Compute Engine, verify estimated price in email is equal estimated in form")
    public void checkEstimatedComputeEnginePriceFromEmail() {
        YopRandomAddressGeneratorPage yopRandomAddressGeneratorPage = new YopMailHomePage(driver)
                .openPage()
                .selectRandomAddressGenerateOption();

        String emailAddress = yopRandomAddressGeneratorPage.getGeneratedEmailAddress();

        YopInboxPage yopInboxPage = yopRandomAddressGeneratorPage.navigateToYopInbox();

        String inboxPageID = driver.getWindowHandle();
        System.out.println(inboxPageID);
        ((JavascriptExecutor)driver).executeScript("window.open()");


        for (String windowHandle : driver.getWindowHandles()) {
            if ((!inboxPageID.contentEquals(windowHandle))) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        ComputeEnginePage computeEnginePage = new HomePage(driver)
                .openPage()
                .getSearchResults(query)
                .navigateToQueryResult(query)
                .activateComputeEngineTab()
                .selectNumberOfInstance(computeEngine)
                .selectOSValue(computeEngine)
                .selectMachineClass(computeEngine)
                .selectSeries(computeEngine)
                .selectInstanceType(computeEngine)
                .changeAddGPUCheckBoxState()
                .setNumberOfGPUs(computeEngine)
                .setGPUType(computeEngine)
                .setLocalSSD(computeEngine)
                .setDataCenterLocation(computeEngine)
                .setCommitedUsage(computeEngine)
                .submitComputeEngineForm()
                .submitEmailEstimate(emailAddress);

        String actualEstimatedPrice = computeEnginePage.getEstimatedPrice();

        driver.switchTo().window(inboxPageID);
        yopInboxPage.refreshInboxUntilEmailWithTextReceived("Google Cloud Platform Price Estimate");

        assertThat(actualEstimatedPrice, is(equalTo(yopInboxPage.getEstimatedPriceFromLetter())));
    }
}
