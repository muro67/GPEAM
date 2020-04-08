package com.groupe.aem;

import org.apache.commons.lang3.SystemUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class SeleniumPMATest {
    private final String URL_PHPMYADMIN = "http://localhost/phpMyAdmin/";
    private final String LOGIN_USERNAME = "root";
    private final String LOGIN_PASSWORD = "";

    @BeforeClass
    public static void init() {
        if (SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver-v0.26.0-linux32");
        } else if (SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver-v0.26.0-win32.exe");
        } else if (SystemUtils.IS_OS_MAC) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver-v0.26.0-macos");
        }
    }

    @Test
    public void testSelenium() {
        WebDriver driver = new FirefoxDriver();
        driver.get(URL_PHPMYADMIN);

        driver.manage().window().maximize();

        // Login Username & Password
        driver.findElement(By.xpath("//*[@id='input_username']")).sendKeys(LOGIN_USERNAME);
        driver.findElement(By.xpath("//*[@id='input_password']")).sendKeys(LOGIN_PASSWORD);

        driver.findElement(By.xpath("//*[@id='select_server']/option[1]")).click();
        driver.findElement(By.xpath("//*[@id='input_username']")).click();
        driver.findElement(By.xpath("//*[@id='input_go']")).click();
        driver.quit();

        assertTrue(true);
    }
}
