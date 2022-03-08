package com.thomson.appiumtest

import io.cucumber.junit.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(
    glue= ["StepDefinitions"],
    features = ["src/test/resources"]
)
class CucumberTest