package com.carleton.nsw;

import java.util.ArrayList;
import java.util.TreeSet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FaqAdapter extends BaseAdapter {

	private static final int TYPE_ITEM = 0;
	private static final int TYPE_SEPARATOR = 1;
 
	private ArrayList<FaqItem> mData = new ArrayList<FaqItem>();
	private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();
 
	private LayoutInflater mInflater;
 
	public FaqAdapter(Context context) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
 
	public void addItem(final FaqItem item) {
		mData.add(item);
		notifyDataSetChanged();
	}
 
	public void addSectionHeaderItem(FaqItem item) {
		mData.add(item);
		sectionHeader.add(mData.size() - 1);
		notifyDataSetChanged();
	}
 
	@Override
	public int getItemViewType(int position) {
		return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
	}
 
	@Override
	public int getViewTypeCount() {
		return 2;
	}
 
	@Override
	public int getCount() {
		return mData.size();
	}
 
	@Override
	public FaqItem getItem(int position) {
		return mData.get(position);
	}
 
	@Override
	public long getItemId(int position) {
		return position;
	}
 
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		int rowType = getItemViewType(position);
 
		if (convertView == null) {
			holder = new ViewHolder();
			switch (rowType) {
			case TYPE_ITEM:
				convertView = mInflater.inflate(R.layout.faq_list_question, null);
				holder.textView = (TextView) convertView.findViewById(R.id.question);
				break;
			case TYPE_SEPARATOR:
				convertView = mInflater.inflate(R.layout.faq_list_header, null);
				holder.textView = (TextView) convertView.findViewById(R.id.textSeparator);
				break;
			}
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(mData.get(position).getQuestion());
 
		return convertView;
	}
 
	public static class ViewHolder {
		public TextView textView;
	}

}
