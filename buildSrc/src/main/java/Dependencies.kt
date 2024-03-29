object Dependencies {
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val ktStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompile = "androidx.room:room-compiler:${Versions.room}"
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
}

object TestDependencies {
    const val junit = "junit:junit:${Versions.junit}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val junitExt = "androidx.test.ext:junit-ktx:${Versions.junitExt}"
}

object TestDependenciesConfiguration {
    const val unitTest = "unitTestDependencies"
    const val androidTest = "instrumentationTestDependencies"
}
