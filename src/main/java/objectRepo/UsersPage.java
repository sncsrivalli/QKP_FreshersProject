package objectRepo;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

	@FindBy(xpath = "//h1[contains(text(),'Users')]")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//a[text() = ' New']")
	private WebElement newBTN;
	
	@FindBy(xpath = "//input[@id='email' and @required]")
	private WebElement emailTF;
	
	@FindBy(xpath = "//input[@id='password' and @required]")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//input[@id='firstname' and @required]")
	private WebElement firstnameTF;
	
	@FindBy(xpath = "//input[@id='lastname' and @required]")
	private WebElement lastnameTF;
	
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addressTextArea;
	
	@FindBy(xpath = "//input[@id='contact']")
	private WebElement contactTF;
	
	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement chooseFile;
	
	@FindBy(xpath = "//button[@name='add']")
	private WebElement saveBTN;
	
	public UsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void clickNewBTN() {
		newBTN.click();
	}
	
	public void createUser(Map<String, String> map) {
		emailTF.sendKeys(map.get("Email"));
		passwordTF.sendKeys(map.get("Password"));
		firstnameTF.sendKeys(map.get("Firstname"));
		lastnameTF.sendKeys(map.get("Lastname"));
		addressTextArea.sendKeys(map.get("Address"));
		contactTF.sendKeys(map.get("Contact Info"));
		chooseFile.sendKeys(map.get("Photo"));
		saveBTN.click();
	}
}
