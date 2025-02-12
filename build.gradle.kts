plugins {
    java
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.bell-sw"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(project(":commons"))
    implementation("org.pf4j:pf4j:3.13.0") {
        exclude(group = "org.slf4j")
    }
    implementation("org.pf4j:pf4j-spring:0.9.0") {
        exclude(group = "org.slf4j")
    }

}

tasks.withType<Test> {
    useJUnitPlatform()
}

val copyPlugins = tasks.register<Copy>("copyPlugins") {
    delete(fileTree("${layout.projectDirectory.asFile}/plugins") {
        include("*.jar")
    })
    dependsOn(":extensions:bye-plugin:jar", ":extensions:hello-plugin:jar")
    from(project(":extensions:bye-plugin").tasks.named("jar"))
    from(project(":extensions:hello-plugin").tasks.named("jar"))
    into("${layout.projectDirectory.asFile}/plugins")
    doLast {
        println("Plugins copied to ${layout.projectDirectory.asFile}/plugins")
    }
}

tasks.named("build") {
    dependsOn(copyPlugins)
}
