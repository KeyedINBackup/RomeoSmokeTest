package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {

	private static WebElement element=null;
	
	public static WebElement SystemAdminLink(WebDriver dr){
		element=dr.findElement(By.xpath(".//*[@id='content']/ul/li[4]/a"));
		return element;
		
	}
	
	public static WebElement ResearcherPortalLink(WebDriver dr){
		element=dr.findElement(By.xpath(".//*[@id='content']/ul/li[2]/a"));
		return element;
		
	}
}
