package com.ozon.test.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class CityPage {
    WebDriver driver;
    WebDriverWait wait;

    private static final String CITY_XPATH = "/html/body/div[1]/div/div/div[1]/div/button/span";
    private static final String CITY_INPUT_XPATH = "//*[@id=\"__nuxt\"]/div/div[2]/div/div/div/div/div/label/div/input";
    private static final String CITY_FIRST_XPATH = "//*[@id=\"__nuxt\"]/div/div[2]/div/div/div/div/ul/li[1]/a";

    private static final String CITY = "Вольск";
    private static final String CITY_FULL = "Вольск, Саратовская область";

    private WebElement cityElement;

    public CityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @Step("Click city label")
    public void clickCityLabel() {
        cityElement = driver.findElement(By.xpath(CITY_XPATH));
        cityElement.click();
    }

    @Step("Input city")
    public void inputCity() {
        WebElement cityInput = driver.findElement(By.xpath(CITY_INPUT_XPATH));
        cityInput.click();
        cityInput.sendKeys(CITY);
        wait.until(ExpectedConditions.textToBe(By.xpath(CITY_FIRST_XPATH), CITY_FULL));
        cityInput.sendKeys(Keys.DOWN);
        cityInput.sendKeys(Keys.ENTER);
    }

    @Step("Check new city")
    public void checkNewCity() {
        wait.until(ExpectedConditions.textToBe(By.xpath(CITY_XPATH), CITY));
        cityElement = driver.findElement(By.xpath(CITY_XPATH));
        assertEquals(cityElement.getText(), CITY);
    }
}
