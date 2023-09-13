package com.example.bubbel.repository

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient(context: Context) {

    private val cacheSize = (5 * 1024 * 1024).toLong()
    private val okHttpClient = OkHttpClient.Builder().cache(Cache(context.cacheDir,cacheSize))
        .addInterceptor { chain ->
            var request = chain.request()
            request = if (com.example.bubbel.utils.NetworkConnection.hasNetwork(context)!!)
                request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
            else
                request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
            chain.proceed(request)
        }
        .build()

    val api by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.joinbubbel.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

}
