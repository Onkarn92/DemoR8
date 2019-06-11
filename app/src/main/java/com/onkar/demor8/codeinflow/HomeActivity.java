package com.onkar.demor8.codeinflow;

import android.os.Bundle;

import com.onkar.demor8.R;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {
	
	@Inject
	Car m_car;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		CarComponent carComponent = DaggerCarComponent.builder().hp(156).build();
		//		m_car = carComponent.getCar();
		carComponent.inject(this);
		m_car.drive();
	}
}