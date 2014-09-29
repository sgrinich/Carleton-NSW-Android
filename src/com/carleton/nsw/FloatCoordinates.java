package com.carleton.nsw;

import java.io.Serializable;

public class FloatCoordinates implements Serializable {

	double longitude; 
	double latitude; 
	
	
	public FloatCoordinates(double d, double e){
		longitude = d; 
		latitude = e;	
	}
	
	public double getLongitude(){
		return longitude; 
	}
	
	public double getLatitude(){
		return latitude; 
	}
	
}
