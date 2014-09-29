package com.carleton.nsw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapActivity extends BaseActivity {
	
	MapLocation location; 
	String title; 
	LatLng coordinates; 
	Marker locationMarker; 
	GoogleMap map; 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		set(getResources().getStringArray(R.array.title_array));
		
		
		int checkGooglePlayServices =    GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
	    if (checkGooglePlayServices != ConnectionResult.SUCCESS) {
	    // google play services is missing!!!!
	    /* Returns status code indicating whether there was an error. 
	    Can be one of following in ConnectionResult: SUCCESS, SERVICE_MISSING, SERVICE_VERSION_UPDATE_REQUIRED, SERVICE_DISABLED, SERVICE_INVALID.
	    */
	       GooglePlayServicesUtil.getErrorDialog(checkGooglePlayServices, this, 1122).show();
	    }
	    
	    else{

		
		
	

		
		 map = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();
		 
		 
		LatLng startCenter = new LatLng(44.461068,-93.154587);
		

		 CameraPosition cameraPosition = new CameraPosition.Builder()
	        .target(startCenter)
	        .zoom(17)
	        .bearing(0)
	        .build();
	        
	    map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

		
		Button button = (Button) findViewById(R.id.button); 
		
		button.setOnClickListener(new View.OnClickListener() {

		                @Override
		                public void onClick(View v) {
		                	Intent intent = new Intent(MapActivity.this, LocationChooserActivity.class); 
		                	startActivityForResult(intent, 0); 

		                }
		            });
		
	    }
		
	}
	
	@Override 
	public void onActivityResult(int requestCode, int resultCode, Intent data) {     
	  super.onActivityResult(requestCode, resultCode, data); 
	  switch(requestCode) { 
	    case (0) : { 
	      if (resultCode == Activity.RESULT_OK) { 
	    	  
	    	  
	        Bundle extras = data.getExtras();
	        
	        
	        
	        if(extras != null) {
	  	    	
	        	map.clear(); 
	  	    	
	  	        location = (MapLocation) extras.getSerializable("location");
	  	        title = location.getTitle();	 
	  	        
	  	        System.out.println(title); 
	  	        coordinates = new LatLng(location.getFloatCoordinates().getLatitude(),location.getFloatCoordinates().getLongitude()); 
	  	        
	  	        
	  	        CameraPosition cameraPosition = new CameraPosition.Builder()
	  	        .target(coordinates)
	  	        .zoom(17)
	  	        .bearing(0)
	  	        .build();
	  	        
	  	        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	  	        
	  	        locationMarker = map.addMarker(new MarkerOptions().title(title).position(coordinates)); 
	  	        locationMarker.showInfoWindow(); 
	  	    }
	      
	      } 
	      break; 
	    } 
	  } 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		return super.onOptionsItemSelected(item);
	}
}
