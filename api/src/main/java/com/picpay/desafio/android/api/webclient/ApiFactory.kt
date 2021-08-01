package com.picpay.desafio.android.api.webclient

import com.google.gson.GsonBuilder
import com.picpay.desafio.android.api.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object ApiFactory {

    private val okHttp: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(ApiResource.Connection.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(ApiResource.Read.TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(ApiResource.Write.TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    val apiServiceGenerator: Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


}