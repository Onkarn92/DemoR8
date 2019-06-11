package com.onkar.demor8.codeinflow;

import android.util.Log;

import javax.inject.Inject;

public class Car {
	
	private static final String TAG = "Car";
	private Engine m_engine;
	private Wheels m_wheels;
	
	@Inject
	public Car(final Engine engine, final Wheels wheels) {
		m_engine = engine;
		m_wheels = wheels;
	}
	
	public void drive() {
		m_engine.start();
		Log.e(TAG, "driving...");
	}
}