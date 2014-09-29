package com.carleton.nsw;

import java.io.Serializable;

public class FaqItem implements Serializable{

	String question; 
	String answer;
	// 1 means question, 0 means header
	int type; 
	
	public FaqItem(String faqQuestion, String faqAnswer, int typeOfRow){
		question = faqQuestion; 
		answer = faqAnswer; 
		type = typeOfRow; 
	}
	
	public String getQuestion(){
		return question; 
	}
	
	public String getAnswer(){
		return answer; 
	}
	
	public int getType(){
		return type; 
	}

	@Override
    public String toString() {
        return question;
    }
}
