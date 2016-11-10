package ExecutionEngine;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import Utility.Constants;

public class RPWithdrawTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void withdraw() throws InterruptedException {
        wd.get(Constants.RPURL);
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).clear();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys("su");
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).clear();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).sendKeys("sudemo");
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
        wd.findElement(By.linkText("Work as Researcher")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).clear();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys("ppromeotest@gmail.com");
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
        wd.findElement(By.id("ctl00_lnkApplyNew")).click();
        wd.findElement(By.linkText("Test Award App Form for Smoke Test checkup by PP Support.")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_txtProjectTitle")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_txtProjectTitle")).clear();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_ctl00_txtProjectTitle")).sendKeys("pp test withdraw");
        wd.findElement(By.xpath("//table[@class='MasterTable_Office2007']//td[normalize-space(.)='']")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
        wd = (FirefoxDriver) wd.switchTo().frame("WorkFlowCommentsWindow");
        wd.findElement(By.xpath("//div/form/table/tbody/tr/td/table/tbody/tr[3]/td/textarea")).click();
        wd.findElement(By.xpath("//div/form/table/tbody/tr/td/table/tbody/tr[3]/td/textarea")).clear();
        wd.findElement(By.xpath("//div/form/table/tbody/tr/td/table/tbody/tr[3]/td/textarea")).sendKeys("pp test withdraw");
        wd.findElement(By.xpath("//div/form/table/tbody/tr/td/table/tbody/tr[1]/td/input[1]")).click();
        wd.switchTo().defaultContent();
        wd.findElement(By.linkText("Applications: Under Review")).click();
        wd.findElement(By.linkText("View")).click();
        wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnWithDraw")).click();
        wd = (FirefoxDriver) wd.switchTo().frame("WorkFlowCommentsWindow");
        wd.findElement(By.xpath("//div/form/table/tbody/tr/td/table/tbody/tr[3]/td/textarea")).click();
        wd.findElement(By.xpath("//div/form/table/tbody/tr/td/table/tbody/tr[3]/td/textarea")).clear();
        wd.findElement(By.xpath("//div/form/table/tbody/tr/td/table/tbody/tr[3]/td/textarea")).sendKeys("pp withdraw");
        wd.findElement(By.xpath("//div/form/table/tbody/tr/td/table/tbody/tr[1]/td/input[1]")).click();
        wd.switchTo().defaultContent();
        wd.findElement(By.linkText("Applications: Withdrawn")).click();
        wd.findElement(By.linkText("Delete")).click();
        Alert del=wd.switchTo().alert();
        del.accept();
        wd.findElement(By.linkText("Home")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
}
