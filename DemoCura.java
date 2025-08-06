//package demotesting;
//
//public class DemoCura {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
package demotesting;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class DemoCura {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\Selenium\\driver\\chromedriver.exe");
		//remove toottip
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com");
        
        driver.findElement(By.id("menu-toggle")).click();
		driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a")).click();//login
		driver.findElement(By.id("txt-username")).sendKeys("standard_user");//Invalid Login
        driver.findElement(By.id("txt-password")).sendKeys("secret_sauce");
        driver.findElement(By.id("btn-login")).click();
        String result= driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]")).getText();//Invalid Message Printing
        if(result.contains("Login failed! Please ensure the username and password are valid."))
        {
        	System.out.println("Wrong Username and Password");
        }
        else
        {
        	System.out.println("No Error message");
        }
        //Thread.sleep(3000);
        driver.findElement(By.id("txt-username")).sendKeys("");//Empty Login
        driver.findElement(By.id("txt-password")).sendKeys("");
        driver.findElement(By.id("btn-login")).click();
        String result1= driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]")).getText();//Invalid Message Printing
        if(result1.contains("Login failed! Please ensure the username and password are valid."))
        {
        	System.out.println("Empty UserName and Password");
        }
        else
        {
        	System.out.println("No Error message");
        }
        //Thread.sleep(3000);
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");//Valid Login
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        System.out.println("Successfull Login");
        	//Thread.sleep(4000);
        	 
    
        	
        WebElement facility =driver.findElement(By.xpath("//*[@id=\"combo_facility\"]"));
	    Select facility1=new Select(facility);
		Thread.sleep(3000);
	    facility1.selectByIndex(1);	
	    String selectedOption = facility1.getFirstSelectedOption().getText();
	    //System.out.println(selectedOption);
	   
	    
	    driver.findElement(By.id("chk_hospotal_readmission")).click();//Checkbox

	    WebElement selectedRadio = driver.findElement(By.id("radio_program_medicaid"));//RadioButton
	    selectedRadio.click();
	    String selectedValue = selectedRadio.getAttribute("value");
	    //System.out.println("Selected radio button value: " + selectedValue);
	    
	 	WebElement date=driver.findElement(By.id("txt_visit_date"));
	 	date.sendKeys("25/05/2025");//Calendar
	 	String selectedDate = date.getAttribute("value");
	 	//System.out.println(selectedDate);
	 	
	 	driver.findElement(By.id("txt_comment")).sendKeys("qwertyuiopafgklxvbn");//TextArea 
	 	
	 	driver.findElement(By.id("btn-book-appointment")).click();

	    //Appoinment confirmation
	 	WebElement faci= driver.findElement(By.id("facility"));
	 	String fac=faci.getText();
	 	WebElement date1= driver.findElement(By.id("visit_date"));
	    String dat=date1.getText();
	    WebElement selpgm=driver.findElement(By.id("program"));
	    String selval=selpgm.getText();
	    
//	    System.out.println(fac);
//	    System.out.println(dat);
//	    System.out.println(selval);
	    
	    String confirm= driver.findElement(By.tagName("h2")).getText();
        if(confirm.contains("Appointment Confirmation"))
        {
        	System.out.println("Appointment Confirmation");
        }
        else
        {
        	System.out.println("Appointment Not Confirmed");
        }
	   if(selectedOption.equals(fac))
	    {
	    		System.out.println("Facility matches");
	    }
	    else
	    {
	    	System.out.println("Facility Not matches");
	    }
	    if(selectedDate.equals(dat))
	    {
	    		System.out.println("date matches");
	    }
	    else
	    {
	    	System.out.println("date Not matches");
	    }
	    if(selectedValue.equals(selval))
	    {
	    		System.out.println("program matches");
	    }
	    else
	    {
	    	System.out.println("program Not matches");
	    }
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a")).click();//Go Home
	    Thread.sleep(3000);
	  
	    driver.findElement(By.id("menu-toggle")).click();
	    Thread.sleep(3000);
	  //History
	    driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a")).click();
	    
	    WebElement Hfaci= driver.findElement(By.id("facility"));
	 	String Hifac=Hfaci.getText();
	 	WebElement Hdate= driver.findElement(By.xpath("//*[@id=\"history\"]/div/div[2]/div/div/div[1]"));
	    String Hidat=Hdate.getText();
	    WebElement Hselpgm=driver.findElement(By.id("program"));
	    String Hiselval=Hselpgm.getText();
//	    
//	    System.out.println(Hifac);
//	    System.out.println(Hidat);
//	    System.out.println(Hiselval);
	    
	    if(Hifac.equals(fac))
	    {
	    		System.out.println("Facility history matches with past Appointment");
	    }
	    else
	    {
	    	System.out.println("Facility history Not matches with past Appointment");
	    }
	    if(Hidat.equals(dat))
	    {
	    		System.out.println("Date history matches with past Appointment");
	    }
	    else
	    {
	    	System.out.println("Date history Not matches with past Appointment");
	    }
	    if(Hiselval.equals(selval))
	    {
	    		System.out.println("Program history matches with past Appointment");
	    }
	    else
	    {
	    	System.out.println("Program history Not matches with past Appointment");
	    
	    }
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"history\"]/div/div[3]/p/a")).click();//Go Home
	    
	    //Profile management
	    Thread.sleep(3000);
	    WebElement profile=driver.findElement(By.id("menu-toggle"));
	    profile.click();
	    Thread.sleep(3000);
	    WebElement Profilemanage=driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[4]/a"));
	    Profilemanage.click();
	    
	    //Screenshot
	    TakesScreenshot screenshot1=(TakesScreenshot)driver;
		File src1=screenshot1.getScreenshotAs(OutputType.FILE);
 		File des1=new File("photo/profile.png");
 		FileHandler.copy(src1, des1);
 		// Logout
 		
 		driver.findElement(By.id("menu-toggle")).click();
 	    Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("https://katalon-demo-cura.herokuapp.com/")) {
            System.out.println("Logout success: Returned to login page");
        } else {
            System.out.println("Logout failed");
        }
     /*   //  Press Back button → check session expired
        driver.navigate().back();
        Thread.sleep(2000);
        String urlAfterBack = driver.getCurrentUrl();
        if (urlAfterBack.contains("https://katalon-demo-cura.herokuapp.com/")) {
            System.out.println(" Back button test passed: session expired");
        } else {
            System.out.println("Back button test failed");
        }
        //  Simulate session timeout (wait for idle period)
        
        driver.findElement(By.id("btn-make-appointment")).click();
        Thread.sleep(60000); // Wait 1 minute (adjust as needed)

        System.out.println("ℹ️ Waited to simulate session timeout (manual validation required if no auto-expiry)");*/


	}

}
