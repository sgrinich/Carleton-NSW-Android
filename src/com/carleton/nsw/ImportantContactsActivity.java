package com.carleton.nsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class ImportantContactsActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_important_contacts);
		
		set(getResources().getStringArray(R.array.title_array)); 
		
		ArrayList<NSWContact> contactList = getContactList(); 
		NSWContact[] contactArray = contactList.toArray(new NSWContact[contactList.size()]);
		
		final ListView contactListView = (ListView) findViewById(R.id.contact_list_view);

		ContactAdapter adapter = new ContactAdapter(this,
				R.layout.contact_row_layout,R.id.textItem, contactArray);
		

		contactListView.setAdapter(adapter);
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.important_contacts, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		return super.onOptionsItemSelected(item);
	}
	
	public String getStringFromFile(String filename){
    	AssetManager am = ImportantContactsActivity.this.getAssets();

 
    	InputStream is = null;
    	String result = null; 
    	
    	try {
			is = am.open(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	InputStreamReader inputStreamReader = new InputStreamReader(is);
    	BufferedReader br = new BufferedReader(inputStreamReader);
    	
    	 StringBuilder sb = new StringBuilder();
    	 String line = null; 
    	 try {
			while ((line = br.readLine()) != null)
			    {
			        sb.append(line + "\n");
			    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    result = sb.toString();
    	
    	
    	
    	return result; 
    	
    }
	
	
	
	public ArrayList<NSWContact> getContactList(){
		ArrayList<NSWContact> contactList = new ArrayList<NSWContact>(); 
		
		NSWContact addressChanges = new NSWContact("Address Changes", "15072224195", "addresses@carleton.edu");
		contactList.add(addressChanges); 
		
		NSWContact admissions = new NSWContact("Admissions", "15072224190", "admissions@carleton.edu");
		contactList.add(admissions); 

		NSWContact business = new NSWContact("Business Office", "15072224165", "studentaccounts@carleton.edu");
		contactList.add(business); 
		
		NSWContact chaplain = new NSWContact("Chaplain", "15072224003", "chaplain@carleton.edu");
		contactList.add(chaplain); 
		
		NSWContact helpdesk = new NSWContact("Computing/Email Support", "15072224040", "helpdesk@carleton.edu");
		contactList.add(helpdesk); 
		
		NSWContact doc = new NSWContact("Dean of the College", "15072224300", "docoffice@carleton.edu");
		contactList.add(doc); 
		
		NSWContact dos = new NSWContact("Dean of Students", "15072224075", "dosoffice@carleton.edu");
		contactList.add(dos); 
		
		NSWContact ds = new NSWContact("Disability Services for Students", "15072224080", "ds@carleton.edu");
		contactList.add(ds); 
		
		NSWContact fa = new NSWContact("Financial Aid", "15072224138", "financialaid@carleton.edu");
		contactList.add(fa);
		
		NSWContact ip = new NSWContact("International Programs", "15072225937", "bzubia@carleton.edu");
		contactList.add(ip);
		
		NSWContact lp = new NSWContact("Language Placement", "15072224252", "mtatge@carleton.edu");
		contactList.add(lp);
	
		NSWContact mp = new NSWContact("Math Placement", "15072224360", "mathplacement@carleton.edu");
		contactList.add(mp);
		
		NSWContact onecard = new NSWContact("OneCard", "15072227728", "onecard@carleton.edu");
		contactList.add(onecard);
		
		NSWContact registration = new NSWContact("Registration", "15072224289", "registrar@carleton.edu");
		contactList.add(registration);
		
		NSWContact reslife = new NSWContact("Residential Life", "15072224072", "reslife@carleton.edu");
		contactList.add(reslife);
		
		NSWContact sm = new NSWContact("Shipping & Mailing", "15072224187", "mailservices@carleton.edu");
		contactList.add(sm);
		
		NSWContact sao = new NSWContact("Student Activities Office", "15072224462", "sao@carleton.edu");
		contactList.add(sao);
		
		NSWContact shac = new NSWContact("Student Health and Counseling", "15072224080", "shac@carleton.edu");
		contactList.add(shac);

		return contactList; 
		
	}
	
	
}
