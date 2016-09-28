package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RPLoginPage {

	private static WebElement element=null;
	public static WebElement LoginUserName(WebDriver dr){
		element=dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName"));
		return element;	
	}
	
	public static WebElement LoginPassword(WebDriver dr){
		element=dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword"));
		return element;	
	}
	
	public static WebElement Language_Yes(WebDriver dr){
		element=dr.findElement(By.id("ctl00_ContentPlaceHolder1_rbtnUsePreferredLanguage_0"));
		return element;	
	}
	
	public static WebElement Language_No(WebDriver dr){
		element=dr.findElement(By.id("ctl00_ContentPlaceHolder1_rbtnUsePreferredLanguage_1"));
		return element;	
	}

	public static WebElement Login_btn(WebDriver dr){
		element=dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit"));
		return element;	
	}
	
	public static WebElement Resetpassword(WebDriver dr){
		element=dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnResetpassword"));
		return element;	
	}
	
}
