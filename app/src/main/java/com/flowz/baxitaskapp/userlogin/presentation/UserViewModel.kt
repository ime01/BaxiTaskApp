package com.flowz.sixtjobapp2.presentation.cars_list

import android.util.Log
import androidx.lifecycle.*
import com.flowz.baxitaskapp.userlogin.data.local.LoginRequestModel
import com.flowz.baxitaskapp.userlogin.domain.model.UserLoginResponse
import com.flowz.baxitaskapp.preference.UserSessionManager
import com.flowz.sixtjobapp.domain.usecases.LoginUserUseCase
import com.plcoding.cryptocurrencyappyt.common.Constants.REFRESHTOKEN
import com.plcoding.cryptocurrencyappyt.common.Constants.SAVETOKENKEY
import com.plcoding.cryptocurrencyappyt.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
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


    private fun readUserToken():String {
        var token = ""
        viewModelScope.launch(Dispatchers.Main) {
            token = readUserToken(SAVETOKENKEY)
            Log.e("token", "  users's token is: $token")
        }

        return token

    }




    suspend fun saveUserToken(userToken : String){
        userSessionManager.saveUserToken(SAVETOKENKEY,userToken)
    }

    suspend fun readUserToken(key : String): String{
        return userSessionManager.readUserToken(SAVETOKENKEY)!!
        }


    suspend fun saveRefreshUserToken(userToken : String){
        userSessionManager.saveUserRefreshToken(REFRESHTOKEN,userToken)
    }

    suspend fun readRefreshUserToken(key : String): String{
        return userSessionManager.readUserRefreshToken(REFRESHTOKEN)!!
    }



}