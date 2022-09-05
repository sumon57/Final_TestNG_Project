package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.Test101Page;
import util.BrowserFactory;

public class Test101 {
	
	WebDriver driver;

	@Test
	public void test() {
		driver = BrowserFactory.init();
		Test101Page testObj = PageFactory.initElements(driver, Test101Page.class);

		testObj.addCategory();
		testObj.categoryDisplayed();

		BrowserFactory.tearDown();

	}

}
