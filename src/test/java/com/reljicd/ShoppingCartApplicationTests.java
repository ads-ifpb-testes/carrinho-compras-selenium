package com.reljicd;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

public class ShoppingCartApplicationTests {

	private static WebDriver driver;
	private String baseUrl = "http://localhost:8070/";

	@BeforeClass
	public static void inicializarBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
	}

	@Before
	public void inicializarTeste() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void testarLogin() throws InterruptedException {
		driver.get(this.baseUrl + "login");
		WebElement element = driver.findElement(By.id("username"));
		Thread.sleep(1000L);
		element.sendKeys("user");
		Thread.sleep(2000L);
		element = driver.findElement(By.id("password"));
		element.sendKeys("pass");
		Thread.sleep(2000L);
		element = driver.findElement(By.tagName("form"));
		element.submit();
		Thread.sleep(2000L);
		assertEquals(this.baseUrl + "home", driver.getCurrentUrl());
	}

	@AfterClass
	public static void tearDownTest(){
		driver.quit();
	}

}
