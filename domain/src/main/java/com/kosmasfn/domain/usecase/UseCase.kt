package com.kosmasfn.domain.usecase

import com.kosmasfn.data.common.Resource
import com.kosmasfn.domain.model.TestDomainModel
import kotlinx.coroutines.flow.Flow

interface UseCase {
    suspend fun fetchData(): Flow<Resource<List<TestDomainModel>>>
}