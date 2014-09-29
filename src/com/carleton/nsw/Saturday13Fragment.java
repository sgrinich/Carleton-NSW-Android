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

public class Saturday13Fragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_day, container, false);
         
        ScheduleActivity mainActivity = (ScheduleActivity) getActivity();
        @SuppressWarnings("unchecked")
        
		ArrayList<NSWEvent> saturdayEventList = mainActivity.getSaturdayEvents(); 
                
       // TextView headerText = (TextView) rootView.findViewById(R.id.text);
        //headerText.setText("Saturday, Sep 13");
        
        final ListView saturdayListView = (ListView) rootView.findViewById(R.id.srListView);
        saturdayListView.setAdapter(new NSWBaseAdapter(getActivity(), saturdayEventList)); 
        
       /* for(int i = 0; i<saturdayEventList.size(); i++){
        	System.out.println("Saturday Schedule: " + saturdayEventList.get(i).getTitle());
        }*/
        

		
        saturdayListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = saturdayListView.getItemAtPosition(position);
                NSWEvent event = (NSWEvent)o;
                
                Intent descriptionIntent = new Intent(getActivity(), EventDescriptionActivity.class);
                descriptionIntent.putExtra("eventObject", event);
                startActivity(descriptionIntent);

            
            }
        });
        
        return rootView;
    }
	
}
