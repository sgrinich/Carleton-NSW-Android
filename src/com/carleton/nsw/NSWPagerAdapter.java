package com.carleton.nsw;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class NSWPagerAdapter extends FragmentPagerAdapter {
	
	String[] title  = {"Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
 
    public NSWPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            return new Tuesday9Fragment();
        case 1:
            return new Wednesday10Fragment();
        case 2:
            return new Thursday11Fragment();
        case 3:
        	return new Friday12Fragment(); 
        case 4: 
        	return new Saturday13Fragment(); 
        case 5:
        	return new Sunday14Fragment(); 
           
        }
        
        return null;
    }
    
    @Override
    public int getCount() {
        return 6;
    }
    
    @Override
    public CharSequence getPageTitle(int position) {
    	return title[position];
    }
 
}
