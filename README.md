# ML Challenge - Setup Guide - by Lucas Esteves
## ML Challenge App | Android | Kotlin

Welcome to Mercado Pago Challenge project! This guide will walk you through setting up the environment to test the project on your local machine.

`Jetpack Compose` & `MVI Architecture`

## Prerequisites

- Android Studio installed on your machine with Java 17.

## Getting Started

1. **Install Java 17:**

    ```
    https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
    ```

2. **Clone the Repository:**

    ```
    git clone https://github.com/lukesteves92/MLChallenge.git
    ```

3. **Open Project in Android Studio:**

    Open Android Studio and navigate to `File` > `Open` and select the cloned project directory.

4. **Set Java 17 by Default:**

   Open Android Studio and navigate to `File` > `Settings` > `Build, Execution...` > `Build Tools` > `Gradle` and select the new `Gradle SDK` downloaded, Java 17.

5. **Configure Android App:**

    - Open the ML Challenge project in Android Studio.
    - Locate the `build.gradle.kts(app)` and set the public URL defined above.
    ```
    buildConfigField(type = "String", name = "URL_BASE", value = "\"https://yoururl.com\"")
    ```
    - Now, locate the `AndroidManifest.xml` and configure your Google Maps API Key. (Check https://cloud.google.com/apis)
    ```
    <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="" />
    ```

10. **Run the App:**

    - Build and run the ML Challenge app in Android Studio.

Congratulations! You have successfully set up the environment to test the Mercado Pago Challenge project on your local machine. If you encounter any issues, feel free to reach out for assistance. Enjoy!
