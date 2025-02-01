package Scenario3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseTest;

public class TestCase3 extends BaseTest {

	@Test
	public void validateInputFromSubmit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		Thread.sleep(1000);
		WebElement inputFormSubmitLink = driver.findElement(By.xpath(locator.getProperty("inputFromSubmit_Link")));
		wait.until(ExpectedConditions.elementToBeClickable(inputFormSubmitLink));
		inputFormSubmitLink.click();

		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)");

		Thread.sleep(1000);
		WebElement submitButton = driver.findElement(By.xpath(locator.getProperty("submit_Button")));
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));

		submitButton.click();

		WebElement activeElement = driver.switchTo().activeElement();
		String actualRequiredMsg = activeElement.getAttribute("validationMessage");
		Thread.sleep(1000);
		System.out.println("Actual message appeared on screen: " + actualRequiredMsg);
		Assert.assertEquals(actualRequiredMsg, prop.getProperty("ExpectedRequiredMessage"));

		Thread.sleep(1000);
		WebElement nameTxtBox = driver.findElement(By.name(locator.getProperty("name_TxtBox")));
		wait.until(ExpectedConditions.visibilityOf(nameTxtBox));
		nameTxtBox.sendKeys(prop.getProperty("Name"));
Thread.sleep(1000);
		WebElement emilTxtBox = driver.findElement(By.id(locator.getProperty("email_TxtBox")));
		wait.until(ExpectedConditions.visibilityOf(emilTxtBox));
		emilTxtBox.sendKeys(prop.getProperty("Email"));

		Thread.sleep(1000);
		WebElement passwordTextBox = driver.findElement(By.name(locator.getProperty("password_TxtBox")));
		wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
		passwordTextBox.sendKeys(prop.getProperty("Password"));

		Thread.sleep(1000);
		WebElement companyTxtbox = driver.findElement(By.name(locator.getProperty("company_TxtBox")));
		wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
		companyTxtbox.sendKeys(prop.getProperty("Company"));

		Thread.sleep(1000);
		WebElement websiteTxtBox = driver.findElement(By.name(locator.getProperty("website_TxtBox")));
		wait.until(ExpectedConditions.visibilityOf(websiteTxtBox));
		websiteTxtBox.sendKeys(prop.getProperty("Website"));
Thread.sleep(1000);
		
		WebElement countryDrpDwn = driver.findElement(By.name(locator.getProperty("country_DrpDwn")));
		wait.until(ExpectedConditions.visibilityOf(countryDrpDwn));
		countryDrpDwn.click();

		Thread.sleep(1000);
		WebElement countryDrpDwnValue = driver.findElement(By.xpath(locator.getProperty("us_DrpDwnValue")));
		wait.until(ExpectedConditions.visibilityOf(countryDrpDwnValue));
		countryDrpDwnValue.click();

		Thread.sleep(1000);
		WebElement cityTxtbox = driver.findElement(By.name(locator.getProperty("city_TxtBox")));
		wait.until(ExpectedConditions.visibilityOf(cityTxtbox));
		cityTxtbox.sendKeys(prop.getProperty("City"));

		Thread.sleep(1000);
		WebElement addressTextBox1 = driver.findElement(By.name(locator.getProperty("address_TxtBox1")));
		wait.until(ExpectedConditions.visibilityOf(addressTextBox1));
		addressTextBox1.sendKeys(prop.getProperty("Address1"));

		Thread.sleep(1000);
		WebElement addressTextBox2 = driver.findElement(By.name(locator.getProperty("address_TxtBox2")));
		wait.until(ExpectedConditions.visibilityOf(addressTextBox2));
		addressTextBox2.sendKeys(prop.getProperty("Address2"));

		Thread.sleep(1000);
		WebElement stateTxtBox = driver.findElement(By.id(locator.getProperty("state")));
		wait.until(ExpectedConditions.visibilityOf(stateTxtBox));
		stateTxtBox.sendKeys(prop.getProperty("State"));

		Thread.sleep(1000);
		WebElement zipCodeTxtBox = driver.findElement(By.name(locator.getProperty("zipcode_TxtBox")));
		wait.until(ExpectedConditions.visibilityOf(zipCodeTxtBox));
		zipCodeTxtBox.sendKeys(prop.getProperty("ZipCode"));

		Thread.sleep(1000);
		WebElement submitBtn = driver.findElement(By.xpath(locator.getProperty("submit_Button")));
		wait.until(ExpectedConditions.visibilityOf(submitBtn));
		submitBtn.click();

		Thread.sleep(1000);
		WebElement successMsg = driver.findElement(By.xpath(locator.getProperty("success_Msg")));
		wait.until(ExpectedConditions.visibilityOf(successMsg));

		Thread.sleep(1000);
		String actualSuccessMsg = successMsg.getText();

		Assert.assertEquals(actualSuccessMsg, prop.getProperty("SuccessMsg"));

	}
}
