package com.ozon.test.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JuicersPage {
    WebDriver driver;
    WebDriverWait wait;

    public JuicersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[1]/input")
    private WebElement minPrice;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/div[10]/div[2]/div[2]/div[1]/input")
    private WebElement minPower;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[2]/input")
    private WebElement maxPrice;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span")
    private WebElement priceRange;

    @FindBy(css = "[role=\"combobox\"]")
    private WebElement chooseSortTypeInput;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[2]/div/a")
    private WebElement clickJuicer;


    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div[3]/div[2]/div[2]/div/div[3]/div[2]/div/div[1]/div/div/div/div/div[6]/div/div/div/div/div/div/button/div")
    private WebElement addtoBasket;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div/div/div[3]/div[2]/div/div/button/div/div")
    private WebElement addPowertoBasket;


    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/section/main/div[3]/div[1]/a")
    private WebElement juicers;


    protected static final String powerRange = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]/button/div/span";
    protected static final String priceLocation = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span";
    protected static final String buttonCart = "//*[@id=\"__nuxt\"]/div/div[1]/div[3]/div[2]/div[2]/div/div[3]/div[2]/div/div[1]/div/div/div/div/div[6]/div/div/div/div/div/div/button";
    protected static final String cartTo = "//*[@id=\"__nuxt\"]/div/div[1]/div[3]/div[2]/div[2]/div/div[3]/div[2]/div/div[1]/div/div/div/div/div[6]/div/div/div/div/div[1]/div[1]/button/div/div/div";


    @Step("Open catalog juicers")
    public void open() {
        driver.get("https://www.ozon.ru/category/sokovyzhimalki-10592/");
        wait.until(ExpectedConditions.visibilityOf(minPrice));
    }

    @Step("Set min price")
    public void setMinPrice() {
        minPrice.sendKeys("\b\b\b");
        minPrice.sendKeys(Integer.toString(3000));
        juicers.click();
    }

    @Step("Set max price")
    public void setMaxPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceLocation)));
        maxPrice.sendKeys("\b\b\b\b\b\b");
        maxPrice.sendKeys(Integer.toString(4000));
        priceRange.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceLocation)));
    }

    @Step("Set min power")
    public void setMinPower() {
        minPower.sendKeys("\b");
        minPower.sendKeys(Integer.toString(1000));
        maxPrice.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(powerRange)));
    }



    @Step("Set cheepest sort")
    public void setCheepest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceLocation)));
        chooseSortTypeInput.click();
        //wait.until(ExpectedConditions.elementToBeClickable(chooseSortTypeInput));
        chooseSortTypeInput.click();
        for(int i = 0; i < 2; i++) {
            chooseSortTypeInput.sendKeys(Keys.ARROW_DOWN);
        }
        chooseSortTypeInput.sendKeys(Keys.ENTER);
    }

    @Step("Check price range")
    public void checkpriceRange() {
        String priceRange = "Цена: от 3 000 до 4 000";
        Assert.assertEquals(priceRange, this.priceRange.getText());
    }




    @Step("Click on juicer and add to Basket")
    public void gotoCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceLocation)));
        clickJuicer.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonCart)));
        addtoBasket.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartTo)));
    }


    @Step("Click on juicer and add to Basket")
    public void gotoCartwithPowerJuicer() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceLocation)));
        addPowertoBasket.click();
    }


}
