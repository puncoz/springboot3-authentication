plugins {
    java
    alias(libs.plugins.springframework.boot)
    alias(libs.plugins.spring.dependency.management)
}

group = "com.practice"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.springboot.starter.web)
    implementation(libs.springboot.starter.security)
    implementation(libs.springboot.starter.data.jpa)
    implementation(libs.jsonwebtoken.api)

    compileOnly(libs.lombok)
    runtimeOnly(libs.postgresql)
    runtimeOnly(libs.jsonwebtoken.impl)
    runtimeOnly(libs.jsonwebtoken.jackson)

    annotationProcessor(libs.lombok)

    testImplementation(libs.springboot.starter.test)
    testImplementation(libs.springboot.security.test)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
