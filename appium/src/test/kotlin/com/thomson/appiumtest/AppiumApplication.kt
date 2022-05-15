package com.thomson.appiumtest

import io.appium.java_client.AppiumDriver
import io.appium.java_client.remote.AutomationName
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File
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
            "${File(".").absolutePath}/../android_app/app/build/intermediates/apk/debug/app-debug.apk"
        )
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ESPRESSO)
        // Workaround for Espresso driver and Jetpack compose compatibility
        val espressoBuildConfig = """
            {
                "toolsVersions": { 
                    "compileSdk": "31", 
                    "minSdk": "26"
                }, 
                "additionalAndroidTestDependencies": [
                    "androidx.lifecycle:lifecycle-extensions:2.2.0", 
                    "androidx.activity:activity:1.3.1",
                    "androidx.compose.ui:ui-tooling:1.1.1"
                ]
            }
        """.trimIndent()
        capabilities.setCapability("espressoBuildConfig", espressoBuildConfig)
        try {
            Companion.driver = AppiumDriver(URL("http://0.0.0.0:4723/wd/hub"), capabilities).apply {
                setSetting("driver", "compose")
            }
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