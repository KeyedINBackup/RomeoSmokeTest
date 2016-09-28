package appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObjects.*;

public class RomeoSignInAction {

	public static void login(){
		WebDriver dr= new FirefoxDriver();
		dr.navigate().to("http://qa.researchservicesoffice.com/");
		homePage.SystemAdminLink(dr).click();
		RomeoLoginPage.LoginUserName(dr).sendKeys("su");
		RomeoLoginPage.LoginPassword(dr).sendKeys("sudemo");
		RomeoLoginPage.LoginButton(dr).click();
	}
}
