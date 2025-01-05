package com.kosmasfn.data.service

import com.kosmasfn.data.base.BaseResponse
import com.kosmasfn.data.model.TestDataModel
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("/getData/test")
    suspend fun fetchData(): List<TestDataModel>
}