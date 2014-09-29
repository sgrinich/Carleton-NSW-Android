package com.carleton.nsw;

import java.io.Serializable;

import com.google.android.gms.maps.model.LatLng;

public class MapLocation implements Serializable {
	
	// eclipse wanted this
	private static final long serialVersionUID = 1L;
	String title; 
	FloatCoordinates coordinates; 
	
	public MapLocation(String locationTitle, FloatCoordinates locationCoordinates){
		title = locationTitle; 
		coordinates = locationCoordinates; 
	}
	
	public String getTitle(){
		return title; 
	}
	
	public FloatCoordinates getFloatCoordinates(){
		return coordinates; 
	}
	
	@Override
    public String toString() {
        return title;
    }


}
