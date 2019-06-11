package com.onkar.demor8.codeinflow;

import android.util.Log;

public class DieselEngine implements Engine {
	
	private static final String TAG = "Car";
	
	private int m_hp;
	
	public DieselEngine(int hp) {
		m_hp = hp;
	}
	
	@Override
	public void start() {
		Log.e(TAG, "start: Diesel engine started... HP is: " + m_hp);
	}
}
