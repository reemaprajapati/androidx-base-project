package com.example.baseapplicationjetpack.utility

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Accept", "application/json")
//            .addHeader("Authorization", "")
            .build()
        return chain.proceed(request)
    }
}