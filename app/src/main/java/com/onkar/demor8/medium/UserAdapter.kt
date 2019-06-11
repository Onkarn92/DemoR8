package com.onkar.demor8.medium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onkar.demor8.R
import com.onkar.demor8.medium.UserAdapter.ViewHolder
import com.onkar.demor8.medium.model.User
import kotlinx.android.synthetic.main.item_user_list.view.*

class UserAdapter(private val callback: Callback) : RecyclerView.Adapter<ViewHolder>() {
	
	private var items: ArrayList<User>? = null
	
	override fun onCreateViewHolder(
			parent: ViewGroup,
			viewType: Int
	): ViewHolder {
		val holder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false))
		holder.itemView.setOnClickListener {
			if (holder.user != null) {
				callback.onItemClick(holder.user!!, holder.itemView.profileImage)
			}
		}
		return holder
	}
	
	override fun getItemCount(): Int = items?.size ?: 0
	
	override fun onBindViewHolder(
			holder: ViewHolder,
			position: Int
	) {
		holder.user = items!![position]
	}
	
	fun setItems(users: ArrayList<User>) {
		items = users
		notifyDataSetChanged()
	}
	
	class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		
		var user: User? = null
			set(value) {
				field = value
				Glide.with(itemView.context).load(user?.picture?.large).into(itemView.profileImage)
				itemView.name.text = user?.name?.title.plus(" ").plus(user?.name?.first).plus(" ").plus(user?.name?.last)
				itemView.gender.text = user?.gender
				itemView.phone.text = user?.phone
			}
	}
	
	interface Callback {
		fun onItemClick(
				user: User,
				view: View
		)
	}
}