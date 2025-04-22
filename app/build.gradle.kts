plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.hydra.axiommanager"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hydra.axiommanager"
        minSdk = 23
        targetSdk = 23
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    applicationVariants.all {
        outputs.all {
            val outputImpl = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            val variantName = name // e.g. debug or release
            outputImpl.outputFileName = "AxiomManager-${variantName}.apk"
        }
    }
}

dependencies {
    val activity_version = "1.7.2"
    val core_ktx_version = "1.12.0"

    implementation("androidx.core:core-ktx:$core_ktx_version")
    implementation("androidx.activity:activity-ktx:$activity_version")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("com.google.android.material:material:1.11.0")
}
