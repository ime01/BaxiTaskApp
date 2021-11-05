package com.flowz.baxitaskapp.usertransactionhistory.domain.usecases

import com.flowz.baxitaskapp.userlogin.domain.repository.UserHistoryRepository
import com.flowz.baxitaskapp.userlogin.domain.repository.UserRepository
import com.flowz.baxitaskapp.usertransactionhistory.data.local.TransactionHistoryDto
import com.plcoding.cryptocurrencyappyt.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserHistoryUseCase @Inject constructor (private val repository:UserHistoryRepository) {


    operator fun invoke (page:Int): Flow<Resource<TransactionHistoryDto>> = flow {

        try {
            emit(Resource.Loading<TransactionHistoryDto>())

            val response = repository.getHistory(page)

            val historyResponse = TransactionHistoryDto(response.data, response.respCode, response.respDescription, response.respMessage)

            emit(Resource.Success(historyResponse))

        }catch (e:HttpException){

            emit(Resource.Error<TransactionHistoryDto>(e.localizedMessage ?: "An unexpected error occurred"))

        }catch (e: IOException){

            emit(Resource.Error<TransactionHistoryDto>("Couldn't reach the server, Check your internet connection and try again"))
        }
    }
}