package com.onkar.demor8.codeinflow;

import dagger.BindsInstance;
import dagger.Component;

// this is the injector.. backbone of dagger...
@Component(modules = {WheelsModule.class, PetrolEngineModule.class})
public interface CarComponent {
	
	Car getCar();
	
	void inject(HomeActivity homeActivity);
	
	@Component.Builder
	interface Builder{
		
		@BindsInstance
		Builder hp(int hp);
		
		CarComponent build();
	}
}