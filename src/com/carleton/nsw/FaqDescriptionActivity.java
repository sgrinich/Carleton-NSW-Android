package com.carleton.nsw;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class FaqDescriptionActivity extends Activity {
	
	FaqItem item; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faq_description);
		
	    Bundle extras = getIntent().getExtras();
	    if(extras != null) {
	        item = (FaqItem) extras.getSerializable("item");
	       
	    }
	    
	    
	    TextView titleText = (TextView)findViewById(R.id.question_text_view);
	    titleText.setText(item.getQuestion());
	    
	    TextView descriptionText = (TextView)findViewById(R.id.answer_text_view); 
	    descriptionText.setText(item.getAnswer()); 
	    descriptionText.setMovementMethod(new ScrollingMovementMethod());

	    
	    Linkify.addLinks(descriptionText, Linkify.WEB_URLS | Linkify.PHONE_NUMBERS);
	    //Linkify.addLinks(descriptionText, Linkify.EMAIL_ADDRESSES);
	    //Linkify.addLinks(descriptionText, Linkify.MAP_ADDRESSES);
	    
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.faq_description, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		return super.onOptionsItemSelected(item);
	}
}
