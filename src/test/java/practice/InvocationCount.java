package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCount {

	@Test(invocationCount = 0)
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
