package stepDef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class myFirstTest {

	WebDriver driver;

	WebDriverWait wait;
	

@Given("user open the browser")
public void user_open_the_browser() {
   driver = new ChromeDriver();
}


	@Given("user maximize the browser")
	public void user_maximize_the_browser() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 40);
	}

	@When("user open the URL {string}")
	public void user_open_the_url(String appUrl) {
		driver.get(appUrl);
	}

	@Then("user is gets redirected to {string}")
	public void user_is_gets_redirected_to(String appLandingPageTitle) {

		Assert.assertEquals("Page title is incorrect", appLandingPageTitle, driver.getTitle());

	}

	@Then("user close the browser")
	public void user_close_the_browser() {
		driver.quit();
	}

//	@Given("user click on signin butten")
//	public void user_click_on_signin_butten1() {
//		WebElement signInButton = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
//		signInButton.click();
//	}

	@When("user enter his registered {string}")
	public void user_enter_his_registered(String string) {
		WebElement userEmailIdField = driver.findElement(By.id("email"));
	wait.until(ExpectedConditions.visibilityOf(userEmailIdField));
		userEmailIdField.sendKeys("usertest123@gmail.com");
	}

	@When("user click on signin butten")
	public void user_click_on_signin_butten() {
		WebElement signinButton = driver.findElement(By.id("SubmitLogin"));
		signinButton.click();
	}

	@Then("user first and last name is displayed as {string} in top right corner")
	public void user_first_and_last_name_is_displayed_as_in_top_right_corner(String string) {
	wait.until(ExpectedConditions.titleIs("My account - My Store"));
		WebElement userFirstNameLastName = driver.findElement(By.xpath("//a[@title='View my customer account']/span"));
		Assert.assertEquals("User name is not matching user the given one", userFirstNameLastName,
				userFirstNameLastName.getText());
	}

	@Then("user is able to see the main categories")
	public void user_is_able_to_see_the_main_categories(io.cucumber.datatable.DataTable dataTable) {
		
		//List<String> mainCatogiesList = mainCategories;
		List<WebElement> actualMainCategoriesList = driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li"));
		for(int i = 0; i<actualMainCategoriesList.size();i++) 
		{
		System.out.println(	(i+1)+") "+actualMainCategoriesList.get(i).getText());
			
		}
		
//		
//		for (int i = 0; i < mainCatogiesList.size(); i++) {
//			Assert.assertEquals(mainCatogiesList.get(i), actualMainCategoriesList.get(i).getText());
//		}

	}

	@When("user search for product {string}")
	public void user_search_for_product(String productName) {
		WebElement searchBoxElement = driver.findElement(By.id("search_query_top"));
		wait.until(ExpectedConditions.elementToBeClickable(searchBoxElement));
		searchBoxElement.sendKeys(productName);
		WebElement searchButtonElement = driver.findElement(By.name("submit_search"));
		searchButtonElement.click();
	}

	@Then("Search result page is displayed")
	public void search_result_page_is_displayed() {
		List<WebElement> productContainers = driver.findElements(By.xpath("//div[@class='product-container']"));
		for (int i = 0; i < productContainers.size(); i++) {
			Assert.assertTrue(productContainers.get(i).isDisplayed());
		}

	}
}
