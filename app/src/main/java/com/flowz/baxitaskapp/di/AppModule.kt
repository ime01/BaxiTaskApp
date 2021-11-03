package com.flowz.daggerexampleapp.di


import android.content.Context
import com.flowz.baxitaskapp.data.repository.UserRepositoryImpl
import com.flowz.baxitaskapp.domain.repository.UserRepository
import com.flowz.daggerexampleapp.loginandsavetoken.preference.UserSessionManager
import com.flowz.sixtjobapp.data.remote.LoginApi
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
class AppModule {


//  This provides The userSession DataStore Class with the Context it needs
    @Provides
    @Singleton
    fun provideUserSessionManager(@ApplicationContext context: Context): UserSessionManager{
        return UserSessionManager(context)
    }


    val okHttpClient = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()


    @Singleton
    @Provides
    fun providesLoginApi(): LoginApi{
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoginApi::class.java)
    }

    @Provides
    @Singleton
    fun providesUsersRepository(api: LoginApi): UserRepository{
        return  UserRepositoryImpl(api)
    }


}