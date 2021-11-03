package com.flowz.sixtjobapp.domain.usecases

import com.flowz.baxitaskapp.data.local.LoginRequestModel
import com.flowz.baxitaskapp.domain.model.UserLoginResponse
import com.flowz.baxitaskapp.domain.repository.UserRepository
import com.plcoding.cryptocurrencyappyt.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUserUseCase @Inject constructor (private val repository:UserRepository) {


    operator fun invoke (loginRequest: LoginRequestModel): Flow<Resource<UserLoginResponse>> = flow {

        try {
            emit(Resource.Loading<UserLoginResponse>())

//            val response = repository.loginUser(loginRequest).data.tokenData.map{ it.toCar() }
            val response = repository.loginUser(loginRequest).data
            val userResponse = UserLoginResponse(response.tokenData.token, response.firstName)

            emit(Resource.Success(userResponse))

        }catch (e:HttpException){

            emit(Resource.Error<UserLoginResponse>(e.localizedMessage ?: "An unexpected error occurred"))

        }catch (e: IOException){

            emit(Resource.Error<UserLoginResponse>("Couldn't reach the server, Check your internet connection and try again"))
        }
    }
}