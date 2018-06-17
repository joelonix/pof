package com.ryanair.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ryanair.base.TestBase;

public class SeatSelectionPage extends TestBase{
	
	@FindBy(xpath="//div[@class='seat-map-prompt-content']/button[@class='core-btn-primary same-seats']")
	WebElement okgotitbtn;
	
	@FindBy(xpath=".//div[@class='seat-map-rows']")
	WebElement seattable;
	
	public SeatSelectionPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnOkGotItbutton(){
		this.okgotitbtn.click();
	}
	
	
public void selectSeat(){
		
		
		List<WebElement> rows=this.seattable.findElements(By.xpath("//div[@class='seat-wrapper seat-group-ONSALE']"));
				
		outer:for(int rowcount=0;rowcount<rows.size();rowcount++){
			List<WebElement> cols=rows.get(rowcount).findElements(By.xpath("//span[@class='seat-row-seat onsale']"));
			
			for(int colcount=0;colcount<cols.size();colcount++){
				{
					cols.get(colcount).click();
					if(colcount==3) {
						break;
					}
				}
				
				
			}
			
			break outer;
		}
		
		

	}

}
