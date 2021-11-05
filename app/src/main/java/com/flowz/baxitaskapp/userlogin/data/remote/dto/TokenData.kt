package com.flowz.baxitaskapp.userlogin.data.remote.dto


import com.google.gson.annotations.SerializedName

data class TokenData(
    @SerializedName("expirer_in")
    val expirerIn: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    val token: String
)