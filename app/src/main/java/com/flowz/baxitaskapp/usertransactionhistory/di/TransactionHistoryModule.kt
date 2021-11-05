package com.flowz.daggerexampleapp.di


import android.content.Context
import com.flowz.baxitaskapp.userlogin.data.remote.LoginApi
import com.flowz.baxitaskapp.userlogin.data.repository.UserRepositoryImpl
import com.flowz.baxitaskapp.userlogin.domain.repository.UserHistoryRepository
import com.flowz.baxitaskapp.userlogin.domain.repository.UserRepository
import com.flowz.baxitaskapp.usertransactionhistory.data.remote.MyInterceptor
import com.flowz.baxitaskapp.usertransactionhistory.data.remote.UserTransactionHistoryApi
import com.flowz.baxitaskapp.usertransactionhistory.data.repository.UserHistoryRepositoryImpl
import com.plcoding.cryptocurrencyappyt.common.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TransactionHistoryModule {


    val okHttpClientWithHeader = OkHttpClient.Builder()
        .addInterceptor(MyInterceptor())
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()


    @Provides
    @Singleton
    fun providesTransactionHistoryApi(): UserTransactionHistoryApi{
        return Retrofit.Builder()
            .client(okHttpClientWithHeader)
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