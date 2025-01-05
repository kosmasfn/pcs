package com.kosmasfn.data.di.module

import com.kosmasfn.data.repository.Repository
import com.kosmasfn.data.repository.RepositoryImpl
import com.kosmasfn.data.service.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(apiService: APIService): Repository = RepositoryImpl(apiService)

}