package com.kosmasfn.domain.di.module

import com.kosmasfn.data.repository.Repository
import com.kosmasfn.domain.usecase.UseCase
import com.kosmasfn.domain.usecase.UseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Reusable
    fun provideUseCase(repository: Repository): UseCase = UseCaseImpl(repository)

}