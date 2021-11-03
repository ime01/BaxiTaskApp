package com.flowz.baxitaskapp.data.repository

import com.flowz.baxitaskapp.data.local.LoginRequestModel
import com.flowz.baxitaskapp.data.remote.dto.UserLoginResponseDto
import com.flowz.baxitaskapp.domain.repository.UserRepository
import com.flowz.sixtjobapp.data.remote.LoginApi
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: LoginApi): UserRepository{

    override suspend fun loginUser(loginRequest: LoginRequestModel): UserLoginResponseDto {
        return api.loginUser(loginRequest)
    }
}