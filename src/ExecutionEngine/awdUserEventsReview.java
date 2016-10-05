package ExecutionEngine;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import Utility.Constants;

public class awdUserEventsReview {
	public static WebDriver dr;
	
	@Test(enabled=false, priority=1)
	public void EventSubmit() throws InterruptedException, AWTException, IOException {
	  	
//		dr.findElement(By.xpath("html/body/div[1]/ul/li[2]/a")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.SuperUser);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys(Constants.SuperUserPass);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[10]/a")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.mail2);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		dr.findElement(By.partialLinkText("Applications: Post-Review")).click();
		dr.findElement(By.linkText("Events")).click();
		dr.findElement(By.linkText("Test Award Event Form for Smoke Test checkup by PP Support")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_txtComments")).sendKeys("Test Notes");
		dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_tbsEventForm']/div/ul/li[2]/a/span/span/span")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_btnAdd")).click();
		WebElement UploadAttachment=dr.findElement(By.name("AttachmentAddPage"));
		dr.switchTo().frame(UploadAttachment);
		dr.findElement(By.id("txtAttachmentDescription")).sendKeys("Event attachment");
		dr.findElement(By.xpath(".//*[@id='upAttachmentrow0']/span")).click();
		Runtime.getRuntime().exec("C:\\Users\\sakthivel\\Documents\\Romeo Support\\EventAttachment1.exe");
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("btnAdd")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		WebElement WorkFlowFrame=dr.findElement(By.name("WorkFlowCommentsWindow"));
		dr.switchTo().frame(WorkFlowFrame);
		dr.findElement(By.id("txtComments")).sendKeys("Event First Submit");
		dr.findElement(By.id("btnSubmit")).click();
		System.out.println("Event submitted to awduser successfuly");
		TimeUnit.SECONDS.sleep(5);
	  }
  
  @Test(enabled=false, priority=2)
  public void AwdUserEventRMI() throws IOException, InterruptedException, AWTException {
	  
//	  	dr.findElement(By.xpath("html/body/div[1]/ul/li[1]/a")).click();
	  	dr.findElement(By.id("txtUsername")).sendKeys(Constants.AwardUser);
		dr.findElement(By.id("txtPassword")).sendKeys(Constants.AwardUserPass);
		dr.findElement(By.id("btn_SignIn")).click();
		for(String win2:dr.getWindowHandles()){
			dr.switchTo().window(win2);
		}
		dr.findElement(By.partialLinkText("New Events")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_rptSubCategory_ctl00_dgPrimary_ctl03_imgbtnEdit")).click();
		dr.findElement(By.xpath(".//*[@id='ctl02_radtabstripApplication']/div/ul/li[7]/a/span/span/span")).click();
		dr.findElement(By.id("ctl02_ctl00_ctl01_radgrdEvents_ctl00_ctl04_imgbtnEdit")).click();
		dr.findElement(By.id("ctl02_txtInternalNotes")).sendKeys("Internal test Notes");
		dr.findElement(By.id("ctl02_imgbtnWorkFlowAction")).click();
		WebElement ApprovalFrame=dr.findElement(By.name("rwWorkFlow"));
		dr.switchTo().frame(ApprovalFrame);
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
		dr.findElement(By.id("ctl02_imgbtnSaveAndClose")).click();
		TimeUnit.SECONDS.sleep(5);
	  
  }
  
  @Test(enabled=false, priority=3)
	public void EventReSubmit() throws InterruptedException, AWTException, IOException {
	  	
//		dr.findElement(By.xpath("html/body/div[1]/ul/li[2]/a")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.SuperUser);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys(Constants.SuperUserPass);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[10]/a")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.mail2);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		dr.findElement(By.partialLinkText("Events: Requiring Attention")).click();
		dr.findElement(By.linkText("Events")).click();
		dr.findElement(By.linkText("Edit")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnResubmit")).click();
		WebElement WorkFlowFrame=dr.findElement(By.name("WorkFlowCommentsWindow"));
		dr.switchTo().frame(WorkFlowFrame);
		dr.findElement(By.id("txtComments")).sendKeys("Event ReSubmit");
		dr.findElement(By.id("btnSubmit")).click();
		System.out.println("Event Resubmitted to awduser successfuly");
		TimeUnit.SECONDS.sleep(5);
	  }
  
  
  @Test(enabled=false, priority=4)
	public void AwdUserEventsentforApproval() throws InterruptedException, AWTException, IOException {
	  	
//		dr.findElement(By.xpath("html/body/div[1]/ul/li[1]/a")).click();
	  	dr.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	  	dr.findElement(By.id("txtUsername")).sendKeys(Constants.AwardUser);
		dr.findElement(By.id("txtPassword")).sendKeys(Constants.AwardUserPass);
		dr.findElement(By.id("btn_SignIn")).click();
		for(String win2:dr.getWindowHandles()){
			dr.switchTo().window(win2);
		}
		dr.findElement(By.partialLinkText("Recently Re-Submitted Events ")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_rptSubCategory_ctl00_dgPrimary_ctl03_imgbtnEdit")).click();
		dr.findElement(By.xpath(".//*[@id='ctl02_radtabstripApplication']/div/ul/li[7]/a/span/span/span")).click();
		dr.findElement(By.id("ctl02_ctl00_ctl01_radgrdEvents_ctl00_ctl04_imgbtnEdit")).click();
		dr.findElement(By.xpath(".//*[@id='ctl02_rpbEventDetails']/ul/li[1]")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl02_rpbEventDetails_i0_i0_CtrlAdmCEHE_ReviewActivities1_imgbtnAddNew")).click();
		WebElement ReviewActFrame=dr.findElement(By.name("rwReviewActivityTask"));
		dr.switchTo().frame(ReviewActFrame);
		Select CommitteeMember=new Select(dr.findElement(By.id("ctl06_cboReviewerCategory")));
		CommitteeMember.selectByVisibleText("pp test Committee");
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl06_imgbtnSave")).click();
		dr.findElement(By.id("ctl02_rpbEventDetails_i0_i0_CtrlAdmCEHE_ReviewActivities1_dgReviewActivities1_ctl00_ctl04_chkChair")).click();
		TimeUnit.SECONDS.sleep(4);
		dr.findElement(By.id("ctl02_rpbEventDetails_i0_i0_CtrlAdmCEHE_ReviewActivities1_imgbtnNotifyReviewers")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath(".//*[@id='ctl02_rpbEventDetails']/ul/li[2]")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl02_rpbEventDetails_i1_i0_Ctrladmcehe_Meetingactivities1_imgbtnAddNew")).click();
		TimeUnit.SECONDS.sleep(4);
		WebElement MeetingActFrame=dr.findElement(By.name("rwMeetingActivityTask"));
		dr.switchTo().frame(MeetingActFrame);
		Select Committee=new Select(dr.findElement(By.id("ctl06_ddlCommittee")));
		Committee.selectByVisibleText("pp test Committee");
		TimeUnit.SECONDS.sleep(2);
		Select Year=new Select(dr.findElement(By.id("ctl06_ddlMeetingYear")));
		Year.selectByValue("2016");
		TimeUnit.SECONDS.sleep(2);
		Select Date=new Select(dr.findElement(By.id("ctl06_ddlMeetingDate")));
		Date.selectByValue("96");
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl06_imgbtnSave")).click();
		dr.findElement(By.id("ctl02_imgbtnSave")).click();
		dr.findElement(By.id("ctl02_ctl00_ctl01_radgrdEvents_ctl00_ctl05_imgbtnEdit")).click();
		dr.findElement(By.xpath(".//*[@id='ctl02_rpbEventDetails']/ul/li[1]")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl02_rpbEventDetails_i0_i0_CtrlAdmCEHE_ReviewActivities1_imgbtnAddNew")).click();
		WebElement ReviewActFrame1=dr.findElement(By.name("rwReviewActivityTask"));
		dr.switchTo().frame(ReviewActFrame1);
		Select CommitteeMember1=new Select(dr.findElement(By.id("ctl06_cboReviewerCategory")));
		CommitteeMember1.selectByVisibleText("pp test Committee");
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl06_imgbtnSave")).click();
		dr.findElement(By.id("ctl02_rpbEventDetails_i0_i0_CtrlAdmCEHE_ReviewActivities1_dgReviewActivities1_ctl00_ctl04_chkChair")).click();
		TimeUnit.SECONDS.sleep(4);
		dr.findElement(By.id("ctl02_rpbEventDetails_i0_i0_CtrlAdmCEHE_ReviewActivities1_imgbtnNotifyReviewers")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath(".//*[@id='ctl02_rpbEventDetails']/ul/li[2]")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl02_rpbEventDetails_i1_i0_Ctrladmcehe_Meetingactivities1_imgbtnAddNew")).click();
		TimeUnit.SECONDS.sleep(4);
		WebElement MeetingActFrame1=dr.findElement(By.name("rwMeetingActivityTask"));
		dr.switchTo().frame(MeetingActFrame1);
		Select Committee1=new Select(dr.findElement(By.id("ctl06_ddlCommittee")));
		Committee1.selectByVisibleText("pp test Committee");
		TimeUnit.SECONDS.sleep(2);
		Select Year1=new Select(dr.findElement(By.id("ctl06_ddlMeetingYear")));
		Year1.selectByValue("2016");
		TimeUnit.SECONDS.sleep(2);
		Select Date1=new Select(dr.findElement(By.id("ctl06_ddlMeetingDate")));
		Date1.selectByValue("96");
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl06_imgbtnSave")).click();
		dr.findElement(By.id("ctl02_imgbtnSave")).click();
		dr.findElement(By.id("ctl02_imgbtnSaveAndClose")).click();
		TimeUnit.SECONDS.sleep(5);
  }
  
  @Test(enabled=false, priority=5)
	public void ReviewerApproval() throws InterruptedException, AWTException, IOException {
	  	
//		dr.findElement(By.xpath("html/body/div[1]/ul/li[2]/a")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.SuperUser);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys(Constants.SuperUserPass);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[10]/a")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.mail1);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		dr.findElement(By.partialLinkText("Applications: Chair")).click();
		dr.findElement(By.linkText("View")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnReview")).click();
		WebElement ReviewFrame=dr.findElement(By.name("ReviewDialog"));
		dr.switchTo().frame(ReviewFrame);
		dr.findElement(By.id("cboReviewStatus_Arrow")).click();
		WebElement ReviewDecision=dr.findElement(By.xpath("html/body/form/div[1]/div/div[1]/ul"));
		List<WebElement> ReviewOptions=ReviewDecision.findElements(By.tagName("li"));
		int n=ReviewOptions.size();
		for(int i=2;i<=n;i++){
			String RD1="html/body/form/div[1]/div/div[1]/ul/li[";
			String RD2="]";
			WebElement DT=dr.findElement(By.xpath(RD1+i+RD2));
			String RD3=DT.getText();
			System.out.println(RD3);
			if(RD3.equalsIgnoreCase("pp test Event status")){
				dr.findElement(By.xpath(RD1+i+RD2)).click();
				break;
			}
		}
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("btnSubmit")).click();
		Alert alt=dr.switchTo().alert();
		alt.accept();
		TimeUnit.SECONDS.sleep(4);
		dr.findElement(By.partialLinkText("Events: Chair")).click();
		dr.findElement(By.linkText("View Event")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnReview")).click();
		WebElement ReviewFrame1=dr.findElement(By.name("ReviewDialog"));
		dr.switchTo().frame(ReviewFrame1);
		dr.findElement(By.id("cboReviewStatus_Arrow")).click();
		WebElement ReviewDecision1=dr.findElement(By.xpath("html/body/form/div[1]/div/div[1]/ul"));
		List<WebElement> ReviewOptions1=ReviewDecision1.findElements(By.tagName("li"));
		int n1=ReviewOptions1.size();
		for(int i=2;i<=n1;i++){
			String RD1="html/body/form/div[1]/div/div[1]/ul/li[";
			String RD2="]";
			WebElement DT=dr.findElement(By.xpath(RD1+i+RD2));
			String RD3=DT.getText();
			if(RD3.equalsIgnoreCase("pp test Event status")){
				dr.findElement(By.xpath(RD1+i+RD2)).click();
				break;
			}
		}
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("btnSubmit")).click();
		Alert alt1=dr.switchTo().alert();
		alt1.accept();
		TimeUnit.SECONDS.sleep(4);
	  }

  @Test(enabled=true, priority=6)
	public void AwdUserEventApproval() throws InterruptedException, AWTException, IOException {
	  	
//		dr.findElement(By.xpath("html/body/div[1]/ul/li[1]/a")).click();
	  	dr.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	  	dr.findElement(By.id("txtUsername")).sendKeys(Constants.AwardUser);
		dr.findElement(By.id("txtPassword")).sendKeys(Constants.AwardUserPass);
		dr.findElement(By.id("btn_SignIn")).click();
		for(String win2:dr.getWindowHandles()){
			dr.switchTo().window(win2);
		}
		dr.findElement(By.partialLinkText("Recently Re-Submitted Events ")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_rptSubCategory_ctl00_dgPrimary_ctl03_imgbtnEdit")).click();
		dr.findElement(By.xpath(".//*[@id='ctl02_radtabstripApplication']/div/ul/li[7]/a/span/span/span")).click();
		dr.findElement(By.id("ctl02_ctl00_ctl01_radgrdEvents_ctl00_ctl04_imgbtnEdit")).click();
		dr.findElement(By.id("ctl02_imgbtnWorkFlowAction")).click();
		WebElement ApprovalFrame=dr.findElement(By.name("rwWorkFlow"));
		dr.switchTo().frame(ApprovalFrame);
		WebElement TXTfrme = dr.findElement(By.id("txtComments_contentIframe"));
		dr.switchTo().frame(TXTfrme);
		dr.findElement(By.xpath("html/body")).sendKeys("Event approved");
		dr.switchTo().defaultContent();
		Robot object = new Robot();
		object.delay(2000);
		object.keyPress(KeyEvent.VK_TAB);
		object.keyRelease(KeyEvent.VK_TAB);
		object.keyPress(KeyEvent.VK_ENTER);
		object.keyRelease(KeyEvent.VK_ENTER);
		TimeUnit.SECONDS.sleep(4);
		dr.findElement(By.id("ctl02_imgbtnSaveAndClose")).click();
		TimeUnit.SECONDS.sleep(5);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  	dr= new FirefoxDriver();
		dr.navigate().to(Constants.RomeoURL);
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
