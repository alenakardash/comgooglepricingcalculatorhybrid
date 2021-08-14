package com.google.hybrid.test;

import com.google.hybrid.model.ComputeEngine;
import com.google.hybrid.page.*;
import com.google.hybrid.service.ComputeEngineCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PricingCalculatorSmokeTest extends CommonConditions {
    private static final String query = "Google Cloud Platform Pricing Calculator";

    ComputeEngine computeEngine = ComputeEngineCreator.withParamertersFromProperty();

    @Test(description = "Search Google Pricing Calculator, create Compute Engine and check estimated price")
    public void checkEstimatedComputeEnginePrice() {
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
                .submitComputeEngineForm();

        String actualEstimatedPrice = computeEnginePage.getEstimatedPrice();

        assertThat(actualEstimatedPrice, is(equalTo(computeEngine.getPrice())));
    }
}
