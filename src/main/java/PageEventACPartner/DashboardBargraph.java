package PageEventACPartner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Base.BaseTest;
import Utils.ElementFetch;

public class DashboardBargraph extends BaseTest{

	ElementFetch ele = new ElementFetch();
	public void pirchart() throws InterruptedException {
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='19-Jun-2023']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Last Month']")).click();
		driver.findElement(By.xpath("//*[text()='Apply']")).click(); 
		Thread.sleep(3000); 
		Actions act = new Actions (driver);
		driver.findElement(By.tagName("canvas")).click();
		List<WebElement> canvasElements = driver.findElements(By.className("g2-tooltip-name"));
	 
		
		 for (WebElement canvas : canvasElements) {
	           act.moveToElement(canvas).build().perform();
	           js.executeScript("window.scrollBy(0,500)"); 
	           System.out.println(canvas.getText());
	}}
	
}
