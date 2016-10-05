package ExecutionEngine;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.Constants;

public class ApplicationSubmitTest {
	
	public static WebDriver dr;
	
  @Test(enabled=true, priority=1)
  public void ApplicationSubmit() throws IOException, InterruptedException {
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[10]/a")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.mail2);
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	  dr.findElement(By.linkText("APPLY NEW")).click();
	  dr.findElement(By.linkText("Test Award App Form for Smoke Test checkup by PP Support.")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_txtProjectTitle")).sendKeys("pp test title");
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_rcbKeyWord_Input")).sendKeys("pp keyword");
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_phContent']/table/tbody/tr[4]/td[2]/div[2]/input")).click();
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_tbsApplicationForm']/div/ul/li[4]/a/span/span/span")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_btnAdd")).click();
	  WebElement Frame1=dr.findElement(By.name("AttachmentAddPage"));
	  dr.switchTo().frame(Frame1);
	  dr.findElement(By.xpath(".//*[@id='upAttachmentrow0']/span")).click();
	  Runtime.getRuntime().exec("C:\\Users\\sakthivel\\Documents\\Romeo Support\\Attachement.exe");
	  TimeUnit.SECONDS.sleep(5);
	  dr.findElement(By.id("txtAttachmentDescription")).sendKeys("Test attachemnt001");
	  dr.findElement(By.id("btnAdd")).click();
	  dr.switchTo().defaultContent();
	  System.out.println("Attachment added successfully");
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_tbsApplicationForm']/div/ul/li[5]/a/span/span/span")).click();
	  WebElement TR=dr.findElement(By.xpath("html/body/form/div[4]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/table/tbody"));
	  List<WebElement> AppFormRow=TR.findElements(By.tagName("tr"));
	  int n=AppFormRow.size();
	  for(int i=1; i<=n; i++){
	  String Str1="html/body/form/div[4]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/table/tbody/tr[";
	  String Str2="]/td[4]";
	  String Str3="]/td[1]/input";
	  WebElement get=dr.findElement(By.xpath(Str1+i+Str2));
	  String department=get.getText();
	  if(department.equalsIgnoreCase("pp test CSA")){
		  dr.findElement(By.xpath(Str1+i+Str3)).click();
		  System.out.println("CSA assigned successfuly");
	  	}
	  }
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	  WebElement Frame2=dr.findElement(By.name("WorkFlowCommentsWindow"));
	  dr.switchTo().frame(Frame2);
	  dr.findElement(By.id("txtComments")).sendKeys("First Submit");
	  TimeUnit.SECONDS.sleep(2);
	  dr.findElement(By.id("btnSubmit")).click();
	  System.out.println("Application submitted successfuly");
	  TimeUnit.SECONDS.sleep(3);
	  
  }
  
  @Test(enabled=true, priority=2)
  public void ApplicationRMI() throws IOException, InterruptedException {
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[10]/a")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.mail1);
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	  dr.findElement(By.linkText("Applications: New*")).click();
	  WebElement TR=dr.findElement(By.xpath("html/body/form/div[4]/div[4]/div[1]/div[2]/table/tbody"));
	  List<WebElement> AppFormRow=TR.findElements(By.tagName("tr"));
	  int n=AppFormRow.size();
	  System.out.println(n);
	  String S1="html/body/form/div[4]/div[4]/div[1]/div[2]/table/tbody/tr[";
	  String S2="]/td[1]/div/p/a";
	  dr.findElement(By.xpath(S1+n+S2)).click();
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_tbsApplicationForm']/div/ul/li[5]/a/span/span/span")).click();
	  WebElement AP=dr.findElement(By.xpath("html/body/form/div[4]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/table/tbody"));
	  List<WebElement> ARow=AP.findElements(By.tagName("tr"));
	  int no=ARow.size();
	  System.out.println(no);
	  for(int i=1;i<=no;i++){
	  String S3="html/body/form/div[4]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/table/tbody/tr[";
	  String S4="]/td[4]";
	  String S5="]/td[2]/input";
	  WebElement DepName=dr.findElement(By.xpath(S3+i+S4));
	  String Name=DepName.getText();
	  System.out.println(Name);
	  if(Name.equalsIgnoreCase("pp test CSA")){
		  dr.findElement(By.xpath(S3+i+S5)).click();
		  break;
	  }
	  }
	  WebElement Frame3=dr.findElement(By.name("CSAApprovalsPage"));
	  dr.switchTo().frame(Frame3);
	  dr.findElement(By.id("rbWorkFlowAction_0")).click();
	  dr.findElement(By.id("txtComments")).sendKeys("Approve");
	  dr.findElement(By.id("btnSubmit")).click();
	  TimeUnit.SECONDS.sleep(2);
	  dr.findElement(By.linkText("Applications: New*")).click();
	  dr.findElement(By.linkText("Review")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnApproval")).click();
	  WebElement Frame4=dr.findElement(By.name("WorkFlowCommentsWindow"));
	  dr.switchTo().frame(Frame4);
	  dr.findElement(By.id("rbWorkFlowAction_1")).click();
	  dr.findElement(By.id("txtComments")).sendKeys("Request More Information");
	  TimeUnit.SECONDS.sleep(2);
	  dr.findElement(By.id("btnSubmit")).click();
	  System.out.println("Application send for RMI successfuly");
	  TimeUnit.SECONDS.sleep(3);
  }
  
  @Test(enabled=true, priority=3)
  public void ApplicationReSubmit() throws IOException, InterruptedException {
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[10]/a")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.mail2);
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	  dr.findElement(By.linkText("Applications: Requiring Attention*")).click();
	  dr.findElement(By.linkText("Edit")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnResubmit")).click();
	  WebElement Frame5=dr.findElement(By.name("WorkFlowCommentsWindow"));
	  dr.switchTo().frame(Frame5);
	  dr.findElement(By.id("txtComments")).sendKeys("Application ReSubmit");
	  TimeUnit.SECONDS.sleep(3);
	  dr.findElement(By.id("btnSubmit")).click();
	  System.out.println("Application Resubmitted successfuly");
	  TimeUnit.SECONDS.sleep(3);
	 
  }
  
  @Test(enabled=true, priority=4)
  public void ApplicationApproval() throws IOException, InterruptedException {
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[10]/a")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.mail1);
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	  dr.findElement(By.linkText("Applications: New*")).click();
	  dr.findElement(By.linkText("Review")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnApproval")).click();
	  WebElement Frame6=dr.findElement(By.name("WorkFlowCommentsWindow"));
	  dr.switchTo().frame(Frame6);
	  dr.findElement(By.id("txtComments")).sendKeys("Application Approved");
	  TimeUnit.SECONDS.sleep(2);
	  dr.findElement(By.id("btnSubmit")).click();
	  System.out.println("Application Approved successfuly");
	  TimeUnit.SECONDS.sleep(3);
  }
  
  
  
  @BeforeMethod
  public void SignIn() {
	  	dr= new FirefoxDriver();
		dr.navigate().to(Constants.RPURL);
		dr.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
//	  	dr.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.SuperUser);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys(Constants.SuperUserPass);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		
  }

  @AfterMethod
  public void EOF() {
	  dr.close();
	  dr.quit();
  }

  
  
}
