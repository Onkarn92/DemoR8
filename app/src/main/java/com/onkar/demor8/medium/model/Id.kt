package com.onkar.demor8.medium.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class Id @ParcelConstructor constructor(
		@SerializedName("name") var name: String?,
		
		@SerializedName("value") var value: String?
)