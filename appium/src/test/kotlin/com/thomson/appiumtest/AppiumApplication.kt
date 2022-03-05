package com.thomson.appiumtest

import org.openqa.selenium.remote.DesiredCapabilities
import io.appium.java_client.remote.MobileCapabilityType
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidElement
import org.openqa.selenium.WebDriver
import java.net.MalformedURLException
import java.net.URL
import java.util.concurrent.TimeUnit

class AppiumApplication {

    val driver: WebDriver
        get() = Companion.driver

    fun initialiseAppium() {
        val capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability(
            MobileCapabilityType.APP,
            "/Users/thomson/projects/PushNotification/app/build/intermediates/apk/debug/app-debug.apk"
        )
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554")
        try {
            Companion.driver = AppiumDriver<AndroidElement>(URL("http://0.0.0.0:4723/wd/hub"), capabilities)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
    }

    fun shutDown() {
        driver.quit()
    }

    companion object {
        lateinit var driver: WebDriver
            private set
    }
}