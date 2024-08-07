package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;

public class CreateCourseTest extends BaseClass {

	@Test
	public void createCourseTest() {
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCourseList();
		soft.assertEquals(course.getPageHeader(), "Course List");
		
		course.clickNewBTN();
		
		Map<String, String> map = excel.readFromExcel("Add Course");
		course.addCourse(web, map.get("Name"), map.get("Category"), 
				map.get("Price"), map.get("Photo"), map.get("Description"));
		course.addCourse(web, "AWS", "Testing", "10000", "C:\\Users\\jagua\\Downloads\\AWS.jpeg", "DevOps course");
		
		soft.assertTrue(course.getAlertMessage().contains("Course added"));
		soft.assertTrue(course.searchForCourse("AWS"));
		
		course.deleteCourse(web, "AWS");
		
		soft.assertFalse(course.searchForCourse("AWS"));
		soft.assertTrue(course.getAlertMessage().contains("Product deleted"));
		soft.assertAll();
	}
}
