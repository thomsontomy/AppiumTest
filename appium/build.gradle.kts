plugins {
    java
}

group = "org.thomson"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.appium:java-client:7.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("org.junit.vintage:junit-vintage-engine:5.8.2")
    testImplementation("io.cucumber:cucumber-java:7.2.3")
    testImplementation("io.cucumber:cucumber-junit:7.2.3")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}