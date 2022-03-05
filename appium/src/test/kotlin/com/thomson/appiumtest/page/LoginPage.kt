package com.thomson.appiumtest.page

import com.thomson.appiumtest.base.BasePage
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AndroidBy

class LoginPage(driver: AppiumDriver<MobileElement>) : BasePage(driver) {

    @AndroidBy(id = "registerFirst")
    lateinit var registerFirst: MobileElement

    fun clickOnLogin() {
        registerFirst.click()
    }

    fun validateLoginShowed(): Boolean {
        return registerFirst.isDisplayed
    }
}