import com.ozon.test.listeners.TestListener;
import com.ozon.test.pages.BasketPage;
import com.ozon.test.pages.JuicersPage;
import com.ozon.test.pages.PageObjectMain;
import com.ozon.test.settings.SupportTestSettings;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class BuyAnotherJuicers extends SupportTestSettings{
    @Test
    public void fourthTest() {
        PageObjectMain pageObjectMain = new PageObjectMain(driver, webDriverWait);//

        JuicersPage juicersPage = new JuicersPage(driver);
        juicersPage.open();

        juicersPage.setMinPrice();
        juicersPage.setMaxPrice();

        juicersPage.setMinPower();

        juicersPage.setCheepest();
        juicersPage.checkpriceRange();
        juicersPage.gotoCartwithPowerJuicer();


        BasketPage basketPage = new BasketPage(driver);
        basketPage.open();
        basketPage.checkPowerPrices();
    }
}
