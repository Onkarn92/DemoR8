package com.onkar.demor8.medium.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class Coordinates @ParcelConstructor constructor(
		@SerializedName("latitude") var latitude: String?,
		
		@SerializedName("longitude") var longitude: String?
)