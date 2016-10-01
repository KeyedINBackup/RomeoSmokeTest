package ExecutionEngine;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class awdUserAppReview {
	public static WebDriver dr;
	
	@Test(enabled=false, priority=1)
	public void AwdUserRMI() throws InterruptedException, AWTException {
	  	
		dr.findElement(By.xpath("html/body/div[1]/ul/li[4]/a")).click();
	  	dr.findElement(By.id("txtUsername")).sendKeys("awd_user");
		dr.findElement(By.id("txtPassword")).sendKeys("demo");
		dr.findElement(By.id("btn_SignIn")).click();
		for(String win2:dr.getWindowHandles()){
			dr.switchTo().window(win2);
		}
		dr.findElement(By.partialLinkText("New Applications")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_rptSubCategory_ctl00_dgPrimary_ctl03_imgbtnEdit")).click();
		dr.findElement(By.id("ctl02_imgbtnWorkFlowAction")).click();
		WebElement Frame2=dr.findElement(By.name("rwWorkFlow"));
		dr.switchTo().frame(Frame2);
		dr.findElement(By.id("rbActionSelect_0")).click();
		TimeUnit.SECONDS.sleep(3);
		WebElement TXTfrme = dr.findElement(By.id("txtComments_contentIframe"));
		dr.switchTo().frame(TXTfrme);
		dr.findElement(By.xpath("html/body")).sendKeys("Request More Information");
		dr.switchTo().defaultContent();
		Robot object = new Robot();
		object.delay(2000);
		object.keyPress(KeyEvent.VK_TAB);
		object.keyRelease(KeyEvent.VK_TAB);
		object.keyPress(KeyEvent.VK_ENTER);
		object.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Applicationsen for More Information successfuly");
	  }
  
  @Test(enabled=true, priority=2)
  public void ApplicationReSubmit() throws IOException, InterruptedException {
	  dr.findElement(By.xpath("html/body/div[1]/ul/li[2]/a")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys("su");
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys("sudemo");
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[10]/a")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys("ppromeotest@mailinator.com");
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	  dr.findElement(By.linkText("Applications: Requiring Attention*")).click();
	  dr.findElement(By.linkText("Edit")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnResubmit")).click();
	  WebElement Frame5=dr.findElement(By.name("WorkFlowCommentsWindow"));
	  dr.switchTo().frame(Frame5);
	  dr.findElement(By.id("txtComments")).sendKeys("Application ReSubmit to awduser");
	  TimeUnit.SECONDS.sleep(2);
	  dr.findElement(By.id("btnSubmit")).click();
	  System.out.println("Application Resubmitted to awduser successfuly");
	 
  }
  
  @Test(enabled=true, priority=1)
	public void AwdUserAppApproval() throws InterruptedException, AWTException {
	  	
		dr.findElement(By.xpath("html/body/div[1]/ul/li[4]/a")).click();
	  	dr.findElement(By.id("txtUsername")).sendKeys("awd_user");
		dr.findElement(By.id("txtPassword")).sendKeys("demo");
		dr.findElement(By.id("btn_SignIn")).click();
		for(String win2:dr.getWindowHandles()){
			dr.switchTo().window(win2);
		}
		dr.findElement(By.partialLinkText("Recently Re-Submitted Applications")).click();
		dr.findElement(By.xpath(".//*[@id='ctl02_radtabstripApplication']/div/ul/li[4]/a/span/span/span")).click();
		
	  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  	dr= new FirefoxDriver();
		dr.navigate().to("http://qa.researchservicesoffice.com");
		dr.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	  	dr.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		
  }

  @AfterMethod
  public void afterMethod() {
	  dr.close();
	  dr.quit();
  }

}
