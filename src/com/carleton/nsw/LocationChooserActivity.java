package com.carleton.nsw;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class LocationChooserActivity extends Activity implements LocationListener {
	
	LocationManager mLocationManager; 
	Double myLatitude; 
	Double myLongitude; 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_chooser);
		 

		try{
			
			mLocationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);
			Location location = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			
			myLatitude = location.getLatitude();
			myLongitude = location.getLongitude(); 
			
			System.out.println(myLatitude + " " + myLongitude); 
			
		}
		
		catch(Exception e){
			System.out.println("No gps"); 
		}
		

		ArrayList<MapLocation> locationsList = getLocationList(); 
		
		final ListView locationListView = (ListView) findViewById(R.id.location_list_view);
		MapLocation[] locationArray = locationsList.toArray(new MapLocation[locationsList.size()]);

		ArrayAdapter<MapLocation> adapter = new ArrayAdapter<MapLocation>(this, 
		        R.layout.location_chooser_row_layout,R.id.textItem, locationArray);
		
		locationListView.setAdapter(adapter);
		locationListView.setFastScrollEnabled(true);
		locationListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = locationListView.getItemAtPosition(position);
                MapLocation location = (MapLocation)o;
                
                
                Intent resultIntent = new Intent(); 
                resultIntent.putExtra("location", location); 
                setResult(Activity.RESULT_OK, resultIntent);
                finish(); 
                
                
                
            }
        });
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.location_chooser, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		return super.onOptionsItemSelected(item);
	}
	
	public ArrayList<MapLocation> getLocationList(){
		ArrayList<MapLocation> locationsList = new ArrayList<MapLocation>(); 

		try{
			
			// Where am I?
			FloatCoordinates myCoords = new FloatCoordinates(myLatitude, myLongitude);
			MapLocation myLocation = new MapLocation("Where am I?", myCoords); 
			locationsList.add(myLocation); 
		}
		
		catch(Exception e){
			System.out.println("not adding"); 
		}
		
		// Allen House
		FloatCoordinates allencoords = new FloatCoordinates(-93.158276, 44.460106);
		MapLocation allenHouse = new MapLocation("Allen House", allencoords); 
		locationsList.add(allenHouse); 

		// Alumni Guest House
		FloatCoordinates alumnicoords = new FloatCoordinates(-93.155846, 44.459241);
		MapLocation alumniHouse = new MapLocation("Alumni Guest House", alumnicoords); 
		locationsList.add(alumniHouse); 
		
		// Lower Arboretum
		FloatCoordinates lowerArbCoords = new FloatCoordinates(-93.153251, 44.465027);
		MapLocation lowerArb = new MapLocation("Arboretum, Lower", lowerArbCoords); 
		locationsList.add(lowerArb); 
		
		// Upper Arboretum
		FloatCoordinates upperArbCoords = new FloatCoordinates(-93.148198, 44.462523);
		MapLocation upperArb = new MapLocation("Arboretum, Upper", upperArbCoords); 
		locationsList.add(upperArb); 
		
		// Bald Spot
		FloatCoordinates baldSpotCoords = new FloatCoordinates(-93.154587, 44.461068);
		MapLocation baldSpot = new MapLocation("Bald Spot", baldSpotCoords); 
		locationsList.add(baldSpot); 
		
		// Baseball Field
		FloatCoordinates baseballCoords = new FloatCoordinates(-93.147234, 44.466633);
		MapLocation baseBall = new MapLocation("Baseball Field", baseballCoords); 
		locationsList.add(baseBall); 
		
		// Bell Field
		FloatCoordinates bellFieldCoords = new FloatCoordinates(-93.148842, 44.460195);
		MapLocation bellField = new MapLocation("Bell Field", bellFieldCoords); 
		locationsList.add(bellField); 
		
		// Benton House
		FloatCoordinates bentonHouseCoords = new FloatCoordinates(-93.154315, 44.458730);
		MapLocation bentonHouse = new MapLocation("Benton (Sci-Fi) House", bentonHouseCoords); 
		locationsList.add(bentonHouse); 
		
		// Berg House
		FloatCoordinates bergHouseCoords = new FloatCoordinates(-93.157437, 44.458782);
		MapLocation bergHouse = new MapLocation("Berg (WA) House", bergHouseCoords); 
		locationsList.add(bergHouse); 
		
		// Bird House
		FloatCoordinates birdHouseCoords = new FloatCoordinates(-93.155248, 44.459509);
		MapLocation birdHouse = new MapLocation("Bird House", birdHouseCoords); 
		locationsList.add(birdHouse); 
		
		// Boliou Hall
		FloatCoordinates boliouHallCoords = new FloatCoordinates(-93.152998, 44.462398);
		MapLocation boliouHall = new MapLocation("Boliou Hall", boliouHallCoords); 
		locationsList.add(boliouHall); 
		
		// Brooks House
		FloatCoordinates brooksHouseCoords = new FloatCoordinates(-93.157974, 44.459607);
		MapLocation brooksHouse = new MapLocation("Brooks House", brooksHouseCoords); 
		locationsList.add(brooksHouse); 
		
		// Burton Hall
		FloatCoordinates burtonHallCoords = new FloatCoordinates(-93.156772, 44.460560);
		MapLocation burtonHall = new MapLocation("Burton Hall", burtonHallCoords); 
		locationsList.add(burtonHall); 
		
		// Cassat Hall
		FloatCoordinates cassatHallCoords = new FloatCoordinates(-93.151038, 44.460041);
		MapLocation cassatHall = new MapLocation("Cassat Hall", cassatHallCoords); 
		locationsList.add(cassatHall); 
		
		// Central Park
		FloatCoordinates centralParkCoords = new FloatCoordinates(-93.154704, 44.456829);
		MapLocation centralPark = new MapLocation("Central Park", centralParkCoords); 
		locationsList.add(centralPark); 
		
		// Chaney House
		FloatCoordinates chaneyHouseCoords = new FloatCoordinates(-93.150567, 44.458786);
		MapLocation chaneyHouse = new MapLocation("Chaney (CANOE) House", chaneyHouseCoords); 
		locationsList.add(chaneyHouse); 
		
		// Chapel
		FloatCoordinates chapelCoords = new FloatCoordinates(-93.154838, 44.460170);
		MapLocation chapel = new MapLocation("Chapel", chapelCoords); 
		locationsList.add(chapel); 
		
		// Clader House
		FloatCoordinates claderHouseCoords = new FloatCoordinates(-93.157743, 44.458692);
		MapLocation claderHouse = new MapLocation("Clader House", claderHouseCoords); 
		locationsList.add(claderHouse); 
		
		// CMC
		FloatCoordinates cmcCoords = new FloatCoordinates(-93.153519, 44.462463);
		MapLocation cmc = new MapLocation("CMC (Center for Mathematics and Computing)", cmcCoords); 
		locationsList.add(cmc); 
		
		// Collier House
		FloatCoordinates collierHouseCoords = new FloatCoordinates(-93.158174, 44.459281);
		MapLocation collierHouse = new MapLocation("Collier House", collierHouseCoords); 
		locationsList.add(collierHouse); 
		
		// Colwell House
		FloatCoordinates colwellHouseCoords = new FloatCoordinates(-93.158599, 44.458798);
		MapLocation colwellHouse = new MapLocation("Colwell House", colwellHouseCoords); 
		locationsList.add(colwellHouse); 
		
		// Concert Hall
		FloatCoordinates concertHallCoords = new FloatCoordinates(-93.153326, 44.460241);
		MapLocation concertHall = new MapLocation("Concert Hall", concertHallCoords); 
		locationsList.add(concertHall); 
		
		// Cowling Rec Center
		FloatCoordinates cowlingRecCoords = new FloatCoordinates(-93.149963, 44.459896);
		MapLocation cowlingRec = new MapLocation("Cowling Gymnasium", cowlingRecCoords); 
		locationsList.add(cowlingRec); 
		
		// Dacie Moses House
		FloatCoordinates dacieHouseCoords = new FloatCoordinates(-93.157389, 44.459047);
		MapLocation dacieHouse = new MapLocation("Dacie Moses House", dacieHouseCoords); 
		locationsList.add(dacieHouse);
		
		// Davis Hall
		FloatCoordinates davisHallCoords = new FloatCoordinates(-93.156764, 44.460083);
		MapLocation davisHall = new MapLocation("Davis Hall", davisHallCoords); 
		locationsList.add(davisHall); 
		
		// Dixon House
		FloatCoordinates dixonHouseCoords = new FloatCoordinates(-93.158261, 44.459147);
		MapLocation dixonHouse = new MapLocation("Dixon House", dixonHouseCoords); 
		locationsList.add(dixonHouse); 
		
		// Douglas House
		FloatCoordinates douglasHouseCoords = new FloatCoordinates(-93.155313, 44.457572);
		MapLocation douglasHouse = new MapLocation("Douglas (F.I.S.H.) House", douglasHouseCoords); 
		locationsList.add(douglasHouse); 
		
		// Dow House
		FloatCoordinates dowHouseCoords = new FloatCoordinates(-93.158340, 44.459012);
		MapLocation dowHouse = new MapLocation("Dow House", dowHouseCoords); 
		locationsList.add(dowHouse);
		
		// Eugster House
		FloatCoordinates eugsterHouseCoords = new FloatCoordinates(-93.157742, 44.459982);
		MapLocation eugsterHouse = new MapLocation("Eugster House", eugsterHouseCoords); 
		locationsList.add(eugsterHouse);
		
		// Evans Hall
		FloatCoordinates evansHallCoords = new FloatCoordinates(-93.149829, 44.460367);
		MapLocation evansHall = new MapLocation("Evans Hall", evansHallCoords); 
		locationsList.add(evansHall);
		
		// Faculty Club
		FloatCoordinates facultyCoords = new FloatCoordinates(-93.149517, 44.458725);
		MapLocation facultyClub = new MapLocation("Faculty Club", facultyCoords); 
		locationsList.add(facultyClub);
		
		// Farm House
		FloatCoordinates farmHouseCoords = new FloatCoordinates(-93.149448, 44.466051);
		MapLocation farmHouse = new MapLocation("Farm House", farmHouseCoords); 
		locationsList.add(farmHouse);
		
		// Geffert House
		FloatCoordinates geffertHouseCoords = new FloatCoordinates(-93.158990, 44.458901);
		MapLocation geffertHouse = new MapLocation("Geffert (Fitness) House", geffertHouseCoords); 
		locationsList.add(geffertHouse);
		
		// Goodhue Hall
		FloatCoordinates goodhueHallCoords = new FloatCoordinates(-93.149728, 44.462455);
		MapLocation goodhueHall = new MapLocation("Goodhue Hall", goodhueHallCoords); 
		locationsList.add(goodhueHall);
		
		// Goodsell Observatory
		FloatCoordinates goodsellCoords = new FloatCoordinates(-93.152440, 44.461856);
		MapLocation goodsell = new MapLocation("Goodsell Observatory", goodsellCoords); 
		locationsList.add(goodsell);
		
		// Hall House
		FloatCoordinates hallHouseCoords = new FloatCoordinates(-93.157912, 44.459512);
		MapLocation hallHouse = new MapLocation("Hall (Asia) House", hallHouseCoords); 
		locationsList.add(hallHouse);
				
		// Henrickson House
		FloatCoordinates henricksonHouseCoords = new FloatCoordinates(-93.158195, 44.458617);
		MapLocation henricksonHouse = new MapLocation("Henrickson House", henricksonHouseCoords); 
		locationsList.add(henricksonHouse);
		
		// Hoppin House
		FloatCoordinates hoppinCoords = new FloatCoordinates(-93.154317, 44.459541);
		MapLocation hoppinHouse = new MapLocation("Hoppin House", hoppinCoords); 
		locationsList.add(hoppinHouse);
		
		// Hulings Hall
		FloatCoordinates hulingsCoords = new FloatCoordinates(-93.153460, 44.460928);
		MapLocation hulingsHall = new MapLocation("Hulings Hall", hulingsCoords); 
		locationsList.add(hulingsHall);
		
		// Hill Houses
		FloatCoordinates hillHousesCoords = new FloatCoordinates(-93.155302, 44.458083);
		MapLocation hillHosues = new MapLocation("Hill House", hillHousesCoords); 
		locationsList.add(hillHosues);
		
		// Hill of Three Oaks
		FloatCoordinates oakCoords = new FloatCoordinates(-93.147314, 44.463266);
		MapLocation threeOaks = new MapLocation("Hill of Three Oaks", oakCoords); 
		locationsList.add(threeOaks);
		
		// Hunt Cottage
		FloatCoordinates hutCottageCoords = new FloatCoordinates(-93.157413, 44.459257);
		MapLocation huntCottage = new MapLocation("Hunt Cottage (La Casa de Sol)", hutCottageCoords); 
		locationsList.add(huntCottage);
		
		// Hunt House
		FloatCoordinates huntHouseCoords = new FloatCoordinates(-93.158451, 44.458623);
		MapLocation huntHouse = new MapLocation("Hunt House", huntHouseCoords); 
		locationsList.add(huntHouse);
		
		// Huntington House
		FloatCoordinates huntingtonCoords = new FloatCoordinates(-93.155342, 44.458751);
		MapLocation huntingtonHouse = new MapLocation("Huntington House", huntingtonCoords); 
		locationsList.add(huntingtonHouse);
		
		// James Hall
		FloatCoordinates jamesCoords = new FloatCoordinates(-93.151773, 44.460025);
		MapLocation jamesHall = new MapLocation("James (Memo) Hall", jamesCoords); 
		locationsList.add(jamesHall);
		
		// Jewett House
		FloatCoordinates jewettCoords = new FloatCoordinates(-93.157513, 44.457677);
		MapLocation jewettHouse = new MapLocation("Jewett (Culinary) House", jewettCoords); 
		locationsList.add(jewettHouse);
		
		// Johnson House
		FloatCoordinates johnsonCoords = new FloatCoordinates(-93.155970, 44.459472);
		MapLocation johnsonHouse = new MapLocation("Johnson House", johnsonCoords); 
		locationsList.add(johnsonHouse);
		
		// Laird Stadium
		FloatCoordinates lairdStadiumCoords = new FloatCoordinates(-93.157987, 44.461516);
		MapLocation lairdStadium = new MapLocation("Laird Stadium", lairdStadiumCoords); 
		locationsList.add(lairdStadium);
		
		// Laird Hall
		FloatCoordinates lairdHallCoords = new FloatCoordinates(-93.154052, 44.462103);
		MapLocation lairdHall = new MapLocation("Laird Hall", lairdHallCoords); 
		locationsList.add(lairdHall);
		
		// LDC
		FloatCoordinates ldcCoordinates = new FloatCoordinates(-93.1513742, 44.461026);
		MapLocation ldc = new MapLocation("Language and Dining Center (LDC)", ldcCoordinates); 
		locationsList.add(ldc);
		
		// Leighton Hall
		FloatCoordinates leightonCoordinates = new FloatCoordinates(-93.155643, 44.462114);
		MapLocation leighton = new MapLocation("Leighton Hall", leightonCoordinates); 
		locationsList.add(leighton);
		
		// Libe
		FloatCoordinates libeCoord = new FloatCoordinates(-93.154774, 44.462232);
		MapLocation libe = new MapLocation("Libe (Gould Library)", libeCoord); 
		locationsList.add(libe);
		
		// Mudd Hall
		FloatCoordinates muddCoord = new FloatCoordinates(-93.152479, 44.460953);
		MapLocation muddHall = new MapLocation("Mudd Hall", muddCoord); 
		locationsList.add(muddHall);
		
		// Music Hall
		FloatCoordinates musicCoord = new FloatCoordinates(-93.153583, 44.461376);
		MapLocation musicHall = new MapLocation("Music Hall", musicCoord); 
		locationsList.add(musicHall);
		
		// Musser Hall
		FloatCoordinates musserCoord = new FloatCoordinates(-93.157050, 44.459934);
		MapLocation musserHall = new MapLocation("Musser Hall", musserCoord); 
		locationsList.add(musserHall);
		
		// Myers Hall
		FloatCoordinates myersCoord = new FloatCoordinates(-93.150870, 44.460721);
		MapLocation myersHall = new MapLocation("Myers Hall", myersCoord); 
		locationsList.add(myersHall);
		
		// Nason House
		FloatCoordinates nasonCoord = new FloatCoordinates(-93.157676, 44.459740);
		MapLocation nasonHouse = new MapLocation("Nason House", nasonCoord); 
		locationsList.add(nasonHouse);
		
		// Olin Hall
		FloatCoordinates olinCoord = new FloatCoordinates(-93.152897, 44.461370);
		MapLocation olinHall = new MapLocation("Olin Hall", olinCoord); 
		locationsList.add(olinHall);
		
		// Owens House
		FloatCoordinates owensCoord = new FloatCoordinates(-93.158074, 44.459443);
		MapLocation owensHouse = new MapLocation("Owens House", owensCoord); 
		locationsList.add(owensHouse);
		
		// Page House
		FloatCoordinates pageCoord = new FloatCoordinates(-93.155817, 44.457587);
		MapLocation pageHouse = new MapLocation("Page House (Jewish Interest)", pageCoord); 
		locationsList.add(pageHouse);
		
		// Parish House
		FloatCoordinates parishCoord = new FloatCoordinates(-93.154857, 44.457589);
		MapLocation parishHouse = new MapLocation("Parish House", parishCoord); 
		locationsList.add(parishHouse);
		
		// Parr House
		FloatCoordinates parrCoord = new FloatCoordinates(-93.149292, 44.466390);
		MapLocation parrHouse = new MapLocation("Parr House", parrCoord); 
		locationsList.add(parrHouse);
		
		// Prentice House
		FloatCoordinates prenticeCoord = new FloatCoordinates(-93.158371, 44.459940);
		MapLocation prenticeHouse = new MapLocation("Prentice (Q&A) House", prenticeCoord); 
		locationsList.add(prenticeHouse);

		// Rec Center
		FloatCoordinates recCoord = new FloatCoordinates(-93.149614, 44.463985);
		MapLocation recCenter = new MapLocation("Rec Center", recCoord); 
		locationsList.add(recCenter);
		
		// Rice House
		FloatCoordinates riceCoord = new FloatCoordinates(-93.155882, 44.457976);
		MapLocation riceHouse = new MapLocation("Rice House", riceCoord); 
		locationsList.add(riceHouse);
		
		// Sayles Hill
		FloatCoordinates saylesCoord = new FloatCoordinates(-93.156159, 44.461259);
		MapLocation saylesHill = new MapLocation("Sayles Hill", saylesCoord); 
		locationsList.add(saylesHill);
		
		// Scott House
		FloatCoordinates scottCoord = new FloatCoordinates(-93.157787, 44.459825);
		MapLocation scottHouse = new MapLocation("Scott House", scottCoord); 
		locationsList.add(scottHouse);
		
		// Scoville Hall
		FloatCoordinates scovilleCoord = new FloatCoordinates(-93.155928, 44.460127);
		MapLocation scovilleHouse = new MapLocation("Scoville Hall", scovilleCoord); 
		locationsList.add(scovilleHouse);
		
		// Severence Hall
		FloatCoordinates severenceCoord = new FloatCoordinates(-93.156760, 44.460972);
		MapLocation severenceHall = new MapLocation("Severence Hall", severenceCoord); 
		locationsList.add(severenceHall);
		
		// Softball Field
		FloatCoordinates softballCoord = new FloatCoordinates(-93.146882, 44.465616);
		MapLocation softballField = new MapLocation("Softball Field", softballCoord); 
		locationsList.add(softballField);
		
		// Stimson House
		FloatCoordinates stimsonCoord = new FloatCoordinates(-93.156788, 44.459488);
		MapLocation stimsonHouse = new MapLocation("Stimson House (Multicultural Center)", stimsonCoord); 
		locationsList.add(stimsonHouse);
		
		// Strong House
		FloatCoordinates strongCoord = new FloatCoordinates(-93.155846, 44.458728);
		MapLocation strongHouse = new MapLocation("Strong House", strongCoord); 
		locationsList.add(strongHouse);
		
		// Watson Hall
		FloatCoordinates watsonCoord = new FloatCoordinates(-93.150524, 44.459390);
		MapLocation watsonHouse = new MapLocation("Watson Hall", watsonCoord); 
		locationsList.add(watsonHouse);
		
		// West Gym
		FloatCoordinates westCoord = new FloatCoordinates(-93.156925, 44.462856);
		MapLocation westGym = new MapLocation("West Gym", westCoord); 
		locationsList.add(westGym);
		
		// Weitz Center
		FloatCoordinates weitzCoord = new FloatCoordinates(-93.156035, 44.457037);
		MapLocation weitzCenter = new MapLocation("Weitz Center", weitzCoord); 
		locationsList.add(weitzCenter);
		
		// Williams House
		FloatCoordinates williamsCoord = new FloatCoordinates(-93.156947, 44.459111);
		MapLocation williamsHouse = new MapLocation("Williams House", williamsCoord); 
		locationsList.add(williamsHouse);
		
		// Willis Hall
		FloatCoordinates willisCoord = new FloatCoordinates(-93.155987, 44.460735);
		MapLocation willisHall = new MapLocation("Willis Hall", willisCoord); 
		locationsList.add(willisHall);
		
		// Wilson House
		FloatCoordinates wilsonCoord = new FloatCoordinates(-93.158135, 44.460252);
		MapLocation wilsonHouse = new MapLocation("Wilson House", wilsonCoord); 
		locationsList.add(wilsonHouse);
				
		return locationsList; 
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
		myLatitude = location.getLatitude();
		myLongitude = location.getLongitude(); 
		

	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	
}
