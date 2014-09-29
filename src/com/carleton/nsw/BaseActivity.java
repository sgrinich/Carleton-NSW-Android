package com.carleton.nsw;


import java.util.ArrayList;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;


public class BaseActivity extends FragmentActivity {
	 private DrawerLayout mDrawerLayout;
	 private ListView mDrawerList;
	 private ActionBarDrawerToggle mDrawerToggle;
	 protected RelativeLayout _completeLayout, _activityLayout;
	 // nav drawer title
	 private CharSequence mDrawerTitle;

	  // used to store app title
	 private CharSequence mTitle;

	 private ArrayList<NavDrawerItem> navDrawerItems;
	 private NavDrawerListAdapter adapter;

	  @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
	  // if (savedInstanceState == null) {
	  // // on first time display view for first nav item
	  // // displayView(0);
	  // }
	 }

	  public void set(String[] navMenuTitles) {
		  mTitle = mDrawerTitle = getTitle();
	
		  mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		  mDrawerList = (ListView) findViewById(R.id.left_drawer);
	
		  navDrawerItems = new ArrayList<NavDrawerItem>();
	
	      // adding nav drawer items
		  for(int i=0;i<navMenuTitles.length;i++){
		   navDrawerItems.add(new NavDrawerItem(navMenuTitles[i])); 
		  }


		  mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		  
		   // setting the nav drawer list adapter
		  adapter = new NavDrawerListAdapter(getApplicationContext(),navDrawerItems);
		  mDrawerList.setAdapter(adapter);
	
		  

		  mDrawerToggle = new ActionBarDrawerToggle(
	                this,                  /* host Activity */
	                mDrawerLayout,         /* DrawerLayout object */
	                R.drawable.ic_navigation_drawer,  /* nav drawer icon to replace 'Up' caret */
	                R.string.drawer_open,  /* "open drawer" description */
	                R.string.drawer_close  /* "close drawer" description */
	                ) {

	            /** Called when a drawer has settled in a completely closed state. */
	            public void onDrawerClosed(View view) {
	                super.onDrawerClosed(view);
	                getActionBar().setTitle(mTitle);
	            }

	            /** Called when a drawer has settled in a completely open state. */
	            public void onDrawerOpened(View drawerView) {
	                super.onDrawerOpened(drawerView);
	                getActionBar().setTitle(mDrawerTitle);
	            }
	        };
	        
	     // Set the drawer toggle as the DrawerListener
	        mDrawerLayout.setDrawerListener(mDrawerToggle);

	        getActionBar().setDisplayHomeAsUpEnabled(true);
	        getActionBar().setHomeButtonEnabled(true);


		  
		  
		  
	 }
	  
	  private class SlideMenuClickListener implements
	   ListView.OnItemClickListener {
		  @Override
		  public void onItemClick(AdapterView<?> parent, View view, int position,
		    long id) {
		   // display view for selected nav drawer item
		   displayView(position);
		  }
	 }

	 @Override
	 public boolean onCreateOptionsMenu(Menu menu) {
	  // getSupportMenuInflater().inflate(R.menu.main, menu);
	  return true;
	 }

	 @Override
	 public boolean onOptionsItemSelected(MenuItem item) {

	  if (item.getItemId() == android.R.id.home) {
		  if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
			  mDrawerLayout.closeDrawer(mDrawerList);
	   } else {
	    mDrawerLayout.openDrawer(mDrawerList);
	   		  }
	  }

	  return super.onOptionsItemSelected(item);
	 }

	 /***
	  * Called when invalidateOptionsMenu() is triggered
	  */
	 @Override
	 public boolean onPrepareOptionsMenu(Menu menu) {
	  // if nav drawer is opened, hide the action items
	  // boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
	  // menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
	  return super.onPrepareOptionsMenu(menu);
	 }

	 /**
	  * Diplaying fragment view for selected nav drawer list item
	  * */
	 private void displayView(int position) {
	  // update the main content by replacing fragments
	  switch (position) {
		  case 0:
			   Intent intent = new Intent(this, ScheduleActivity.class);
			   startActivity(intent);
			   this.overridePendingTransition(0, 0);
			   finish();
			   break;
			   
		  case 1:
			   Intent intent2 = new Intent(this, MapActivity.class);
			   startActivity(intent2);
			   this.overridePendingTransition(0, 0);
			   finish();
			   break;	 
			   
		  case 2:
			   Intent intent3 = new Intent(this, SpeakCarletonActivity.class);
			   startActivity(intent3);
			   this.overridePendingTransition(0, 0);
			   finish();
			   break;
	      
		  case 3: 
			   Intent intent4 = new Intent(this, ImportantContactsActivity.class); 
			   startActivity(intent4); 
			   this.overridePendingTransition(0,0);
			   finish(); 
			   break; 
			   
		  case 4: 
			   Intent intent5 = new Intent(this, FAQActivity.class); 
			   startActivity(intent5); 
			   this.overridePendingTransition(0,0);
			   finish(); 
			   break; 
			    
		     
		  
		  default:
			  break;
	  }

	  // update selected item and title, then close the drawer
	  mDrawerList.setItemChecked(position, true);
	  mDrawerList.setSelection(position);
	  mDrawerLayout.closeDrawer(mDrawerList);
	 }

	 @Override
	 public void setTitle(CharSequence title) {
	  mTitle = title;
	  getActionBar().setTitle(mTitle);
	 }

	 /**
	  * When using the ActionBarDrawerToggle, you must call it during
	  * onPostCreate() and onConfigurationChanged()...
	  */

	 @Override
	 protected void onPostCreate(Bundle savedInstanceState) {
	  super.onPostCreate(savedInstanceState);
	  // Sync the toggle state after onRestoreInstanceState has occurred.
	  mDrawerToggle.syncState();
	 }

	 @Override
	 public void onConfigurationChanged(Configuration newConfig) {
	  super.onConfigurationChanged(newConfig);
	  // Pass any configuration change to the drawer toggls
	  mDrawerToggle.onConfigurationChanged(newConfig);
	 }
	 
	 
	 
		
		
	 
}
	  