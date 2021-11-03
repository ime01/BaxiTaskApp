package com.flowz.baxitaskapp.data.remote.dto


import com.flowz.baxitaskapp.domain.model.UserLoginResponse
import com.google.gson.annotations.SerializedName

data class UserLoginResponseDto(
    val `data`: Data,
    val errors: Any,
    @SerializedName("resp_code")
    val respCode: String,
    @SerializedName("resp_description")
    val respDescription: String,
    @SerializedName("resp_message")
    val respMessage: String
)

fun UserLoginResponseDto.toUserLoginResponse() : UserLoginResponse {

    return UserLoginResponse(
        userToken = data.tokenData.token,
        firstName = data.firstName
    )
}