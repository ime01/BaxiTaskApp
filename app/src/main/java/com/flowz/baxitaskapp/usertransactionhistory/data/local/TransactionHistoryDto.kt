package com.flowz.baxitaskapp.usertransactionhistory.data.local


import com.google.gson.annotations.SerializedName

data class TransactionHistoryDto(
    val `data`: Data,
    @SerializedName("resp_code")
    val respCode: String,
    @SerializedName("resp_description")
    val respDescription: String,
    @SerializedName("resp_message")
    val respMessage: String
)

