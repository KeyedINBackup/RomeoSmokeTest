package ExecutionEngine;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Constants;

public class RPAppEveCreation {
	public static WebDriver dr;
	
  @Test(enabled=true, priority=0 )
  public void ApplicationCreation() throws InterruptedException, AWTException {
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[1]/a")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_dgAppFormList_ctl00_ctl02_ctl00_btnAddNew")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_dgAppFormList_ctl00_ctl02_ctl03_EditFormControl_rbtnEnableCSA_0")).click();
	  System.out.println("CSA enabled");
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_dgAppFormList_ctl00_ctl02_ctl03_EditFormControl_txtName")).sendKeys("Test Award App Form for Smoke Test checkup by PP Support.");
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_dgAppFormList_ctl00_ctl02_ctl03_EditFormControl_btnInsert")).click();
	  dr.findElement(By.linkText("Home")).click();
//	  WebElement TR=dr.findElement(By.xpath("html/body/form/div[5]/div[3]/div[1]/div[2]/table/tbody"));
//	  List<WebElement> AppFormRow=TR.findElements(By.tagName("tr"));
//	  int n=AppFormRow.size();
//	  System.out.println(n);
//	  String Str1="html/body/form/div[5]/div[3]/div[1]/div[2]/table/tbody/tr[";
//	  String Str2="]/td[6]/input";
//	  dr.findElement(By.xpath(Str1+n+Str2)).click();
	  
  }
  
  @Test(enabled=true, priority=1)
  public void EventCreation() throws AWTException, InterruptedException{
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[2]/a")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_dgEventFormList_ctl00_ctl02_ctl00_btnAddNew")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_dgEventFormList_ctl00_ctl02_ctl03_EditFormControl_cboEventCategory_Input")).sendKeys("p");
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_dgEventFormList_ctl00_ctl02_ctl03_EditFormControl_txtName")).sendKeys("Test Award Event Form for Smoke Test checkup by PP Support");
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_dgEventFormList_ctl00_ctl02_ctl03_EditFormControl_btnInsert")).click();
	  dr.findElement(By.linkText("Home")).click();
      
  }
      
  @BeforeTest
  public void SignIn() {
	  	dr= new FirefoxDriver();
		dr.navigate().to(Constants.RPURL);
		dr.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
//	  	dr.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.SuperUser);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys(Constants.SuperUserPass);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		
  }

  @AfterTest
  public void EOF() {
	  dr.close();
	  dr.quit();
  }

  
  
  
}
