package com.flowz.baxitaskapp.preference

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import com.plcoding.cryptocurrencyappyt.common.Constants
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UserSessionManager @Inject constructor(@ApplicationContext context : Context){

    private var datastorePref = context.createDataStore(name = Constants.DATASTORENAME)


    suspend fun saveUserToken(tokenkey:String, token:String){
        val tokenDSkey = preferencesKey<String>(tokenkey)
        datastorePref.edit { login->
            login[tokenDSkey] = token

        }
    }

    suspend fun saveUserRefreshToken(tokenkey:String, token:String){
        val tokenDSkey = preferencesKey<String>(tokenkey)
        datastorePref.edit { login->
            login[tokenDSkey] = token

        }
    }

   suspend fun readUserToken(key: String):String?{
        val dataStoreKey = preferencesKey<String>(key)
        val preferences = datastorePref.data.first()
        return preferences[dataStoreKey]
    }

    suspend fun readUserRefreshToken(key: String):String?{
        val dataStoreKey = preferencesKey<String>(key)
        val preferences = datastorePref.data.first()
        return preferences[dataStoreKey]
    }
}