package com.flowz.sixtjobapp.data.remote

import com.flowz.baxitaskapp.data.local.LoginRequestModel
import com.flowz.baxitaskapp.data.remote.dto.UserLoginResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginApi {

    @POST("/api/core/account/login")
    suspend fun loginUser(@Body loginRequest: LoginRequestModel) : UserLoginResponseDto
}