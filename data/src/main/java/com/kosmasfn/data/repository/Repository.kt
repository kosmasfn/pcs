package com.kosmasfn.data.repository

import com.kosmasfn.data.model.TestDataModel

interface Repository {
    suspend fun fetchData() : List<TestDataModel>
}