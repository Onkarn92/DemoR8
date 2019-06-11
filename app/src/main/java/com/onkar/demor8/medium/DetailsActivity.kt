package com.onkar.demor8.medium

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.onkar.demor8.R
import com.onkar.demor8.medium.model.User
import kotlinx.android.synthetic.main.activity_details.*
import org.parceler.Parcels

class DetailsActivity : AppCompatActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_details)
		val user: User? = Parcels.unwrap(intent.getParcelableExtra("user"))
		Glide.with(this).load(user?.picture?.large).into(userImage)
		name.text = user?.name?.title.plus(" ${user?.name?.first} ${user?.name?.last}")
		age.text = user?.dob?.age?.toString() ?: 0.toString()
		address.text = user?.location?.street?.plus(", ${user.location?.city}, ${user.location?.state} - ${user.location?.postcode}")
		email.text = user?.email
		phone.text = user?.phone
	}
}