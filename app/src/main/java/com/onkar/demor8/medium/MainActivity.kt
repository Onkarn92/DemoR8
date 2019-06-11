package com.onkar.demor8.medium

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.onkar.demor8.App
import com.onkar.demor8.R
import com.onkar.demor8.medium.main.DaggerMainActivityComponent
import com.onkar.demor8.medium.main.MainActivityModule
import com.onkar.demor8.medium.model.RandomUserResponse
import com.onkar.demor8.medium.model.User
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.Parcels
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity(), UserAdapter.Callback {
	
	private lateinit var skeletonView: RecyclerViewSkeletonScreen
	@Inject lateinit var service: RandomUserApiService
	@Inject lateinit var userAdapter: UserAdapter
	
	// Commented code is based on another approach i.e. without @Inject annotation.
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		// val randomUserComponent = DaggerRandomUserComponent.create()
		DaggerMainActivityComponent.builder().mainActivityModule(MainActivityModule(this)).randomUserComponent(App.randomUserAppComponent).build()
				.injectMainActivity(this)
		// service = mainActivityComponent.getRandomUserApiService()
		mainRecycler.layoutManager = LinearLayoutManager(this)
		// userAdapter = mainActivityComponent.getUserAdapter()
		skeletonView = Skeleton.bind(mainRecycler).adapter(userAdapter).load(R.layout.item_skeleton_user_list).duration(1300).show()
		call()
	}
	
	override fun onDestroy() {
		super.onDestroy()
		skeletonView.hide()
	}
	
	override fun onItemClick(
			user: User,
			view: View
	) {
		val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, getString(R.string.app_name))
		ActivityCompat.startActivity(this, Intent(this, DetailsActivity::class.java).putExtra("user", Parcels.wrap(user)), options.toBundle())
	}
	
	private fun call() {
		service.getUsers(200).enqueue(object : Callback<RandomUserResponse> {
			
			override fun onFailure(
					call: Call<RandomUserResponse>,
					t: Throwable
			) {
				skeletonView.hide()
				Toast.makeText(this@MainActivity, "Error occurred::${t.localizedMessage}", Toast.LENGTH_LONG).show()
			}
			
			override fun onResponse(
					call: Call<RandomUserResponse>,
					response: Response<RandomUserResponse>
			) {
				skeletonView.hide()
				if (response.isSuccessful && response.body()?.users?.isNotEmpty() == true) {
					userAdapter.setItems(response.body()?.users!!)
				} else if (!response.body()?.error.isNullOrBlank()) {
					Toast.makeText(this@MainActivity, response.body()?.error, Toast.LENGTH_LONG).show()
				} else if (response.errorBody() != null) {
					Toast.makeText(this@MainActivity, "Error occurred::${response.errorBody()?.string()}", Toast.LENGTH_LONG).show()
				} else {
					Toast.makeText(this@MainActivity, "Something went wrong!!!", Toast.LENGTH_LONG).show()
				}
			}
		})
	}
}