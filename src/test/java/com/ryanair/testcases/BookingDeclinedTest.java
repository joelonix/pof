package com.ryanair.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ryanair.base.TestBase;
import com.ryanair.pages.BookingPage;
import com.ryanair.pages.HomePage;
import com.ryanair.pages.LoginPage;
import com.ryanair.pages.SeatSelectionPage;

public class BookingDeclinedTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage = new HomePage();
	BookingPage bookingPage = new BookingPage();
	SeatSelectionPage seatSelectionPage = new SeatSelectionPage();
	
	public BookingDeclinedTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void bookingDeclinedTest() throws InterruptedException{
		//provide username and password to login
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String flyoutdate = prop.getProperty("flyoutdate");
		String flyoutmonth = prop.getProperty("flyoutmonth");
		String flyoutyear = prop.getProperty("flyoutyear");
		String adults = prop.getProperty("adults");
		String children = prop.getProperty("children");
		String teens = prop.getProperty("teens");
		String infants = prop.getProperty("infants");
		
		//loginpage will return object of type homepage
		homePage = loginPage.login(username, password); 
		boolean flag = homePage.validateLoggedInUser(); //Assert loggedin user
		Assert.assertTrue(flag);
		
		
		
		//homePage.clickOnFlightstab();
		//homePage.clickOnReturn();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.elementToBeClickable(homePage.onewayradiobutton));
		homePage.clickOnOneWay();
		homePage.selectFromAirport();
		homePage.selectToAirport();
		homePage.selectFlyOutDate(flyoutdate, flyoutmonth, flyoutyear);
		
		Thread.sleep(3000);
		homePage.selectPassengers(adults, children, teens, infants);
		
		Thread.sleep(3000);
		bookingPage = homePage.clickOnLetsgobutton();
		Thread.sleep(3000);
		
		bookingPage.clickOnPriceButton();
		Thread.sleep(3000);
		
		bookingPage.clickOnStandardFare();
		Thread.sleep(3000);
		
		seatSelectionPage = bookingPage.clickOnContinue();
		Thread.sleep(3000);
		
		seatSelectionPage.clickOnOkGotItbutton();
		Thread.sleep(3000);
		
		seatSelectionPage.selectSeat();
		Thread.sleep(3000);
		
		
	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
		
	}

}
