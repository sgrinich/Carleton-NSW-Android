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

public class Sunday14Fragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_day, container, false);
         
        ScheduleActivity mainActivity = (ScheduleActivity) getActivity();
        @SuppressWarnings("unchecked")
		ArrayList<NSWEvent> sundayEventList = mainActivity.getSundayEvents(); 
        
        
     //   TextView headerText = (TextView) rootView.findViewById(R.id.text);
      //  headerText.setText("Sunday, Sep 14");
        
        final ListView sundayListView = (ListView) rootView.findViewById(R.id.srListView);
        sundayListView.setAdapter(new NSWBaseAdapter(getActivity(), sundayEventList)); 
		
        /*for(int i = 0; i<sundayEventList.size(); i++){
        	System.out.println("Saturday Schedule: " + sundayEventList.get(i).getTitle());
        }*/
        
        sundayListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = sundayListView.getItemAtPosition(position);
                NSWEvent event = (NSWEvent)o;
                
                Intent descriptionIntent = new Intent(getActivity(), EventDescriptionActivity.class);
                descriptionIntent.putExtra("eventObject", event);
                startActivity(descriptionIntent);

            
            }
        });
        
        return rootView;
    }
	

	
	
}
