package com.carleton.nsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class SpeakCarletonActivity extends BaseActivity {
	
	final int NUMBER_OF_CARL_TERMS = 48; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speak_carleton);
		
		set(getResources().getStringArray(R.array.title_array)); 
		
		ArrayList<NSWCarlTerm> carlSpeakArray = getCarlspeakArray();
		
        final ListView termListView = (ListView) findViewById(R.id.term_list_view);

		ArrayAdapter<NSWCarlTerm> adapter = new ArrayAdapter<NSWCarlTerm>(this, 
		        R.layout.carlterm_row_layout,R.id.textItem, carlSpeakArray);
		
		termListView.setAdapter(adapter);
		
		termListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = termListView.getItemAtPosition(position);
                NSWCarlTerm term = (NSWCarlTerm)o;
                
                Intent intent = new Intent(SpeakCarletonActivity.this, CarlTermDescriptionActivity.class);
                intent.putExtra("carlTerm", term);
                startActivity(intent);
            }
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.speak_carleton, menu);
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
	
	public String getJsonFile(String filename){
    	AssetManager am = SpeakCarletonActivity.this.getAssets();

 
    	InputStream is = null;
    	String result = null; 
    	
    	try {
			is = am.open(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	InputStreamReader inputStreamReader = new InputStreamReader(is);
    	BufferedReader br = new BufferedReader(inputStreamReader);
    	
    	 StringBuilder sb = new StringBuilder();
    	 String line = null; 
    	 try {
			while ((line = br.readLine()) != null)
			    {
			        sb.append(line + "\n");
			    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    result = sb.toString();
    	
    	
    	
    	return result; 
    	
    }
	
	
	
	public ArrayList<NSWCarlTerm>getCarlspeakArray(){
		String jsonString = getJsonFile("speak_carleton.json"); 
		
		ArrayList<NSWCarlTerm> termList = new ArrayList<NSWCarlTerm>(); 
		NSWCarlTerm term; 
		String[] array = jsonString.split("\",", NUMBER_OF_CARL_TERMS);
		
		String title; 
		String description; 
		String termString; 
		
		for(int i = 0; i<array.length; i++){
			termString = array[i]; 
						
			String[] parts  = termString.split("\"");
			title = parts[1];			
			description = parts[3];
			
		
			if(!(description.endsWith("."))){
				description = description + ".";
			}
			
			term = new NSWCarlTerm(title,description); 
			termList.add(term); 

		}
		
	
		return termList; 
		
		
		
	}
	
	
}



