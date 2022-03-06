package com.thomson.appiumtest.page

import com.thomson.appiumtest.base.BasePage
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy

class LoginPage(driver: AppiumDriver<MobileElement>) : BasePage(driver) {

    @AndroidBy(tagName = "title")
    lateinit var title: MobileElement

    @AndroidBy(tagName = "username")
    lateinit var userName: MobileElement

    @AndroidBy(tagName = "password")
    lateinit var password: MobileElement

    @AndroidBy(tagName = "loginButton")
    lateinit var loginButton: MobileElement

    fun clickOnLogin() {
        loginButton.click()
    }

    fun validateLoginShowed(): Boolean {
        return title.isDisplayed && userName.isDisplayed && password.isDisplayed && loginButton.isDisplayed
    }
}