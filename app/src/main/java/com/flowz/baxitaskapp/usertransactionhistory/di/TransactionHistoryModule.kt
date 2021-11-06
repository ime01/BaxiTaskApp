package com.flowz.daggerexampleapp.di


import android.content.Context
import com.flowz.baxitaskapp.common.preference.UserSessionManager
import com.flowz.baxitaskapp.userlogin.domain.repository.UserHistoryRepository
import com.flowz.baxitaskapp.usertransactionhistory.data.remote.MyInterceptor
import com.flowz.baxitaskapp.usertransactionhistory.data.remote.UserTransactionHistoryApi
import com.flowz.baxitaskapp.usertransactionhistory.data.repository.UserHistoryRepositoryImpl
import com.plcoding.cryptocurrencyappyt.common.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TransactionHistoryModule {

    fun httpClient(context: Context): OkHttpClient{
        val okHttpClientWithHeader = OkHttpClient.Builder()
            .addInterceptor(MyInterceptor(context))
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return okHttpClientWithHeader
    }

    @Provides
    @Singleton
    fun providesTransactionHistoryApi (@ApplicationContext context: Context): UserTransactionHistoryApi{
        return Retrofit.Builder()
            .client(httpClient(context))
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserTransactionHistoryApi::class.java)
    }

    @Provides
    @Singleton
    fun providesUserHistoryRepository(historyApi: UserTransactionHistoryApi): UserHistoryRepository {
        return  UserHistoryRepositoryImpl(historyApi)
    }


}