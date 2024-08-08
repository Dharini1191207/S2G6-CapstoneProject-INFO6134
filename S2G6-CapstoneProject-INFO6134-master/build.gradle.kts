buildscript{
    dependencies{
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
        classpath("com.google.gms:google-services:4.4.2")
    }
}

plugins {
    id("com.android.application") version "8.2.2" apply false
    id ("com.android.library") version "8.2.2" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}