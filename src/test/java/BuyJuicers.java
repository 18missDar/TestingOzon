import com.ozon.test.listeners.TestListener;
import com.ozon.test.pages.BasketPage;
import com.ozon.test.pages.JuicersPage;
import com.ozon.test.pages.PageObjectMain;
import com.ozon.test.settings.SupportTestSettings;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class BuyJuicers extends SupportTestSettings{
    @Test
    public void thirdTest() {
        PageObjectMain pageObjectMain = new PageObjectMain(driver, webDriverWait);//

        JuicersPage juicersPage = new JuicersPage(driver);
        juicersPage.open();
        juicersPage.setMinPrice();
        juicersPage.setMaxPrice();
        juicersPage.setCheepest();
        juicersPage.checkpriceRange();
        juicersPage.gotoCart();


        BasketPage basketPage = new BasketPage(driver);
        basketPage.open();
        basketPage.checkPrices();
    }
}
