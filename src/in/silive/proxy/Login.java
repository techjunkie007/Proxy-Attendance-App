package in.silive.proxy;

//imports

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Login extends Activity {

	// objects created

	TextView dialog;
	Button set_start_date, set_exam_date, start_save, exam_save, submit;
	EditText fname, lname, alarm_hr, alarm_min, start_day, start_month,
			start_year, exam_day, exam_month, exam_year;
	Dialog SetDate, SetDate2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		// find views from layouts

		fname = (EditText) findViewById(R.id.edit_text1);
		lname = (EditText) findViewById(R.id.edit_text2);
		start_day = (EditText) findViewById(R.id.start_date1);
		start_month = (EditText) findViewById(R.id.start_date2);
		start_year = (EditText) findViewById(R.id.start_date3);
		exam_day = (EditText) findViewById(R.id.exam_date1);
		exam_month = (EditText) findViewById(R.id.exam_date2);
		exam_year = (EditText) findViewById(R.id.exam_date3);
		alarm_hr = (EditText) findViewById(R.id.alarm_hr);
		alarm_min = (EditText) findViewById(R.id.alarm_min);

	
		
		submit = (Button) findViewById(R.id.button3);
		

		// set on click listener for sem start date button

//		set_start_date.setOnClickListener(new View.OnClickListener() {
//
//			String start_d, start_m, start_y;
//
//			@Override
//			public void onClick(View arg0) {
//
//				// TODO Auto-generated method stub
//				SetDate = new Dialog(Login.this);
//				SetDate.setContentView(R.layout.start_date);
//				SetDate.setTitle("Enter Sem Start Date");
//
//				// set view by xml of sem start dialog
//
//				start_day = (EditText) SetDate.findViewById(R.id.start_day);
//				start_month = (EditText) SetDate.findViewById(R.id.start_month);
//				start_year = (EditText) SetDate.findViewById(R.id.start_year);
//				start_save = (Button) SetDate
//						.findViewById(R.id.start_date_button1);
//
//				// set on click listener for save button in sem start date
//				// dialog
//
//				start_save.setOnClickListener(new View.OnClickListener() {
//
//					@Override
//					public void onClick(View arg0) {
//						// TODO Auto-generated method stub
//
//						start_d = start_day.getText().toString();
//						start_m = start_month.getText().toString();
//						start_y = start_year.getText().toString();
//
//						// save start dates in db using try catch
//						boolean didItWork = true;
//
//						try {
//
//							Data entry = new Data(Login.this);
//							entry.open();
//
//							entry.createEntryStart(start_d, start_m, start_y);
//
//							entry.close();
//
//						} catch (Exception e) {
//							didItWork = false;
//
//						}finally{
//							
//							if(didItWork){
//								
//								Dialog d= new Dialog(Login.this);
//								d.setTitle("Heck Yeah!!");
//								TextView tv = new TextView(Login.this);
//								tv.setText("Success");
//								d.setContentView(tv);
//								d.show();
//								
//							}
//						}
//						// dismissing dialog
//
//						SetDate.dismiss();
//
//					}
//
//				});
//
//				// showing start sem date dialog
//
//				SetDate.show();
//
//			}
//
//		});
//
//		// set on click listener for exam date button
//
//		set_exam_date.setOnClickListener(new View.OnClickListener() {
//
//			String exam_d, exam_m, exam_y;
//
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				SetDate2 = new Dialog(Login.this);
//				SetDate2.setContentView(R.layout.exam_date);
//				SetDate2.setTitle("Enter Exam Date");
//				exam_day = (EditText) SetDate2.findViewById(R.id.exam_day);
//				exam_month = (EditText) SetDate2.findViewById(R.id.exam_month);
//				exam_year = (EditText) SetDate2.findViewById(R.id.exam_year);
//				exam_save = (Button) SetDate2
//						.findViewById(R.id.exam_date_button1);
//
//				// set on click listener for save button in exam date dialog
//
//				exam_save.setOnClickListener(new View.OnClickListener() {
//
//					@Override
//					public void onClick(View arg0) {
//						// TODO Auto-generated method stub
//
//						exam_d = exam_day.getText().toString();
//						exam_m = exam_month.getText().toString();
//						exam_y = exam_year.getText().toString();
//						
//						// save exam dates in db using try catch
//						boolean didItWork = true;
//
//						try {
//
//							Data entry = new Data(Login.this);
//							entry.open();
//
//							entry.createEntryExam(exam_d, exam_m, exam_y);
//
//							entry.close();
//
//						} catch (Exception e) {
//							didItWork = false;
//
//						}finally{
//							
//							if(didItWork){
//								
//								Dialog d= new Dialog(Login.this);
//								d.setTitle("Heck Yeah!!");
//								TextView tv = new TextView(Login.this);
//								tv.setText("Success");
//								d.setContentView(tv);
//								d.show();
//								
//							}
//						}
//						
//						// dismissing dialog
//
//						SetDate2.dismiss();
//
//					}
//
//				});
//
//				// showing start sem date dialog
//
//				SetDate2.show();
//
//			}
//
//		});

		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// save name in db using try catch
				boolean didItWork = true;

				try {

					String name_first = fname.getText().toString();
					String name_last = lname.getText().toString();
					String start_date1= start_day.getText().toString();
					String start_date2= start_month.getText().toString();
					String start_date3= start_year.getText().toString();
					String exam_date1= exam_day.getText().toString();
					String exam_date2= exam_month.getText().toString();
					String exam_date3= exam_year.getText().toString();
					String alarm_hour= alarm_hr.getText().toString();
					String alarm_minutes= alarm_min.getText().toString();
					
					
					Data entry = new Data(Login.this);
					entry.open();

					entry.createEntry(name_first, name_last, start_date1, start_date2, start_date3, exam_date1, exam_date2, exam_date3, alarm_hour, alarm_minutes);

					entry.close();
 
				} catch (Exception e) {
					didItWork = false;

				}
				
				
				
				// intent open main activity

				Intent openmain = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(openmain);

			}

		});

	}
}
