package com.hrs.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.hrs.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop = new Properties();
		FileInputStream ip;
		try 
		{
			ip = new FileInputStream("D:\\Selenium_Programming\\HRS\\src\\main\\java\\com\\hrs\\qa\\config\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setAcceptInsecureCerts(true);
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-Maximized");
			options.addArguments("--incognito");
			options.merge(caps);
			
			driver = new ChromeDriver(options);	
		}
		else if(browserName.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("internetexplorer")) 
		{
			WebDriverManager.iedriver();
			driver = new InternetExplorerDriver();
		}
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));		
	}
}
