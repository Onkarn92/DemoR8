package com.onkar.demor8.codeinflow;

import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {
	
	private int m_hp;
	
	public DieselEngineModule(final int hp) {
		m_hp = hp;
	}
	
	@Provides
	Engine provideEngine(){
		return new DieselEngine(m_hp);
	}
}
