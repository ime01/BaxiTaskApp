package com.flowz.baxitaskapp.usertransactionhistory.data.remote

import com.flowz.baxitaskapp.usertransactionhistory.data.local.TransactionHistoryDto
import com.plcoding.cryptocurrencyappyt.common.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserTransactionHistoryApi {


    @GET(Constants.TRANSACTIONHISTORY_END_POINT)
    suspend fun getTransactionHistory(@Query("page") pagenumber:Int) : TransactionHistoryDto

}