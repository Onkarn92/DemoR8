package com.onkar.demor8.codeinflow;

import android.util.Log;

import javax.inject.Inject;

public class PetrolEngine implements Engine {
	
	private static final String TAG = "Car";
	
	private int m_hp;
	
	@Inject
	public PetrolEngine(int hp) {
		m_hp = hp;
	}
	
	@Override
	public void start() {
		Log.e(TAG, "start: Petrol engine started...HP is:: " + m_hp);
	}
}
