package com.google.hybrid.page;

import com.google.hybrid.model.ComputeEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComputeEnginePage extends AbstractPage {
    private WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    private JavascriptExecutor executor = (JavascriptExecutor) driver;

    @FindBy(xpath = "//input[@name = 'quantity' and @ng-model='listingCtrl.computeServer.quantity']")
    WebElement numberOfInstancesField;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    WebElement operatingSystemDropdown;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    WebElement machineClassField;

    @FindBy(xpath = "//md-select[@name='series']")
    WebElement seriesDropdown;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    WebElement machineTypeDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-checkbox[@aria-label='Add GPUs']")
    WebElement addGPUCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    WebElement numberOfGPUsDropdown;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    WebElement GPUTypeDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Local SSD']")
    WebElement localSSDDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Datacenter location']")
    WebElement dataCenterLocationDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Committed usage']")
    WebElement committedUsageDropdown;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")
    WebElement addToEstimateButton;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    WebElement emailEstimateButton;

    @FindBy(xpath = "//form[@name='emailForm']//label[contains(text(), 'Email')]/following-sibling::input")
    WebElement emailAddressField;

    @FindBy(xpath = "//form[@name='emailForm']//button[contains(text(), 'Send Email')]")
    WebElement sendEmailButton;

    @FindBy(xpath = "//h2[@class='md-title']/b")
    WebElement estimatedPriceText;

    ComputeEnginePage(WebDriver driver) {
        super(driver);
    }

    public ComputeEnginePage selectNumberOfInstance(ComputeEngine computeEngine) {
        numberOfInstancesField.sendKeys(computeEngine.getNumberOfInstances());
        return this;
    }

    public ComputeEnginePage selectOSValue(ComputeEngine computeEngine) {
        String OSValueXpath = String.format("//div[contains(text(), '%s')]/ancestor::md-option", computeEngine.getOperatingSystem());

        executor.executeScript("arguments[0].click();", operatingSystemDropdown);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OSValueXpath)));

        driver.findElement(By.xpath(OSValueXpath)).click();
        return this;
    }

    public ComputeEnginePage selectMachineClass(ComputeEngine computeEngine) {
        String machineClassTypeXpath = String.format("//md-select[@placeholder='VM Class']//div[@class='md-text' and text()='%s']", computeEngine.getMachineClass());

        executor.executeScript("arguments[0].scrollIntoView();", machineClassField);
        executor.executeScript("arguments[0].click();", machineClassField);
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(machineClassTypeXpath)));
        return this;
    }

    public ComputeEnginePage selectSeries(ComputeEngine computeEngine) {
        String seriesXpath = String.format("//div[contains(text(), '%s')]", computeEngine.getSeries());

        executor.executeScript("arguments[0].click();", seriesDropdown);
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(seriesXpath)));
        return this;
    }

    public ComputeEnginePage selectInstanceType(ComputeEngine computeEngine) {
        String instanceTypeXpath = String.format("//md-option/div[contains(text(), '%s')]", computeEngine.getInstanceType());

        executor.executeScript("arguments[0].click();", machineTypeDropdown);
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(instanceTypeXpath)));
        return this;
    }

    public ComputeEnginePage changeAddGPUCheckBoxState() {

        executor.executeScript("arguments[0].scrollIntoView();", addGPUCheckbox);
        executor.executeScript("arguments[0].click();", addGPUCheckbox);
        return this;
    }

    public ComputeEnginePage setNumberOfGPUs(ComputeEngine computeEngine) {
        String fullXPath = String.format("//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]' and @value='%s']", computeEngine.getNumberOfGPU());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-select[@placeholder='Number of GPUs']")));

        executor.executeScript("arguments[0].click();", numberOfGPUsDropdown);
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(fullXPath)));
        return this;
    }

    public ComputeEnginePage setGPUType(ComputeEngine computeEngine) {
        executor.executeScript("arguments[0].click();", GPUTypeDropdown);
        String GPUTypeXpath = String.format("//div[contains(text(),'%s')]", computeEngine.getGPUType());
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(GPUTypeXpath)));
        return this;
    }

    public ComputeEnginePage setLocalSSD(ComputeEngine computeEngine) {
        String localSSDXpath = String.format("//div[contains(text(), '%s')]", computeEngine.getLocalSSD());

        executor.executeScript("arguments[0].click();", localSSDDropdown);
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(localSSDXpath)));
        return this;
    }

    public ComputeEnginePage setDataCenterLocation(ComputeEngine computeEngine) {
        String countryXPath = String.format("//div[contains(text(), '%s')]", computeEngine.getDataCenterLocation());

        executor.executeScript("arguments[0].scrollIntoView();", dataCenterLocationDropdown);
        executor.executeScript("arguments[0].click();", dataCenterLocationDropdown);
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(countryXPath)));
        return this;
    }

    public ComputeEnginePage setCommitedUsage(ComputeEngine commitedUsage) {
        String commitedUsageXPath = String.format("//div[text()='%s']", commitedUsage.getCommittedUsage());

        executor.executeScript("arguments[0].scrollIntoView();", committedUsageDropdown);
        executor.executeScript("arguments[0].click();", committedUsageDropdown);
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(commitedUsageXPath)));
        return this;
    }

    public ComputeEnginePage submitComputeEngineForm() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")));

        executor.executeScript("arguments[0].scrollIntoView();", addToEstimateButton);
        executor.executeScript("arguments[0].click();", addToEstimateButton);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Total Estimated Cost:')]")));
        return this;
    }

    public ComputeEnginePage submitEmailEstimate(String emailAddressToSend) {

        executor.executeScript("arguments[0].scrollIntoView();", emailEstimateButton);
        executor.executeScript("arguments[0].click();", emailEstimateButton);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@name='emailForm']//label[contains(text(), 'Email')]")));

        emailAddressField.sendKeys(emailAddressToSend);
        executor.executeScript("arguments[0].scrollIntoView();", sendEmailButton);
        executor.executeScript("arguments[0].click();", sendEmailButton);
        return this;
    }

    public String getEstimatedPrice() {
        Pattern pattern = Pattern.compile("USD(\\s[\\d,.]+)");
        Matcher matcher = pattern.matcher(estimatedPriceText.getText());
        matcher.find();
        return matcher.group();
    }
}
