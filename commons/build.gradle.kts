plugins {
    id("java")
}

group = "com.bell-sw"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.pf4j:pf4j:3.13.0") {
        exclude(group = "org.slf4j")
    }
}

tasks.test {
    useJUnitPlatform()
}