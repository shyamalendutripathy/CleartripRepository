package cleartrip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.FlightSelection;
import pagefactory.SelectFlightsFactory;

public class LoginInvoke {
	@Test
	public void search(){
		LoginInstance instance=LoginInstance.init();
		WebDriver driver= instance.returnDriver();
		
		SelectFlightsFactory searchPageObj=PageFactory.initElements(driver, SelectFlightsFactory.class);
		searchPageObj.enterRoundTripBtn();
		
		searchPageObj.enterFromToTextBox(driver,"Delhi","Bhubaneswar");
		
		searchPageObj.selectDate(driver);
		searchPageObj.selectSeats("2", "0", "0");
		searchPageObj.search();
		
		FlightSelection selection=new FlightSelection();
		selection.waitTillBookBtn(driver);
		
		System.out.println("Welcome After Wait");
		
	}
}
