import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
    application
}

group = "me.jgperez"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val lwjglVersion = "3.0.0b"
    implementation("org.lwjgl:lwjgl:${lwjglVersion}")
    implementation("org.lwjgl:lwjgl-platform:${lwjglVersion}:natives-windows")
    implementation("org.lwjgl:lwjgl-platform:${lwjglVersion}:natives-linux")
    implementation("org.lwjgl:lwjgl-platform:${lwjglVersion}:natives-osx")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}