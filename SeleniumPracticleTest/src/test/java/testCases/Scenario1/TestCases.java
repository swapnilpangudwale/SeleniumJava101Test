package testCases.Scenario1;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseTest;

import org.testng.annotations.Test;

public class TestCases extends BaseTest {

	@Test
	public void tc_01_ValidateTextMessage() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement simpleFormDemo_Link = driver.findElement(By.xpath(locator.getProperty("simpleFormDemo_Link")));
		wait.until(ExpectedConditions.elementToBeClickable(simpleFormDemo_Link));
		simpleFormDemo_Link.click();

	
		String actualURL = driver.getCurrentUrl();
		wait.until(ExpectedConditions.urlContains("simple-form-demo"));
		Assert.assertTrue(actualURL.contains("simple-form-demo"));
		
		WebElement enterMessage = driver.findElement(By.xpath(locator.getProperty("enterMessage_TxtBox")));
		wait.until(ExpectedConditions.visibilityOf(enterMessage));
		enterMessage.sendKeys(prop.getProperty("message"));

		WebElement clickOnGetCheckedValue = driver.findElement(By.id(locator.getProperty("getCheckedValue_Button")));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnGetCheckedValue));
		clickOnGetCheckedValue.click();

		WebElement msg = driver.findElement(By.xpath(locator.getProperty("actualMessage")));
		wait.until(ExpectedConditions.visibilityOf(enterMessage));
		String getActualMsg = msg.getText();

		Assert.assertEquals(prop.getProperty("message"), getActualMsg);

	}

}
