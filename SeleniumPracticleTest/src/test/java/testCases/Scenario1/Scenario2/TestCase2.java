package testCases.Scenario1.Scenario2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseTest;

public class TestCase2 extends BaseTest {

	@Test
	public void validateDragAndDropSliders() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		Thread.sleep(1000);
		WebElement clickOnLink = driver.findElement(By.xpath(locator.getProperty("dragAndDrop_Link")));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnLink));
		clickOnLink.click();

		Thread.sleep(1000);
		WebElement slider15 = driver.findElement(By.xpath(locator.getProperty("defalutValue15_Slider")));
		wait.until(ExpectedConditions.visibilityOf(slider15));

		
		Actions slider = new Actions(driver);
		slider.clickAndHold(slider15);
	Thread.sleep(1000);
		slider.moveByOffset(212, 0).build().perform();

		WebElement sliderValue = driver.findElement(By.xpath(locator.getProperty("defaultValue15_SliderValue")));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(sliderValue));
		String getActualSliderValue = sliderValue.getText();
		Assert.assertEquals(Integer.parseInt(getActualSliderValue), 95);

	}

}
