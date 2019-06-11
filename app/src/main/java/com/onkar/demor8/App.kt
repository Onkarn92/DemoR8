package com.onkar.demor8

import android.app.Application
import android.content.Context
import com.onkar.demor8.medium.DaggerRandomUserComponent
import com.onkar.demor8.medium.RandomUserComponent
import timber.log.Timber

class App : Application() {
	
	companion object {
		
		lateinit var randomUserAppComponent: RandomUserComponent
		
		private lateinit var app: App
		
		fun getContext(): Context = app.applicationContext
	}
	
	override fun onCreate() {
		super.onCreate()
		app = this
		Timber.plant(Timber.DebugTree())
		randomUserAppComponent = DaggerRandomUserComponent.create()
	}
}