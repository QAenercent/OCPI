package PageEventACPartner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.imageio.ImageIO;
import java.io.File;
import Base.BaseTest;
import Utils.ElementFetch;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
public class Capturelogoimage extends BaseTest{
    WebDriver driver = new ChromeDriver();
	ElementFetch ele = new ElementFetch();
	String Logoimage = "//*[@alt='Truepowerlogo']";
	
	WebElement LogoimageElement = driver.findElement(By.xpath(Logoimage));
	Screenshot LogoimageScreenshot  = new AShot().takeScreenshot(driver, LogoimageElement);
//	ImageIO.Write(LogoimageScreenshot.getImage(), "png", new File("\\OCPI_AccountManager4\\ImageComparission\\title.png"));
//	
//	File logo = new File("//OCPI_AccountManager4//ImageComparission//title.png");
//	
//	if(logo.exists()) {
//		System.out.println("Image File Captured");
//	}
//	else {
//		System.out.println("Image File Not Captured");
//	}
}
