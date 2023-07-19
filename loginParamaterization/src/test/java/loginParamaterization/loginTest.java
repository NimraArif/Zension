package loginParamaterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;


public class loginTest {
		WebDriver driver = null; 
		WebElement username_page = null;
		String title = "https://preprodportal.zensiontec.com/einvoicing/#/invoices/draft-invoices"; 
		String actual = "";
		public loginTest(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver= driver;
		}

		public void login_page() throws InterruptedException, IOException {
			
			
			File file = new File("C:\\Users\\nimra.arif\\Downloads\\file.xlsx"); // Replace with the actual file path
			FileInputStream fis = new FileInputStream(file);
		//	FileOutputStream fos = new FileOutputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			//XSSFWorkbook wb = new XSSFWorkbook(fos);
			XSSFSheet sheet = workbook.getSheetAt(0); // Assuming the username is in the first sheet
			int rowCount = sheet.getLastRowNum();
			System.out.println("Row " + rowCount);
			int columnCount = sheet.getRow(0).getLastCellNum();
			System.out.println("Column " + columnCount);
			int columncheck = columnCount-1;
			  XSSFCell cell = null;
			for (int rowIndex = 1; rowIndex <= rowCount ; rowIndex++) {
				cell = sheet.getRow(rowIndex).createCell(3);
				int columnIndex = 0;
						while (columnIndex < columncheck) {
	                    //XSSFCell cell = row.getCell(columnIndex);
	                    String sheet_username = sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
	                    System.out.println(sheet_username);
	                    Thread.sleep(5000);
	                    username_page = driver.findElement(By.xpath("//input[@id='user_name']"));
	            		Thread.sleep(1000);
	                    username_page.sendKeys(sheet_username);
	        			Thread.sleep(1000);
	                    System.out.println("Column Index " + columnIndex);
	                    columnIndex = columnIndex + 1;
				}
				
	                    double sheet_password = (int) sheet.getRow(rowIndex).getCell(columnIndex).getNumericCellValue();
	                	String ch_sheet_password = String.valueOf((int) sheet_password);
	                	//System.out.println(sheet_username);
	                   	System.out.println(ch_sheet_password);
	                   	WebElement password_page = driver.findElement(By.xpath("//input[@id='password']"));
	        			Thread.sleep(2000);
	        			password_page.sendKeys(ch_sheet_password);
	        			Thread.sleep(1000);
	        			WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
	        		
	        			Thread.sleep(2000);
	        			login.click();
	        			Thread.sleep(5000);
	        			Thread.sleep(5000);
	        			 actual = driver.getCurrentUrl();
	        			 FileOutputStream fos = new FileOutputStream("C:\\Users\\nimra.arif\\Downloads\\file.xlsx");
	        				boolean var = check(actual);
	    			 		
	    			 		if (var == true) {
	    					Thread.sleep(2000);		
	    					WebElement icon =  driver.findElement(By.xpath("//app-header/mat-toolbar[1]/div[2]/mat-icon[1]"));
	    					Thread.sleep(2000);	
	    					icon.click();
	    					Thread.sleep(2000);
	    					WebElement logout = driver.findElement(By.xpath("//mat-icon[contains(text(),'logout')]"));
	    					Thread.sleep(2000);
	    					logout.click();
	    					Thread.sleep(5000);
	    	                System.out.println();
	    	                cell.setCellValue("PASS");
	    	                
	    	                
	    			 		}
	    			 		
	    			 		else 
	    			 		{
	    			 			System.out.print("Login is not successfull..... ");// Move to the next row
	    			 			password_page.clear();
	    			 			username_page.clear();
	    			 			//create a new cell in the row at index 6
	    			          
	    			 			 // Replace with the new data you want to write
	    			 			cell.setCellValue("Fail");
	    			 			
	    			            // Set the new value to the cell
	    			           
	    			 		
	    			 		}
	    			 		workbook.write(fos);
	                }
			workbook.close();
	            }
		
		public boolean check(String actual) {
			 if(!title.equals(actual)) {
				 System.out.println("Failed!!!");
				 return false;
			 }
			 else {
				 System.out.println("PASS");
					
				 Reporter.log("Login is successfull");
				 return true;
			    }
		}
	}	    
		

