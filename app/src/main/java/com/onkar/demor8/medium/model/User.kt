package com.onkar.demor8.medium.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class User @ParcelConstructor constructor(
		@SerializedName("gender") var gender: String?,
		
		@SerializedName("name") var name: Name?,
		
		@SerializedName("location") var location: Location?,
		
		@SerializedName("email") var email: String?,
		
		@SerializedName("login") var login: Login?,
		
		@SerializedName("dob") var dob: Dob?,
		
		@SerializedName("registered") var registered: Registered?,
		
		@SerializedName("phone") var phone: String?,
		
		@SerializedName("cell") var cell: String?,
		
		@SerializedName("id") var id: Id?,
		
		@SerializedName("picture") var picture: Picture?,
		
		@SerializedName("nat") var nat: String?
)