package com.onkar.demor8.medium.model

import com.google.gson.annotations.SerializedName

data class RandomUserResponse(
		@SerializedName("results") var users: ArrayList<User> = arrayListOf(),
		
		@SerializedName("info") var info: Info = Info(),
		
		@SerializedName("error") var error: String = ""
)