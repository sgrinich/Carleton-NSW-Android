package com.carleton.nsw;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
	
	NSWEvent event; 

	@Override
	public void onReceive(Context context, Intent intent) {
			
		int iUniqueId = (int) (System.currentTimeMillis() & 0xfffffff);
		
		Bundle extras = intent.getExtras();
	    if(extras != null) {
	        event = (NSWEvent) extras.getSerializable("eventObject");
	       
	    }
	    
	    Bitmap bitmapIcon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.knight);
	    int width = context.getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_width);
	    int height = context.getResources().getDimensionPixelSize(android.R.dimen.notification_large_icon_height);

	    Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmapIcon, width, height, false);
	    
		Intent toDescription = new Intent(context,EventDescriptionActivity.class);
		toDescription.putExtra("eventObject", event);
		PendingIntent contentIntent = PendingIntent.getActivity(context, iUniqueId, toDescription, 0);
		
		
		String title = event.getTitle();
		String startTime = event.getStartTimeToDisplay();
		

		NotificationCompat.Builder mBuilder = 
				new NotificationCompat.Builder(context)
		.setSmallIcon(R.drawable.ic_stat_nsw_icon)
		.setLargeIcon(resizedBitmap)
		.setContentTitle(title)
		.setContentText("Event begins at " + startTime + ".");
		mBuilder.setContentIntent(contentIntent);
	    mBuilder.setDefaults(Notification.DEFAULT_SOUND);
	    mBuilder.setAutoCancel(true);
		


		NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(iUniqueId, mBuilder.build());
		
	}

}
