package com.onkar.demor8.medium.main

import com.onkar.demor8.medium.UserAdapter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val callback: UserAdapter.Callback) {
	
	@Provides
	@MainActivityScope
	fun provideUserAdapter(): UserAdapter = UserAdapter(callback)
}