package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObjects.*;

public class RPSignInAction {

	public static void login(){
		WebDriver dr= new FirefoxDriver();
		dr.navigate().to("http://qa.researchservicesoffice.com/");
		homePage.ResearcherPortalLink(dr).click();
		RPLoginPage.LoginUserName(dr).sendKeys("su");
		RPLoginPage.LoginPassword(dr).sendKeys("sudemo");
		RPLoginPage.Login_btn(dr).click();
	}
}
