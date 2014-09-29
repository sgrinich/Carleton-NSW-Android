package com.carleton.nsw;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
 
public class NSWBaseAdapter extends BaseAdapter {
    private ArrayList<NSWEvent> nswEventList;
 
    private LayoutInflater mInflater;
 
    public NSWBaseAdapter(Context context, ArrayList<NSWEvent> eventList) {
    	nswEventList = eventList;
        mInflater = LayoutInflater.from(context);
    }
 
    public int getCount() {
        return nswEventList.size();
    }
 
    public Object getItem(int position) {
        return nswEventList.get(position);
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_row_view, null);
            holder = new ViewHolder();
            holder.timeRangeTextView = (TextView) convertView.findViewById(R.id.time_range);
            holder.eventTitleTextView = (TextView) convertView.findViewById(R.id.event_title);
 
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
 
        if(!(nswEventList.get(position).getStartTimeToDisplay().equals(nswEventList.get(position).getEndTimeToDisplay()))){
			holder.timeRangeTextView.setText(nswEventList.get(position).getStartTimeToDisplay() + " - " + nswEventList.get(position).getEndTimeToDisplay());
		}
		
		else{
			holder.timeRangeTextView.setText(nswEventList.get(position).getStartTimeToDisplay());
		}
        holder.eventTitleTextView.setText(nswEventList.get(position).getTitle());
 
        return convertView;
    }
 
    class ViewHolder {
        TextView timeRangeTextView;
        TextView eventTitleTextView;
    }
}