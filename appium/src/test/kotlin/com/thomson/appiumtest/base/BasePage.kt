package com.thomson.appiumtest.base

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

open class BasePage(protected val driver: AppiumDriver) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }
}