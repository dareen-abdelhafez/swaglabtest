package firstproject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new EdgeDriver();

	@BeforeTest

	public void mysetup() {

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)

	public void login() throws InterruptedException {
		
		//ELEMENTS

		WebElement UserNameInputFeild = driver.findElement(By.id("user-name"));
		WebElement PasswordInputFeild = driver.findElement(By.id("password"));
		WebElement LogInButton = driver.findElement(By.id("login-button"));
       //ACTIONS
		UserNameInputFeild.sendKeys("standard_user");

		PasswordInputFeild.sendKeys("secret_sauce");

		LogInButton.click();
		Thread.sleep(1000);

	}

	@Test(priority = 2)

	public void addTocart() throws InterruptedException {

		WebElement FirstItem=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		WebElement SecondElement =driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));

		FirstItem.click();
		SecondElement.click();
		Thread.sleep(2000);

	}
	
	
	@Test(priority = 3)

	public void RemoveFromCart() throws InterruptedException {

		WebElement FirstItem=driver.findElement(By.id("remove-sauce-labs-backpack"));
		WebElement SecondElement =driver.findElement(By.id("remove-sauce-labs-bike-light"));

		FirstItem.click();
		SecondElement.click();
		Thread.sleep(2000);

	}
	@Test(priority = 4)

	public void addTocartAfterRemove() throws InterruptedException {

		WebElement FirstItem=driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		WebElement SecondElement =driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));

		FirstItem.click();
		SecondElement.click();
		Thread.sleep(2000);

	}
	
	
	
	
	
	
	
	

	@Test(priority = 5)

	public void CheckOut() throws InterruptedException {

		
		driver.navigate().to("https://www.saucedemo.com/cart.html");
		
		WebElement CheckOutButton=driver.findElement(By.id("checkout"));
		CheckOutButton.click();

		WebElement FirstName =driver.findElement(By.id("first-name"));
		WebElement LastName=driver.findElement(By.id("last-name"));
		WebElement PostalCode=driver.findElement(By.id("postal-code"));



		FirstName.sendKeys("Dareen");
		LastName.sendKeys("Abdelhafez");
		PostalCode.sendKeys("11110");
		
		WebElement ContinueButton=driver.findElement(By.name("continue"));
		ContinueButton.click();
		WebElement FinishButton=driver.findElement(By.id("finish"));
		FinishButton.click();
		WebElement HomeButton=driver.findElement(By.id("back-to-products"));
		HomeButton.click(); 

	}

	


	@Test(priority = 6)
	public void logout() throws InterruptedException {
		WebElement BurgerMenu=driver.findElement(By.id("react-burger-menu-btn"));
		BurgerMenu.click();

		Thread.sleep(1000);

		WebElement LogInButton=driver.findElement(By.id("logout_sidebar_link"));
		LogInButton.click();
 
	}

	@AfterTest

	public void afterthetestisdone() {

		driver.close();

	}

}
