package com.ryanair.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ryanair.utils.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	public TestBase(){
		
		try{
			
			//Read the properties file 
			prop = new Properties();
			FileInputStream ip = new FileInputStream("config"+File.separator+"config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
	
	public static void initialization(){
		String browsername = prop.getProperty("browser");
		
		//provide the path for the respective drivers correctly
		
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","externals"+File.separator+"chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browsername.equals("firefox")){
			System.setProperty("webdriver.firefox.driver", "externals"+File.separator+"geckodriver.exe");
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait= new WebDriverWait(driver, 10);
		
		
		
	}
	
}
