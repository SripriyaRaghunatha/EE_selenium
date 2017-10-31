package com.hotelbooking;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class TestBooking {

 private WebDriver driver;
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public void createBooking(String firstname, String lastName, String price, Boolean depositPaid, String checkinDate, String checkoutDate) {
	  setFirstName(firstname);
	  setSurName(lastName);
	  setPrice(price);
	  setDeposit(depositPaid);
	  setCheckinDate(checkinDate);
	  setCheckoutDate(checkoutDate);
	  driver.findElement(By.xpath("//*[@type='button' and @value=' Save ']")).click();
  }
  
  public void deleteAllBooking() {
	  List<WebElement> buttonArrays = driver.findElements(By.xpath("//*[@type='button' and @value='Delete']"));
	  System.out.println("No of Buttons: "+buttonArrays.size());
	  for(int bindex=0;bindex<buttonArrays.size(); bindex++){
		  buttonArrays.get(bindex).click();
	  }
  }
  
  public void deleteABooking(Integer bIndex) {
	  List<WebElement> buttonArrays = driver.findElements(By.xpath("//*[@type='button' and @value='Delete']"));
	  System.out.println("No of Buttons: "+buttonArrays.size());
	  buttonArrays.get(bIndex).click();	  
  }
  
  @Test
  public void getHotelReservationPage() {
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get("http://hotel-test.equalexperts.io/");
  }
  
  public void setFirstName(String firstName){
	driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstName);
  }
  
  public void setSurName(String surName){
	driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys(surName);
  }
  
  public void setPrice(String totalPrice){
	driver.findElement(By.xpath("//*[@id='totalprice']")).sendKeys(totalPrice);
  }
  
  public void setDeposit(Boolean depositPaid){
	Select paid = new Select(driver.findElement(By.xpath("//*[@id='depositpaid']")));
			paid.selectByVisibleText(String.valueOf(depositPaid));
  }
  
  public void setCheckinDate(String checkinDate){
	driver.findElement(By.xpath("//*[@id='checkin']")).sendKeys(checkinDate);
  }
  
  public void setCheckoutDate(String checkoutDate){
	driver.findElement(By.xpath("//*[@id='checkout']")).sendKeys(checkoutDate);
  }
    
  @Test(dependsOnMethods = { "getHotelReservationPage" })
  public void testDeleteAllBooking() {
	  deleteAllBooking();
  }

  @Test(dependsOnMethods = { "getHotelReservationPage" })
  public void testCreateBooking() {
	  createBooking("Priya","Raghu","100.00",true,"2017-10-31","2017-10-31");
	  createBooking("Pr&ya","R=ghu","10.55",true,"2020-10-31","2020-12-31");
  }
  

}
