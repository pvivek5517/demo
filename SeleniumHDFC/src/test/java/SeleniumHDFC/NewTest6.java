package SeleniumHDFC;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewTest6 {
	
	@Test
	public void testSoftHardAssert() {
		
		//HardAssert-- fails TC and stops execution
		//Assert.assertTrue(true);
		//Assert.assertTrue(false);
		//Assert.assertEquals(5, "5");
		//Assert.assertEquals(5, 5);
		
		//SoftAssert-- fails TC and continue to verify, all classes of Assert will be in softAssert
		
		SoftAssert softAssert= new SoftAssert();
		
		softAssert.assertTrue(true);
		softAssert.assertTrue(false);
		softAssert.assertEquals(5, "5");
		softAssert.assertEquals(5, 9);
		
		//This neeed to be mentioned to execute softAsserts
		softAssert.assertAll();
	}

}
