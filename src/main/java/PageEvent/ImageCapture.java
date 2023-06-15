package PageEvent; 
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; 
import Base.BaseTest;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class ImageCapture extends BaseTest{

	public void captureimage() throws IOException, InterruptedException {
		
		//*************************Capture Image***********************//
		 WebElement logoimage = driver.findElement(By.xpath("//img[@alt='Truepowerlogo']"));
		 Thread.sleep(20000);
		 Screenshot logoimageScreenshot  = new AShot().takeScreenshot(driver,logoimage);
		 ImageIO.write(logoimageScreenshot.getImage(),"png",new File("./images/logoimage.png"));
		 
		 File logo = new File("./images/logoimage.png");
		 if(logo.exists()==true) {
			 System.out.println("Image File Is Captured");
		 }
		 else {
			 System.out.println("Image File Is Not Captured");
		 }
		 
	}
}
