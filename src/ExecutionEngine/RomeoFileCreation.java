package ExecutionEngine;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import Utility.*;

public class RomeoFileCreation {
	public static WebDriver dr;
	public static String win1, InvestigatorID1, InvestigatorID2;
	
  @Test(enabled=true, priority=1, groups="FileCreation")
  public void FacultyFileCreation() throws InterruptedException {
	  	dr.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	  	dr.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
//	  	dr.findElement(By.xpath(".//*[@id='content']/ul/li[4]/a")).click();
		dr.findElement(By.id("txtUsername")).sendKeys(Constants.SuperUser);
		dr.findElement(By.id("txtPassword")).sendKeys(Constants.SuperUserPass);
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
		FacultyCreation();	
		InvestigatorCreation1();
		InvestigatorCreation2();
		AssignSigningAuthority();
		OtherSigningAuthority();
		Reviewer();
		ReviewerCommitte();
		EventCategory();
		EventActivity();
		ReviewActivityStatus();
		EmailBody();
		letterDoc();
  }
  
  public static void FacultyCreation()throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		dr.findElement(By.xpath(".//*[@class='rmVertical']/li[4]/a/span")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl02_ctl00_imgbtnAddNew")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableItemElement_txtName")).sendKeys("pp test Faculty");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctl00_chkSigningAuthority")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSave2")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("pp test Faculty");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		System.out.println("New Faculty is added and Verified successfully");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnClearAll")).click();
  }

  public static void InvestigatorCreation1() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath(".//*[@class='rmVertical']/li[3]/a/span")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imtbtnAddNew")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtName")).sendKeys("test1");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtInvestigatorGivenName")).sendKeys("pp1");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtInvestigatorEmail")).sendKeys(Constants.mail1);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_cbValid")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_Appointment_radgrdMyAppoinments_ctl00_ctl02_ctl00_imgbtnAddNew")).click();
		Select FacultyUnit=new Select(dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_Appointment_radgrdMyAppoinments_ctl00_ctl02_ctl03_EditFormControl_ddlUnit")));
		FacultyUnit.selectByVisibleText("pp test Faculty");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_Appointment_radgrdMyAppoinments_ctl00_ctl02_ctl03_EditFormControl_chkPA")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_Appointment_radgrdMyAppoinments_ctl00_ctl02_ctl03_EditFormControl_imgbtnInsert")).click();
		JavascriptExecutor jse = (JavascriptExecutor) dr;
        jse.executeScript("window.scrollBy(0,-750)", "");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_btnRegistrationNotification")).click();
		TimeUnit.SECONDS.sleep(5);
		Alert alt=dr.switchTo().alert();
		alt.accept();		
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnCancelTop")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtMail")).sendKeys(Constants.mail1);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSearch")).click();
		System.out.println("New Investigator is created and Verified successfully");
		WebElement InvID=dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_dgInvestigator_ctl03_lblInvestigatorID"));
		InvestigatorID1=InvID.getText();
		System.out.println("New created Investigator ID is : "+InvestigatorID1);
		TimeUnit.SECONDS.sleep(2);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnClearAll")).click();	
  }
		
  public static void InvestigatorCreation2() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath(".//*[@class='rmVertical']/li[3]/a/span")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imtbtnAddNew")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtName")).sendKeys("test");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtInvestigatorGivenName")).sendKeys("pp");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtInvestigatorEmail")).sendKeys("Constants.mail2");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_cbValid")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_Appointment_radgrdMyAppoinments_ctl00_ctl02_ctl00_imgbtnAddNew")).click();
		Select FacultyUnit=new Select(dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_Appointment_radgrdMyAppoinments_ctl00_ctl02_ctl03_EditFormControl_ddlUnit")));
		FacultyUnit.selectByVisibleText("pp test Faculty");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_Appointment_radgrdMyAppoinments_ctl00_ctl02_ctl03_EditFormControl_chkPA")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_Appointment_radgrdMyAppoinments_ctl00_ctl02_ctl03_EditFormControl_imgbtnInsert")).click();
		JavascriptExecutor jse = (JavascriptExecutor) dr;
		jse.executeScript("window.scrollBy(0,-750)", "");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_btnRegistrationNotification")).click();
		TimeUnit.SECONDS.sleep(5);
		Alert alt=dr.switchTo().alert();
		alt.accept();		
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnCancelTop")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtMail")).sendKeys(Constants.mail2);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSearch")).click();
		System.out.println("New Investigator is created and Verified successfully");
		WebElement InvID=dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_dgInvestigator_ctl03_lblInvestigatorID"));
		InvestigatorID2=InvID.getText();
		System.out.println("New created Investigator ID is : "+InvestigatorID2);
		TimeUnit.SECONDS.sleep(2);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnClearAll")).click();	
}
  
  public static void AssignSigningAuthority() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath(".//*[@class='rmVertical']/li[4]/a/span")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("pp test Faculty");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl04_imgBtnSigningAuthority")).click();
		WebElement element1 = dr.findElement(By.name("rwSigningAuthority"));
        dr.switchTo().frame(element1);
		dr.findElement(By.id("ctrlSigningAuthority_radGridSigningAuthority_ctl00_ctl02_ctl00_imgbtnAddNew")).click();
		WebElement element2 = dr.findElement(By.name("rwndInvestigatorList"));
	    dr.switchTo().frame(element2);
	    dr.findElement(By.id("txtLastName")).sendKeys("test1");
	    dr.findElement(By.id("txtGivenName")).sendKeys("pp1");
//		dr.findElement(By.id("txtInvestigatorID")).sendKeys(InvestigatorID1);
		dr.findElement(By.id("imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("radgrdProjectMember_ctl00_ctl04_chkSelect")).click();
		dr.findElement(By.id("imgbtnSave")).click();
		dr.switchTo().defaultContent();
		TimeUnit.SECONDS.sleep(3);
		WebElement element11 = dr.findElement(By.name("rwSigningAuthority"));
		dr.switchTo().frame(element11);
		dr.findElement(By.id("ctrlSigningAuthority_radGridSigningAuthority_ctl00_ctl04_chkPrimary")).click();
		dr.findElement(By.id("ctrlSigningAuthority_imgbtnSaveBottom")).click();
		dr.switchTo().defaultContent();
		System.out.println("SA created succesfully");
  }
  
  public static void OtherSigningAuthority() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[2]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath(".//*[@class='rmVertical']/li[8]/a/span")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl02_ctl00_imgbtnAddNew")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableItemElement_txtName")).sendKeys("pp test CSA");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctl00_imgRetrieve")).click();
		WebElement element2 = dr.findElement(By.name("rwndInvestigatorList"));
	    dr.switchTo().frame(element2);
	    dr.findElement(By.id("txtLastName")).sendKeys("test1");
	    dr.findElement(By.id("txtGivenName")).sendKeys("pp1");
//		dr.findElement(By.id("txtInvestigatorID")).sendKeys(InvestigatorID1);
		dr.findElement(By.id("imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("radgrdProjectMember_ctl00_ctl04_lnkSelect")).click();
		dr.switchTo().defaultContent();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSave2")).click();
		System.out.println("CSA created succesfully");
  }
  
  public static void Reviewer() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Reviewer")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl02_ctl00_imgbtnAddNew")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctl00_imgRetrieve")).click();
		WebElement element2 = dr.findElement(By.name("rwndInvestigatorList"));
	    dr.switchTo().frame(element2);
	    dr.findElement(By.id("txtLastName")).sendKeys("test1");
	    dr.findElement(By.id("txtGivenName")).sendKeys("pp1");
//		dr.findElement(By.id("txtInvestigatorID")).sendKeys(InvestigatorID1);
		dr.findElement(By.id("imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("radgrdProjectMember_ctl00_ctl04_lnkSelect")).click();
		dr.switchTo().defaultContent();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSave2")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("test1");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		String ID=dr.getPageSource();
		if(ID.contains(InvestigatorID1)){
			System.out.println("Reviewer created succesfully");
		}
		else{
			System.out.println("Try again..!");
		}
}
  
  public static void ReviewerCommitte() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Reviewer Committee")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl02_ctl00_imgbtnAddNew")).click();
		dr.findElement(By.xpath("html/body/form/div[9]/div/div[4]/div/table/tbody/tr[3]/td/div/div/ul/li[1]/a")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctl00_pnlAdditionProperties_i0_i0_ctrlCommitteeMembers_radgrdCommitteeMembers_ctl00_ctl02_ctl00_imgbtnAdd")).click();
		WebElement element2 = dr.findElement(By.name("rwSelectReviewer"));
	    dr.switchTo().frame(element2);
	    dr.findElement(By.id("txtLastName")).sendKeys("test1");
	    dr.findElement(By.id("txtGivenName")).sendKeys("pp1");;
		dr.findElement(By.id("imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath("html/body/form/div[4]/div/div[3]/div/div/div/div/table/tbody/tr[1]/td[1]/a")).click();
		dr.switchTo().defaultContent();
		TimeUnit.SECONDS.sleep(5);
		dr.findElement(By.xpath("html/body/form/div[9]/div/div[4]/div/table/tbody/tr[3]/td/div/div/ul/li[2]/a")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctl00_pnlAdditionProperties_i1_i0_ctrlCommitteeSchedule_radgrdCommitteeMeetingSchedule_ctl00_ctl02_ctl00_imgbtnAdd")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctl00_pnlAdditionProperties_i1_i0_ctrlCommitteeSchedule_radgrdCommitteeMeetingSchedule_ctl00_ctl02_ctl02_MeetingDateDtPicker_dateInput")).sendKeys("2016/09/22");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctl00_pnlAdditionProperties_i1_i0_ctrlCommitteeSchedule_radgrdCommitteeMeetingSchedule_ctl00_ctl02_ctl02_TB_MeetingLocationColumn")).sendKeys("test location");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableItemElement_txtName")).sendKeys("pp test Committee");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctl00_pnlAdditionProperties_i1_i0_ctrlCommitteeSchedule_radgrdCommitteeMeetingSchedule_ctl00_ctl02_ctl02_imgbtnSaveNew")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSave")).click();		
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("pp test Committee");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		WebElement name=dr.findElement(By.xpath("html/body/form/div[9]/table[3]/tbody/tr[5]/td[2]/div/div[2]/table/tbody/tr[1]/td[2]"));
		String RC=name.getText();
		if(RC.equalsIgnoreCase("pp test Committee")){
			System.out.println("Reveiwer committee created succesfully");
		}
		else{
			System.out.println("Try again..!");
		}
  }
  
  public static void EventCategory() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Event Category")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl02_ctl00_imgbtnAddNew")).click(); 
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableItemElement_txtName")).sendKeys("pp test Event category");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSave2")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("pp test Event category");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		WebElement name=dr.findElement(By.xpath("html/body/form/div[9]/table[3]/tbody/tr[5]/td[2]/div/div[2]/table/tbody/tr[1]/td[2]"));
		String RC=name.getText();
		if(RC.equalsIgnoreCase("pp test Event category")){
			System.out.println("Event category created succesfully");
		}
		else{
			System.out.println("Try again..!");
		}
}
  
  public static void EventActivity() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Event Activity")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_radgrdEventActivity_ctl00_ctl02_ctl00_imtbtnAddNew")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtName")).sendKeys("pp test Event");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSave")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtName")).sendKeys("pp test Event");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		WebElement name=dr.findElement(By.xpath("html/body/form/div[9]/table/tbody/tr[9]/td/div/table/tbody/tr[1]/td[3]"));
		String RC=name.getText();
		if(RC.equalsIgnoreCase("pp test Event")){
			System.out.println("Event Activity created succesfully");
		}
		else{
			System.out.println("Try again..!");
		}
}
  
  public static void ReviewActivityStatus() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Review Activity Status")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableSearchResult_radgrdGeneral_ctl00_ctl02_ctl00_imgbtnAddNew")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlMasterTableItemElement_txtName")).sendKeys("pp test Event status");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSave2")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_ctrlMasterTableSearchCriteriaElement_txtName")).sendKeys("pp test Event status");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_ctrlSearchCriteria_imgbtnSearch")).click();
		TimeUnit.SECONDS.sleep(3);
		WebElement name=dr.findElement(By.xpath("html/body/form/div[9]/table[3]/tbody/tr[5]/td[2]/div/div[2]/table/tbody/tr[1]/td[2]"));
		String RC=name.getText();
		if(RC.equalsIgnoreCase("pp test Event status")){
			System.out.println("Review Activity Status created succesfully");
		}
		else{
			System.out.println("Try again..!");
		}
}
  
  public static void EmailBody() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Email Body")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imtbtnAddNew")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtName")).sendKeys("pp test Email");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtSubject")).sendKeys("Email");
		WebElement emailfrme = dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_reEmailTemplate_contentIframe"));
		dr.switchTo().frame(emailfrme);
		dr.findElement(By.xpath("html/body")).sendKeys("[[ProjectTitle]][[ProjectStatus]][[FileNo]][[ProjectTitle]][[ProjectStatus]][[Keywords]][[InstitutionLogo]][[ESignature1]][[ESignature2]][[ESignature3]][[ESignature4]]");
		dr.switchTo().defaultContent();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSave")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtName")).sendKeys("pp test Email");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSearch")).click();
		WebElement name=dr.findElement(By.xpath("html/body/form/div[9]/table/tbody/tr[10]/td/table/tbody/tr[2]/td[2]"));
		String RC=name.getText();
		if(RC.equalsIgnoreCase("pp test Email")){
			System.out.println("EmailBody created succesfully");
		}
		else{
			System.out.println("Try again..!");
		}
}
  
  public static void letterDoc() throws InterruptedException {
	  	WebElement genBtn=dr.findElement(By.xpath(".//*[@id='ctl00_menuContentPlaceHolder_TemplateRadMenu']/ul/li[3]/a/span"));
		Actions act=new Actions(dr);
		act.moveToElement(genBtn).build().perform();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.linkText("Letters / Docs")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imtbtnAddNew")).click();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtTitle")).sendKeys("pp test letter");
		WebElement letterfrme = dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_reLetterTemplate_contentIframe"));
		dr.switchTo().frame(letterfrme);
		dr.findElement(By.xpath("html/body")).sendKeys("[[ProjectTitle]][[ProjectStatus]][[FileNo]][[ProjectTitle]][[ProjectStatus]][[Keywords]][[InstitutionLogo]][[ESignature1]][[ESignature2]][[ESignature3]][[ESignature4]]");
		dr.switchTo().defaultContent();
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSave")).click();
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_txtTitle")).sendKeys("pp test letter");
		dr.findElement(By.id("ctl00_ContentPlaceHolder1_ctrlContent_imgbtnSearch")).click();
		WebElement name=dr.findElement(By.xpath("html/body/form/div[9]/table/tbody/tr[10]/td/table/tbody/tr[2]/td[2]"));
		String RC=name.getText();
		if(RC.equalsIgnoreCase("pp test letter")){
			System.out.println("LetterDoc created succesfully");
		}
		else{
			System.out.println("Try again..!");
		}
}
  
  
  @BeforeMethod
  public void SignIn() {
	  	dr= new FirefoxDriver();
		dr.navigate().to(Constants.RomeoURL);
		
  }

  @AfterMethod
  public void EOF() {
	  dr.close();
	  dr.quit();
  }

}
