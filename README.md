# APIvalorant  2024
Projeto Marvel Android 2024
# Projeto de Consumo de uma API no Android:
[Valorant-API:https://dash.valorant-api.com/](https://dash.valorant-api.com/)
# Avatar do Jogo:
![](https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/displayicon.png)
![](https://media.valorant-api.com/agents/dade69b4-4f5a-8528-247b-219e5a1facd6/displayicon.png)
![](https://media.valorant-api.com/agents/5f8d3a7f-467b-97f3-062c-13acf203c006/displayicon.png)
# Código
# plugins
```
plugins {
    id 'com.android.application' version '8.0.1' apply false
    id 'com.android.library' version '8.0.1' apply false
    id 'org.jetbrains.kotlin.android' version '1.7.20' apply false
    id 'com.google.dagger.hilt.android' version '2.44' apply false

    // Add the dependency for the Google services Gradle plugin
    //id("com.google.gms.google-services") version "4.3.15" apply false
}

```
# android
```

    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-kapt'
    id 'com.google.dagger.hilt.android'

    // Add the Google services Gradle plugin
   // id("com.google.gms.google-services")
}

android {
    namespace 'com.giorgio.apivalorant'
    compileSdk 33

    defaultConfig {
        applicationId "com.giorgio.apivalorant"
        minSdk 24
        targetSdk 33
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary true
        }
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
    buildFeatures {
        compose true
    }
    composeOptions {
        kotlinCompilerExtensionVersion '1.3.2'
    }
    packagingOptions {
        resources {
            excludes += '/META-INF/{AL2.0,LGPL2.1}'
        }
    }
}

```
