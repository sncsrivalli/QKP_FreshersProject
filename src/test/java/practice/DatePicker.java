package practice;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		
		WebElement quickCreateDD = driver.findElement(By.id("qccombo"));
		Select s = new Select(quickCreateDD);
		s.selectByValue("Events");
		
		driver.findElement(By.name("subject")).sendKeys("Expo");
		driver.findElement(By.id("jscal_trigger_date_start")).click();
		
		int reqYear = 2025;
		int reqMonth = 6;
		String reqDate = "9";
		
		String currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[@class='title']")).getText();
		String[] str = currentMonthYear.split(", ");
		int currentYear = Integer.parseInt(str[1]);
		
		while(currentYear < reqYear) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[text()='»']")).click();
			
			currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[@class='title']")).getText();
			str = currentMonthYear.split(", ");
			currentYear = Integer.parseInt(str[1]);
		}
		
		int currentMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
		
		while(currentMonth < reqMonth) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[text()='›']")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[@class='title']")).getText();
			str = currentMonthYear.split(", ");
			currentMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
		}
		
		while(currentMonth > reqMonth) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[text()='‹']")).click();
			currentMonthYear = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[@class='title']")).getText();
			str = currentMonthYear.split(", ");
			currentMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
		}
		driver.findElement(By.xpath("//div[@class='calendar' and contains(@style, 'block')]/descendant::td[text()='"+reqDate+"']")).click();
		
	}

}
