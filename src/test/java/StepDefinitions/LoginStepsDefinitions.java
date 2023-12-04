package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinitions {

	static WebDriver driver;
	String urlBase = "https://www.saucedemo.com/";
	String usuario = "standard_user";
	String password = "secret_sauce";

	public void setup() {
		// Set up WebDriver
		System.setProperty("webdriver.geckodriver.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\geckodriver.exe");

	}

	@Given("El usuario está en la página de inicio de sesión")

	public void el_usuario_está_en_la_página_de_inicio_de_sesión() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(urlBase);

	}

	@When("El usuario introduce un nombre de usuario y un password válidos")

	public void el_usuario_introduce_un_nombre_de_usuario_y_una_contraseña_válidos() {
		WebElement campoUsuario = driver.findElement(By.xpath("//input[@id='user-name']"));
		campoUsuario.sendKeys(usuario);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement campoPassword = driver.findElement(By.xpath("//input[@id='password']"));
		campoPassword.sendKeys(password);
	}

	@And("Pulsa el boton de inicio de sesion")

	public void pulsa_el_boton_de_inicio_de_sesion() {
		WebElement inicioSesionButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		inicioSesionButton.click();
	}

	@Then("El usuario es dirigido a la página de inicio")

	public void el_usuario_es_dirigido_a_la_página_de_inicio() {
		Assert.assertTrue(driver.findElements(By.xpath("//div[@class='app_logo']")).size() > 0,
				"El usuario es dirigido a la página de inicio");
	}

	@And(value = "Cierra el navegador")

	public void cierra_el_navegador() {
		System.out.println("Prueba Certificada por QA");
		driver.close();

	}

}
