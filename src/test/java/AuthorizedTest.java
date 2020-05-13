import com.ozon.test.listeners.TestListener;
import com.ozon.test.pages.PageObjectMain;
import com.ozon.test.settings.SupportTestSettings;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class AuthorizedTest extends SupportTestSettings {

    @Test
    public void firstTest() {
        PageObjectMain pageObjectMain = new PageObjectMain(driver, webDriverWait);//
        pageObjectMain.clickLoginButton();
        pageObjectMain.inputPhoneNumber();
        pageObjectMain.inputVerificationCode();
        pageObjectMain.checkAccountSettings();
    }
}