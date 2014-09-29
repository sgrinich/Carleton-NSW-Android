package com.carleton.nsw;

import java.io.Serializable;


public class NSWContact implements Serializable {
	
	String title; 
	String phone; 
	String email; 

	public NSWContact(String contactTitle, String contactPhone, String contactEmail){
		title = contactTitle; 
		phone = contactPhone; 
		email = contactEmail; 
	}
	
	public String getTitle(){
		return title; 
	}
	
	public String getPhone(){
		return phone; 
	}
	
	public String getEmail(){
		return email; 
	}
	
	@Override
    public String toString() {
        return title;
    }

}