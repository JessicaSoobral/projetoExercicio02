package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroDeProdutosTest {

	@Test
	public void CadastroDeProdutosTest() {
		
		// executando o driver do googlechrome
		System.setProperty("webdriver.chrome.driver","c:\\chromedriver\\chromedriver.exe");
		
		// Abrindo o navegador (google chrome)
		WebDriver driver = new ChromeDriver();
		
		// maximizar o navegador
		driver.manage().window().maximize();
		
		// acessar a página wen do sistema que será testada
		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio05");
		
		//Preencher o nome do produto
		driver.findElement(By.xpath("//*[@id=\"nome\"]")).sendKeys("Notebook Dell");
		
		//Preencher o preço
		driver.findElement(By.xpath("//*[@id=\"preco\"]")).sendKeys("3500");
		
		//Preencher a quantidade de produtos
		driver.findElement(By.xpath("//*[@id=\"quantidade\"]")).sendKeys("10");
		
		// clicar em cadastar produto
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
		
		// Capturar mensagem exibida pelo sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		
		// Comparando se a mensagem exibida pelo sistema é "Produto cadastrado com sucesso."
		assertEquals(mensagem, "Produto cadastrado com sucesso.");
		
		try {
			// O selenium irá fazer um print da tela e armazenar em memória
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Salvando o arquivo na pasta
			FileUtils.copyFile(arquivo, new File("c:\\evidencias_teste\\Cadastro de Produtos.png"));

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		
			// fechar o navegador
			driver.close();
			driver.quit();
		
		
		
	}


}
