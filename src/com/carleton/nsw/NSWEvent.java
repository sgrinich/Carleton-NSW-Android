package com.carleton.nsw;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.net.ParseException;



public class NSWEvent  implements Comparable<NSWEvent>, Serializable {
	
	String title; 
	String description; 
	String location; 
	String startTime; 
	String endTime; 
	
	
	// uses ical4j Date and Duration
	public NSWEvent(String eventTitle, String eventDescription, String eventLocation, String eventStart, String eventEnd){
		title = eventTitle;
		description = eventDescription; 
		location = eventLocation; 
		startTime = eventStart; 
		endTime = eventEnd; 
	}
	
	public String toString(){
		return startTime + " to " + endTime;
		}
	
	public String getTitle(){
		return title; 
	}
	
	public String getDescription(){
		return description; 
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getStartTime(){

		return startTime; 
	}

	public String getEndTime(){
		return endTime; 
	}
	
	public String getStartTimeToDisplay() throws ParseException{
		Date date = null;
		try {
			date = new SimpleDateFormat("MM-dd-yyyy hh:mm a").parse(startTime);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DateFormat df = new SimpleDateFormat("hh:mm a");
		String displayTime = df.format(date);
		
		if(displayTime.startsWith("0")){
		
			displayTime = displayTime.substring(1);
		}
		
		
		
		return displayTime;
	}
	
	public String getEndTimeToDisplay() throws ParseException{
		Date date = null;
		try {
			date = new SimpleDateFormat("MM-dd-yyyy hh:mm a").parse(endTime);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DateFormat df = new SimpleDateFormat("hh:mm a");
		String displayTime = df.format(date);
		
		if(displayTime.startsWith("0")){
			
			displayTime = displayTime.substring(1);
		}
		
		return displayTime;
	}
	
	public Date getStartDateObject(){
		Date date = null;
		try {
			date = new SimpleDateFormat("MM-dd-yyyy hh:mm a").parse(startTime);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return date; 
	}
	
	
	
	

	@Override
	public int compareTo(NSWEvent o) {

		return getStartDateObject().compareTo(o.getStartDateObject());
	}



}
