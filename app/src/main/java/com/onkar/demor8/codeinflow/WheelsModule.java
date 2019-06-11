package com.onkar.demor8.codeinflow;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class WheelsModule {
	
	@Provides
	static Rims provideRims() {
		return new Rims();
	}
	
	@Provides
	static Tires provideTires() {
		return new Tires();
	}
	
	@Provides
	static Wheels provideWheels(Rims rims, Tires tires){
		return new Wheels(rims, tires);
	}
}