package com.onkar.demor8.medium.main

import com.onkar.demor8.medium.MainActivity
import com.onkar.demor8.medium.RandomUserComponent
import dagger.Component

@Component(modules = [MainActivityModule::class], dependencies = [RandomUserComponent::class])
@MainActivityScope
interface MainActivityComponent {
	
	/*fun getUserAdapter(): UserAdapter
	
	fun getRandomUserApiService(): RandomUserApiService*/
	
	fun injectMainActivity(mainActivity: MainActivity)
}