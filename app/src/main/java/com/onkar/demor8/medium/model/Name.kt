package com.onkar.demor8.medium.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class Name @ParcelConstructor constructor(
		@SerializedName("title") var title: String?,
		
		@SerializedName("first") var first: String?,
		
		@SerializedName("last") var last: String?
)