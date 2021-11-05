package com.flowz.baxitaskapp.usertransactionhistory.data.local


import com.google.gson.annotations.SerializedName

data class Channel(
    @SerializedName("channel_code")
    val channelCode: String,
    @SerializedName("created_at")
    val createdAt: Any,
    @SerializedName("deleted_at")
    val deletedAt: Any,
    val description: String,
    val id: Int,
    @SerializedName("is_enabled")
    val isEnabled: Boolean,
    val name: String,
    @SerializedName("updated_at")
    val updatedAt: Any
)