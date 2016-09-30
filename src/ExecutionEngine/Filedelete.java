package ExecutionEngine;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Filedelete {
	public static WebDriver dr;
	public static String win1, InvestigatorID1, InvestigatorID2;
	
  @Test(enabled=true, priority=1, groups="FileCreation")
  public void FacultyFileCreation() throws InterruptedException {
	  	dr.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	  	dr.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
//	  	dr.findElement(By.xpath(".//*[@id='content']/ul/li[4]/a")).click();
		dr.findElement(By.id("txtUsername")).sendKeys("su");
		dr.findElement(By.id("txtPassword")).sendKeys("sudemo");
		dr.findElement(By.id("btn_SignIn")).click();
		Set<String> ids = dr.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String win1 = it.next();
		String win2 = it.next();  
		dr.switchTo().window(win2);
//		winHandleBefore = dr.getWindowHandle();
//		dr.findElement(By.id("btn_SignIn")).click();
//		for(String win2:dr.getWindowHandles()){
//			dr.switchTo().window(win2);
//			}
		ReviewerCommitte();
		Reviewer();
		ReviewActivityStatus();
		letterDoc();
		EventActivity();
		EventCategory();
		EmailBody();
		OtherSigningAuthority();
		InvestigatorDeletion();
		FacultyDeletion();
		
  }
  
  public static void FacultyDeletion() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		dr.findElement(By.xpath(".//*[@class='rmVertical']/li[4]/a/span")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("pp test Faculty");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl04_imgBtnDelete")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnDelete2")).click();
		Alert DelRC=dr.switchTo().alert();
		DelRC.accept();
		System.out.println("Faculty deleted successfully");
  }
  
  public static void InvestigatorDeletion() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath(".//*[@class='rmVertical']/li[3]/a/span")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtName")).sendKeys("test1");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtGivenName")).sendKeys("pp1");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSearch")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_dgInvestigator_ctl03_imgBtnDelete")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnDeleteTop")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtName")).clear();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtGivenName")).clear();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtName")).sendKeys("test");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtGivenName")).sendKeys("pp");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSearch")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_dgInvestigator_ctl03_imgBtnDelete")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnDeleteTop")).click();
		System.out.println("Investigators deleted successfully");
		
  }

  public static void OtherSigningAuthority() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath(".//*[@class='rmVertical']/li[8]/a/span")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("pp test CSA");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl04_imgBtnDelete")).click();	
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnDelete2")).click();
		Alert DelRC=dr.switchTo().alert();
		DelRC.accept();
		System.out.println("CSA deleted succesfully");
  }
  
  public static void Reviewer() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Reviewer")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("test1");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl04_imgBtnDelete")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnDelete2")).click();
		Alert DelRC=dr.switchTo().alert();
		DelRC.accept();
		System.out.println("Reviewer deleted succesfully");
}
  
  public static void ReviewerCommitte() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Reviewer Committee")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("pp test Committee");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl04_imgBtnDelete")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnDelete2")).click();
		Alert DelRC=dr.switchTo().alert();
		DelRC.accept();
		System.out.println("Reveiwer committee deleted succesfully");
		
  }
  
  public static void EventCategory() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Event Category")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("pp test Event category");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl04_imgBtnDelete")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnDelete2")).click();
		Alert DelRC=dr.switchTo().alert();
		DelRC.accept();
		System.out.println("Event category deleted succesfully");
}
  
  public static void EventActivity() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Event Activity")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtName")).sendKeys("pp test Event");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_radgrdEventActivity_ctl00_ctl04_imgbtnDelete")).click();
		Alert DelRC=dr.switchTo().alert();
		DelRC.accept();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnDelete")).click();
		System.out.println("Event Activity deleted succesfully");
}
  
  public static void ReviewActivityStatus() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Review Activity Status")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("pp test Event status");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl04_imgBtnDelete")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnDelete2")).click();
		Alert DelRC=dr.switchTo().alert();
		DelRC.accept();
		System.out.println("Review Activity Status deleted succesfully");
}
  
  public static void EmailBody() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Email Body")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtName")).sendKeys("pp test Email");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_dgGeneral_ctl03_imgBtnDelete")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnDelete")).click();
		System.out.println("EmailBody deleted succesfully");
}
  
  public static void letterDoc() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Letters / Docs")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtTitle")).sendKeys("pp test letter");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_dgGeneral_ctl03_imgBtnDelete")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnDelete")).click();
		System.out.println("LetterDoc deleted succesfully");
		
}
  
  
  @BeforeMethod
  public void SignIn() {
	  	dr= new FirefoxDriver();
		dr.navigate().to("http://qa.researchservicesoffice.com/ROMEO/");
		
  }

  @AfterMethod
  public void EOF() {
	  dr.close();
	  dr.quit();
  }

}
