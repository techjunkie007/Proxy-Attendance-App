package in.silive.proxy;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.ContactsContract.RawContacts.Data;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Database extends Fragment{

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
//		TextView tvname= (TextView) getActivity().findViewById(R.id.get_info);
//		in.silive.proxy.Data info = new in.silive.proxy.Data(getActivity().getApplicationContext());
//		info.open();
//		String data= info.getData();
//		info.close();
//		tvname.setText(data);
//		
		
	}

@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 //TODO Auto-generated method stub
		
		View databasefrag=inflater.inflate(R.layout.database, null);
		
		return databasefrag;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		 //TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		TextView tvname= (TextView) getActivity().findViewById(R.id.get_info);
		in.silive.proxy.Data info = new in.silive.proxy.Data(getActivity().getApplicationContext());
		info.open();
		String data= info.getData();
		info.close();
		tvname.setText(data);

		
	}
}
