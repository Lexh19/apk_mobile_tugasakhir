plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")


}

android {
    namespace = "com.example.iqbaalrafi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.iqbaalrafi"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
//        buildConfigField("String","BASE_URL", "\"https://api.themoviedb.org/3/\"")
//        buildConfigField("String","PHOTO_BASE_URL", "\"https://image.tmdb.org/t/p/w500/\"")
//        buildConfigField("String","API_KEY", "\"450707599ec0f019f7262f96096aea28\"")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()

    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")


    //retrofit dan rcycleview
    implementation ("com.squareup.retrofit2:retrofit:2.6.2")
    implementation ("com.squareup.retrofit2:converter-gson:2.6.2")
    implementation ("androidx.recyclerview:recyclerview:1.1.0")
    implementation ("androidx.cardview:cardview:1.0.0")

    // htttp logger
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")

    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // coroutine lifecycle scopes

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // room
    implementation ("androidx.room:room-runtime:2.6.0")
    kapt ("androidx.room:room-compiler:2.6.0")
    implementation("androidx.room:room-ktx:2.6.0")

    // glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")
    // dependecy injection
    implementation ("io.insert-koin:koin-android:3.1.2")
    implementation ("io.insert-koin:koin-core:3.1.2")




}