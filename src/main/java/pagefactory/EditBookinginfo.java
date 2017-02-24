package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import util.WaitFunctionality;

public class EditBookinginfo {
	@FindBy(how=How.ID, using ="insurance_box") WebElement insuranceBox;
	@FindBy(how=How.ID, using ="itineraryBtn") WebElement iteneraryBtn;
	@FindBy(how=How.ID, using ="username") WebElement emailbox;
	@FindBy(how=How.ID, using ="LoginContinueBtn_1") WebElement continueBtn;
	@FindBy(how=How.ID, using ="mobileNumber") WebElement mobileNo;
	@FindBy(how=How.ID, using ="travellerBtn") WebElement travellerBtn;
	
	
	public void performAndBookItenerary(WebDriver driver){
		new WaitFunctionality().FluentWaitUtil(driver, insuranceBox);
		insuranceBox.click();
		iteneraryBtn.click();
	}
	
	public void enterEmailAndContinue(WebDriver driver,String email){
		new WaitFunctionality().FluentWaitUtil(driver, emailbox);
		emailbox.click();
		emailbox.sendKeys(email);
		
		continueBtn.click();
	}
	
	public void enterPassengerDetails(WebDriver driver,String[] fName,String[] lName,String mobile){
		new WaitFunctionality().FluentWaitUtil(driver, mobileNo);
		int cnt=0;
		
		for (int i = 0; i < fName.length; i++) {
			int val=cnt;
			val++;
			WebElement fUsername=driver.findElement(By.id("AdultFname"+val));
			WebElement lUsername=driver.findElement(By.id("AdultLname"+val));
			WebElement lTitle=driver.findElement(By.id("AdultTitle"+val));
			fUsername.click();
			fUsername.sendKeys(fName[cnt]);
			lUsername.click();
			lUsername.sendKeys(lName[cnt]);
			
			Select select=new Select(lTitle);
//			Assuming it always selects 1
			select.selectByIndex(1);
			cnt++;
		}
		
		mobileNo.click();
		mobileNo.sendKeys(mobile);
		
		travellerBtn.click();
		
	}
	
}
