package com.example.weatherapp

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

//        request.newBuilder().ad

        val mResponse = chain.proceed(request)

        return mResponse
    }
}