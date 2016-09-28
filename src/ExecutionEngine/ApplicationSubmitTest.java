package ExecutionEngine;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApplicationSubmitTest {
	
	public static WebDriver dr;
	
  @Test
  public void ApplicationSubmit() throws IOException, InterruptedException {
	  dr.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_panel1']/ul/li[10]/a")).click();
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys("ppromeotest@gmail.com");
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
	  if(department.equalsIgnoreCase("PP CSA")){
		  dr.findElement(By.xpath(Str1+i+Str3)).click();
		  System.out.println("CSA assigned successfuly");
	  	}
	  }
	  dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
	  WebElement Frame2=dr.findElement(By.name("WorkFlowCommentsWindow"));
	  dr.switchTo().frame(Frame2);
	  dr.findElement(By.id("txtComments")).sendKeys("First Submit");
	  dr.findElement(By.id("btnSubmit")).sendKeys("First Submit");
	  System.out.println("Application submitted successfuly");
	 
  }
  
  
  @BeforeTest
  public void SignIn() {
	  	dr= new FirefoxDriver();
		dr.navigate().to("http://qa.researchservicesoffice.com/Romeo.Researcher");
		dr.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
//	  	dr.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys("su");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys("sudemo");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		
  }

  @AfterTest
  public void EOF() {
	  dr.close();
	  dr.quit();
  }

  
  
}