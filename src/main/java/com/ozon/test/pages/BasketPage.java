package com.ozon.test.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasketPage {
    WebDriver driver;//
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div/div/div[3]/div[4]/div[1]/div[1]/div/div[2]/div[3]/div[3]/div[1]/div/span")
    private WebElement price;


    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div/div/div[3]/div[4]/div[1]/div[1]/div/div[2]/div[3]/div[3]/div[1]/div/span")
    private WebElement pricePowerJuicer;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div/div/div[3]/div[4]/div[2]/div/div[1]/div[2]/div[4]/span[2]")
    private WebElement priceCart;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div/div/div[3]/div[4]/div[2]/div/div[1]/div[2]/div[4]/span[2]")
    private WebElement pricePowerJuicerCart;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @Step("Open Basket")
    public void open() {
        driver.get("https://www.ozon.ru/cart");
    }

    @Step("Check price juicer and cart price")
    public void checkPrices() {
        Assert.assertEquals(this.priceCart.getText(), this.price.getText());;
    }

    @Step("Check price power juicer and cart price")
    public void checkPowerPrices() {
        Assert.assertEquals(this.pricePowerJuicer.getText(), this.pricePowerJuicerCart.getText());;
    }



}
