package com.kosmasfn.domain.usecase

import com.kosmasfn.data.common.Resource
import com.kosmasfn.data.repository.Repository
import com.kosmasfn.domain.converter.toDomainModel
import com.kosmasfn.domain.model.TestDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UseCaseImpl @Inject constructor(private val repository: Repository) : UseCase {
    override suspend fun fetchData(): Flow<Resource<List<TestDomainModel>>> = flow {
        try {
            emit(Resource.loading())
            emit(Resource.success(repository.fetchData().map { it.toDomainModel() }))
        } catch (e: Throwable) {
            emit(Resource.error(e))
        }
    }
}