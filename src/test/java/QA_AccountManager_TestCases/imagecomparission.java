package QA_AccountManager_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.ImageComparission;

public class imagecomparission extends BaseTest {
	
	ImageComparission img = new ImageComparission();
	
	@Test
	public void logocomparission() throws IOException {
		img.imagecomparission();
		
	}

}
