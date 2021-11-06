package com.flowz.baxitaskapp.usertransactionhistory.data.remote

import android.content.Context
import android.util.Log
import com.flowz.baxitaskapp.preference.UserSessionManager
import com.plcoding.cryptocurrencyappyt.common.Constants.SAVETOKENKEY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response


class MyInterceptor (context: Context): Interceptor {

     val userSessionManager = UserSessionManager(context)


    override fun intercept(chain: Interceptor.Chain): Response {

       // Header: "Authorization" = Bearer + token gotten from login response

        val requestBuilder = chain.request().newBuilder()
               requestBuilder.addHeader("Authorization",  "Bearer ${readUserToken()}")
                   .build()

        return chain.proceed(requestBuilder.build())

    }
    private fun readUserToken(): String {

        var token = ""
//        CoroutineScope(Dispatchers.Main).launch {
//            token =  userSessionManager.readUserToken(SAVETOKENKEY)!!
//            Log.e("token", "  Network Request Token is : $token")
//        }

        runBlocking {
            token =  userSessionManager.readUserToken(SAVETOKENKEY)!!
            Log.e("token", "  Network Request Token is : $token")
        }
        return token
    }

}