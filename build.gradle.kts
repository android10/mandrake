group = AppConfiguration.group
version = AppConfiguration.version
application {
    mainClass.set(AppConfiguration.mainClass)
    applicationName = AppConfiguration.name
}

plugins {
    // Language Specific Plugins
    kotlin(BuildPlugins.jvm)
    kotlin(BuildPlugins.serialization) version Kotlin.std

    // Application Specific Plugins
    id(BuildPlugins.application)

    // Internal Script plugins
    id(ScriptPlugins.compilation)
    id(ScriptPlugins.infrastructure)
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    // Application dependencies
    implementation(Libraries.kotlinStd)
    implementation(Libraries.kotlinCoroutines)
    implementation(Libraries.ktorServerCore)
    implementation(Libraries.ktorServerCio)
    implementation(Libraries.ktorSerialization)
    implementation(Libraries.logback)
    implementation(Libraries.gson)

    // Test dependencies
    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.mockk)
    testImplementation(TestLibraries.kluent)
    testImplementation(TestLibraries.serverTests)
}