package com.onkar.demor8.medium

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [OkHttpClientModule::class])
class RandomUserModule {
	
	@Provides
	fun provideRandomUserApiService(retrofit: Retrofit): RandomUserApiService = retrofit.create(RandomUserApiService::class.java)
	
	@RandomUserAppScope
	@Provides
	fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
			Retrofit.Builder().baseUrl("https://randomuser.me/").client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
}