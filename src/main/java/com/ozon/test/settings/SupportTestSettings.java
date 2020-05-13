package com.ozon.test.settings;


import com.ozon.test.listeners.WebDriverEventListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public abstract class SupportTestSettings {

    public static EventFiringWebDriver driver;
    public static WebDriverWait webDriverWait;
    public static Properties properties = new Properties();
    public static final String OZON_URL = "https://www.ozon.ru";
    public static String PHONE = "89873596773";
    public static String AUTH_CODE = "";


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/TestPO/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        WebDriverEventListener eventListener = new WebDriverEventListener();
        driver.register(eventListener);
        webDriverWait = new WebDriverWait(driver, 80);
        driver.get(OZON_URL);
    }

//    @AfterMethod
//    public void close() {
//        driver.quit();
//    }
}
