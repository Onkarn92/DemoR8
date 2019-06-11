package com.onkar.demor8.medium

import dagger.Component

@RandomUserAppScope
@Component(modules = [RandomUserModule::class])
interface RandomUserComponent {
	
	fun getRandomUserApiService(): RandomUserApiService
}