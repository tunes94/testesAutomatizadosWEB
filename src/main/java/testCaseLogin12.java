import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class testCaseLogin12 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        Logger.getLogger("").setLevel(Level.OFF);
        System.setProperty("webdriver.gecko.driver",
                "drivers\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver",
                "drivers\\MicrosoftWebDriver.exe");
        System.setProperty("webdriver.chrome.driver",
                "drivers\\chromedriver.exe");
        System.setProperty("phantomjs.binary.path",
                "drivers\\phantomjs.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("–-lang=pt-pt");
        driver = new ChromeDriver(options);
        baseUrl = "http://159.65.29.212/login";
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void testTestCaseLogin12() throws Exception {
        driver.get("http://159.65.29.212/");
        driver.findElement(By.linkText("TeenPower")).click();
        /*driver.findElement(By.cssSelector("button.navbar-toggler")).click();*/
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("password_tp18_t");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        // Warning: verifyTextPresent may require manual changes

        //System.out.println(driver.findElement(By.id("email")).getAttribute("validationMessage"));
        try {
            assertTrue("Ao deixar o campo email em branco deve-me ser apresentada uma mensagem a dizer para preencher esse mesmo campo",driver.findElement(By.id("email")).getAttribute("validationMessage").contains("Preencha este campo"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}