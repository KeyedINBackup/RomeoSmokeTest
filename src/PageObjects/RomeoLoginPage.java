package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RomeoLoginPage {

	private static WebElement element=null;
	public static WebElement LoginUserName(WebDriver dr){
		element=dr.findElement(By.id("txtUsername"));
		return element;	
	}
	
	public static WebElement LoginPassword(WebDriver dr){
		element=dr.findElement(By.id("txtPassword"));
		return element;	
	}
	
	public static WebElement LoginButton(WebDriver dr){
		element=dr.findElement(By.id("btn_SignIn"));
		return element;	
	}
	
	
}
