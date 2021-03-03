package StepDefinitions;

import static org.junit.Assert.assertNotEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AcessoSteps {
	
	WebDriver driver = null;
	
	@Given("Acesso a url")
	public void acesso_a_url() {
	   
		System.out.println("Acesso a url");
		System.setProperty("webdriver.chrome.driver","C:/Users/zelit/eclipse-workspace/Test_YU_Cucumber_Java_Selenium/src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
	    
		driver.manage().window().maximize(); 																		//Maximizo a tela
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://sampleapp.tricentis.com/101/app.php");	
	}

	@Then("Preencho o formulario aba Enter Vehicle")
	public void preencho_o_formulario() {
		
		//Preenche o Formulario
				driver.findElement(By.cssSelector("#make > option:nth-child(2)")).click();
				driver.findElement(By.cssSelector("#model > option:nth-child(2)")).click();
				driver.findElement(By.id("cylindercapacity")).sendKeys("30");
				driver.findElement(By.id("engineperformance")).sendKeys("10");
				driver.findElement(By.id("dateofmanufacture")).sendKeys("03/03/2021");
				driver.findElement(By.cssSelector("#numberofseats > option:nth-child(6)")).click();
				driver.findElement(By.cssSelector("#insurance-form > div > section:nth-child(1) > div:nth-child(7) > p > label:nth-child(1) > span")).click();
				driver.findElement(By.cssSelector("#numberofseatsmotorcycle > option:nth-child(3)")).click();
				driver.findElement(By.cssSelector("#fuel > option:nth-child(3)")).click();
				driver.findElement(By.id("payload")).sendKeys("1");
				driver.findElement(By.id("totalweight")).sendKeys("100");
				driver.findElement(By.id("listprice")).sendKeys("500");
				driver.findElement(By.id("licenseplatenumber")).sendKeys("Teste");
				driver.findElement(By.id("annualmileage")).sendKeys("2021");
				driver.findElement(By.id("nextenterinsurantdata")).click();				
				
	}
	
	@Then("Preencho o formulario aba Enter Insurant")
	public void preencho_o_formulario_aba_Enter_Insurant() {
	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,-250)", "");
		
				driver.findElement(By.id("firstname")).sendKeys("Alvaro");
				driver.findElement(By.id("lastname")).sendKeys("Marques");
				driver.findElement(By.id("birthdate")).sendKeys("01/27/1993");
				driver.findElement(By.cssSelector("#insurance-form > div > section:nth-child(2) > div:nth-child(4) > p > label:nth-child(1) > span")).click();
				driver.findElement(By.id("streetaddress")).sendKeys("rua honorato pereira lopes");
				driver.findElement(By.cssSelector("#country > option:nth-child(32)")).click();
				driver.findElement(By.id("zipcode")).sendKeys("75382685");
				driver.findElement(By.id("city")).sendKeys("Trindade");
				driver.findElement(By.cssSelector("#occupation > option:nth-child(2)")).click();
				
			    driver.findElement(By.cssSelector("#other")).sendKeys("Other");
			    driver.findElement(By.cssSelector("#insurance-form > div > section:nth-child(2) > div.field.idealforms-field.idealforms-field-checkbox.invalid > p > label:nth-child(5)")).click();
				driver.findElement(By.id("website")).sendKeys("https://www.linkedin.com/in/alvaro-rangel-marques-de-oliveira-b0429b156/");
			
				//Anexar foto depois
				
				driver.findElement(By.id("nextenterproductdata")).click();				

	}
	
	@Then("Preencho o formulario aba Enter Product Data")
	public void preencho_o_formulario_aba_Enter_Product_data() {
		
				driver.findElement(By.id("startdate")).sendKeys("05/03/2021");
				driver.findElement(By.cssSelector("#insurancesum > option:nth-child(2)")).click();
				driver.findElement(By.cssSelector("#meritrating > option:nth-child(8)")).click();
				driver.findElement(By.cssSelector("#damageinsurance > option:nth-child(2)")).click();
				driver.findElement(By.cssSelector("#insurance-form > div > section:nth-child(3) > div.field.idealforms-field.idealforms-field-checkbox > p > label:nth-child(1) > span")).click();
				driver.findElement(By.cssSelector("#courtesycar > option:nth-child(2)")).click();
				driver.findElement(By.id("nextselectpriceoption")).click();
				
	}
	

	@Then("Preencho o formulario aba Select Price Option")
	public void preencho_o_formulario_aba_Select_Price_Option() {
	
				driver.findElement(By.cssSelector("#priceTable > tfoot > tr > th.group > label:nth-child(3) > span")).click();
//				driver.findElement(By.cssSelector("#downloadquote > span")).click(); Caso queira fazer o download basta descomentar essa linha
				driver.findElement(By.id("nextsendquote")).click();
		
	}
	
	@Then("Preencho o formulario aba Send Quote")
	public void preencho_o_formulario_aba_Send_Quote() {
				driver.findElement(By.id("email")).sendKeys("rangeelmarques@gmail.com");
				driver.findElement(By.id("phone")).sendKeys("62982584952");
				driver.findElement(By.id("username")).sendKeys("rangeelmarques");
				driver.findElement(By.id("password")).sendKeys("Teste123");
				driver.findElement(By.id("confirmpassword")).sendKeys("Teste123");
				driver.findElement(By.id("sendemail")).click();
				
				//Verifica a mensagem de sucesso
			    WebElement element = driver.findElement(By.tagName("p"));
			    assertNotEquals(element.getText(), "Sending e-mail success!");

			    driver.close();
			    
				
				
	}
}
