object Dependencies {
    object Versions {
        const val KOTLIN_GRADLE_PLUGIN = "1.5.0"
    }

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_GRADLE_PLUGIN}"
}

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.kotlinGradlePlugin)
}