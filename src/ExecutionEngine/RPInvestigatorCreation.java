package ExecutionEngine;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import Utility.Constants;

public class RPInvestigatorCreation {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        
    }
    
    @Test
    public void RPInvestigatorCreation1() throws InterruptedException {
    	wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get(Constants.RPURL);
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnRegister")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).clear();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).sendKeys("qa");
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).clear();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).sendKeys("pp");
        wd.findElement(By.xpath("//div[@class='tab-border']/table/tbody/tr[3]/td[2]")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmail")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmail")).clear();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmail")).sendKeys(Constants.mail3);
        wd.findElement(By.cssSelector("input.input-button-forms")).click();
        WebElement Affiliation = wd.findElement(By.name("AffiliationEditPage"));
        wd.switchTo().frame(Affiliation);
        wd.findElement(By.id("cboUnit_Input")).click();
        WebElement AffiliationOptions=wd.findElement(By.cssSelector("ul.rcbList"));
        List<WebElement> AffiliationSelection=AffiliationOptions.findElements(By.tagName("li"));
        int n=AffiliationSelection.size();
        for(int i=1; i<=n; i++){
        	String s1="html/body/form/div[1]/div/div/ul/li[";
        	WebElement options=wd.findElement(By.xpath(s1+i+"]"));
        	String ActText=options.getText();
        	System.out.println(ActText);
        	TimeUnit.SECONDS.sleep(5);
        	if(ActText.equalsIgnoreCase("pp test Faculty")){
        		wd.findElement(By.xpath(s1+i+"]")).click();
        		break;
        	}
        }
        TimeUnit.SECONDS.sleep(3);
        wd.findElement(By.cssSelector("input#btnSave")).click();
        wd.switchTo().defaultContent();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_cboGender_Input")).click();
        WebElement GenderOptions=wd.findElement(By.cssSelector("ul.rcbList"));
        List<WebElement> GenderSelection=GenderOptions.findElements(By.tagName("li"));
        int m=GenderSelection.size();
        for(int i=1; i<=m; i++){
        	String s1="html/body/form/div[1]/div/div/ul/li[";
        	WebElement options=wd.findElement(By.xpath(s1+i+"]"));
        	String ActText=options.getText();
        	if(ActText.equalsIgnoreCase("Male")){
        		wd.findElement(By.xpath(s1+i+"]")).click();
        		break;
        	}
        }
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_imgInfo")).click();
        WebElement GuideLinePage= wd.findElement(By.name("GuidelinePage"));
        wd.switchTo().frame(GuideLinePage);
        TimeUnit.SECONDS.sleep(3);
        wd.findElement(By.cssSelector("#btnClose")).click();
        wd.switchTo().defaultContent();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave")).click();
        TimeUnit.SECONDS.sleep(4);
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnBack")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).clear();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Constants.mail3);
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnResetpassword")).click();
        Alert alt=wd.switchTo().alert();
        alt.accept();
        TimeUnit.SECONDS.sleep(5);
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
}
