package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import objectRepo.CourseListPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.UsersPage;

public class BaseClass {

	//@BeforeSuite
	//@BeforeTest
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected JavaUtility jutil;
	
	protected WebDriver driver;
	
	protected LoginPage login;
	protected HomePage home;
	protected CourseListPage course;
	protected UsersPage users;
	
	@BeforeClass
	public void classConfig() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		web = new WebDriverUtility();
		jutil = new JavaUtility();
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		
		driver = web.launchBrowser(property.getDataFromProperties("browser"));
		web.maximizeBrowser();
		
		long time = (Long) jutil.parseStringToAnyDatatype("long", property.getDataFromProperties("timeouts"));
		web.waitTillElementFound(time);
	}
	
	@BeforeMethod
	public void methodConfig() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		course = new CourseListPage(driver);
		users = new UsersPage(driver);
		
		web.navigateToApp(property.getDataFromProperties("url"));
		login.setEmail(property.getDataFromProperties("username"));
		login.setPassword(property.getDataFromProperties("password"));
		login.clickLogin();
		
		excel.excelInit(IConstantPath.EXCEL_PATH, "Sheet1");
	}
	
	@AfterMethod
	public void methodTeardown() {
		home.signOutOfSkillrary();
		excel.saveExcel(IConstantPath.EXCEL_PATH);
	}
	
	@AfterClass
	public void classTeardown() {
		web.quitBrowsers();
		excel.closeExcel();
	}
	
	//@AfterTest
	//@AfterSuite
}
