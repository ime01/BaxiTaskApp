package com.flowz.baxitaskapp.userlogin.domain.repository


import com.flowz.baxitaskapp.usertransactionhistory.data.local.TransactionHistoryDto

interface UserHistoryRepository {

    suspend fun getHistory(page:Int):TransactionHistoryDto

}