package com.onkar.demor8.medium.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class Picture @ParcelConstructor constructor(
		@SerializedName("large") var large: String?,
		
		@SerializedName("medium") var medium: String?,
		
		@SerializedName("thumbnail") var thumbnail: String?
)