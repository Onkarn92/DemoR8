package com.onkar.demor8.medium

import com.onkar.demor8.App
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import timber.log.Timber
import java.io.File

@Module
class OkHttpClientModule {
	
	@RandomUserAppScope
	@Provides
	fun provideOkHttpClient(
			cache: Cache,
			interceptor: HttpLoggingInterceptor
	): OkHttpClient = OkHttpClient.Builder().cache(cache).addInterceptor(interceptor).build()
	
	@Provides
	fun provideCache(cacheFile: File): Cache = Cache(cacheFile, 10 * 1000 * 1000)
	
	@Provides
	fun provideFile(): File {
		val file = File(App.getContext().codeCacheDir, "DemoR8Cache")
		file.mkdirs()
		return file
	}
	
	@Provides
	fun provideInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
		Timber.d(it)
	}).setLevel(BODY)
}