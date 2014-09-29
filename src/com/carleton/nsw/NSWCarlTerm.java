package com.carleton.nsw;

import java.io.Serializable;



public class NSWCarlTerm implements Serializable {
	
	String title; 
	String description; 

	public NSWCarlTerm(String termTitle, String termDescription){
		title = termTitle; 
		description = termDescription; 
	}
	
	public String getTitle(){
		return title; 
	}
	
	public String getDescription(){
		return description; 
	}
	
	public void setTitle(String titleToSet){
		title = titleToSet; 
	}
	
	public void setDescription(String descriptionToSet){
		description = descriptionToSet; 
	}
	
	@Override
    public String toString() {
        return title;
    }
	

}