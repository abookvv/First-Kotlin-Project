plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "vistory.rate"
    compileSdk = 34

    defaultConfig {
        applicationId = "vistory.rate"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":authentication"))
    //firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth.ktx)
    //
    implementation(libs.androidx.core.ktx)
    //di
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}