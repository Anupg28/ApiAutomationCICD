package com.videogamedb.testcase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTile {
	
	    public static String getPageTitle(WebDriver driver) {
	        return driver.getTitle();
	        }
	        
	        public static void main(){
	        	WebDriver driver = new ChromeDriver();
	          getPageTitle(driver);
	        }
	        }

