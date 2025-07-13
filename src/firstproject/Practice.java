package firstproject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

   public class Practice {

		WebDriver driver = new EdgeDriver();

		@BeforeTest

		public void mySetup() {

			driver.get("https://www.saucedemo.com/");

			driver.manage().window().maximize();
		}

		@Test(priority = 1)
		public void login() throws InterruptedException {

			// Elements
			WebElement UserNameInputField = driver.findElement(By.id("user-name"));
			WebElement PasswordInputField = driver.findElement(By.id("password"));

			WebElement LoginButton = driver.findElement(By.id("login-button"));

			// actions

			UserNameInputField.sendKeys("standard_user");

			PasswordInputField.sendKeys("secret_sauce");

			LoginButton.click();

		}

		@Test(priority = 2 ,enabled=false)
		public void AddAllItemsToTheCart() {

			driver.findElements(By.className(".btn.btn_primary.btn_small.btn_inventory"));

			// static
			String[] mynames = { "ahmad", "ali", "anas", "omar" };

			System.out.println(mynames.length);

			// dyanmic

//			List<WebElement> prices = new ArrayList<WebElement>();
	//
//			WebElement firstItemPrice = driver.findElement(By.className("inventory_item_price"));
	//
//			prices.add(firstItemPrice);
//			
//			System.out.println(prices.get(0).getText());

			List<WebElement> AllThePrices = driver.findElements(By.className("inventory_item_price"));

//			System.out.println(AllThePrices.get(0).getText());
//			System.out.println(AllThePrices.get(1).getText());
//			System.out.println(AllThePrices.get(2).getText());
//			System.out.println(AllThePrices.get(3).getText());
//			System.out.println(AllThePrices.get(4).getText());
//			System.out.println(AllThePrices.get(5).getText());

			for (int i = 0; i < AllThePrices.size(); i++) {

				System.out.println(AllThePrices.get(i).getText());
			}

			List<WebElement> AllAddbuttons = driver.findElements(By.className("btn_primary"));
			
			for (int i = 0; i < AllAddbuttons.size(); i++) {
				
				if(i==3||i==4) {
					System.out.println("this item has been skipped");

					continue; 
				}

				AllAddbuttons.get(i).click();
			}

		}
		
		@Test(priority=3)
		public void additem() {
			
			
		List<WebElement> selectedPrices = driver.findElements(By.className("inventory_item_price"));
		List<WebElement> AllAddbuttons = driver.findElements(By.className("btn_primary"));
		
		List<WebElement> elementname=driver.findElements(By.className("inventory_item_name"));
		
		
		for(int i=0;i<elementname.size();i++)
		{
			if(i%2==0) {
				AllAddbuttons.get(i).click();
				System.out.println(elementname.get(i).getText()+"and the price is" +selectedPrices.get(i).getText()+" The item has been added");}
			else {
				System.out.println(elementname.get(i).getText()+"and the price is" +selectedPrices.get(i).getText()+" The item has not been added");
			}
			
			
		}
			
			
			
			
			
			
			
		}
		

	}

