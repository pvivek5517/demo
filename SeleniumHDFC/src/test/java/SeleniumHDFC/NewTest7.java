package SeleniumHDFC;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest7 {
  @Test(groups = {"dry"})
  public void test1() {
	  System.out.println("test1");
  }
  
  @Test(groups = {"smoke"})
  public void test2() {
	  System.out.println("test2");
  }
  @Test(groups = {"dry", "smoke"})
  public void test3() {
	  System.out.println("test3");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method");
	  
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

}
