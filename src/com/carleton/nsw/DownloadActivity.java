package com.carleton.nsw;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.util.CompatibilityHints;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class DownloadActivity extends Activity {
	
	ComponentList events; 
	Calendar calendar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		 
		setContentView(R.layout.activity_download);
	    

		
		new DownloadData().execute(); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.download, menu);
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
	
	final class DownloadData extends AsyncTask<Void,Void, Void> {
		@Override
        protected void onPreExecute(){
            
            //TextView.setText("Downloading");
            
        }
		
		@Override
        protected Void doInBackground(Void... arg0) {

             try {
                    URL url = new URL("https://apps.carleton.edu/newstudents/events/?start_date=2014-08-06&format=ical");
                    HttpURLConnection c = (HttpURLConnection) url.openConnection();
                    c.setRequestMethod("GET");
                    c.connect();

                    FileOutputStream fos = openFileOutput("events.ics", DownloadActivity.MODE_PRIVATE);
                    InputStream is = c.getInputStream();
                    
                    
                    byte[] buffer = new byte[1024];
                    int length = 0;
                    while ((length = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, length);
                    }
                    fos.close();
                    is.close();
                } catch (IOException e) {
                    Log.d("log_tag", "Error: " + e);
                }
                
           
            return null;
        }
		
		@Override
        protected void onPostExecute(Void Result) {

             new Loadicaldata().execute();

        }
	}
	
	
final class Loadicaldata extends AsyncTask<Void, Void, Void> {
        
        
        Component event; 
        
        @Override
        protected Void doInBackground(Void... arg0) {

            FileInputStream fis = null;
            try {
                fis =  openFileInput("events.ics");
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            

            CompatibilityHints.setHintEnabled(CompatibilityHints.KEY_RELAXED_UNFOLDING, true);
            CompatibilityHints.setHintEnabled(CompatibilityHints.KEY_RELAXED_VALIDATION, true);
            CalendarBuilder builder = new CalendarBuilder();

            calendar = null;

            try {
                calendar = builder.build(fis);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParserException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            
            return null;
	
        }
        
        @Override
        protected void onPostExecute(Void Result) {
        	
        	
        	Intent intent = new Intent(DownloadActivity.this, ScheduleActivity.class);
                	
        	
        	// converts ComponentList to String to pass as intent
        	//intent.putExtra("eventList", calendar.toString());
        	
        	startActivity(intent); 

        }

	
	
	
	}



}
