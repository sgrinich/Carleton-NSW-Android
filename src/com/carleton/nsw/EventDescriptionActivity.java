package com.carleton.nsw;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ParseException;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;



public class EventDescriptionActivity extends Activity {
	
	NSWEvent event;
	String notifyTime; 
	Calendar cal; 
	Calendar nowCal; 
	Date today; 
	Date date; 
	Boolean show; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	    getActionBar().hide();
		
		setContentView(R.layout.activity_event_description);
		

		Bundle extras = getIntent().getExtras();
	    if(extras != null) {
	        event = (NSWEvent) extras.getSerializable("eventObject");
	       
	    }
	    
	    TextView titleText = (TextView)findViewById(R.id.title);
	    titleText.setText(event.getTitle());
	    
	    TextView locationText = (TextView)findViewById(R.id.location);
	    locationText.setText(event.getLocation());
	    
	    notifyTime = event.getStartTime(); 
	    date = null;
		try {
			date = new SimpleDateFormat("MM-dd-yyyy hh:mm a").parse(notifyTime);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		today = new Date(); 
		cal = Calendar.getInstance();
		nowCal = Calendar.getInstance(); 
		
		
	    TextView durationText = (TextView)findViewById(R.id.duration);
	    try {
	    	
	    	if(!(event.getStartTimeToDisplay().equals(event.getEndTimeToDisplay()))){
	    	
	    		durationText.setText(event.getStartTimeToDisplay() + " - " + event.getEndTimeToDisplay());
	    	}
	    	
	    	else{
	    		durationText.setText(event.getStartTimeToDisplay());
	    	}
	    	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    TextView descriptionText = (TextView)findViewById(R.id.description);
	    descriptionText.setText(event.getDescription());
	    descriptionText.setLinksClickable(true);
	    descriptionText.setMovementMethod(new ScrollingMovementMethod());
	    
	    Linkify.addLinks(descriptionText, Linkify.WEB_URLS);
	    
	    ImageButton notifyButton = (ImageButton) findViewById(R.id.notify_button); 
	    notifyButton.setOnTouchListener(new ButtonHighlighterOnTouchListener(notifyButton));
	    

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event_description, menu);
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
	

	
	class ButtonHighlighterOnTouchListener implements OnTouchListener {

		  final ImageButton imageButton;

		  public ButtonHighlighterOnTouchListener(final ImageButton imageButton) {
		    super();
		    this.imageButton = imageButton;
		  }
		  
		  public int compareTwoDates(Date date1, Date date2) {
		        if (date1 != null && date2 != null) {
		            int retVal = date1.compareTo(date2);

		            if (retVal > 0)
		                return 1; // date1 is greatet than date2
		            else if (retVal == 0) // both dates r equal
		                return 0;

		        }
		        return -1; // date1 is less than date2
		    }

		  public boolean onTouch(final View view, final MotionEvent motionEvent) {
		    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
		      //grey color filter, you can change the color as you like
		      imageButton.setColorFilter(Color.argb(200, 185, 185, 185));
		    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
		      imageButton.setColorFilter(Color.argb(0, 185, 185, 185)); 
		      
		      	if((compareTwoDates(today,date) == -1)||(compareTwoDates(today,date)==0)){
		      		
		      		PopupMenu popup = new PopupMenu(EventDescriptionActivity.this, imageButton);
		            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());  
		            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {  
		                public boolean onMenuItemClick(MenuItem item) {  

		                	String title = (String) item.getTitle();
		                	
		                	cal.setTime(date);
		                	
		                	
		                	if(title.equals("5 Minutes Before")){
		                		 cal.add(Calendar.MINUTE, -5);
		                		 
		                		 show = true; 
		                		 if(nowCal.compareTo(cal)>0){
		                			 AlertDialog.Builder builder = new AlertDialog.Builder(EventDescriptionActivity.this);
		                			 
		         		            builder.setMessage("It's too close to this event right now to be reminded that early.")
		         		                   .setNeutralButton("OK", new DialogInterface.OnClickListener() {
		         		                       public void onClick(DialogInterface dialog, int id) {
		         		                       }
		         		                   });
		         		            builder.create();
		         		            builder.show();
		         		            
		         		            show = false; 
		                		 }
		                	}
		                	
		                	if(title.equals("10 Minutes Before")){	
		                		 cal.add(Calendar.MINUTE, -10);
		                		 
		                		 show = true; 
		                		 if(nowCal.compareTo(cal)>0){
		                			 AlertDialog.Builder builder = new AlertDialog.Builder(EventDescriptionActivity.this);
		                			 
		         		            builder.setMessage("It's too close to this event right now to be reminded that early.")
		         		                   .setNeutralButton("OK", new DialogInterface.OnClickListener() {
		         		                       public void onClick(DialogInterface dialog, int id) {
		         		                       }
		         		                   });
		         		            builder.create();
		         		            builder.show();
		         		            
		         		            show = false; 
		                		 }
		                	}
		                	
		                	if(title.equals("15 Minutes Before")){	
		                		 cal.add(Calendar.MINUTE, -15);
		                		 
		                		 show = true; 
		                		 if(nowCal.compareTo(cal)>0){
		                			 AlertDialog.Builder builder = new AlertDialog.Builder(EventDescriptionActivity.this);
		                			 
		         		            builder.setMessage("It's too close to this event right now to be reminded that early.")
		         		                   .setNeutralButton("OK", new DialogInterface.OnClickListener() {
		         		                       public void onClick(DialogInterface dialog, int id) {
		         		                       }
		         		                   });
		         		            builder.create();
		         		            builder.show();
		         		            
		         		            show = false; 
		                		 }
		                	}
		                	
		                	if(title.equals("30 Minutes Before")){	
		                		 cal.add(Calendar.MINUTE, -30);
		                		 
		                		 show = true; 
		                		 if(nowCal.compareTo(cal)>0){
		                			 AlertDialog.Builder builder = new AlertDialog.Builder(EventDescriptionActivity.this);
		                			 
		         		            builder.setMessage("It's too close to this event right now to be reminded that early.")
		         		                   .setNeutralButton("OK", new DialogInterface.OnClickListener() {
		         		                       public void onClick(DialogInterface dialog, int id) {
		         		                       }
		         		                   });
		         		            builder.create();
		         		            builder.show();
		         		            
		         		            show = false; 
		                		 }
		                	}
		                	
		                	if(title.equals("One Hour Before")){	
		                		 cal.add(Calendar.MINUTE, -60);
		                		 
		                		 show = true; 
		                		 if(nowCal.compareTo(cal)>0){
		                			 AlertDialog.Builder builder = new AlertDialog.Builder(EventDescriptionActivity.this);
		                			 
		         		            builder.setMessage("It's too close to this event right now to be reminded that early.")
		         		                   .setNeutralButton("OK", new DialogInterface.OnClickListener() {
		         		                       public void onClick(DialogInterface dialog, int id) {
		         		                       }
		         		                   });
		         		            builder.create();
		         		            builder.show();
		         		            
		         		            show = false; 
		                		 }
		                	}
		                	
		                	if(title.equals("One Day Before")){	
		                		cal.add(Calendar.MINUTE, -1440);
		                		
		                		show = true; 
		                		 if(nowCal.compareTo(cal)>0){
		                			 AlertDialog.Builder builder = new AlertDialog.Builder(EventDescriptionActivity.this);
		                			 
		         		            builder.setMessage("It's too close to this event right now to be reminded that early.")
		         		                   .setNeutralButton("OK", new DialogInterface.OnClickListener() {
		         		                       public void onClick(DialogInterface dialog, int id) {
		         		                       }
		         		                   });
		         		            builder.create();
		         		            builder.show();
		         		            
		         		            show = false; 
		                		 }
		                	}
		          

		                	Intent myIntent = new Intent(EventDescriptionActivity.this , AlarmReceiver.class);     
		                	myIntent.putExtra("eventObject", event);
		                	
		                	if(show){
		 
		                		PendingIntent pendingIntent = PendingIntent.getBroadcast(EventDescriptionActivity.this,0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
			                    AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
			                    alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
			                    // use for testing notification
			                	//Calendar calendar = Calendar.getInstance();
			                    //alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis() + 5000, pendingIntent);
			                    
			                    TextView msg = new TextView(EventDescriptionActivity.this);
			                    msg.setText("Notification Set");
			                    msg.setGravity(Gravity.CENTER);
			                    msg.setPadding(0, 35, 0, 0);
			                    msg.setTextSize(18);
			                    
			                    
			                    DialogInterface.OnClickListener onClick = new DialogInterface.OnClickListener() {

			                        public void onClick(DialogInterface dialog, int which) {
			                            if (which == DialogInterface.BUTTON_NEGATIVE) {
			                                finish();
			                            }
			                        }

			                    };
			                    
			                    Builder builder = new AlertDialog.Builder(EventDescriptionActivity.this);
			                    builder.setView(msg);
			                    builder.setNeutralButton("OK", onClick);

			                    AlertDialog dialog = builder.create();
			                    dialog.show();

		                	}

		                	
		                	return true;  
		                }  
		               });  
		     
		               popup.show();  
		      		
		      	}
		      	
		      	else{
		      		AlertDialog.Builder builder = new AlertDialog.Builder(EventDescriptionActivity.this);
		            builder.setMessage("This event has already occured or started.")
		                   .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
		                       public void onClick(DialogInterface dialog, int id) {
		                       }
		                   });
		            builder.create();
		            builder.show();

		      	}
		       	

		    }
		    return false;
		  }

		}
	

}