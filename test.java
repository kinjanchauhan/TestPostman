package test.com.ca;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test {


	 
	    public static void main(String[] args) throws InterruptedException {
	        
	        //Setting up chrome using chromedriver by setting its property
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drpra\\chromedriver.exe"); 
	        
	        //Opening browser
	        ChromeDriver driver= new ChromeDriver() ;
	        
	        //Opening window tab in maximize mode
	        //driver.manage().window().maximize();
	        Thread.sleep(3000);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        
	        //Opening application
	        //driver.get("http://www.crawco.co.uk");
	        //WebElement url=driver.findElement((By.xpath("//*[@id="mmenu-page"]/footer/div/div[1]/p[2]/a[2]" ="https://www.facebook.com/crawfordandco"));
	         
	        String homePage = "http://www.crawco.co.uk";
	        String url = "https://www.facebook.com/crawfordandco";
	        HttpURLConnection huc = null;
	        int respCode = 200;
	        
	        driver = new ChromeDriver();
	        
	        driver.manage().window().maximize();
	        
	        driver.get(homePage);
	     
	      List<WebElement> links =driver.findElement(By.class("c-footer__social"));
	      
	     //   WebElement links1 = driver.findElements(By.className("c-footer__social"));        
	        @SuppressWarnings("unchecked")
			Iterator<WebElement> it = ((List<WebElement>) links).iterator();
	        
	        while(it.hasNext()){
	            
	            if (url == it.next().getAttribute("href"));
	            {
	             System.out.println(url);
	        
	            if(url == null || url.isEmpty()){
	            	System.out.println("URL is either not configured for anchor tag or it is empty");
	                continue;
	            }
	            
	            if(!url.startsWith(homePage)){
	                System.out.println("URL belongs to another domain, skipping it.");
	                continue;
	            }
	            
	            try {
	                huc = (HttpURLConnection)(new URL(url).openConnection());
	                
	                huc.setRequestMethod("HEAD");
	                
	                huc.connect();
	                
	                respCode = huc.getResponseCode();
	                
	                if(respCode >= 400){
	                    System.out.println(url+" is a broken link");
	                }
	                else{
	                    System.out.println(url+" is a valid link");
	                }
	                    
	            } catch (MalformedURLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }	
	      }
	        
	      /*  //Locating the email field element via Name tag and storing it in the webelement
	        WebElement email_field=driver.findElement(By.name("email"));
	        
	        //Entering text into the email field
	        email_field.sendKeys("sadhvisingh24@gmail.com");
	        
	        //Locating the password field element via Name tag and storing it in the webelement
	        WebElement password_field=driver.findElement(By.name("password"));
	                
	        //Entering text into the password field
	        password_field.sendKeys("LoremIpsum");
	        
	        //Clicking on the login button to login to the application
	        WebElement login_button=driver.findElement(By.xpath("//button[text()='LOGIN']"));
	        
	        //Clicking on the 'login' button
	        login_button.click();
	        
	        //Closing the window*/
	        driver.close();
	        }
	}

