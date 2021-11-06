package com.flowz.baxitaskapp.usertransactionhistory.data.repository

import com.flowz.baxitaskapp.userlogin.data.local.LoginRequestModel
import com.flowz.baxitaskapp.userlogin.data.remote.LoginApi
import com.flowz.baxitaskapp.usertransactionhistory.data.remote.UserTransactionHistoryApi
import com.flowz.baxitaskapp.userlogin.data.remote.dto.UserLoginResponseDto
import com.flowz.baxitaskapp.userlogin.domain.repository.UserHistoryRepository
import com.flowz.baxitaskapp.userlogin.domain.repository.UserRepository
import com.flowz.baxitaskapp.usertransactionhistory.data.local.TransactionHistoryDto
import javax.inject.Inject

class UserHistoryRepositoryImpl @Inject constructor(private val historyapi: UserTransactionHistoryApi): UserHistoryRepository{

    override suspend fun getHistory(page: Int): TransactionHistoryDto {

     return historyapi.getTransactionHistory(page)

    }

}