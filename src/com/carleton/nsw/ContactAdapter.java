package com.carleton.nsw;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class ContactAdapter extends ArrayAdapter<NSWContact> {

    private Context mContext;
    NSWContact contact; 
	
	public ContactAdapter(Context context, int resource, int textViewResourceId, NSWContact[] objects) {
		super(context, resource, textViewResourceId, objects);

		 mContext = context;
	
	}

	
	public View getView(final int position, View convertView, ViewGroup parent) {


		contact =  (NSWContact) getItem(position);
		
		ViewHolder holder = null; 
		
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_row_layout, null);
            
            holder = new ViewHolder(); 
            
            holder.callButton = (ImageButton) convertView.findViewById(R.id.call_button);
    		holder.emailButton = (ImageButton) convertView.findViewById(R.id.email_button);
    		holder.contactTitle = (TextView) convertView.findViewById(R.id.textItem); 
    	
    		convertView.setTag(holder); 
        }
        
        else{
        	holder = (ViewHolder)convertView.getTag(); 
        
        }
        
        
        holder.contactTitle.setText(contact.getTitle()); 
        holder.callButton.setOnTouchListener(new CallButtonHighlighterOnTouchListener(holder.callButton,contact));
        holder.emailButton.setOnTouchListener(new EmailButtonHighlighterOnTouchListener(holder.emailButton,contact));
		
        
        return convertView;   
        
    }
	
	class ViewHolder {
        TextView contactTitle;
        ImageButton callButton;
        ImageButton emailButton; 
    }
	
	class CallButtonHighlighterOnTouchListener implements OnTouchListener {

		  final ImageButton imageButton;
		  final NSWContact contact; 

		  public CallButtonHighlighterOnTouchListener(final ImageButton imageButton, final NSWContact contact) {
		    super();
		    this.imageButton = imageButton;
		    this.contact = contact; 
		  }

		  public boolean onTouch(final View view, final MotionEvent motionEvent) {
		    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
		      imageButton.setColorFilter(Color.argb(200, 185, 185, 185));
		    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
		      imageButton.setColorFilter(Color.argb(0, 185, 185, 185)); 
		      
		      System.out.println(contact.getPhone()); 
		      
		      Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contact.getPhone())); 
		      mContext.startActivity(callIntent);
		      
		    }
		    
		    if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){
		    	imageButton.setColorFilter(Color.argb(0, 185, 185, 185)); 
		    }
		    

		    return false;
		  }

		}
	
	
	class EmailButtonHighlighterOnTouchListener implements OnTouchListener {
		
		
		  final ImageButton imageButton;
		  final NSWContact contact; 

		  public EmailButtonHighlighterOnTouchListener(final ImageButton imageButton, final NSWContact contact) {
		    super();
		    this.imageButton = imageButton;
		    this.contact = contact; 
		  }

		  public boolean onTouch(final View view, final MotionEvent motionEvent) {
		    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
		      imageButton.setColorFilter(Color.argb(200, 185, 185, 185));
		    } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
		      imageButton.setColorFilter(Color.argb(0, 185, 185, 185)); 
		      
		      
		      Intent i = new Intent(Intent.ACTION_SEND);
		    	i.setType("message/rfc822");
		    	i.putExtra(Intent.EXTRA_EMAIL  , new String[]{contact.getEmail()});
		    	
		    	try {
		    	    mContext.startActivity(Intent.createChooser(i, "Send mail..."));
		    	} catch (android.content.ActivityNotFoundException ex) {
		    	    Toast.makeText(mContext, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		    	}
				      
		    }
		    
		    if(motionEvent.getAction() == MotionEvent.ACTION_MOVE){
		    	imageButton.setColorFilter(Color.argb(0, 185, 185, 185)); 
		    }
		    

		    return false;
		  }

		}
	
	

}
