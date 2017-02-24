package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class WaitFunctionality {
	public void FluentWaitUtil(WebDriver driver,final WebElement element){
		FluentWait<WebDriver> wait = new FluentWait(driver)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver,WebElement>() {
			public WebElement apply(WebDriver driver) {
				if(element.isDisplayed()){
					return element;
				}
				else{
					return null;
				}
			}
		});
	}
}	
