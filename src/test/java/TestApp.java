import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApp {

    static AndroidDriver<AndroidElement> driver = null;

    @Before
    public void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6 API 31");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void sumTest() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/result_final")));
        String result = resultElement.getText();
        assertEquals("9", result);
    }
    @Test
    public void multiplyTest(){
        driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/result_final")));
        String result = resultElement.getText();
        assertEquals("18", result);
    }
    @Test
    public void subtractTest(){
        driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/result_final")));
        String result = resultElement.getText();
        assertEquals("3", result);
    }
    @Test
    public void divideTest(){
        driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/result_final")));
        String result = resultElement.getText();
        assertEquals("2", result);
    }

    @AfterAll
    public static void tearDown() {
            driver.quit();
    }
}

