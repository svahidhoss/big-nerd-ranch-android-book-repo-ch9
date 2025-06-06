// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.4" apply false
    id("org.jetbrains.kotlin.android") version "2.1.20" apply false
    id("com.google.devtools.ksp") version "2.1.20-1.0.32" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.8.9" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
