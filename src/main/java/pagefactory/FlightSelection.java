package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.WaitFunctionality;

public class FlightSelection {
	@FindBy(how=How.XPATH, using ="//div[@class='colZero leg col12 last']/nav[@class='listViewNav']//li[2]//input[@type='radio']") WebElement departRadioBtn;
	@FindBy(how=How.XPATH, using ="//div[@class='row roundTripHead'][@style='display: block;']//button[@type='submit']") WebElement bookBtn;
	
	
	public void waitTillBookBtn(WebDriver driver){
		new WaitFunctionality().FluentWaitUtil(driver, departRadioBtn);
	}
	
	public void bookflight(){
		departRadioBtn.click();
		System.out.println(departRadioBtn.isDisplayed());
		bookBtn.click();
	}
	
}
