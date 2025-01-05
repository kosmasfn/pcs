package com.kosmasfn.data.di.module

import android.content.Context
import com.kosmasfn.data.network.NetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkInterceptor(): NetworkInterceptor =  NetworkInterceptor()

    @Provides
    @Singleton
    fun provideServiceInterceptor(
        interceptor: NetworkInterceptor,
        @ApplicationContext context: Context
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
}