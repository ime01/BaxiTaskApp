package com.flowz.sixtjobapp2.presentation

import com.flowz.baxitaskapp.userlogin.domain.model.UserLoginResponse


data class UserLoginState(
    val isLoading: Boolean = false,
    val user: UserLoginResponse = UserLoginResponse("", ""),
    val error: String = ""
)