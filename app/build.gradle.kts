plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-kapt")

}

android {
    namespace = "com.example.proyectostareas"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.proyectostareas"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.room:room-common:2.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation ("androidx.navigation:navigation-compose:2.7.7")


     // Verifica la última versión disponible
    implementation("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1") // Para Java
    //noinspection KaptUsageInsteadOfKsp
    kapt("androidx.room:room-compiler:2.6.1") // Para Kotlin

// Para usar Room con coroutines
    implementation("androidx.room:room-ktx:2.6.1")

// Para testing
    testImplementation("androidx.room:room-testing:2.6.1")


   // Verifica la última versión disponible
    implementation("androidx.compose.ui:ui:1.6.2")
    implementation("androidx.compose.material:material:1.6.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")

// Para testing de Compose
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.2")


    // Verifica la última versión disponible
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.37")

// Para Hilt con Jetpack Compose
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:1.1.0")


   // Verifica la última versión disponible
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")




}

fun kapt(s: String) {
    TODO("Not yet implemented")
}
