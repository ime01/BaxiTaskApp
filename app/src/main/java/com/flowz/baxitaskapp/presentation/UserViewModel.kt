package com.flowz.sixtjobapp2.presentation.cars_list

import androidx.lifecycle.*
import com.flowz.baxitaskapp.data.local.LoginRequestModel
import com.flowz.baxitaskapp.domain.model.UserLoginResponse
import com.flowz.daggerexampleapp.loginandsavetoken.preference.UserSessionManager
import com.flowz.sixtjobapp.domain.usecases.LoginUserUseCase
import com.plcoding.cryptocurrencyappyt.common.Constants.SAVETOKENKEY
import com.plcoding.cryptocurrencyappyt.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

enum class  UserApiStatus {LOADING, ERROR, DONE}


@HiltViewModel
class UsersViewModel @Inject constructor(private val usersUseCase: LoginUserUseCase, private val userSessionManager: UserSessionManager) :ViewModel() {



       val userResponseFromNetwork = MutableLiveData<UserLoginResponse>()
       val requestLoginNetworkStatus = MutableLiveData<UserApiStatus>()



     fun LoginUser(loginRequest: LoginRequestModel) {

         usersUseCase.invoke(loginRequest).onEach {result->

             when(result){
                 is Resource.Success ->{

                     requestLoginNetworkStatus.value = UserApiStatus.DONE

                     userResponseFromNetwork.postValue(result.data!!)


                 }
                 is Resource.Error ->{

                     requestLoginNetworkStatus.value = UserApiStatus.ERROR

                 }
                 is Resource.Loading ->{

                     requestLoginNetworkStatus.value = UserApiStatus.LOADING

                 }

             }
         }.launchIn(viewModelScope)

         }

    suspend fun saveUserToken(userToken : String){
        userSessionManager.SaveUserToken(SAVETOKENKEY,userToken)
    }

    suspend fun readUserToken(key : String): String{
        return userSessionManager.ReadUserToken(SAVETOKENKEY)!!
        }

}