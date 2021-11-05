package com.flowz.baxitaskapp.userlogin.domain.model

data class UserLoginResponse (
    val userToken: String,
    val refreshToken: String,
    val firstName: String
)