package QA_AccountManager_TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvent.ImageCapture;

public class Imangecapture extends BaseTest {
	ImageCapture logo = new ImageCapture();
	
	@Test
	public void captureimage() throws IOException, InterruptedException {
		logo.captureimage();
	}

}
