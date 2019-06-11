package com.onkar.demor8.medium.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class Registered @ParcelConstructor constructor(
		@SerializedName("date") var date: String?,
		
		@SerializedName("age") var age: Int = 0
)