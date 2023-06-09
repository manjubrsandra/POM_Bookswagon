package com.bookswagon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.bookswagon.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\manju\\eclipse-workspace\\Bookswagan\\src\\main\\java\\com\\bookswagon\\qa\\config\\config.properties");
			
			prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}


  @SuppressWarnings("deprecation")
public static void initialization() {
	   String browserName=prop.getProperty("browser");
	   if(browserName.equals("chrome"))
	   {
		  WebDriverManager.chromedriver().setup(); 
	   }else if(browserName.equals("firefox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
	   }
	   
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   //driver.manage().timeouts().pageLoadTimeout((TestUtil.PAGE_LOAD_TIMEOUT),TimeUnit.SECONDS);
	  // driver.manage().timeouts().implicitlyWait((TestUtil.IMPLICIT_WAIT),TimeUnit.SECONDS);
	   
	   driver.get(prop.getProperty("url"));
  }
  
  
  
  }
	

