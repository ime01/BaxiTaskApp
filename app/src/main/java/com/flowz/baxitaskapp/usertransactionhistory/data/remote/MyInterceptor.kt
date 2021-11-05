package com.flowz.baxitaskapp.usertransactionhistory.data.remote

import android.content.Context
import android.util.Log
import com.flowz.baxitaskapp.common.preference.UserSessionManager
import com.plcoding.cryptocurrencyappyt.common.Constants.SAVETOKENKEY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor (): Interceptor {

//     val userSessionManager = UserSessionManager(context)


    override fun intercept(chain: Interceptor.Chain): Response {

//       val apiToken = readUserToken()

       // Header: "Authorization" = Bearer + token gotten from login response


        val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImRlYmJ5b2Zmb3IiLCJuYW1laWQiOiI4ZDAwNGQzMC1mNDBiLTRhNjYtMDZmNy0wOGQ4M2VlNjkxNmEiLCJVc2VyVHlwZSI6IlBhcnRuZXIiLCJVc2VySWQiOiI4ZDAwNGQzMC1mNDBiLTRhNjYtMDZmNy0wOGQ4M2VlNjkxNmEiLCJBY2NvdW50U291cmNlIjoiTmV3IiwianRpIjoiYWFhNmUyNzMtZmIwNC00YTY5LWEyNWYtMmVlNjM3MTQwYzZhIiwiaWF0IjoxNjM2MDU4MzExLCJDYXRlZ29yeUlkIjoiIiwiUGFydG5lclR5cGVJZCI6IjMiLCJBQ0NFU1NfVFlQRSI6WyJDT05TVU1FUl9BR0VOVCIsIkNPTlNVTUVSX0FHRU5UX0JFTkVGSUNJQVJZIiwiTk9OX0FETUlOIl0sIkV4dGVybmFsVG9rZW4iOiIiLCJuYmYiOjE2MzYwNTgzMTEsImV4cCI6MTYzNjE0NDcxMSwiaXNzIjoiaHR0cHM6Ly9hcGkuZGV2LmJheGktc2VydmljZXMuY29tLyIsImF1ZCI6Imh0dHBzOi8vYXBpLmRldi5iYXhpLXNlcnZpY2VzLmNvbS8ifQ.XqtFQZLSj1mDsSX3j-KP3r7XUFjPzEtSGO095Kd4Ufk"
        val requestBuilder = chain.request().newBuilder()
               requestBuilder.addHeader("Authorization",  "Bearer $token")
                   .build()

        return chain.proceed(requestBuilder.build())

    }

//    private fun readUserToken(): String {
//
//        var token = ""
//
//        CoroutineScope(Dispatchers.Main).launch {
//            token =  userSessionManager.readUserToken(SAVETOKENKEY)!!
//            Log.e("token", "  users's token is: $token")
//        }
//
//        return token
//
//    }


}