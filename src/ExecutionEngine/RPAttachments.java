package ExecutionEngine;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import Utility.Constants;

public class RPAttachments {
   WebDriver dr;
    
    @BeforeMethod
    public void setUp() throws Exception {
//    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sakthivel\\Documents\\Jar files\\chromedriver_win32_Update\\chromedriver.exe");
//		dr=new ChromeDriver();
    	dr=new FirefoxDriver();
        dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void testWithdraw() throws InterruptedException, IOException {
        dr.get(Constants.RPURL);
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).click();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).clear();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys("su");
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).click();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).clear();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys(Constants.SuperUserPass);
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
        dr.findElement(By.linkText("Work as Researcher")).click();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).click();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).clear();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys("ppromeotest@gmail.com");
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
        dr.findElement(By.id("ctl00_lnkApplyNew")).click();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_rptrNewApplicationFormsGroups_ctl01_rptrNewApplicationFormsItems_ctl10_lnkAppForm")).click();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_txtProjectTitle")).click();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_txtProjectTitle")).clear();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_txtProjectTitle")).sendKeys("pp test withdraw");
        dr.findElement(By.id("btnImportToWord")).click();
        dr.findElement(By.id("btnExportToPdf")).click();
        dr.findElement(By.xpath("//ul[@class='rtsUL']/li[4]/a/span/span/span")).click();
        dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_btnAdd")).click();
        WebElement Frame1=dr.findElement(By.name("AttachmentAddPage"));
  	  	dr.switchTo().frame(Frame1);
  	  	dr.findElement(By.xpath(".//*[@id='upAttachmentrow0']/span")).click();
  	  	Runtime.getRuntime().exec("C:\\Users\\sakthivel\\Documents\\Romeo Support\\5mbtest.exe");
  	  	dr.findElement(By.cssSelector(".ruButton.ruRemove")).click();
  	  	dr.switchTo().defaultContent();
  	  	TimeUnit.SECONDS.sleep(4);
        dr.findElement(By.xpath(".//*[@id='upAttachmentrow0']/span")).click();
  	  	Runtime.getRuntime().exec("C:\\Users\\sakthivel\\Documents\\Romeo Support\\10mbtest.exe");
  	  	dr.findElement(By.cssSelector(".ruButton.ruRemove")).click();
	  	TimeUnit.SECONDS.sleep(4);
        dr.findElement(By.xpath(".//*[@id='upAttachmentrow0']/span")).click();
  	  	Runtime.getRuntime().exec("C:\\Users\\sakthivel\\Documents\\Romeo Support\\pdftest.exe");
  	  	TimeUnit.SECONDS.sleep(3);
        dr.findElement(By.id("btnCancel")).click();
        dr.switchTo().defaultContent();
        
    }
    
    @AfterMethod
    public void tearDown() {
      
    }
    
}
