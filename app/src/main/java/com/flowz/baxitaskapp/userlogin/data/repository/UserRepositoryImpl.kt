package com.flowz.baxitaskapp.userlogin.data.repository

import com.flowz.baxitaskapp.userlogin.data.local.LoginRequestModel
import com.flowz.baxitaskapp.userlogin.data.remote.LoginApi
import com.flowz.baxitaskapp.usertransactionhistory.data.remote.UserTransactionHistoryApi
import com.flowz.baxitaskapp.userlogin.data.remote.dto.UserLoginResponseDto
import com.flowz.baxitaskapp.userlogin.domain.repository.UserRepository
import com.flowz.baxitaskapp.usertransactionhistory.data.local.TransactionHistoryDto
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: LoginApi): UserRepository{

    override suspend fun loginUser(loginRequest: LoginRequestModel): UserLoginResponseDto {
        return api.loginUser(loginRequest)
    }

}