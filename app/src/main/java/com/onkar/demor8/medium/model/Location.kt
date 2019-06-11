package com.onkar.demor8.medium.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class Location @ParcelConstructor constructor(
		@SerializedName("street") var street: String?,
		
		@SerializedName("city") var city: String?,
		
		@SerializedName("state") var state: String?,
		
		@SerializedName("postcode") var postcode: String?,
		
		@SerializedName("coordinates") var coordinates: Coordinates?,
		
		@SerializedName("timezone") var timezone: Timezone?
)