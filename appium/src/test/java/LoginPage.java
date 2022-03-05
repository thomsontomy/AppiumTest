import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;

public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidBy(id = "registerFirst")
    public MobileElement registerFirst;

    public void clickOnLogin() {
        registerFirst.click();
    }

    public boolean validateLoginShowed() {
        return registerFirst.isDisplayed();
    }
}