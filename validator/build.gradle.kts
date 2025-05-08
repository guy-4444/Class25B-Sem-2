plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish) // Apply the maven-publish plugin
}

android {
    namespace = "com.guyi.validatorclass"
    compileSdk = 35

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                groupId = "com.github.guy-4444" // Change as needed
                artifactId = "validator" // Change as needed
                version = "1.00.04" // Change as needed
                artifact(tasks.getByName("bundleReleaseAar"))

                // Add dependencies to the Maven publication configuration (api or implementation)
            }
        }
    }
}