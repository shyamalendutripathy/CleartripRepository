package pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectFlightsFactory {
	@FindBy(how=How.XPATH, using ="//input[@id='RoundTrip']") WebElement roundTripBtn;
	@FindBy(how=How.XPATH, using ="//input[@id='FromTag']") WebElement fromTextBox;
	@FindBy(how=How.XPATH, using ="//input[@id='ToTag']") WebElement toTextBox;
	@FindBy(how=How.XPATH, using ="//ul[@id='ui-id-1']/li/a") WebElement fromFirstVal;
	@FindBy(how=How.XPATH, using ="//ul[@id='ui-id-2']/li/a") WebElement toFirstVal;
	
	
	@FindAll(@FindBy(how=How.XPATH, using ="//input[@id='DepartDate']")) WebElement departDateTextBox;
	@FindAll(@FindBy(how=How.XPATH, using ="//input[@id='ReturnDate']")) WebElement returnDateTextBox;
	//select[@id='Adults']
	@FindBy(how=How.ID, using ="Adults") WebElement adultNo;
	@FindBy(how=How.ID, using ="Childrens") WebElement childrenNo;
	@FindBy(how=How.ID, using ="Infants") WebElement infantNo;
	
	@FindBy(how=How.XPATH, using ="//input[@id='SearchBtn']") WebElement searchBtn;
	
	public void enterRoundTripBtn(){
		roundTripBtn.click();
	}
	
	public void enterFromToTextBox(WebDriver driver,String from,String to){
		fromTextBox.click();
		fromTextBox.sendKeys(from);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		fromFirstVal.click();

		toTextBox.click();
		toTextBox.sendKeys(to);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		toFirstVal.click();
	}
	
	public void selectDate(WebDriver driver){
		SearchCalendarFactory searchPageObj=PageFactory.initElements(driver, SearchCalendarFactory.class);
		searchPageObj.selectDepartDate(driver);
	}
	
	public void selectSeats(String adults,String children,String infants){
		Select adult=new Select(adultNo);
		Select children1=new Select(childrenNo);
		Select infant=new Select(infantNo);
		
		Integer adultInt=Integer.parseInt(adults);
		Integer childrenInt=Integer.parseInt(children);
		Integer infantInt=Integer.parseInt(infants);
		
		
		adult.selectByIndex(--adultInt);
		children1.selectByIndex(childrenInt);
		infant.selectByIndex(infantInt);
	}
	
	public void search(){
		searchBtn.click();
	}

}
