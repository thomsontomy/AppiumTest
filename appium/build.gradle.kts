plugins {
    java
    kotlin("jvm") version "1.6.10"
}

group = "org.thomson"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.appium:java-client:8.0.0")
    testImplementation("org.seleniumhq.selenium:selenium-support:4.1.4")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("org.junit.vintage:junit-vintage-engine:5.8.2")
    testImplementation("io.cucumber:cucumber-java:7.3.3")
    testImplementation("io.cucumber:cucumber-junit:7.3.3")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}