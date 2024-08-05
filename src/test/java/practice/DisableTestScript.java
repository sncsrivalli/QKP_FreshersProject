package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DisableTestScript {

	@Test(enabled = false)
	public void test1() {
		Reporter.log("test1", true);
	}
	
	@Test(invocationCount = 3)
	public void test2() {
		Reporter.log("test2", true);
	}
	
	@Test(invocationCount = -3)
	public void test3() {
		Reporter.log("test3", true);
	}
}
