package in.silive.proxy;

import android.app.Dialog;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EditProfile extends Fragment{
	
	Button  set_exam_date, alarm_save, exam_save, back, set_name, name_save, set_alarm;
	EditText fname, lname, alarm_hr, alarm_min, exam_day, exam_month, exam_year;
	//String first_name, last_name, alarm_hour, alarm_minutes, start_d, start_m, start_y, exam_d, exam_m, exam_y;
	Dialog SetDate, SetName, SetAlarm;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
			

		
	
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View editprofilefrag=inflater.inflate(R.layout.edit_profile, null);
		
		return editprofilefrag;
	
	
	
		
	
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	
		
		fname=(EditText)getView().findViewById(R.id.fname1);
		lname=(EditText)getView().findViewById(R.id.lname1);
		exam_day=(EditText)getView().findViewById(R.id.exam_day);
		exam_month=(EditText)getView().findViewById(R.id.exam_month);
		exam_year=(EditText)getView().findViewById(R.id.exam_year);
		alarm_hr=(EditText) getView().findViewById(R.id.alarm_hr1);
		alarm_min=(EditText) getView().findViewById(R.id.alarm_min);
		
		
		set_exam_date=(Button)getView().findViewById(R.id.button5_2);
		set_name=(Button)getView().findViewById(R.id.button5_1);
		set_alarm=(Button)getView().findViewById(R.id.button5_3);
		back=(Button)getView().findViewById(R.id.button5_4);
		
		exam_save=(Button)getView().findViewById(R.id.exam_date_button1);
		name_save=(Button)getView().findViewById(R.id.save_name1);
		alarm_save=(Button)getView().findViewById(R.id.save_alarm1);
		
		
		
		// set on click listener for exam date date button
				set_exam_date.setOnClickListener(new View.OnClickListener() {
					
					String exam_d, exam_m, exam_y;
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						SetDate = new Dialog(getActivity());
				        SetDate.setContentView(R.layout.exam_date);
				        SetDate.setTitle("Enter Next Exam Date");
				        exam_day= (EditText)SetDate.findViewById(R.id.exam_day);
				        exam_month= (EditText)SetDate.findViewById(R.id.exam_month);
				        exam_year= (EditText)SetDate.findViewById(R.id.exam_year);
				        exam_save = (Button)SetDate.findViewById(R.id.exam_date_button1);
						
				        // set on click listener for save button in sem start date dialog
				        
				        exam_save.setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View arg1) {
								// TODO Auto-generated method stub
								
					            
						        exam_d=exam_day.getText().toString();
						        exam_m=exam_month.getText().toString();
						        exam_y=exam_year.getText().toString();
					            
								
					             //SharedPreferences.Editor edit = pref1.edit();
					             
					             //Storing Data using SharedPreferences
					            
					             //edit.putString("Start Day", start_d);
					             //edit.putString("Start Month", start_m);
					             //edit.putString("Start Year", start_y);
					             //edit.commit();
					             
					             // dismissing dialog
					             
					             SetDate.dismiss();
								
							}
						});
				        
				        // showing exam date dialog
				        
				        SetDate.show();
				        
					}
					}); 
				
				
				// set on click listener for set name button
				set_name.setOnClickListener(new View.OnClickListener() {
					
					String f_name, l_name;
					
					
					@Override
					public void onClick(View arg2) {
						// TODO Auto-generated method stub
						SetName = new Dialog(getActivity());
				        SetName.setContentView(R.layout.set_name);
				        SetName.setTitle("Enter Your Name");
				        fname= (EditText)SetName.findViewById(R.id.fname1);
				        lname= (EditText)SetName.findViewById(R.id.lname1);
				        
				        // set on click listener for save button in set name dialog
				        
				        name_save.setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO Auto-generated method stub
								
					            
						        f_name=fname.getText().toString();
						        l_name=lname.getText().toString();
						        
						        
					            
								
					             //SharedPreferences.Editor edit = pref1.edit();
					             
					             //Storing Data using SharedPreferences
					            
					             //edit.putString("Start Day", start_d);
					             //edit.putString("Start Month", start_m);
					             //edit.putString("Start Year", start_y);
					             //edit.commit();
					             
					             // dismissing dialog
					             
					             SetName.dismiss();
								
							}
						});
				        
				        // showing set name dialog
				        
				        SetName.show();
				        
					}
					});
		
				// set on click listener for set name button
				set_alarm.setOnClickListener(new View.OnClickListener() {
					
					String hour, min;
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						SetAlarm= new Dialog(getActivity());
				        SetAlarm.setContentView(R.layout.set_alarm);
				        SetAlarm.setTitle("Enter Notification Time");
				     alarm_hr= (EditText)SetAlarm.findViewById(R.id.alarm_hr1);
				        
				        alarm_min =(EditText)SetAlarm.findViewById(R.id.alarm_min1);
				        
				        // set on click listener for save button in set name dialog
				        
				        alarm_save.setOnClickListener(new View.OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								// TODO Auto-generated method stub
								
					            
						        hour=EditProfile.this.alarm_hr.getText().toString();
						        min=EditProfile.this.alarm_min.getText().toString();
						        
						        
					            
								
					             //SharedPreferences.Editor edit = pref1.edit();
					             
					             //Storing Data using SharedPreferences
					            
					             //edit.putString("Start Day", start_d);
					             //edit.putString("Start Month", start_m);
					             //edit.putString("Start Year", start_y);
					             //edit.commit();
					             
					             // dismissing dialog
					             
					             SetAlarm.dismiss();
								
							}
						});
				        
				        // showing set notification time dialog
				        
				        SetAlarm.show();
				        
					}
					});
	
		

	
	}


}
