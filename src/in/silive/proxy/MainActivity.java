package in.silive.proxy;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	// Fragments, Manager, Transaction

	public AddAttendance addfrag;
	public EditProfile editprofilefrag;
	public ViewStatus viewstatusfrag;
	public EditAttendance editfrag;
	public Database databasefrag;
	public SuggestUs suggestfrag;
	public FragmentManager fragmanager;
	public FragmentTransaction fragtrans;

	// Drawer Layout n Action Bar

	public DrawerLayout drawerlayout;
	public ActionBarDrawerToggle drawerListener;
	// private MyAdapter myAdapter;

	public ListView drawerlist;
	public String[] items = { "Add Attendance", "Edit Attendance",
			"Edit Profile", "Suggest Us", "Database View" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		// myAdapter = new MyAdapter(this);

		// Drawer Toggle Activation

		drawerlayout = (DrawerLayout) findViewById(R.id.drawer);
		drawerListener = new ActionBarDrawerToggle(this, drawerlayout,
				R.drawable.ic_drawer, R.string.open_drawer,
				R.string.close_drawer) {

			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Menu Drawer Opened",
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Menu Drawer Closed",
						Toast.LENGTH_SHORT).show();
			}

		};
		drawerlayout.setDrawerListener(drawerListener);

		// Home Button on drawer

		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// Instantiate Fragments

		addfrag = (AddAttendance) Fragment.instantiate(this,
				AddAttendance.class.getName(), null);
		editfrag = (EditAttendance) Fragment.instantiate(this,
				EditAttendance.class.getName(), null);
		databasefrag = (Database) Fragment.instantiate(this,
				Database.class.getName(), null);
		suggestfrag = (SuggestUs) Fragment.instantiate(this,
				SuggestUs.class.getName(), null);
		viewstatusfrag = (ViewStatus) Fragment.instantiate(this,
				ViewStatus.class.getName(), null);
		editprofilefrag = (EditProfile) Fragment.instantiate(this,
				EditProfile.class.getName(), null);

		// Commit Home Screen Transaction

		fragmanager = getFragmentManager();
		fragtrans = fragmanager.beginTransaction();
		fragtrans.add(R.id.screen_layout, viewstatusfrag);
		fragtrans.commit();

		// Set array adapter for drawer list

		drawerlist = (ListView) findViewById(R.id.list);
		ArrayAdapter<String> drawerlistadapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		drawerlist.setAdapter(drawerlistadapter);
		// drawerlist.setAdapter(myAdapter);
		drawerlist.setOnItemClickListener(new OnItemClickListener() {

			// Set item click listener for drawer

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				selectItem(position);

				// Switch case for position of click

				switch (drawerlist.getPositionForView(view)) {

				case 0: {

					fragmanager = getFragmentManager();
					fragtrans = fragmanager.beginTransaction();
					fragtrans.replace(R.id.screen_layout, addfrag);
					fragtrans.commit();

					Toast.makeText(getApplicationContext(),
							items[position] + " Clicked", Toast.LENGTH_SHORT)
							.show();
					drawerlayout.closeDrawers();
					break;
				}
				case 1: {

					fragmanager = getFragmentManager();
					fragtrans = fragmanager.beginTransaction();
					fragtrans.replace(R.id.screen_layout, editfrag);
					fragtrans.commit();

					Toast.makeText(getApplicationContext(),
							items[position] + " Clicked", Toast.LENGTH_SHORT)
							.show();
					drawerlayout.closeDrawers();
					break;
				}
				case 2: {

					fragmanager = getFragmentManager();
					fragtrans = fragmanager.beginTransaction();
					fragtrans.replace(R.id.screen_layout, editprofilefrag);
					fragtrans.commit();

					Toast.makeText(getApplicationContext(),
							items[position] + " Clicked", Toast.LENGTH_SHORT)
							.show();
					drawerlayout.closeDrawers();
					break;
				}
				case 3: {

					fragmanager = getFragmentManager();
					fragtrans = fragmanager.beginTransaction();
					fragtrans.replace(R.id.screen_layout, suggestfrag);
					fragtrans.commit();

					Toast.makeText(getApplicationContext(),
							items[position] + " Clicked", Toast.LENGTH_SHORT)
							.show();
					drawerlayout.closeDrawers();
					break;
				}
				case 4: {

					fragmanager = getFragmentManager();
					fragtrans = fragmanager.beginTransaction();
					fragtrans.replace(R.id.screen_layout, databasefrag);
					fragtrans.commit();
					// Intent opendatabase= new Intent(getApplicationContext(),
					// DatabaseView.class);
					// startActivity(opendatabase);

					Toast.makeText(getApplicationContext(),
							items[position] + " Clicked", Toast.LENGTH_SHORT)
							.show();
					drawerlayout.closeDrawers();
					break;
				}

				}

			}

			// Calls set title

			public void selectItem(int position) {

				drawerlist.setItemChecked(position, true);
				setTitle(items[position]);

			}

			// sets title of actionbar
			public void setTitle(String title) {

				getActionBar().setTitle(title);

			}

		});

	}

	// Forwarding event to open drawer through actionbar

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (drawerListener.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);

	}

	// Syncing state of drawer with view

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();

	}

}

/*
 * 
 * // Listview adapter
 * 
 * class MyAdapter extends BaseAdapter {
 * 
 * private Context context; String[] menuItems; int[] images = {
 * R.drawable.ic_add_attendance, R.drawable.ic_edit_attendance,
 * R.drawable.ic_edit_profile, R.drawable.ic_suggest_us,
 * R.drawable.ic_database_view };
 * 
 * public MyAdapter(Context context) { this.context = context; menuItems =
 * context.getResources().getStringArray(R.array.items); }
 * 
 * @Override public int getCount() { // TODO Auto-generated method stub return
 * menuItems.length; }
 * 
 * @Override public Object getItem(int position) { // TODO Auto-generated method
 * stub return menuItems[position]; }
 * 
 * @Override public long getItemId(int position) { // TODO Auto-generated method
 * stub return position; }
 * 
 * @Override public View getView(int position, View convertView, ViewGroup
 * parent) { // TODO Auto-generated method stub View row; if (convertView ==
 * null) { LayoutInflater inflater = (LayoutInflater) context
 * .getSystemService(Context.LAYOUT_INFLATER_SERVICE); row =
 * inflater.inflate(R.layout.custom_row, null); } else { row = convertView; }
 * TextView menu_name = (TextView) row.findViewById(R.id.textView1); ImageView
 * menu_image = (ImageView) row.findViewById(R.id.imageView1);
 * menu_name.setText(menuItems[position]);
 * menu_image.setImageResource(images[position]); return null; } }
 */