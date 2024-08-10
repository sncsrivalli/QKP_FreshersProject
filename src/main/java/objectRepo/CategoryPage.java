package objectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CategoryPage {

	@FindBy(xpath = "//h1[contains(text(),'Category')]")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//a[text() = ' New']")
	private WebElement newBTN;
	
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement alert;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameTF;
	
	@FindBy(xpath = "//button[@name='add']")
	private WebElement saveBTN;
	
	private String dynamicPathForDelete = "//td[text()='%s']/following-sibling::td/button[text()=' Delete']";
	
	@FindBy(xpath = "//button[@name='delete']")
	private WebElement deleteBTN;
	
	@FindBy(xpath = "//td[@class='sorting_1']")
	private List<WebElement> categoryList;
	
	public CategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public String getAlertMessage() {
		return alert.getText();
	}
	
	public void clickNewBTN() {
		newBTN.click();
	}
	
	public void deleteCategory(WebDriverUtility web, String categoryName) {
		web.convertdynamicXpathToWebElement(dynamicPathForDelete, categoryName).click();
		deleteBTN.click();
	}
	
	public boolean searchForCategory(String categoryName) {
		boolean isPresent = false;
		for (WebElement category : categoryList) {
			if(category.getText().equals(categoryName)) {
				isPresent = true;
				break;
			}	
		}
		return isPresent;
	}
	
	public void addCategory(String name) {
		nameTF.sendKeys(name);
		saveBTN.click();
	}
}
