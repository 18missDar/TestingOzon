import com.ozon.test.listeners.TestListener;
import com.ozon.test.pages.CityPage;
import com.ozon.test.pages.PageObjectMain;
import com.ozon.test.settings.SupportTestSettings;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class ChangeCity extends SupportTestSettings {

    @Test
    public void secondTest() {
        PageObjectMain pageObjectMain = new PageObjectMain(driver, webDriverWait); //
        CityPage cityPage = new CityPage(driver);
        cityPage.clickCityLabel();
        cityPage.inputCity();
        cityPage.checkNewCity();
    }
}
