package com.flowz.baxitaskapp.usertransactionhistory.data.local


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("agent_code")
    val agentCode: String,
    @SerializedName("agent_device_id")
    val agentDeviceId: Any,
    @SerializedName("agent_fullname")
    val agentFullname: String,
    @SerializedName("agent_id")
    val agentId: String,
    @SerializedName("agent_partner_type_id")
    val agentPartnerTypeId: Int,
    @SerializedName("agent_username")
    val agentUsername: String,
    @SerializedName("amount_paid")
    val amountPaid: Int,
    val channel: Channel,
    @SerializedName("channel_id")
    val channelId: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("debited_wallet")
    val debitedWallet: String,
    @SerializedName("device_type_id")
    val deviceTypeId: Int,
    val id: Int,
    val latitude: String,
    val longitude: String,
    @SerializedName("partner_type")
    val partnerType: String,
    @SerializedName("payment_method")
    val paymentMethod: Int,
    @SerializedName("payment_status")
    val paymentStatus: Int,
    @SerializedName("request_id")
    val requestId: String,
    @SerializedName("source_model")
    val sourceModel: String,
    @SerializedName("split_fees")
    val splitFees: List<Any>,
    val status: String,
    @SerializedName("total_commission")
    val totalCommission: Double,
    @SerializedName("total_fee")
    val totalFee: Int,
    @SerializedName("transaction_amount")
    val transactionAmount: Int,
    @SerializedName("transaction_date")
    val transactionDate: String,
    @SerializedName("transaction_description")
    val transactionDescription: String,
    @SerializedName("transaction_ref")
    val transactionRef: String,
    @SerializedName("transaction_service")
    val transactionService: TransactionService,
    @SerializedName("transaction_service_id")
    val transactionServiceId: String,
    @SerializedName("transaction_status")
    val transactionStatus: Any,
    @SerializedName("transaction_status_message")
    val transactionStatusMessage: String,
    @SerializedName("transaction_type")
    val transactionType: TransactionType,
    @SerializedName("transaction_type_id")
    val transactionTypeId: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("value_given")
    val valueGiven: Any
)