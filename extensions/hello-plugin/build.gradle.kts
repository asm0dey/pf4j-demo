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
    annotationProcessor("org.pf4j:pf4j:3.13.0")
    implementation(project(":commons"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    manifest {
        attributes["Plugin-Id"] = "hello-plugin"
        attributes["Plugin-Version"] = project.version
        attributes["Plugin-Provider"] = "bell-sw"
    }
}
