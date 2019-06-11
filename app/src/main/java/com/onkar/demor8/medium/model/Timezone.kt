package com.onkar.demor8.medium.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class Timezone @ParcelConstructor constructor(
		@SerializedName("offset") var offset: String?,
		
		@SerializedName("description") var description: String?
)