package com.carleton.nsw;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Thursday11Fragment extends Fragment {

	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_day, container, false);
         
        ScheduleActivity mainActivity = (ScheduleActivity) getActivity();
        @SuppressWarnings("unchecked")
        
		ArrayList<NSWEvent> thursdayEventList = mainActivity.getThursdayEvents(); 
        
       
        System.out.println(thursdayEventList.get(5).getTitle()); 
        
        
      //  TextView headerText = (TextView) rootView.findViewById(R.id.text);
       // headerText.setText("Thursday, Sep 11");
        
        final ListView thursdayListView = (ListView) rootView.findViewById(R.id.srListView);
        thursdayListView.setAdapter(new NSWBaseAdapter(getActivity(), thursdayEventList)); 
        
        /*for(int i = 0; i<thursdayEventList.size(); i++){
        	System.out.println("Thursday Schedule: " + thursdayEventList.get(i).getTitle());
        }*/

        
		
        thursdayListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = thursdayListView.getItemAtPosition(position);
                NSWEvent event = (NSWEvent)o;
                
                Intent descriptionIntent = new Intent(getActivity(), EventDescriptionActivity.class);
                descriptionIntent.putExtra("eventObject", event);
                startActivity(descriptionIntent);

            
            }
        });
        
        return rootView;
    }
}
