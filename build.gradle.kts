import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
    application
    `maven-publish`
}

group = "com.juanleodev"
version = "0.0.1"

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

// TODO: complete credential part
publishing {
    publications {
        create<MavenPublication>("default") {
            from(components["java"])
            // Include any other artifacts here, like javadocs
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/JuanLeo83/KGamesLib")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}