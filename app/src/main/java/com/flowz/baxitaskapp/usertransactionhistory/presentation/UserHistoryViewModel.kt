package com.flowz.sixtjobapp2.presentation.cars_list

import android.util.Log
import androidx.lifecycle.*
import com.flowz.baxitaskapp.preference.UserSessionManager
import com.flowz.baxitaskapp.usertransactionhistory.data.local.TransactionHistoryDto
import com.flowz.baxitaskapp.usertransactionhistory.domain.usecases.UserHistoryUseCase
import com.plcoding.cryptocurrencyappyt.common.Constants.SAVETOKENKEY
import com.plcoding.cryptocurrencyappyt.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class  UserHistoryApiStatus {LOADING, ERROR, DONE}


@HiltViewModel
class UserHistoryViewModel @Inject constructor(private val userHistoryUseCase: UserHistoryUseCase) :ViewModel() {


       val historyResponseFromNetwork = MutableLiveData<TransactionHistoryDto>()
       val requestHistoryNetworkStatus = MutableLiveData<UserHistoryApiStatus>()


    fun getUserHistory(page:Int) {

        userHistoryUseCase.invoke(page).onEach {result->

            when(result){
                is Resource.Success ->{

                    requestHistoryNetworkStatus.value = UserHistoryApiStatus.DONE
                    historyResponseFromNetwork.postValue(result.data!!)

                }
                is Resource.Error ->{

                    requestHistoryNetworkStatus.value = UserHistoryApiStatus.ERROR
                }
                is Resource.Loading ->{

                    requestHistoryNetworkStatus.value = UserHistoryApiStatus.LOADING
                }

            }
        }.launchIn(viewModelScope)

    }


}