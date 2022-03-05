package com.thomson.appiumtest.base

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.support.PageFactory
import io.appium.java_client.pagefactory.AppiumFieldDecorator

open class BasePage(driver: AppiumDriver<MobileElement>) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }
}