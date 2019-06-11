package com.onkar.demor8.medium

import com.onkar.demor8.medium.model.RandomUserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApiService {
	
	@GET("api")
	fun getUsers(@Query("results") count: Int = 100): Call<RandomUserResponse>
}