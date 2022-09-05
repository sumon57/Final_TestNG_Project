package page;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test101Page {

	WebDriver driver;

	public Test101Page(WebDriver driver) {
		this.driver = driver;

	}

	String categoryType = "Sum-s" + new Random().nextInt(999);
	String duplicateType = "Sum-s";

	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[1]")
	WebElement CATEGORY_INSERT_BAR;
	@FindBy(how = How.XPATH, using = "//*[@id=\"extra\"]/input[2]")
	WebElement ADD_CATEGORY_BUTTON;
	@FindBy(how = How.XPATH, using = "//select[option='None'] [3]")
	WebElement MONTH_LIST;

	@Test
	public void addCategory() {
		CATEGORY_INSERT_BAR.sendKeys(categoryType);
		ADD_CATEGORY_BUTTON.click();
	}

	public void addCategory(String categoryName) {
		CATEGORY_INSERT_BAR.sendKeys(duplicateType);
		ADD_CATEGORY_BUTTON.click();
	}

	public void categoryDisplayed() {

		boolean actualDisplayed = driver.getPageSource().contains(categoryType);
		Assert.assertTrue(actualDisplayed);

	}

	public boolean assertduplicateCategory() {
		WebElement element = driver.findElement(By.tagName("body"));
		boolean str = element.getText().contains("The category you want to add already exists:");
		return str;
	}

	public void addDuplicate() {
		boolean expected = true;
		boolean actual = assertduplicateCategory();
		Assert.assertEquals(actual, expected);

	}

	public void validateMonthDropdown() {
		String arr[] = { "None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Select select = new Select(MONTH_LIST);
		List<WebElement> dropdownvalues = select.getOptions();

		for (int i = 0; i < dropdownvalues.size(); i++) {
//			System.out.println(dropdownvalues.get(i).getText());

			Assert.assertEquals(arr[i], dropdownvalues.get(i).getText());
		}
	}

}
