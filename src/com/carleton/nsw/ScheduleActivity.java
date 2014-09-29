package com.carleton.nsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.component.VEvent;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import edu.emory.mathcs.backport.java.util.Collections;


public class ScheduleActivity extends BaseActivity {

	private ViewPager viewPager;
    private NSWPagerAdapter mAdapter;
    
    Calendar calendar; 
	ComponentList eventComponentList; 
	
	ArrayList<NSWEvent> nswEventList;
	
	ArrayList<NSWEvent> tuesday9Events;
	ArrayList<NSWEvent> wednesday10Events;
	ArrayList<NSWEvent> thursday11Events; 
	ArrayList<NSWEvent> friday12Events; 
	ArrayList<NSWEvent> saturday13Events; 
	ArrayList<NSWEvent> sunday14Events; 
	
	String summary; 
    String description;
    String location; 
    String startDateTime;
    String endDateTime;
    Date today; 
    Date firstDay;
    Date lastDay; 

    
    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {	
    	// uncomment to remove actionbar
    	//requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        set(getResources().getStringArray(R.array.title_array)); 
        
        nswEventList = new ArrayList<NSWEvent>();
        tuesday9Events = new ArrayList<NSWEvent>();
        wednesday10Events = new ArrayList<NSWEvent>();
        thursday11Events = new ArrayList<NSWEvent>();
        friday12Events = new ArrayList<NSWEvent>();
        saturday13Events = new ArrayList<NSWEvent>();
        sunday14Events = new ArrayList<NSWEvent>();
               
        today = new Date();
        firstDay = new Date();
        lastDay = new Date();
        
        Intent intent = getIntent(); 
		
        String events = getEventsFile("events.txt"); 
        
        StringReader sin = new StringReader(events);
        CalendarBuilder builder = new CalendarBuilder();
        try {
			calendar = builder.build(sin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        eventComponentList = calendar.getComponents(Component.VEVENT);
        for(int i = 0; i<eventComponentList.size(); i++){
        	
        	VEvent event = (VEvent) eventComponentList.get(i); 
        	// some of these have rogue characters
        	summary = getSummaryFromICAL(event);
        	description = getDescriptionFromICAL(event);         	
            location = getLocationFromICAL(event); 
            startDateTime = getStartDateFromICAL(event); 
            endDateTime = getEndDateFromICAL(event);
      
            NSWEvent nswEvent = new NSWEvent(summary, description, location, startDateTime, endDateTime); 
            nswEventList.add(nswEvent); 
        }

        Collections.sort(nswEventList);
        
        java.util.Calendar cal = java.util.Calendar.getInstance(); 
        Date eventDate = null;
        
        // put each NSWEvent object into a list according to the day of the event
        for(int i = 0; i<nswEventList.size(); i++){
        	NSWEvent eventObject = nswEventList.get(i); 
        	
        	try {
				 eventDate = new SimpleDateFormat("MM-dd-yyyy").parse(eventObject.getStartTime());
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 
        	cal.setTime(eventDate);
        	
        	int day = cal.get(java.util.Calendar.DAY_OF_MONTH); 
        	
        	if(day == 9){
        		tuesday9Events.add(eventObject);	
        	}
        	
        	if(day == 10){
        		wednesday10Events.add(eventObject);		
        	}
        	
        	if(day == 11){
        		thursday11Events.add(eventObject);	
        	}
        	
        	if(day == 12){
        		friday12Events.add(eventObject);	
        	}
        	
        	if(day == 13){
        		saturday13Events.add(eventObject);		
        	}
        	
        	if(day == 14){
        		sunday14Events.add(eventObject);	
        	}	 
        }
        
        viewPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new NSWPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        
        
        firstDay.setDate(9);
        lastDay.setDate(14);
        
        if((today.getDate() > firstDay.getDate()) || (today.getDate() == firstDay.getDate()) && (today.getDate() < lastDay.getDate()) || (today.getDate() == lastDay.getDate())){
        
        	
        	if(today.getDate() == 9){
        		viewPager.setCurrentItem(0);
        	}
        	
        	if(today.getDate() == 10){
        		viewPager.setCurrentItem(1);
        	}
        	
        	if(today.getDate() == 11){
        		viewPager.setCurrentItem(2);
        	}
        	
        	if(today.getDate() == 12){
        		viewPager.setCurrentItem(3);
        	}
        	
        	if(today.getDate() == 13){
        		viewPager.setCurrentItem(4);
        	}
        	
        	if(today.getDate() == 14){
        		viewPager.setCurrentItem(5);
        	}
        	
        	
        	
        	
        	
        	
        }
        
        
        
        
        
        
        
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    public String getSummaryFromICAL(VEvent event){
    	String summary; 
    	summary = event.getSummary().toString();
        summary = summary.replace("SUMMARY:", "");
        summary = summary.replace("NSW: ", "");
        summary = summary.replace("\\", "");
         
        return summary; 
    }
    
    public String getDescriptionFromICAL(VEvent event){
    	String description; 
    	if(event.getDescription() != null){
        	description = event.getDescription().toString();
        	description = description.replace("DESCRIPTION:", "");
        	description = description.replace("\\", "");
        }
        else{
        	description = ""; 
        } 
    	
    	return description; 
    }
    
    public String getLocationFromICAL(VEvent event){
    	String location; 
    	if(event.getLocation() != null){
        	location = event.getLocation().toString();
        	location = location.replace("LOCATION:", "");
        	location = location.replace("\\", "");
        
        }
        else{
        	location = ""; 
        }
    	
    	return location; 
    }
    
    public String getStartDateFromICAL(VEvent event){
    	String startDate; 
    	Date date = null;
        if(event.getStartDate() != null){
        	startDate = event.getStartDate().toString();
        	startDate = startDate.replace("DTSTART:", "");
     
        	try {
				date= new SimpleDateFormat("yyyyMMdd'T'HHmmss").parse(startDate);
				DateFormat df = new SimpleDateFormat("MM-dd-yyyy hh:mm a");
				String dateE = df.format(date);
				startDate = dateE.toString();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        }
        else{
        	startDate = ""; 
        	
        }
        
        return startDate; 
    }
    
    public String getEndDateFromICAL(VEvent event){
    	String endDateTime; 
    	Date date = null;
        if(event.getEndDate() != null){
        	endDateTime = event.getEndDate().toString();
        	endDateTime = endDateTime.replace("DTEND:", "");
     
        	try {
				date= new SimpleDateFormat("yyyyMMdd'T'HHmmss").parse(endDateTime);
				DateFormat df = new SimpleDateFormat("MM-dd-yyyy hh:mm a");
				String dateE = df.format(date);
				endDateTime = dateE.toString();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        }
        else{
        	endDateTime = ""; 
        	
        }
        
        return endDateTime; 
    }
    
    public ArrayList<NSWEvent> getTuesdayEvents() {
        return tuesday9Events;
    }
    
    public ArrayList<NSWEvent> getWednesdayEvents() {
        return wednesday10Events;
    }
    
    public ArrayList<NSWEvent> getThursdayEvents() {
        return thursday11Events;
    }
    
    public ArrayList<NSWEvent> getFridayEvents() {
        return friday12Events;
    }
    
    public ArrayList<NSWEvent> getSaturdayEvents() {
        return saturday13Events;
    }
    
    public ArrayList<NSWEvent> getSundayEvents() {
        return sunday14Events;
    }
    
    public String getEventsFile(String filename){
    	AssetManager am = ScheduleActivity.this.getAssets();
    	InputStream is = null;
    	try {
			is = am.open(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	InputStreamReader inputStreamReader = new InputStreamReader(is);
    	BufferedReader br = new BufferedReader(inputStreamReader);
    	
    	
    	StringBuilder text = new StringBuilder();

    	String line = null; 
    	
    	try {
    		line = "";
    	    while ((line = br.readLine()) != null) {
    	        text.append(line);
    	        text.append('\n');
    	    }
    	}
    	catch (IOException e) {
    	    //You'll need to add proper error handling here
    	}
    	
		return text.toString(); 
    }
    
    
    
    
    
    
    
    
    
    
}

