plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt") // Required for annotation processing with Hilt
    id("dagger.hilt.android.plugin") // Hilt plugin
}

android {
    namespace = "com.example.mediaplayer"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mediaplayer"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17)) // Set to your desired JDK version
        }
    }


}

dependencies {
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")

    // AndroidX Core & AppCompat
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Material Design
    implementation("com.google.android.material:material:1.9.0")

    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // Lifecycle and LiveData/ViewModel
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-ktx:1.7.2")

    implementation("com.google.android.exoplayer:exoplayer:2.19.1")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.19.1")
    // Retrofit for networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11")

    // OkHttp for HTTP client
    implementation("com.squareup.okhttp3:okhttp:4.11.0")

    // Hilt for Dependency Injection
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    implementation("com.github.bumptech.glide:glide:4.15.1") // Latest stable version at the time of writing

    // Paging Library for pagination
    implementation("androidx.paging:paging-runtime:3.2.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // JUnit for testing
    testImplementation("junit:junit:4.13.2")

    // Mockito for mocking
        testImplementation("io.mockk:mockk:1.13.5")
        testImplementation("org.mockito:mockito-core:5.0.0")
        testImplementation("org.mockito:mockito-inline:5.0.0")

    // Coroutines test
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")

    // AndroidX Test Core
        testImplementation("androidx.arch.core:core-testing:2.1.0")

    // Truth library for assertions
        testImplementation("com.google.truth:truth:1.1.5")

}

kapt {
    correctErrorTypes = true
}