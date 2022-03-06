package com.thomson.appiumtest.stepdefenitions

import com.thomson.appiumtest.AppiumApplication
import com.thomson.appiumtest.page.LoginPage
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.cucumber.java.Before
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.After
import org.junit.jupiter.api.fail

class LoginFeatureStepDefinitions {

    private val application = AppiumApplication()
    private lateinit var loginPage: LoginPage

    @Before
    fun setup() {
        application.initialiseAppium()
        @Suppress("UNCHECKED_CAST")
        loginPage = LoginPage(application.driver as AppiumDriver<MobileElement>)
    }

    @After
    fun tearDown() {
        application.shutDown()
    }

    @Given("The login screen is shown")
    fun givenLoginScreenShown() {
        if (!loginPage.validateLoginShowed()) {
            fail { "Login page is not showed with required elements" }
        }
    }

    @When("The user enters username {string}")
    fun whenUserEntersUsername(userName: String) {
        loginPage.clickOnLogin()
    }

    @And("The user enters password {string}")
    fun andUserEntersPassword(password: String) {
    }

    @And("The user clicks login button")
    fun andUserClicksLoginButton() {
    }

    @Then("The invalid username or password message should be showed")
    fun thenInvalidUsernameShouldBeShowed() {
    }
}