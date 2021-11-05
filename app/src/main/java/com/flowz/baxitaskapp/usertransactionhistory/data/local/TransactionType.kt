package com.flowz.baxitaskapp.usertransactionhistory.data.local


import com.google.gson.annotations.SerializedName

data class TransactionType(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    val description: String,
    val id: Int,
    @SerializedName("is_enabled")
    val isEnabled: Boolean,
    val name: String,
    @SerializedName("updated_at")
    val updatedAt: String
)