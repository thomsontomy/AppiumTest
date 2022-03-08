val serenityVersion = "3.2.0"
plugins {
    java
    kotlin("jvm") version "1.6.10"
    id("net.serenity-bdd.serenity-gradle-plugin") version "3.2.0"
}

group = "org.thomson"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.appium:java-client:8.0.0-beta2")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("org.junit.vintage:junit-vintage-engine:5.8.2")
    testImplementation("net.serenity-bdd:serenity-core:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-cucumber:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-junit:$serenityVersion")
    testImplementation("net.serenity-bdd:serenity-rest-assured:$serenityVersion")
}

/*configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module("io.appium:java-client"))
            .using(module("io.appium:java-client:7.6.0"))
    }
}*/

tasks.getByName<Test>("test") {
    testLogging.showStandardStreams = true
    useJUnitPlatform()
    finalizedBy("aggregate")
}

serenity {
    testRoot = "com.thomson.appiumtest"
    requirementsDir = "src/test/resources"
}