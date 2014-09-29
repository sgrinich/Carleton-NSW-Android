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

public class Friday12Fragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_day, container, false);
         
        ScheduleActivity mainActivity = (ScheduleActivity) getActivity();
        @SuppressWarnings("unchecked")
        
		ArrayList<NSWEvent> fridayEventList = mainActivity.getFridayEvents(); 
        
        
      //  TextView headerText = (TextView) rootView.findViewById(R.id.text);
       // headerText.setText("Friday, Sep 12");
        
        final ListView fridayListView = (ListView) rootView.findViewById(R.id.srListView);
        fridayListView.setAdapter(new NSWBaseAdapter(getActivity(), fridayEventList)); 
		
        /*for(int i = 0; i<fridayEventList.size(); i++){
        	System.out.println("Friday Schedule: " + fridayEventList.get(i).getTitle());
        }*/
        
        
        fridayListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = fridayListView.getItemAtPosition(position);
                NSWEvent event = (NSWEvent)o;
                
                Intent descriptionIntent = new Intent(getActivity(), EventDescriptionActivity.class);
                descriptionIntent.putExtra("eventObject", event);
                startActivity(descriptionIntent);

            
            }
        });
        
        return rootView;
    }
	
}
