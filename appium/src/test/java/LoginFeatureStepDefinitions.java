import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;

public class LoginFeatureStepDefinitions {

    private AppiumApplication application = new AppiumApplication();
    private LoginPage loginPage;


    @Before
    public void setup() {
        application.initialiseAppium();
        loginPage = new LoginPage((AppiumDriver<MobileElement>) application.getDriver());
    }

    @After
    public void tearDown() {
        application.shutDown();
    }

    @Given("The login screen is shown")
    public void givenLoginScreenShown() {
        loginPage.validateLoginShowed();
    }

    @When("The user enters username {string}")
    public void whenUserEntersUsername(String userName) {
        loginPage.clickOnLogin();
    }

    @And("The user enters password {string}")
    public void andUserEntersPassword(String password) {

    }

    @And("The user clicks login button")
    public void andUserClicksLoginButton() {

    }

    @Then("The invalid username or password message should be showed")
    public void thenInvalidUsernameShouldBeShowed() {

    }
}
