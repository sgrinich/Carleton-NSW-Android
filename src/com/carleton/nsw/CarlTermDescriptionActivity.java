package com.carleton.nsw;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;



public class CarlTermDescriptionActivity extends Activity {

	NSWCarlTerm term; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
	    
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_carl_term_description);
		
		
	    
	    Bundle extras = getIntent().getExtras();
	    if(extras != null) {
	        term = (NSWCarlTerm) extras.getSerializable("carlTerm");
	       
	    }
	    
	    TextView titleText = (TextView)findViewById(R.id.term_text_view);
	    titleText.setText(term.getTitle());
	    
	    TextView descriptionText = (TextView)findViewById(R.id.description_text_view); 
	    descriptionText.setText(term.getDescription()); 
	    descriptionText.setMovementMethod(new ScrollingMovementMethod());


		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.carl_term_description, menu);
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
}
