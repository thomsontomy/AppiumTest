package com.thomson.appiumtest.base

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

open class BasePage(protected val driver: AppiumDriver<MobileElement>) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }
}