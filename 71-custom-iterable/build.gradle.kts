plugins {
    java
    application
    
    id("org.danilopianini.gradle-java-qa") version "1.22.1"
}

application {
    // Define the main class for the application
    mainClass.set("it.unibo.inner.TestIterablePlain")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")
}

tasks.test {
    useJUnitPlatform()
    testLogging { events("passed", "skipped", "failed") }
    testLogging.showStandardStreams = true
}

tasks.javadoc {
    isFailOnError = false
}
