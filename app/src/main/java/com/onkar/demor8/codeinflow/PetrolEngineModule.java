package com.onkar.demor8.codeinflow;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {
	
	@Binds
	abstract Engine bindEngine(PetrolEngine petrolEngine);
}
