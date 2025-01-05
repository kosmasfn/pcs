package com.kosmasfn.data.repository

import com.kosmasfn.data.model.TestDataModel
import com.kosmasfn.data.service.APIService
import okhttp3.Callback

class RepositoryImpl(private val service: APIService) : Repository {
    override suspend fun fetchData(): List<TestDataModel> {
        return service.fetchData()
    }
}