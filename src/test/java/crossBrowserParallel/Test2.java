package crossBrowserParallel;

import org.testng.annotations.Test;

public class Test2 extends BaseClass{

	@Test
	public void swiggy() {
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
	}
}
