package com.flowz.baxitaskapp.domain.repository

import com.flowz.baxitaskapp.data.local.LoginRequestModel
import com.flowz.baxitaskapp.data.remote.dto.UserLoginResponseDto

interface UserRepository {

    suspend fun loginUser(loginRequest: LoginRequestModel): UserLoginResponseDto
}