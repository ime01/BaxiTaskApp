package com.flowz.baxitaskapp.userlogin.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("account_source")
    val accountSource: String,
    @SerializedName("address_verification_status")
    val addressVerificationStatus: Int,
    @SerializedName("agent_code")
    val agentCode: String,
    @SerializedName("bvn_face_captured")
    val bvnFaceCaptured: Boolean,
    @SerializedName("can_skip_address_verification")
    val canSkipAddressVerification: Boolean,
    @SerializedName("category_id")
    val categoryId: Any,
    @SerializedName("category_name")
    val categoryName: Any,
    @SerializedName("channel_id")
    val channelId: Int,
    @SerializedName("channel_name")
    val channelName: String,
    @SerializedName("device_id")
    val deviceId: Any,
    @SerializedName("device_owner_id")
    val deviceOwnerId: Any,
    @SerializedName("device_owner_name")
    val deviceOwnerName: Any,
    val email: String,
    @SerializedName("external_token")
    val externalToken: Any,
    @SerializedName("fire_base_token")
    val fireBaseToken: String,
    val firebasetoken: String,
    @SerializedName("first_name")
    val firstName: String,
    val gender: String,
    @SerializedName("has_pin")
    val hasPin: Boolean,
    @SerializedName("has_transaction_pin")
    val hasTransactionPin: Boolean,
    val id: String,
    @SerializedName("ignore_device_code")
    val ignoreDeviceCode: Boolean,
    @SerializedName("is_device_profiled")
    val isDeviceProfiled: Boolean,
    @SerializedName("is_primary_device")
    val isPrimaryDevice: Boolean,
    @SerializedName("kyc_level")
    val kycLevel: Int,
    @SerializedName("kyc_mode")
    val kycMode: Int,
    @SerializedName("last_name")
    val lastName: String,
    val lga: String,
    @SerializedName("migration_status")
    val migrationStatus: Int,
    @SerializedName("mobile_device_update")
    val mobileDeviceUpdate: Any,
    @SerializedName("mpos_status")
    val mposStatus: Int,
    @SerializedName("mpos_status_text")
    val mposStatusText: String,
    @SerializedName("old_referral_code")
    val oldReferralCode: Any,
    @SerializedName("old_user_auth")
    val oldUserAuth: Any,
    @SerializedName("other_name")
    val otherName: String,
    @SerializedName("parent_agent_code")
    val parentAgentCode: Any,
    @SerializedName("parent_id")
    val parentId: Any,
    @SerializedName("partner_type_id")
    val partnerTypeId: Int,
    @SerializedName("partner_type_name")
    val partnerTypeName: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("pos_only")
    val posOnly: Boolean,
    @SerializedName("primary_user_id")
    val primaryUserId: Any,
    @SerializedName("referral3rd_party_account_id")
    val referral3rdPartyAccountId: Any,
    @SerializedName("referral_code")
    val referralCode: String,
    @SerializedName("registered_with_bvn")
    val registeredWithBvn: Boolean,
    @SerializedName("registration_bvn")
    val registrationBvn: String,
    val state: String,
    val status: Int,
    @SerializedName("status_text")
    val statusText: String,
    val street: String,
    @SerializedName("terminal_bank_code")
    val terminalBankCode: Any,
    @SerializedName("terminal_id")
    val terminalId: Any,
    @SerializedName("through3r_party")
    val through3rParty: Boolean,
    @SerializedName("token_data")
    val tokenData: TokenData,
    @SerializedName("user_claims")
    val userClaims: List<Any>,
    @SerializedName("user_type")
    val userType: String,
    val username: String,
    @SerializedName("virtual_account_number")
    val virtualAccountNumber: String
)