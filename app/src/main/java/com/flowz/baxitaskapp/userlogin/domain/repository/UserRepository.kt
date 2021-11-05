package com.flowz.baxitaskapp.userlogin.domain.repository

import com.flowz.baxitaskapp.userlogin.data.local.LoginRequestModel
import com.flowz.baxitaskapp.userlogin.data.remote.dto.UserLoginResponseDto
import com.flowz.baxitaskapp.usertransactionhistory.data.local.TransactionHistoryDto

interface UserRepository {

    suspend fun loginUser(loginRequest: LoginRequestModel): UserLoginResponseDto

}