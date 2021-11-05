package com.flowz.baxitaskapp.userlogin.data.remote

import com.flowz.baxitaskapp.userlogin.data.local.LoginRequestModel
import com.flowz.baxitaskapp.userlogin.data.remote.dto.UserLoginResponseDto
import com.plcoding.cryptocurrencyappyt.common.Constants
import retrofit2.http.*

interface LoginApi {

    @POST(Constants.LOGIN_END_POINT)
    suspend fun loginUser(@Body loginRequest: LoginRequestModel) : UserLoginResponseDto
}