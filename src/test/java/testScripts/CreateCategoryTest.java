package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;

public class CreateCategoryTest extends BaseClass{

	@Test
	public void addCategoryTest() {
		SoftAssert soft = new SoftAssert();
		
		home.clickCoursesTab();
		home.clickCategory();
		
		soft.assertEquals(category.getPageHeader(), "Category");
		
		category.clickNewBTN();
		Map<String, String> map = excel.readFromExcel("Add Category");
		category.addCategory(map.get("Name"));
		
		soft.assertTrue(category.searchForCategory(map.get("Name")));
		soft.assertTrue(category.getAlertMessage().contains("Category added"));
		
		category.deleteCategory(web, map.get("Name"));
		
		soft.assertFalse(category.searchForCategory(map.get("Name")));
		soft.assertTrue(category.getAlertMessage().contains("Category deleted"));
		
		soft.assertAll();
	}
}
