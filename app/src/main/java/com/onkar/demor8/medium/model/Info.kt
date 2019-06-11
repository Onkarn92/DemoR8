package com.onkar.demor8.medium.model

import com.google.gson.annotations.SerializedName

data class Info(
		@SerializedName("seed") var seed: String = "",
		
		@SerializedName("results") var results: Int = 0,
		
		@SerializedName("page") var page: Int = 0,
		
		@SerializedName("version") var version: String = ""
)