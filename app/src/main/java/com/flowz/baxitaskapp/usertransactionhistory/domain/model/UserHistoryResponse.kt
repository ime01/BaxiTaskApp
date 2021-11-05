package com.flowz.baxitaskapp.userlogin.domain.model

data class UserHistoryResponse (
    val history :List<History>

)

data class History(
    val transactionAmount: String,
    val transactionDate: String,
    val transactionDescription: String
)