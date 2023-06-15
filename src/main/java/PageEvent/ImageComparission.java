package PageEvent;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.BaseTest;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ImageComparission extends BaseTest{
  public void imagecomparission() throws IOException { 
	  
	  //****************************Comparision of Actual & Expected Images**************************//
	   BufferedImage expectedimage = ImageIO.read(new File("./images/logoimage.png"));
	   WebElement logoimageelement = driver.findElement(By.xpath("//img[@alt='Truepowerlogo']"));
	   Screenshot logoimageScreenshot  = new AShot().takeScreenshot(driver,logoimageelement);
	   
	   //****************************Captured & Stored Actual Image *******************************//
	   BufferedImage actualimage = logoimageScreenshot.getImage();
	   
	   ImageDiffer imagediffer = new ImageDiffer();
	   ImageDiff diff = imagediffer.makeDiff(expectedimage, actualimage);
	   if(diff.hasDiff()==true) {
		   System.out.println("Images Are Not Same");
	   }
	   else {
		   System.out.println("Images Are Same");
	   }
  }
	

}
