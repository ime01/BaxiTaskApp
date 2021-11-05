package com.flowz.baxitaskapp.usertransactionhistory.data.local


import com.google.gson.annotations.SerializedName

data class TransactionService(
    @SerializedName("amount_limit")
    val amountLimit: Any,
    @SerializedName("created_at")
    val createdAt: String,
    val description: String,
    val id: String,
    @SerializedName("service_name")
    val serviceName: String,
    @SerializedName("transaction_type_id")
    val transactionTypeId: Int,
    @SerializedName("updated_at")
    val updatedAt: String
)