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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import Utility.Constants;

public class awdUserAppReview {
	public static WebDriver dr;
	
	@Test(enabled=true, priority=1)
	public void AwdUserRMI() throws InterruptedException, AWTException {
	  	
		dr.findElement(By.xpath("html/body/div[1]/ul/li[1]/a")).click();
	  	dr.findElement(By.id("txtUsername")).sendKeys(Constants.AwardUser);
		dr.findElement(By.id("txtPassword")).sendKeys(Constants.AwardUserPass);
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
		TimeUnit.SECONDS.sleep(4);
		System.out.println("Applicationsen sent for More Information done successfuly");
	  }
  
  @Test(enabled=true, priority=2)
  public void ApplicationReSubmit() throws IOException, InterruptedException {
	  dr.findElement(By.xpath("html/body/div[1]/ul/li[2]/a")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.SuperUser);
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys(Constants.SuperUserPass);
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[10]/a")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.mail2);
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
	  TimeUnit.SECONDS.sleep(5);
  }
  
  @Test(enabled=true, priority=3)
	public void AwdUserAppApproval() throws InterruptedException, AWTException, IOException {
	  	
		dr.findElement(By.xpath("html/body/div[1]/ul/li[1]/a")).click();
	  	dr.findElement(By.id("txtUsername")).sendKeys(Constants.AwardUser);
		dr.findElement(By.id("txtPassword")).sendKeys(Constants.AwardUserPass);
		dr.findElement(By.id("btn_SignIn")).click();
		for(String win2:dr.getWindowHandles()){
			dr.switchTo().window(win2);
		}
		dr.findElement(By.partialLinkText("Recently Re-Submitted Applications")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_rptSubCategory_ctl00_dgPrimary_ctl03_imgbtnEdit")).click();
		dr.findElement(By.xpath(".//*[@id='ctl02_radtabstripApplication']/div/ul/li[4]/a/span/span/span")).click();
		dr.findElement(By.id("ctl02_ctl00_radgrdDocumentTracking_ctl00_ctl02_ctl00_imgbtnAddNew")).click();
		WebElement attachmentFrame=dr.findElement(By.name("rwDocumentTracking"));
		dr.switchTo().frame(attachmentFrame);
		dr.findElement(By.xpath(".//*[@id='fUploadFilerow0']/span")).click();
		Runtime.getRuntime().exec("C:\\Users\\sakthivel\\Documents\\Romeo Support\\Attachement1.exe");
		TimeUnit.SECONDS.sleep(5);
		dr.findElement(By.id("txtComments")).sendKeys("Test attachemnt002");
		dr.findElement(By.id("imgbtnSave1")).click();
		dr.switchTo().defaultContent();
		System.out.println("Document tracking Attachment added successfully");
		dr.findElement(By.xpath(".//*[@id='ctl02_radtabstripApplication']/div/ul/li[6]/a/span/span/span")).click();
		dr.findElement(By.id("ctl02_ctl00_radgrdMileStones_ctl00_ctl02_ctl00_imgbtnAddNew")).click();
		WebElement MilestoneFrame=dr.findElement(By.name("rwMileStoneTask"));
		dr.switchTo().frame(MilestoneFrame);
		Select milestone= new Select(dr.findElement(By.id("cboMileStoneName")));
		milestone.selectByIndex(3);
		dr.findElement(By.id("txtComment")).sendKeys("Milestone test comment");
		dr.findElement(By.id("rdpMileStoneDueDate_dateInput")).sendKeys("2016/10/22");
		dr.findElement(By.id("cbIsRemindResearcher")).click();
		dr.findElement(By.id("imgbtnSave")).click();
		System.out.println("Milestone created and Reminder added successfully");
		dr.findElement(By.xpath(".//*[@id='ctl02_radtabstripApplication']/div/ul/li[8]/a/span/span/span")).click();
		dr.findElement(By.id("ctl02_ctl00_radgrdCommunication_ctl00_ctl02_ctl00_imgbtnAddNew")).click();
		WebElement ComposeMailFrame=dr.findElement(By.name("rwSendEmail"));
		dr.switchTo().frame(ComposeMailFrame);
		dr.findElement(By.id("txtTo")).sendKeys("ppromeotest@gmail.com");
		WebElement EMailContentFrame=dr.findElement(By.id("rtbEmailBody_contentIframe"));
		dr.switchTo().frame(EMailContentFrame);
		dr.findElement(By.xpath("html/body")).sendKeys("This is sample mail for testing purpose");
		Robot object=new Robot();
		object.delay(2000);
		object.keyPress(KeyEvent.VK_TAB);
		object.keyRelease(KeyEvent.VK_TAB);
		object.keyPress(KeyEvent.VK_ENTER);
		object.keyRelease(KeyEvent.VK_ENTER);
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Mail sent successfully");
		dr.findElement(By.id("ctl02_imgbtnWorkFlowAction")).click();
		WebElement Frame6=dr.findElement(By.name("rwWorkFlow"));
		dr.switchTo().frame(Frame6);
		dr.findElement(By.id("imgBtnSubmit")).click();
		TimeUnit.SECONDS.sleep(5);
		System.out.println("Application Approved successfully");
	  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  	dr= new FirefoxDriver();
		dr.navigate().to(Constants.BaseURL);
//		dr.navigate().to(Constants.RPURL);
		dr.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	  	dr.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		
  }

  @AfterMethod
  public void afterMethod() {
	  dr.close();
	  dr.quit();
  }

}
