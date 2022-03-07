package com.thomson.appiumtest.page

import com.thomson.appiumtest.base.BasePage
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidFindBy
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class LoginPage(driver: AppiumDriver<MobileElement>) : BasePage(driver) {

    @AndroidFindBy(tagName = "title")
    lateinit var title: MobileElement

    @AndroidFindBy(tagName = "username")
    lateinit var userName: MobileElement

    @AndroidFindBy(tagName = "password")
    lateinit var password: MobileElement

    @AndroidFindBy(tagName = "loginButton")
    lateinit var loginButton: MobileElement

    @AndroidFindBy(tagName = "authResult")
    lateinit var authResult: MobileElement

    fun clickOnLogin() {
        loginButton.click()
    }

    fun validateLoginShowed(): Boolean {
        return title.isDisplayed && userName.isDisplayed && password.isDisplayed && loginButton.isDisplayed
    }

    fun enterUsername(userName: String) {
        this.userName.click()
        this.userName.sendKeys(userName)
    }

    fun enterPassword(password: String) {
        this.password.click()
        this.password.sendKeys(password)
    }

    fun validateInvalidLogin(): Boolean {
        val wait = WebDriverWait(driver, 10)
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.tagName("authResult"), "Unauthenticated"))
        return authResult.text == "Invalid username or password"
    }

    fun validateLoginSuccess(): Boolean {
        val wait = WebDriverWait(driver, 10)
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.tagName("authResult"), "Unauthenticated"))
        return authResult.text == "Login Success"
    }
}