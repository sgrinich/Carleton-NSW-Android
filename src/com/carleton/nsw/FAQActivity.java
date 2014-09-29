package com.carleton.nsw;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FAQActivity extends BaseActivity {

	private FaqAdapter mAdapter;
	
    /* Sections are in this order and include:
    -- NewStudents
    -- Housing
    -- OneCard
    -- PostOffice
    -- SHAC
    -- Advising
    -- ITS
    -- Language
    -- PrintServices
    -- DisabilityServices
    -- Miscellaneous
    */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faq);
		
		set(getResources().getStringArray(R.array.title_array)); 
		
		mAdapter = new FaqAdapter(this);
		
		
		final ListView questionListView = (ListView) findViewById(R.id.question_list_view);
		
		ArrayList<FaqItem> newStudentItems = getNewStudents2014Items();
		ArrayList<FaqItem> housingItems = getHousingItems();
		ArrayList<FaqItem> oneCardItems = getOneCardItems(); 
		ArrayList<FaqItem> postOfficeItems = getPostOfficeItems(); 
		ArrayList<FaqItem> shacItems = getSHACItems(); 
		ArrayList<FaqItem> advisingItems = getAdvisingItems(); 
		ArrayList<FaqItem> itsItems = getITSItems(); 
		ArrayList<FaqItem> languageItems = getLanguageItems();
		ArrayList<FaqItem> printItems = getPrintItems(); 
		ArrayList<FaqItem> disItems = getDisItems();
		
		mAdapter.addSectionHeaderItem(new FaqItem("General","",0));
		for(int i = 0; i<newStudentItems.size(); i++){
			mAdapter.addItem(newStudentItems.get(i));
		}
		
		mAdapter.addSectionHeaderItem(new FaqItem("Housing","",0));
		for(int i = 0; i<housingItems.size(); i++){
			mAdapter.addItem(housingItems.get(i));
		}

		mAdapter.addSectionHeaderItem(new FaqItem("OneCard","",0));
		for(int i = 0; i<oneCardItems.size(); i++){
			mAdapter.addItem(oneCardItems.get(i));
		}
		
		mAdapter.addSectionHeaderItem(new FaqItem("Post Office","",0));
		for(int i = 0; i<postOfficeItems.size(); i++){
			mAdapter.addItem(postOfficeItems.get(i));
		}
		
		mAdapter.addSectionHeaderItem(new FaqItem("Student Healh & Counseling","",0));
		for(int i = 0; i<shacItems.size(); i++){
			mAdapter.addItem(shacItems.get(i));
		}
		
		mAdapter.addSectionHeaderItem(new FaqItem("Advising","",0));
		for(int i = 0; i<advisingItems.size(); i++){
			mAdapter.addItem(advisingItems.get(i));
		}
		
		mAdapter.addSectionHeaderItem(new FaqItem("ITS","",0));
		for(int i = 0; i<itsItems.size(); i++){
			mAdapter.addItem(itsItems.get(i));
		}
		
		mAdapter.addSectionHeaderItem(new FaqItem("Foreign Lanugage","",0));
		for(int i = 0; i<languageItems.size(); i++){
			mAdapter.addItem(languageItems.get(i));
		}
		
		mAdapter.addSectionHeaderItem(new FaqItem("Print Services","",0));
		for(int i = 0; i<printItems.size(); i++){
			mAdapter.addItem(printItems.get(i));
		}
		
		mAdapter.addSectionHeaderItem(new FaqItem("Disability Services","",0));
		for(int i = 0; i<disItems.size(); i++){
			mAdapter.addItem(disItems.get(i));
		}

		questionListView.setAdapter(mAdapter);
		
		questionListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = questionListView.getItemAtPosition(position);
                FaqItem item = (FaqItem)o;
                
                if(item.getType() == 1){
                	Intent intent = new Intent(FAQActivity.this, FaqDescriptionActivity.class);
                    intent.putExtra("item", item);
                    startActivity(intent);
                }
                	
                
                
            }
        });
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.faq, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public ArrayList<FaqItem> getNewStudents2014Items(){
		ArrayList<FaqItem> newStudentItems = new ArrayList<FaqItem>(); 
		
		FaqItem a = new FaqItem("Are there any hotels within walking distance of campus?","The Archer House—which is located downtown on Division Street, two blocks from Johnson House, the admissions building—is the closest hotel to Carleton’s campus. Another close hotel is the Country Inn, located on Highway 3, about 4 blocks from campus, or AmericInn, which is approximately a mile from campus. If family members plan to stay in either of these hotels, you will not need a car to get to campus. For more information about hotels, maps, and dining opportunities, check out the Northfield Chamber of Commerce website: http://www.northfieldchamber.com.",1);
		newStudentItems.add(a);
		
		FaqItem b = new FaqItem("Where can I find my Carleton Net ID and password?","The Carleton username and password were sent in Mailing #1. They can be found on the front of the “Computing at Carleton” booklet. To change your password, go to http://go.carleton.edu/password.",1);
		newStudentItems.add(b);
		
		FaqItem c = new FaqItem("What are my banking options in Northfield?","The banks available are Community Resource Bank, First National Bank, Premier Bank Minnesota, and Wells Fargo Bank. Not all of these banks are in walking distance of the campus, but with a car, are within five minutes. Wells Fargo and First National are within walking distance, and Wells Fargo and First National have ATMs in Sayles-Hill, the student center.",1);
		newStudentItems.add(c);
		
		FaqItem d = new FaqItem("How do I get to Carleton?","For driving directions to and from Carleton, information about buses for students to and from the airport, and maps of campus and Northfield, visit http://webapps.acs.carleton.edu/student/transport. ",1);
		newStudentItems.add(d);
		
		FaqItem e = new FaqItem("What do I do if I lost my “Computing at Carleton” booklet?","Call the ITS Helpdesk at 507-222-5999 for help retrieving your username and/or password.",1);
		newStudentItems.add(e);
		
		FaqItem f = new FaqItem("Who made this app?","New Student Week App, iOS: \n\nStephen Grinich '16, Alex Simonides '15, Evan Harris '15. (Carleton College Mobile Application Development class project) Spring 2014.\n\nStephen Grinich \'16, (Software Developer, Design) Summer 2014.\n\n\nNew Student Week App, Android:\n\nStephen Grinich '16, (Software Developer, Design) Summer 2014.\n\n\nSpecial thanks to Louis Newman, Jeff Ondich, Ana Sontag, and Lee Clark.",1);
		newStudentItems.add(f); 
		
		return newStudentItems;
	}
	
	public ArrayList<FaqItem> getHousingItems(){
		ArrayList<FaqItem>  housingItems = new ArrayList<FaqItem>();
		
		FaqItem a = new FaqItem("What size are the beds in the halls?","Carleton College uses bunkable beds with an 80\" (extra long) twin mattress. Most of our mattress dimensions are: 36\"x80\"x8\". When students arrive, the beds will not be bunked, they will be positioned at about 19\" above the floor. If students would like to bunk their bed, the pins are stored in the top drawer of the dresser. Custodial staff in the buildings may have some in storage if there are no pins in the room.",1);
		housingItems.add(a);
		
		FaqItem b = new FaqItem("I have additional questions about residential policies, problems, etc. Who can I turn to for answers?","The Residential Life staff (https://apps.carleton.edu/student/housing/staff/) oversee residential facilities (room assignments and changes, keys, damage charges), but more importantly, the area directors and resident assistants are the first line of assistance for students within their residential environment. The staff is here to help you—to answer questions, to plan fun floor and hall programs, to help you learn about Carleton and yourself, and to just listen. Central office professional and student staff members are available to advise students on any educational or personal concerns. In addition, the central staff selects, trains, and supervises area directors and resident assistants. They also develop and administer residential policies. The residential life staff is led by the director of residential life and an assistant director of residential life. We welcome your questions and suggestions; please e-mail us, stop by our office for information, to meet the staff, or to just learn your way around campus.",1);
		housingItems.add(b);
		
		FaqItem c = new FaqItem("Can I move in any earlier than 8 a.m. on Tuesday, September 9?","We are able to accommodate first year students who must arrive early because of travel difficulties or family conflicts. However, the earliest we can provide housing is Monday, September 8, at noon. There is a nominal fee of $30 which includes the cost of your room and meals for September 8. The charge will be applied to your student account in the Business Office. If you would like to reserve housing , please complete the Early Arrival Request for First Year Students form here: https://apps.carleton.edu/student/new/housing/early_arrival/. We are very sorry but we cannot accept any reservations after August 15.",1);
		housingItems.add(c);
		
		FaqItem d = new FaqItem("What furnishings are provided in the rooms? What should I bring myself?","All rooms are furnished with a bunkable bedframe, 80\" (extra long) twin mattress, desk, desk chair, wardrobe or closet, trash can, mirror, and overhead light. Please note that lofts are not permitted. You are welcome to bring additional items to personalize your room: a small comfy chair, a desk lamp, etc. If you choose to bring a lamp, avoid halogens. During the past few years, halogen lamps have caused a large number of fires in residence halls across the country due to the intensity of heat they generate, and they are prohibited at Carleton. To protect and maintain the furniture for future residents, all room furniture must be kept in the room, and all lounge furniture must be kept in the lounges. Drying racks will be available to use for free for anybody living on the floor, and will be kept in a common area (usually a storage closet or lounge). The drying racks were made possible by the Students Organized for the Protection of the Environment and the Sustainability Revolving Fund as part of an effort to reduce dryer usage and campus-wide energy consumption. Students must provide their own linens which may be ordered from a linen company. The extra long twin size linens are also available at most major department stores. Our student staff have developed a listing of useful items to bring with you to campus. We encourage you to coordinate with your roommate to avoid duplicates.",1);
		housingItems.add(d);
		
		FaqItem e = new FaqItem("Is my personal property insured anywhere on campus (your room or storage)?","Carleton College does not insure and is not responsible for loss or damage from any cause to the personal property of students (including items in storage). Students are encouraged to explore insurance coverage with your family insurance agent or through Sallie Mae Insurance Services. \n\n http://www.salliemaeinsurance.com/protectmystuff \n\n http://www.collegerentersplan.com/Carleton",1);
		housingItems.add(e);
		
		FaqItem f = new FaqItem("Does every floor have bathrooms? What about co-ed bathrooms?","Most floors have two bathrooms (male and female) but some floors have three or more. If there are more than two, the third bathroom may be designated co-ed. Depending on the building and the types of bathrooms in that space, bathrooms may be gendered and/or co-ed.  Most bathrooms have showers and a few also have bathtubs. Residents of rooms with private bathrooms are responsible for keeping the bathroom clean.",1);
		housingItems.add(f);
		
		FaqItem g = new FaqItem("What do I need to do if I want to host a party or an event?","Your Area director has event registration forms with complete guidelines. Any use of public space in your hall (i.e., anywhere except your room) for a party or event requires an event registration form be submitted to Residential Life 48 hours prior to the event. Parties and events in your room do not need to be registered; however, they must be confined to your room and may not disturb others on the floor.\n Large events (more than five (5) guests per resident of the room) must be approved 48 hours before the event starting time. Large events must be held in lounges or other public spaces. The lounge must be reserved through the Hall Director five days in advance.",1);
		housingItems.add(g);
		
		FaqItem h = new FaqItem("How can we decorate?","We encourage you to decorate your room with posters/pictures that make your room your home. Please do not use nails, tacks or duct tape. To avoid damage to the walls and woodwork in your room, use the removable adhesive poster strips that are available in stores.",1);
		housingItems.add(h);
		
		FaqItem i = new FaqItem("Do I need to purchase my own printer?","No. Printers are available in the library and the many computer labs located around campus. For more information visit Printing Services website here: https://apps.carleton.edu/campus/printing_options/general/.",1);
		housingItems.add(i);
		
		FaqItem j = new FaqItem("Will there be a phone in my room? What will my phone number be?","Each room has a phone. Your phone number will always start with 507-222-. The last four digits of your number are determined by your room assignment. Your room and phone number will be available when you are notified about your housing assignment via email. You will receive an authorization code from Telecommunications which will make it possible for you to make long distance calls from your room phone.",1);
		housingItems.add(j);
		
		FaqItem k = new FaqItem("Is cable TV available in College-owned houses?","Some of the College-owned houses are wired for Cable TV installation. Residents of the houses must subscribe for service using house funds to secure the subscription. Information is provided to the residents of the houses regarding cable TV installation at the beginning of each academic year. Houses that may subscribe for service are Allen House, Benton House, Chaney House, Geffert House, Huntington House, Prentice House, Stimson House, Watson House, Williams House, and Wilson Houses.\n\nCarleton College network cable has been installed to Berg House, Brooks House, Clader House, Collier House, Colwell House, Dacie Moses House, Dixon House, Douglas House, Dow House, Eugster House, Hall House, Hill House, Hunt Cottage, Hunt House, Jewett House, Nason House, Owens House, Parish House, Parr House, Rice House, and Scott House. The College network provides only the basic cable package. Telecommunications staff can respond to questions regarding the Carleton network cable.\n\nUnfortunately cable connections are not available to Page House. Street addresses are available on the staff listing page. Questions and concerns regarding cable should be addressed to the Telecommunications Department.\n\nThe College administration and the Committee on Student Life continue to evaluate the possibilities of cable installation to the houses on an annual basis.",1);
		housingItems.add(k);
		
		FaqItem l = new FaqItem("Are there laundry rooms in the halls and houses? How do you pay for laundry?","Each hall and most campus houses have laundry facilities on the main floor or in the basement. The laundry machines in the residence halls accept OneCards. Laundry machines in the houses still use quarters.\n\nDrying racks will be available to use for free for anybody living on the floor, and will be kept in a common area (usually a storage closet or lounge). The drying racks were made possible by the Students Organized for the Protection of the Environment and the Sustainability Revolving Fund as part of an effort to reduce dryer usage and campus-wide energy consumption.",1);
		housingItems.add(l);
		
		FaqItem m = new FaqItem("How does Carleton encourage sustainable living and what can I do to help?","Sustainability is becoming more and more important on Carleton’s campus. For example, Carleton students are encouraged to be conscious of their energy use by setting computers to energy-saving modes, turning off extraneous lights, using power strips that can be turned off at night, using energy-maximizing CFL (compact fluorescent) light bulbs, being conscientious about shower time and water use, using energy-maximizing settings on washers, thinking about air-drying clothes and minimizing wintertime heat loss by keeping windows closed and adjusting the heat to comfortable levels.\n\nCurrently, drying racks are available to use for free for anybody living on the floor, and will be kept in a common area (usually a storage closet or lounge). The drying racks were made possible by the Students Organized for the Protection of the Environment and the Sustainability Revolving Fund as part of an effort to reduce dryer usage and campus-wide energy consumption.\n\nSustainability is about creating and maintaining a long-lasting, healthy community and well as minimizing impact on the environment. The many student and campus-sponsored activities, programs and organizations at Carleton create a healthy, happy, sustainable community that is also sustainable in its low impact on the environment.\n\nWe encourage you to be conscientious of the environmental impact of your purchases as we move towards being a more sustainable campus community.",1);
		housingItems.add(m);
		
		FaqItem n = new FaqItem("Are refrigerators available in the residence halls?","Refrigerators are available in every floor lounge. Many students enjoy having small refrigerators in their rooms, but they are by no means necessary since there is space in the floor refrigerator.\n\nSmall residence hall or apartment-style refrigerators (no greater than 3.6 cubic feet) are permitted in the student rooms.",1);
		housingItems.add(n);
		
		FaqItem o = new FaqItem("What are the policies regarding alcohol and drugs?","Students are expected to make responsible decisions concerning the use of alcohol. The College recognizes and abides by all state laws, and will cooperate fully with civil authorities. Alcoholic beverages may be possessed and consumed (not sold) by anyone of legal drinking age (21). Alcohol is not allowed in public areas except at registered events. Alcohol may be served at registered events where a carding system, food, and alternative beverages are present. The illegal use, sale, distribution, or possession of drugs is prohibited anywhere on the Carleton campus. Education and counseling on alcohol and drugs is provided by staff members in Student Health and Counseling.",1);
		housingItems.add(o);
		
		FaqItem p = new FaqItem("When will I know what my housing assignment is for the fall and who my roommate will be?","Residential Life staff complete housing assignments for new students in mid July. As soon as all new students are housed, the class dean will send an email with the website where new students can find their room assignment and the name, address, phone number and e-mail address of their roommate(s). We hope that when you receive your assignment, you will contact your roommate(s) to become acquainted.",1);
		housingItems.add(p);
		
		FaqItem q = new FaqItem("What meal plan are first year students on?","First year students are assigned to the 20 meal plan. The 20 meal plan is Carleton’s full board plan. This plan offers 20 guaranteed meals per week in either Burton or East Dining Hall, three per day Monday through Saturday and two on Sunday, with $75 in dining dollars that may be used in the Sayles Café or the dining halls.\n\nA unique feature of the 20 Meal Plan is the meal equivalency. THIS IS NOT AVAILABLE WITH THE 5 or the 12 Meal Plan. Meal equivalencies are intended to provide more choice options for the 20 Meal Plan user, especially if all $75 dining dollars have been exhausted.\n\nA meal equivalency allows you to buy food in the Sayles Café by using one of your weekly meal plan meals. The 20 meal plan allows the use of 1 meal per week as a meal equivalency. If you use a meal equivalency in a given week, then you have 19 meals available to use in the dining halls. If you don’t use a meal equivalency in the Sayles Café in a given week, then you have 20 meals available in the dining halls. There is no carryover of meal equivalencies that don’t get used.\n\nAll first-year students are automatically assigned to this plan for the year, but may choose the 12 meal plan for winter and/or spring terms. Unused meals do not carry over to the next day, week, or term. Unused dining dollars are also not carried over from term-to-term.\n\nFurther information on the meal plans is available on the Dining Services site here: https://apps.carleton.edu/campus/dining_services/",1);
		housingItems.add(q);
		
		FaqItem r = new FaqItem("How are first year student room assignments determined?","Remember that Roommate Preference Questionnaire you completed? Residential Life staff read each and every Roommate Preference Questionnaire and match students based on responses to the questions on the form. They take into consideration your habits and patterns. Students are sorted based on the main issues that tend to cause conflicts in roommate situations (room cleanliness, noise/activity levels in the room, and bed times). Once students are put into those broad categories, we look at their academic and extracurricular interests and the other personal information they share. We work to put students together who have some overlapping interests, but who are not identitical matches. We believe that part of the learning that takes place at a residential college is meeting and living with people who are different from you. Because of this philosophy, we strive to not place people from the same state or schools in the same rooms. Siblings are not placed together as roommates and we try not to place siblings in the same buildings together. We typically don't honor roommate or specific dorm requests either. We also don't place athletes from the same team together as roommates. We believe that all of our communities are great places to live and that each student will have a fulfilling experience in the living environment that they are assigned to.\n\nIn mid July, you will receive an email from your class dean with the website address where you can find your room assignment and roommate(s). After your first year at Carleton, you will be able to select your own room and choose your roommate(s) via a housing selection process that occurs every spring. If for some reason during the year, you would like to petition for a room assignment change, talk to your hall director.",1);
		housingItems.add(r);
		
		FaqItem s = new FaqItem("Is there a place to store trunks, giant pieces of luggage, bikes and boxes?","Yes, Carleton has limited storage available. Storage tickets can be purchased from the Bookstore. Contact Custodial Services or your building custodian to make arrangements to get into the secure storage area. We recommend that you confirm with your home owner's policy will cover any valuable items left in the storage areas. Storage insurance is not provided by the College.\n\nCustodial Services manages storage in the residence halls. The Storage Policy (https://apps.carleton.edu/campus/facilities/policies/storage/) provides details about the types, size and cost of storage available. Student belongings remain in their rooms during the winter and spring breaks if they will be returning to campus the following term. Storage is available for students during the summer months, for those who will be on off campus study programs and for those who are taking extended leaves from campus.\n\nThere are also self-storage units in the Northfield area:\n\nGreenvale Mini-Storage, 507-645-2332\n\nNorthside Self Storage, 507-645-8814\n\nSelf Storage, 507-645-8888\n\nSouthgate Mini Storage, 507-645-4547",1);
		housingItems.add(s);
		
		FaqItem t = new FaqItem("Are there kitchens and lounges on each floor? What equipment do they have?","There is a kitchen and lounge area on every floor but one. The kitchens have a sink, stove/oven, microwave, and refrigerator. We do not provide any cooking utensils so you may want to have a few essentials in your room. Many floors have floor funds which they use to purchase kitchen supplies such as dish soap and baking pans. Students who use the facilities are expected to clean the kitchen. Caution: items left in a public kitchen may disappear.",1);
		housingItems.add(s);
		
		FaqItem u = new FaqItem("What are the differences between halls, larger houses, small houses?","There are differences in architecture, room size and type, privacy of bathrooms, student class years and meal plan options. Check out the Floor Plans (http://www.carleton.edu/student/housing/roomdraw/rooms.html) to learn more.",1);
		housingItems.add(u);
		
		FaqItem v = new FaqItem("What are quiet hours and when are they in effect?","The most common and potentially aggravating problem with hall life is excessive noise. Campus-wide quiet hours start in the evening (around 11 PM) and end in the early morning (9 AM). Stereos, radios, TVs, and human voices interfere with the need for sleep, study, and quiet. The privilege of playing a stereo or socializing ceases when it disturbs someone else. Cooperating fully with requests for quiet is expected.\n\nDuring finals week, residents are expected to observe 24 hour quiet hours in residential halls. You don't have to be completely silent, just respect the needs of others.",1);
		housingItems.add(v);
		
		FaqItem w = new FaqItem("Is cable TV available in the residence halls?","There is cable TV available in the TV lounges of the residence halls. Cable TV is not available to the individual student rooms in the residence halls. See the Conditions of Occupancy (http://apps.carleton.edu/student/housing/policies/?policy_id=21953) for more information on cable.",1);
		housingItems.add(w);
		
		FaqItem x = new FaqItem("Is there a housing contract?","The Conditions of Occupancy printed on the back side of the Room Condition Report is used in lieu of a housing contract at Carleton College. The Residential Policies (https://apps.carleton.edu/handbook/housing/) posted on these pages provide detailed information on all aspects of living in our residential halls and houses.",1);
		housingItems.add(x);
		
		FaqItem y = new FaqItem("Are pets allowed in the halls and houses?","Fish, yes. Dogs, cats, gerbils, birds, snakes, lizards, or any other animal unable to live in a small water-filled aquarium must stay home. You will want to keep in mind that you will be gone for six weeks over the winter break when selecting your fish and their tank.",1);
		housingItems.add(y);
		
		FaqItem z = new FaqItem("What is a substance free area?","The possession or use of alcohol, controlled substances and tobacco products by residents or their guests is prohibited in student rooms and public spaces in Substance Free Areas. If residents or their guests choose to use such substances outside of the Substance Free Area, the results of that choice must not have a negative impact upon residents or property upon return to the Substance Free Area. Residents are responsible for the behavior of their guests. Substance Free Areas are: Fourth Burton, Fourth Davis, Second Goodhue, Second Musser, Second Myers, Third Nourse, Rice House and Second Watson.",1);
		housingItems.add(z);
		
		FaqItem A = new FaqItem("May I look at my room during the summer?","Carleton College's halls and houses are actually occupied during the summer months by summer program participants. We are sorry but you'll need to wait it out with your fellow classmates until the residence halls officially open. You can take a look at the floor plans here: http://www.carleton.edu/student/housing/roomdraw/rooms.html for the rooms.",1);
		housingItems.add(A);
		
		FaqItem B = new FaqItem("Are the halls air conditioned?","All campus halls and houses have centrally-controlled heating since Minnesota can get quite cold in the winter. The residential buildings are not air conditioned during the academic year. We recommend that students bring a fan with them or purchase one at one of the local discount stores when they arrive.",1);
		housingItems.add(B);
		
		FaqItem C = new FaqItem("How big are the rooms/halls/houses? How many people live on a floor?","The halls and houses vary in size a great deal. Floor plans for all residence halls/houses show the general layout of each room and floor. Staff are currently working to provide measurements for all rooms on campus. Our floor plans will be updated when that information is available.",1);
		housingItems.add(C);
		
		FaqItem D = new FaqItem("What type of cleaning is provided in the residence halls and houses?","The residence hall public areas (lounges, hallways, kitchens and bathrooms) are cleaned daily (Monday through Friday). Private areas (apartments, private bathrooms, adjoining bathrooms, common areas of a private room) are the responsibility of the residents of the room. Only during winter, spring and summer breaks will Custodial staff do a thorough cleaning of the private and adjoining bathrooms in the residence halls and the bathrooms, kitchens and main living areas in the apartments. Custodial Services provides vacuums and other basic cleaning supplies for student use. We have noted on the floor plans if cleaning is done during the term. If limited cleaning is provided, Custodial staff clean the public areas of the houses on a bi-weekly, weekly or daily basis. Residents of the houses are responsible for keeping the houses clean. Questions or concerns regarding cleaning can be referred to the Maintenance and Custodial Office, Ext. 4133.",1);
		housingItems.add(D);
		
		FaqItem E = new FaqItem("Is smoking allowed in campus buildings or dorms?","Carleton is a smoke-free campus. Smoking is prohibited in all indoor spaces, including but not limited to: all classrooms, all residential living areas, lounges, bathrooms, vending areas, hallways, indoor athletic facilities, dining halls, and social spaces such as Sayles-Hill Great Space and the Cave. Smoking is also prohibited in private offices. Smoking is allowed outside in designated areas only.",1);
		housingItems.add(E);
		
		FaqItem F = new FaqItem("What is the \"housing freeze?\"","Although the Housing Freeze sounds like something related to cold months in Minnesota, it actually occurs during the first and last two weeks of each term. During the Housing Freeze no room changes can occur. The Freeze is designed to allow time to get settled into your room and get to know your roommate(s), to respect academic efforts at busy times of the term, and to give Residential Life staff members time to evaluate occupancy levels for the term.",1);
		housingItems.add(F);
		
		FaqItem G = new FaqItem("Can I host visitors in my dorm?","Of course you can host visitors. When inviting or hosting guests, please be considerate of your roommate(s) and floormates. Visitors are expected to follow the same guidelines as residents. We suggest that roommates discuss guidelines for their own rooms in terms of guests, activities, privacy, and study atmosphere. As with anything in this communal environment, study, rest, and privacy take precedence over visitation, guests, and recreation. Guests are not allowed to stay for more than three nights in a row.",1);
		housingItems.add(G);
		
		
	
		return housingItems; 
	}
	
	public ArrayList<FaqItem> getOneCardItems(){
		ArrayList<FaqItem> oneCardItems = new ArrayList<FaqItem>();
		
		FaqItem a = new FaqItem("What should I do if I lose my OneCard?", "Mark your OneCard LOST anytime day or night on the OneCard Dashboard here: https://apps.carleton.edu/campus/onecard/dashboard/.\n\nThis is an important step to take to freeze unauthorized use of the financial funds on your OneCard - Schillers, Dining Dollars and Meal Plans. You will be held responsible for financial transactions that occurred prior to marking your card lost on this web site.",1);
		oneCardItems.add(a);
		
		FaqItem b = new FaqItem("I'm a New Student. Can I get my OneCard over the summer?","New Students can get their OneCard after July 4.\n\nSee here: https://apps.carleton.edu/campus/onecard/get_onecard/ for more information",1);
		oneCardItems.add(b);
		
		FaqItem c = new FaqItem("Can I get a refund if I withdraw, graduate or leave the college?","Balances less than $20 will be forfeited.\n\nRefund requests are accepted when a student withdraws, or an employee terminates employment with the college. Refund checks are processed when:\n\n(1) the account balance is $20.00 or more AND\n\n(2) there are no outstanding student charges with the Business Office, AND,\n\n(3) a written request is submitted to Campus Services onecard@carleton.edu.\n\nGraduating seniors with a Schillers balance of $20.00 or more do not need to submit a written request and will be issued a refund check from the Business Office in July after graduation (minus any outstanding fees due the college).",1);
		oneCardItems.add(c);
		
		FaqItem d = new FaqItem("How do I check my account balance(s)?","OneCard Dashboard is the place to check your account balance(s) and recent transaction history. Also, receipts record balances as do the scrolling displays on self service locations like laundry, vending and copiers.\n\nOneCard Dashboard is found here: https://apps.carleton.edu/campus/onecard/dashboard/",1);
		oneCardItems.add(d);
		
		FaqItem e = new FaqItem("Must all students and employees have a OneCard?","OneCard serves as the official Carleton College form of identification for students and employees. Your legal name will be printed on your OneCard.\n\nAll Carleton students, excluding non-degree candidates, are issued a OneCard which serves as the official Carleton College form of identification. The OneCard is necessary for gaining access to residence halls, entry to dining halls for students with a meal plan or Dining Dollars, checking out library materials, cashing checks, the Rec Center, and attending certain special events. Students are encouraged to have their OneCard with them at all times.\n\nAll Carleton employees will be issued a OneCard. The OneCard is necessary for gaining access to certain buidlings, checking out library materials, cashing checks, and the Rec Center. Employees are encouraged to have their OneCard with them at all times.",1);
		oneCardItems.add(e);
		
		FaqItem f = new FaqItem("Why is my photo on my OneCard?","Your photo appears on your OneCard to prevent unauthorized or fraudulent use. It serves as your official Carleton College form of identification and will include your legal name.",1);
		oneCardItems.add(f);
		
		FaqItem g = new FaqItem("Can I withdraw funds from my Schillers account?","No, withdrawal of cash funds is not permitted from any OneCard account.  However, Schillers can be redeemed for purchases and services at numerous campus locations.",1);
		oneCardItems.add(g);
		
		FaqItem h =  new FaqItem("What does a replacement OneCard cost?","The cost of your first OneCard is covered by Campus Services.  The $10.00 fee for replacement cards goes towards the purchase of card stock, printer ribbons, card laminate, equipment, and general operation costs.  When a replacement OneCard is issued, a $10 replacement fee will be charged to your Schiller Account.",1);
		oneCardItems.add(h);
		
		FaqItem i = new FaqItem("Do Schillers carry over from year to year until a student graduates?","Yes, Schiller account funds automatically carry over from year to year for students and employees.  Refer to Schillers Terms & Conditions here: https://apps.carleton.edu/campus/onecard/terms/ for refunds for graduating seniors.",1);
		oneCardItems.add(i);
		
		FaqItem j = new FaqItem("How many Schillers should I pre-purchase?","A student may need between $400 and $1000 Schillers per term, or $40 to $100 Schillers per week while on campus if they want to take advantage of the convenience that OneCard offers.\n\nYou will have to decide for yourself. Some classes require more books than others, some students do laundry more frequently than others, etc. Listed below are factors to consider when determining how many Schillers to pre-purchase:\n\nLaundry: $20-$40 Schillers a term\nTextbooks and supplies: $350-$700 Schillers a term\nFood money beyond Meal Plans and Dining Dollars: $125-$250 Schillers a term\nCopies, Postage, Vending, Student Health and Counseling misc.: $5 - $20 a term",1);
		oneCardItems.add(j);
		
		
		return oneCardItems; 
	}

	public ArrayList<FaqItem> getPostOfficeItems(){
		ArrayList<FaqItem> postOfficeItems = new ArrayList<FaqItem>(); 
		
		FaqItem a = new FaqItem("Where is my student mail box located?","Student mail boxes are located outside of the Campus Post Office in the Sayles-Hill lobby.\n\nAn alphabetical list of assigned student mail boxes is posted outside of the Campus Post Office.\nNever send cash in the mail.  Student mail boxes are unlocked and open to the lobby.",1);
		postOfficeItems.add(a); 
		
		FaqItem b = new FaqItem("How should I ship my personal belongings to Carleton?", "During Summer and Winter breaks we forward mail and parcels home for students until about two weeks before the next term starts. If you want something to arrive before that, and stay at Carleton, please contact us and mark the parcel as \"HOLD FOR NEXT TERM.\"\n\nPack bed linens in your suitcase if your arrival time does not match up with Campus Post Office service hours.\n\nDo not ship any box larger or heavier than you can carry comfortably to your room. \n\nBoxes should be firmly packed with cushioning around items and reinforced with packing tape. \n\nE-mail notifications will be sent the day parcels arrive, and are ready for pickup at the Post Office. An alphabetical list of assigned student mail boxes is posted in the lobby outside of the Campus Post Office.\n\nCarleton College cannot assume responsibility for items stolen or damaged during shipment or while in storage.  Items lost or stolen after arrival at Carleton are the responsibility of the student, not the College.",1);
		postOfficeItems.add(b); 
		
		FaqItem c = new FaqItem("How do I retrieve my packages at Carleton?","A parcel notification e-mail will be sent to your @carleton.edu address once a parcel is ready for pickup.\n\nPhoto I.D. is required for package pick up.\n\nAn alphabetical list of assigned student mail boxes is posted outside of the Campus Post Office located in the lobby of Sayles-Hill.\n\n\nYou will have to transport your own boxes from the Campus Post Office or a temporary storage location to your housing.\n\nDo not send boxes larger/heavier than you can carry across campus.",1);
		postOfficeItems.add(c);
		
		FaqItem d = new FaqItem("Is Photo I.D. required for package pick up?", "Yes - bring your OneCard, Driver's License, or Passport for identification purposes.",1);
		postOfficeItems.add(d);
		
		FaqItem e = new FaqItem("When is the Campus Post Office open?","View Campus Post Office service hours here: https://apps.carleton.edu/campus/postoffice/contact/,",1);
		postOfficeItems.add(e); 
		
		FaqItem f = new FaqItem("What is my student mail/ship to address?","The address for all students at Carleton is:\n\nFull Name\n300 North College Street\nNorthfield, MN  55057\n\nBox numbers should not be included, as they change every term.",1);
		postOfficeItems.add(f);
		
		FaqItem g = new FaqItem("How do I ship my bicycle to Carleton?", "Check with a bike shop near your home. Some bike shops will package a bike for shipping for a fee.\n\nUPS will ship a bicycle that is already properly packaged.\n\nCheck out the helpful instructions offered at this web site: http://www.bikeflights.com/how_to_pack_a_bike.aspx",1);
		postOfficeItems.add(g); 
		

		return postOfficeItems; 
	}
	
	public ArrayList<FaqItem> getSHACItems(){
		ArrayList<FaqItem> shacItems = new ArrayList<FaqItem>(); 
		
		FaqItem a = new FaqItem("Where can I find information about alcohol and other drug resources?", "Student Health and Counseling provides students with alcohol and drug assessment, treatment referrals and education about alcohol and other related drugs.\n\nFor additional policy information, please refer to Carleton\'s alcohol and drug policy here: https://apps.carleton.edu/campus/dos/handbook/policies/primary/?policy_id=21793",1);
		shacItems.add(a); 
		
		FaqItem b = new FaqItem("Is there a peer I can talk to regarding health and wellness questions?","Yes. The Student Wellness Advocates (SWAs) facilitate health-related workshops and encourage Carleton students to lead healthy and balanced lives. SWAs also connect students with other peer leaders and make referrals to support staff on campus.",1);
		shacItems.add(b);
		
		FaqItem c = new FaqItem("Does Carleton College offer an insurance plan that I can purchase?", "Yes.  Information about waiving or enrolling in the Student Illness and Accident Insurance is available on the Business Office website here: https://apps.carleton.edu/campus/business/students/healthinsurance/",1);
		shacItems.add(c);
		
		FaqItem d = new FaqItem("What immunizations are required for admission to Carleton College?", "Information about requirements for incoming students is available on the Student Health and Counseling website.\n\nTo be compliant with Minnesota State Law, all incoming Carleton students are REQUIRED to:\n\nSubmit dates of immunization against measles, mumps and rubella (MMR), for which you will need evidence of 2 doses.\n\nSubmit dates of immunization against tetanus and diphtheria (Tdap preferred, Td also acceptable); must have been received after September 1, 2002.\n\nComplete the online Tuberculosis (TB) Risk Assessment form. If you answer \"Yes\" to any of the Risk Assessment questions, you\'ll need to visit your health care provider to fill out the TB Clinical Documentation Form and submit hardcopy results of a Mantoux (PPD) skin test or IGRA blood test performed after March 15, 2012.",1);
		shacItems.add(d); 
		
		FaqItem e = new FaqItem("I see a medical provider for chronic ongoing health condition. Can I continue care at Student Health and Counseling?", "We recommend that students with chronic health conditions make an appointment at the Allina Medical Clinic (507-663-9000) or the Family Health Medical Clinic (507-646-1494) to establish ongoing care. Conditions warranting this include: Diabetes, Crohn’s Disease, unstable asthma, ongoing orthopedic care, etc. ",1);
		shacItems.add(e); 
		
		FaqItem f = new FaqItem("Are there fees to see health care providers at Student Health and Counseling?", "No.  There is no charge for office visits with a medical provider in Student Health and Counseling (SHAC).  However, there are some related fees, which are outlined on the SHAC website.",1);
		shacItems.add(f);
		
		FaqItem g = new FaqItem("Are there 24 hour emergency services available to Carleton students?", "There are no after-hour medical services provided through Student Health and Counseling (SHAC). Students may seek evening or weekend care at Allina Medical Clinic or at the Northfield Hospital. Carleton Security Services personnel are trained as medical First Responders and will assist with student emergencies 24 hours a day, and refer to ambulance or emergency room services as necessary.\n\nThere is a psychologist on-call 24 hours a day when the academic term is in session to address psychological emergencies that occur after business hours.Please visit SHACs After-Hours/Emergency information website here: https://apps.carleton.edu/studenthealth/afterhours/ for more information.",1);
		shacItems.add(g);
		
		FaqItem h = new FaqItem("I anticipate needing on-going counseling for a psychological concern. Can I work with a psychologist at Student Health and Counseling?", "Student Health and Counseling (SHAC) offers short-term individual and group counseling services to enrolled Carleton students. Counselors will meet with students needing longer-term care to help them find appropriate referrals in the community. Student Health and Counseling also provides the services of a psychiatrist whom students may see free of charge, upon referral from another SHAC staff member. Students who anticipate needing long-term counseling or who begin Carleton with a history of serious mental health concerns (chronic depression or anxiety, bipolar disorder, etc.) should consider establishing care with a local Northfield psychological provider. SHAC can help provide appropriate referrals to community providers.",1);
		shacItems.add(h);
		
		FaqItem i = new FaqItem("I need to receive allergy shots while I am at Carleton. Can I get them at Student Health and Counseling?", "No. Student Health and Counseling does not offer allergy shot services. You can get your allergy injections at the Allina Medical Clinic  (507-663-9000) or Family Health Medical Clinic (507-646-1494)",1);
		shacItems.add(i);
		
		FaqItem j = new FaqItem("Where do I go if I have a disability and need accommodations?", "All students with disabilities must register with Disability Services for Students (https://apps.carleton.edu/campus/wellness/Disability_Services_For_Students/) before accommodations can be granted. Proper documentation is required. Disability Services for Students is housed the lower level of Davis Hall (near Student Health and Counseling) and can be reached at 507-222-4080. For further information please view the Academic Accommodations page of our website here: https://apps.carleton.edu/campus/wellness/Disability_Services_For_Students/",1);
		shacItems.add(j); 
		
		FaqItem k = new FaqItem("What services are available at Student Health and Counseling?", "Please see the Student Health and Counseling website here: http://www.carleton.edu/campus/wellness/ for a full description of the medical and counseling services available.",1);
		shacItems.add(k); 
		
		FaqItem l = new FaqItem("Can I use Student Health and Counseling if I don’t purchase the Carleton sponsored insurance plan?", "Yes, but please note that health services beyond general diagnosis of illness and treatment of minor accidents provided by Student Health and Counseling are not included in the comprehensive fee of the College. Labs, x-rays, office visits and specialist referrals at the local health clinics/hospital are billed to your insurance company, or must be paid out of pocket. Many home-based HMO plans do not provide adequate coverage outside of your home area. Also, if you are considering study abroad options, these may not be covered under your current policy. We encourage you to review your current health insurance policy to verify that you are adequately covered while you pursue your academic interests at Carleton and abroad.",1);
		shacItems.add(l);
		
		FaqItem m = new FaqItem("What do I do if I need prescription medicines while I am at Carleton?", " You can fill your prescription medicines before coming to Carleton at your home pharmacy.\n\n· You can have your health care provider write a prescription that you can fill at local Northfield Pharmacies\n\n· You can make an appointment with one of the Nurse Practitioners at Student Health and Counseling to review your prescription needs.\n\n· If you are on Adderall or other meds for ADHD you need to make an appointment with one of Student Health and Counseling staff members who can clear you to meet with our staff Psychiatrist. He will review your case and write prescriptions to be filled in Northfield. We request that you have your home provider send us dictation regarding your diagnosis/progress and treatment program before you make an appointment at Student Health and Counseling. Fax to: 507-222-5038. We find this very helpful with your care.",1);
		shacItems.add(m); 
		
		
		
		return shacItems; 
	}
	
	public ArrayList<FaqItem> getAdvisingItems(){
		ArrayList<FaqItem> advisingItems = new ArrayList<FaqItem>(); 
		
		FaqItem a = new FaqItem("What do I need to know about Priority Registration?", "Carleton students register in priority order. That means that for most courses, seniors register first and first-year students register last. However, for courses designated “sophomore priority,” sophomores register first, then first-year students, then seniors, and lastly juniors. Within each class, students register three times a year and are assigned three registration priority numbers, one for each trimester. Each student’s numbers add up to 42.\n\nPractically speaking, this means you can’t always get into a course you want during the term you want to take it. When you have a “good” registration number, use it! You’ll soon learn which classes fill up quickly. If you have questions, your Liberal Arts Adviser, Resident Assistant (RA), or a student departmental adviser (SDA) can help you figure out how to strategize. Do keep in mind though that not all courses are offered every term.",1);
		advisingItems.add(a); 
		
		FaqItem b = new FaqItem("What is the purpose of academic advising?", "Academic advising is an educational process intended to aid students in making decisions about their Carleton academic careers and lifelong career choices. Academic advisers for First- and Second-Year students are called \"Liberal Arts Advisers\" (whereas advisers for Juniors and Seniors are called \"Major Advisers\").  Liberal Arts Advisers coordinate course selection, discuss educational and career goals, and encourage students to consider questions of personal growth. Advisers also aid in planning academic programs and in referring students to other campus services. Students are responsible for pursuing this process as they deem appropriate for their needs; effective advising is only possible when communication yields an exchange of ideas.\n\nFirst- and second-year Liberal Arts Advisers are assigned generally; that is, a student thinking of majoring in studio art might have a mathematician as an adviser, or an aspiring chemist may be advised by an English professor. This is not a problem. In addition to your Liberal Arts Adviser, department chairs are available to meet with students during New Student Week and throughout the year. RAs, New Student Week Leaders (NSWLs), and Student Department Assistants (SDAs) are also available during New Student Week and beyond. You will also have a chance to attend an Academic Fair during your first week on campus to meet with faculty and student representatives from various departments.",1);
		advisingItems.add(b);
		
		FaqItem c = new FaqItem("O.K. So I'll take three courses my first term. How do I know which ones to take?", "All students must pre-register online for one Argument and Inquiry Seminar, specially designed for first-year students. In order to enroll in one, you can find the link on the New Student Checklist on the New Student Website.  Or through Course Navigator (see the New Student Website, under Registration, at http://go.carleton.edu/new). \n\nAlmost all students who have not fulfilled the language requirement enroll in a language class sometime during their first year. If you place into Spanish 103, for instance, you'll wait until spring term to enroll. If you decide to start Japanese, you'll want to enroll your first term.\n\nWhat else? All departments have courses designed for incoming students. For complete course descriptions, see the academic catalog.\n\nYou will meet with your adviser during New Student Week and have a chance to drop/add courses you have registered for before classes begin.",1);
		advisingItems.add(c);
		
		FaqItem d = new FaqItem("Will I have an adviser to help me register?", "You will be assigned a Liberal Arts Adviser after summer registration, but before you arrive on campus. To advise you over the summer we have a number of staff and students to help you -- their numbers are listed on your New Student Checklist, which was in Mailing #1.  In addition, the Course Navigator on the New Students site will help you organize your registration decision-making process.",1);
		advisingItems.add(d);
		
		FaqItem e = new FaqItem("What is a Curricular Exploration requirement?", "Curricular Exploration requirements require you to take 36 credits in six different areas.  The specifics of this will be available in the Academic Catalog, but you needn’t worry about these requirements too much at first: no matter what you take your first term, you will inevitably be fulfilling some requirements.\n\nGlobal Understanding requirements require you to take six credits in a course that deal with International Studies and six credits in a course that deals in Intercultural Domestic Studies as well as earn proficiency in a language other than English.\n\nQuantitative Reasoning requires three courses designated as a \"Quantitatively Rich Encounter.\"\n\nWriting requirements require you to take a first-year \"Argument and Inquiry\" seminar, an additional six credit writing course, and submit a revised writing portfolio the spring of your sophomore year.\n\nPhysical Education requirements require you to take four terms of physical education, all of which can be fulfilled by participating in approved club sports.",1);
		advisingItems.add(e);
		
		FaqItem f = new FaqItem("What do those letters at the end of course descriptions mean?", "Requirement Codes as indicated on each course description or in schedule of courses\n\nAI = Argument and Inquiry Seminar (6 credits required)\nARP = Arts Practice (6 credits required)\nFSR = Formal or Statistical Reasoning (6 credits required)\nHI = Humanistic Inquiry (6 credits required)\nIDS = Intercultural Domestic Studies (6 credits required)\nIS = International Studies (6 credits required)\nLA = Literary/Artistic Analysis (6 credits required)\nLP = Language Proficiency, in a language other than English\nLS = Science with Lab (6 credits required)\nNE=No Exploration Credit\nPE=Physical Education. (Four terms of physical education, all of which can be fulfilled by participation in approved club sports)\nQRE = Quantitative Reasoning Encounter (3 courses required)\nSI = Social Inquiry (6 credits required)\nWR1=Designates the Writing Component of an AI Seminar\nWR2 = Second Writing Rich Course (6 credits required)",1);
		advisingItems.add(f); 
		
		FaqItem g = new FaqItem("Do I have to take the placement tests?","Certain SAT II scores may exempt you from some placement tests. For specifics on other placement tests, view the Placement Testing information on the New Students site and Carleton’s Prior Credits Policy on the Registrar's web site.",1);
		advisingItems.add(g); 
		
		FaqItem h = new FaqItem("Where do I get my books?","You will be able to purchase textbooks, manuals, and all necessary materials at The Carleton Bookstore located in the Sayles-Hill Campus Center. Most instructors hand out a list of required texts the first day of class; the bookstore also has a complete listing of required and recommended texts for each course. Once you’ve registered, you can order or look up the textbooks for your classes on the bookstore website: www.carletonbookstore.com. Just follow the textbook links. You can also call the bookstore with questions at 1-800-799-4148 or email them at bookstore@carleton.edu. If your placement in certain courses (e.g., foreign language) will not be definite until early in the term, it is advisable to delay purchase of these textbooks until exact placement and registration are confirmed.",1);
		advisingItems.add(h); 
		
		FaqItem i = new FaqItem("What has to be done to fulfill the writing requirement?", "Carleton's writing requirement has three components. First, you must successfully pass an argument and inquiry seminar - a writing rich course. Second, you must turn in a portfolio by the middle of your sixth term at Carleton. Information on the portfolio can be found at Carleton's Writing Program web site. You will also be receiving an actual portfolio when you arrive on campus. Third, you must complete another writing rich course sometime before you graduate. All writing rich courses are designated by a WR2 and are offered in most departments.",1);
		advisingItems.add(i); 
		
		FaqItem j = new FaqItem("What is \"scrunch\"?", "\"Scrunch\" refers to Carleton's Satisfactory/ Credit/No Credit (S/Cr/NC) grading option.",1);
		advisingItems.add(j);
		
		FaqItem k = new FaqItem("How do I know what courses are available?", "Consult the Registrar's office website at: www.carleton.edu/campus/registrar/schedule.html.", 1);
		advisingItems.add(k);
		
		FaqItem l = new FaqItem("What are the departmental policies on AP scores and placement?", "See the Prior Credits Policy on the Registrar’s web site.", 1);
		advisingItems.add(l);
		
		FaqItem m = new FaqItem("What should I do to prepare for placement tests?", "The purpose of the placement tests is to make sure you get into the right course for you. Cramming for them is not going to be useful -- to you or to us. Reviewing a subject you probably haven't looked at for three months, though, is a good idea.",1);
		advisingItems.add(m);
		
		FaqItem n = new FaqItem("When do Carleton students declare a major? If I already know what I want to major in, can I declare a major early?", "Carleton students declare majors spring term of their sophomore year. Students cannot declare earlier. Why not? We expect you will spend at least part of your first two years exploring the different fields of study that are part of a liberal arts curriculum. It’s amazing how often interests change on encounter with different subjects at the college level! We really want first-year students to strive for variety and exploration in all the distribution groups. We know, though, that some students enter college already planning to major in a certain field, while others have narrowed the possibilities. If you think you know what you want to major in, check the department web site to see if the department you are considering has suggested particular courses or sequences appropriate for first-year study.",1);
		advisingItems.add(n);
		
		FaqItem o = new FaqItem("Are courses at St. Olaf available to me?", "Yes. By special arrangement and if space is available, students may take courses at St. Olaf College which are not offered at Carleton. These courses count as part of the total credit load for the term. Contact the Registrar's Office for more information.",1);
		advisingItems.add(o);
		
		FaqItem p = new FaqItem("What do I need to know about the 3-3 calendar?", "You may have already noticed unusual features of Carleton's calendar. In some ways, it resembles the quarter calendar some of your friends or siblings may be on, but there are significant differences. Our academic year is divided into three terms—roughly ten weeks in length—with the school year running from early September to early June. Students generally enroll in only three six-credit courses each term (credits for participating in music and drama activities are extra). You register three times a year, changing courses each term after talking with your adviser.\n\nWhat does this mean in practical terms? For one thing, while students at semester schools have to fit their course work into eight terms over four years, Carleton students have twelve terms. A student planning to major in chemistry at a semester school probably needs to start chemistry the first term of the first year—the second semester at the latest—or the student will run into trouble fitting in all the requirements. Because you have twelve terms at Carleton, you can enter a major a bit later; in fact, Carleton students don't declare majors until the end of the sophomore year. As a result, Carleton professors recommend you spend some of your first year trying out new subjects.",1);
		advisingItems.add(p);
		
		FaqItem q = new FaqItem("What is a concentration?", "Students may elect to complete one of Carleton’s 16 concentrations in addition to a major. A concentration is an integrated interdisciplinary program that may strengthen and complement a major, but a student majoring in any department could potentially participate in any concentration. Concentrations bridge the boundaries of academic disciplines, promote communities of learning, and relate academic studies to the kinds of issues and opportunities students confront outside of Carleton.",1);
		advisingItems.add(q); 
		
		return advisingItems; 
	}
	
	public ArrayList<FaqItem> getITSItems(){
		ArrayList<FaqItem> itsItems = new ArrayList<FaqItem>(); 
		
		FaqItem a = new FaqItem("What kind of computer should I bring to Carleton?", "We don't make any recommendations with regard to PCs or Macs -- whichever you prefer is fine. It is important, however, that you bring a computer that's new enough to work on our network and run the applications you'll need to do your work.",1);
		itsItems.add(a);
		
		return itsItems;
	}
	
	public ArrayList<FaqItem> getLanguageItems(){
		ArrayList<FaqItem> languageItems = new ArrayList<FaqItem>(); 
		
		FaqItem a = new FaqItem("How do I fulfill the language requirement?", "You may meet the language requirement in four different ways:\n\n1. by testing out with an appropriate score in the CEEB Advanced Placement, Achievement examination, International Baccalaureate examination, or in another standardized examination selected by the faculty of a particular language in consultation with the Associate Dean of the College; or\n\n2. by satisfactory completion (grade of S, C- or better) of a language course numbered 204 (205 in the case of Japanese and Chinese); or\n\n3. by passing a proficiency examination designed or selected by the faculty of the particular language in consultation with the Associate Dean of the College; or\n\n4. in the case of fluent speakers of languages not taught at Carleton, by passing a special examination prepared by an expert.",1);
		languageItems.add(a); 
		
		FaqItem b = new FaqItem("Can I major in a language?", "Regular majors are available in French: Literature, French: Cultural Studies, Greek, German, Latin, Russian and Spanish. Special majors in Chinese, Japanese or Romance Languages are available by petition. Majors are also available in Classical Languages, Classical Studies, and Latin American Studies.",1);
		languageItems.add(b); 
		
		FaqItem c = new FaqItem("How do I know what level to register for?", "Take the placement test here: https://apps.carleton.edu/curricular/languageplacement/",1);
		languageItems.add(c);
		
		FaqItem d = new FaqItem("When should I start language study at Carleton?", "Whether you are continuing a language you studied in high school or are starting a new language, we encourage you to register for language in the first year. Beginning Greek and Latin are offered in the winter. All other languages begin in the fall term only.",1);
		languageItems.add(d); 
		
		FaqItem e = new FaqItem("Can I minor in a language?", "Students who fulfill requirements for advanced coursework beyond the language requirement receive a “Certificate of Advanced Study,” which is comparable to a minor at most other institutions.",1);
		languageItems.add(e);
		
		FaqItem f = new FaqItem("What opportunities will I have to practice my language outside of the classroom?", "All language departments offer a variety of extra-curricular activities, including language tables, film screenings and special events. Parish House is a dorm open to upper class students interested in practicing their languages and participating in international programming. Each year, Carleton hosts 6-7 “language associates,” native speakers of various languages who live in Parish House, coordinate extra-curricular activities and assist the language faculty.",1);
		languageItems.add(f); 
		
		FaqItem g = new FaqItem("Why does Carleton have a language requirement?", "As a liberal arts college, Carleton challenges its students to study broadly as well as deeply, and to gain a larger understanding of the world they live in. In addition to the primary benefits that foreign language competency can offer (including basic communication, the ability to read foreign texts, and interaction with those of a different culture), learning another language offers a unique perspective on other cultures and worldviews.",1);
		languageItems.add(g);
		
		FaqItem h = new FaqItem("What language should I take?", "If you have already achieved some degree of proficiency in a language and are excited about continuing, take the placement test and plan to enroll in the appropriate course.\n\nIf you are not excited about continuing the language you studied in high school, consider starting a new language; many Carleton students fulfill the requirement in a language they have not previously studied. This is especially true for languages not commonly taught in high schools, including Arabic, Chinese, Japanese, Russian, Hebrew and Ancient Greek.",1);
		languageItems.add(h);
		
		FaqItem i = new FaqItem("What languages are offered at Carleton?", "Currently Carleton offers instruction in ten languages: Arabic, Chinese, French, German, Greek, Hebrew, Japanese, Latin, Russian, and Spanish. Norwegian can be taken through special arrangement with St. Olaf College.",1);
		languageItems.add(i); 
		
		FaqItem j = new FaqItem("I've placed out of the language requirement. Now what?", "Keep going! Some courses numbered in the 200s offer advanced work in conversation and composition; others introduce literature organized around a particular theme. Except where noted, these courses are open to first-year students with the necessary background.",1);
		languageItems.add(j); 
		
		FaqItem k = new FaqItem("What are the benefits of language proficiency?", "Career Goals:\n\nSome jobs require knowledge of a foreign language, but many more present additional opportunities to multilingual applicants. Carleton graduates have used their language skills in any number of careers, including social work, medicine, law, international business, community organizing, foreign service, journalism, hospitality, education, the military, volunteer service, law enforcement and many others.\n\nTravel:\n\nStudy or travel in a foreign country can be an incredibly rewarding and enriching experience. Off-campus seminars led by Carleton faculty are available in Chinese, French, German, Russian and Spanish. Carleton students may also enroll in programs offered by other institutions or by consortia of which Carleton is a member. A number of competitive Carleton fellowships provide additional opportunities for internships, research or service learning abroad.\n\nInterest in the literature, history, politics, or culture:\n\nObviously, advanced study of the literature, history, politics or culture of a particular country or region requires proficiency in a language. Students are often surprised to learn that many graduate programs, especially in the humanities, require a reading knowledge of French, German or other languages, no matter what their area of specialization.\n\nLocal immigrant populations:\n\nNearly 1 in 5 Americans speaks a language other than English at home. Spanish is the most common, followed by Chinese, French, German, Tagalog, Vietnamese, Italian, Korean, Russian and Polish. [Source: 2000 Census] Knowing another language can give you access to the cultural riches of immigrant communities, while opening up opportunities in business and volunteer service.\n\nFamily background:\n\nLearning the language of your forebears can open lines of communication with non-English-speaking relatives, while deepening your understanding of your family’s roots.\n\nSharpening intellectual skills:\n\nLearning a second language helps improve memory, critical thinking and study skills. Many students find that the discipline and sustained effort required to learn a language help them succeed in other academic endeavors.",1);
		languageItems.add(k);
		
		FaqItem l = new FaqItem("I'm bad at learning languages. What do I do?", "Whether a result of variable experiences in high school or natural talents, all students have academic strengths and weaknesses. Free one-on-one tutoring is available for all levels of language study.\n\nStudents who have a documented learning disability that interferes with their ability to learn a language should visit the Dean of the College website for information about the language exemption process.",1);
		languageItems.add(l);
		
		
		return languageItems; 
	}
	
	public ArrayList<FaqItem> getPrintItems(){
		ArrayList<FaqItem> printItems = new ArrayList<FaqItem>();
		
		FaqItem a = new FaqItem("How do I establish my account for Personal print jobs?", "Set up your Personal account here: https://www.printservices.carleton.edu/shop/.  Payment is due upon pick up (cash, check, Schillers or Ole Dollars).  This account is subject to MN sales tax.  Non-profit organizations must provide proof of sales tax exemption.",1);
		printItems.add(a); 
		
		return printItems; 
	}
	
	public ArrayList<FaqItem> getDisItems(){
		ArrayList<FaqItem> disItems= new ArrayList<FaqItem>();
		
		FaqItem a = new FaqItem("How do I upload documents to Firefly?", "Firefly can only read .kes and .txt files. If the document you wish to upload is in some other format, first open the file in Kurzweil and save it as a .kes file.\n\nNext, log in to Firefly. On your home screen, choose either your Private or Public folder. Documents uploaded to the Public folder will be visible to all Carleton Firefly users, while documents uploaded to your Private folder will be visible only to you.\n\nFinally, click the orange “Upload A File” button. Select the .kes file, and click “Open” to begin the upload.",1);
		disItems.add(a); 
		
		FaqItem b = new FaqItem("Can I read a document from an online folder in 'regular' Kurzweil?", "Yes! If you put a file in your private or public folder in Firefly, that file will also be available through desktop Kurzweil. In addition, you can access files placed in other folders in the Universal Library through Kurzweil.\n\nPC:\n\nTo access files saved in Firefly folders through Kurzweil, select File, “Open From Library.” A pop-up window will appear showing all accessible Firefly folders. Use this to navigate to the file you wish to open in Kurzweil.\n\nMac:\n\nIn the Mac version of Kurzweil, select the File menu, then “Open From Universal Library.” A pop-up window will appear showing all accessible Firefly folders. Use this to navigate to the file you wish to open in Kurzweil.",1);
		disItems.add(b); 
		
		FaqItem c = new FaqItem("What are the advantages/disadvantages of using Firefly?", "Advantages:\n\nFirefly can be accessed anywhere with a web browser and an internet connection. This makes it a potentially more convenient and portable tool than Kurzweil.\nThe reading voices in Firefly are, as a whole, superior to those in the Mac version of Kurzweil.\nFirefly is comparable to Kurzweil (both Windows and Mac versions) in its ability to translate text. Unlike Mac Kurzweil, Firefly can also intelligibly read text in Spanish.\n\nDisadvantages:\n\nFirefly is not a text editor, and it has limited annotation capabilities (Firefly only supports text highlighting).\nFirefly can only read .kes files. If you wish to upload a file of a different format, you must first create a .kes file using Kurzweil.\nAs an online tool, Firefly is slightly slower than Kurzweil – it takes Firefly a moment to load text and move between pages.",1);
		disItems.add(c); 
		
		FaqItem d = new FaqItem("How do I change the reading voice?", "The reading voice can be changed under the “Options” menu in the toolbar. We personally recommend Paul.\n\nNote: Violeta is intended to be used only when reading documents in Spanish.",1);
		disItems.add(d); 
		
		FaqItem e = new FaqItem("Which browsers support Firefly?", "Firefly can be used in Chrome, Firefox, Safari, and Internet Explorer.",1);
		disItems.add(e); 
		
		FaqItem f = new FaqItem("Can I stop Firefly from reading headers/footers?", "There is no tool within Firefly to block headers, footers, and other extraneous text from being read. However, previous changes made to the .kes file in Kurzweil will carry over to Firefly.\n\nWhen first creating the .kes file in Kurzweil, reading zones can be edited as described here. Zones which are deleted in this way will not be read aloud in Firefly.",1);
		disItems.add(f); 
		
		FaqItem g = new FaqItem("Can Firefly read/translate text in other languages?", "In order to translate text, highlight the passage you want translated. Click the “Translation” button in the top right-hand corner of your screen and choose the desired language from the drop-down menu. Firefly can translate to and from:\n\nEnglish\nSpanish\nFrench\nGerman\nItalian\nPortuguese\nFinnish\n\nWhile the text translations seem accurate, only Spanish can be read proficiently by Firefly. If translating text into languages other than Spanish, we recommend using the desktop PC version of Kurzweil, which can both translate and read foreign languages much more fluently.",1);
		disItems.add(g); 
		
		return disItems; 
	}
	
	
	
}
