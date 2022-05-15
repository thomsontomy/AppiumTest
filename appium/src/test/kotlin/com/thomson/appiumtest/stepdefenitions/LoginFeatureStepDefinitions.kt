package com.thomson.appiumtest.stepdefenitions

import com.thomson.appiumtest.AppiumApplication
import com.thomson.appiumtest.page.LoginPage
import io.appium.java_client.AppiumDriver
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
        loginPage = LoginPage(application.driver as AppiumDriver)
    }

    @After
    fun tearDown() {
        application.shutDown()
    }

    @Given("The login screen is shown")
    fun `the login screen is shown`() {
        if (!loginPage.validateLoginShowed()) {
            fail { "Login page is not showed with required elements" }
        }
    }

    @When("The user enters username {string}")
    fun `the user enters username`(userName: String) {
        loginPage.enterUsername(userName)
    }

    @And("The user enters password {string}")
    fun `the user enters password`(password: String) {
        loginPage.enterPassword(password)
    }

    @And("The user clicks login button")
    fun `the user clicks login button`() {
        loginPage.clickOnLogin()
    }

    @Then("The invalid username or password message should be showed")
    fun `the invalid username or password message should be showed`() {
        if (!loginPage.validateInvalidLogin()) {
            fail { "Invalid login not showed" }
        }
    }

    @Then("The login success message should be showed")
    fun `the login success message should be showed`() {
        if (!loginPage.validateLoginSuccess()) {
            fail { "Login success not showed" }
        }
    }
}