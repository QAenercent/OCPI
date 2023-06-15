package QA_AccountManager_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.ImageComparison;
 

public class imagecomparison extends BaseTest {
	
	ImageComparison img = new ImageComparison();
	
	@Test
	public void logocomparission() throws IOException {
		img.imagecomparison();
		
	}

}
