package cleartrip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagefactory.EditBookinginfo;
import pagefactory.FlightSelection;
import pagefactory.SelectFlightsFactory;

public class LoginInvoke {
	final Integer adultSeats=2;
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
		
		
		FlightSelection selection=PageFactory.initElements(driver,FlightSelection.class);
		
		selection.waitTillBookBtn(driver);
		selection.bookflight();
		
		
		EditBookinginfo bookObj=PageFactory.initElements(driver,EditBookinginfo.class);
		
		bookObj.performAndBookItenerary(driver);
		bookObj.enterEmailAndContinue(driver,"stripathy210@gmail.com");
		
		String[] fName=new String[adultSeats];
		fName[0]="firstabcd";
		fName[1]="firstxyzw";
		
		String[] lName=new String[adultSeats];
		lName[0]="lastabcd";
		lName[1]="lastxyzw";
		
		bookObj.enterPassengerDetails(driver,fName, lName, "9717297235");
	}
}
