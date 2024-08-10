package objectRepo;

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
	
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement alert;
	
	public UsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void clickNewBTN() {
		newBTN.click();
	}
	
	public void createUser(String email, String pwd, String firstName, String lastName, String address, String contact, String photo) {
		emailTF.sendKeys(email);
		passwordTF.sendKeys(pwd);
		firstnameTF.sendKeys(firstName);
		lastnameTF.sendKeys(lastName);
		addressTextArea.sendKeys(address);
		contactTF.sendKeys(contact);
		chooseFile.sendKeys(photo);
		saveBTN.click();
	}
	
	public String getAlertMessage() {
		return alert.getText();
	}
}
