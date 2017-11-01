package com.hotelbooking;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class booking {

 private static WebDriver driver;
  
//  @BeforeClass
//  public static void beforeClass() {
//	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//	  driver = new ChromeDriver();
//  }

  @AfterClass
  public static void afterClass() {
	  driver.quit();
  }
  
  public static void createBooking(String firstname, String lastName, String price, Boolean depositPaid, String checkinDate, String checkoutDate) {
	  setFirstName(firstname);
	  setSurName(lastName);
	  setPrice(price);
	  setDeposit(depositPaid);
	  setCheckinDate(checkinDate);
	  setCheckoutDate(checkoutDate);
	  driver.findElement(By.xpath("//*[@type='button' and @value=' Save ']")).click();
  }
  
  public static void deleteBooking() {
	  List<WebElement> buttonArrays = driver.findElements(By.xpath("//div[@id='bookings']//*[@type='button' and @value='Delete']"));
	  System.out.println("No of Buttons: "+buttonArrays.size());
	  for(int bindex=0;bindex<buttonArrays.size(); bindex++){
		  System.out.println("Button: "+bindex);
		  buttonArrays.get(bindex).click();
	  }
  }
  
  public static void deleteABooking(Integer bIndex) {
	  List<WebElement> buttonArrays = driver.findElements(By.xpath("//div[@id='bookings']//*[@type='button' and @value='Delete']"));
	  System.out.println("No of Buttons: "+buttonArrays.size());
	  buttonArrays.get(bIndex).click();	  
  }
  
  public static void getHotelReservationPage() {
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("http://hotel-test.equalexperts.io/");
  }
  
  public static void setFirstName(String firstName){
	driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstName);
  }
  
  public static void setSurName(String surName){
	driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(surName);
  }
  
  public static void setPrice(String totalPrice){
	driver.findElement(By.xpath("//*[@id='totalprice']")).sendKeys(totalPrice);
  }
  
  public static void setDeposit(Boolean depositPaid){
	Select paid = new Select(driver.findElement(By.xpath("//*[@id='depositpaid']")));
			paid.selectByVisibleText(String.valueOf(depositPaid));
  }
  
  public static void setCheckinDate(String checkinDate){
	driver.findElement(By.xpath("//*[@id='checkin']")).sendKeys(checkinDate);
  }
  
  public static void setCheckoutDate(String checkoutDate){
	driver.findElement(By.xpath("//*[@id='checkout']")).sendKeys(checkoutDate);
  }

}
