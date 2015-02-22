package in.silive.proxy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Data {

	public static final String KEY_FIRST_NAME = "first_name";
	public static final String KEY_LAST_NAME = "last_name";
	public static String KEY_START_DAY = "31";
	public static String KEY_START_MONTH = "12";
	public static String KEY_START_YEAR = "2014";
	public static String KEY_EXAM_YEAR = "2014";
	public static String KEY_EXAM_MONTH = "12";
	public static String KEY_EXAM_DAY = "31";
	public static String KEY_HOURS = "22";
	public static String KEY_MINUTES = "30";
	public static String KEY_TOTAL = "0";
	public static String KEY_PRESENT = "0";
	
	private static final String DATABASE_NAME = "Proxy_db";
	private static final String DATABASE_TABLE1 = "name_table";


	private static final int DATABASE_VERSION = 1;

	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;

	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub

			// CREATING TABLE name_table

			db.execSQL("CREATE TABLE " + DATABASE_TABLE1 + " ("
					+ KEY_FIRST_NAME + " TEXT NOT NULL, "
					+ KEY_LAST_NAME + " TEXT NOT NULL, "
					+ KEY_START_DAY + " INTEGER NOT NULL, "
					+ KEY_START_MONTH + " INTEGER NOT NULL, "
					+ KEY_START_YEAR + " INTEGER NOT NULL, "
					+ KEY_EXAM_DAY + " INTEGER NOT NULL, "
					+ KEY_EXAM_MONTH + " INTEGER NOT NULL, "
					+ KEY_EXAM_YEAR + " INTEGER NOT NULL, "
					 + KEY_HOURS + " INTEGER NOT NULL, " 
					+ KEY_MINUTES + " INTEGER NOT NULL, "
					 + KEY_TOTAL + " INTEGER , " 
					+ KEY_PRESENT + " INTEGER);");
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE1);
			
			onCreate(db);

		}

	}

	public Data(Context c) {
		// TODO Auto-generated constructor stub
		ourContext = c;
	}

	public Data open() throws SQLException {

		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;

	}

	public void close() {

		ourHelper.close();
	}

	public long createEntry(String name_first, String name_last, String start_date1, String start_date2, String start_date3, String exam_date1, String exam_date2, String exam_date3, String alarm_hour, String alarm_minutes) {
		// TODO Auto-generated method stub

		ContentValues cv = new ContentValues();
		cv.put(KEY_FIRST_NAME, name_first);
		cv.put(KEY_LAST_NAME, name_last);
		cv.put(KEY_START_DAY, start_date1);
		cv.put(KEY_START_MONTH, start_date2);
		cv.put(KEY_START_YEAR, start_date3);
		cv.put(KEY_EXAM_DAY, exam_date1);
		cv.put(KEY_EXAM_MONTH, exam_date2);
		cv.put(KEY_EXAM_YEAR, exam_date3);
		cv.put(KEY_HOURS, alarm_hour);
		cv.put(KEY_MINUTES, alarm_minutes);
		

		return ourDatabase.insert(DATABASE_TABLE1, null, cv);

	}

	public String getData() {
		// TODO Auto-generated method stub

		String[] columns = new String[] { KEY_FIRST_NAME, KEY_LAST_NAME, KEY_START_DAY, KEY_START_MONTH, KEY_START_YEAR, KEY_EXAM_DAY, KEY_EXAM_MONTH, KEY_EXAM_YEAR, KEY_HOURS, KEY_MINUTES, KEY_TOTAL, KEY_PRESENT };
		Cursor c = ourDatabase.query(DATABASE_TABLE1, columns, null, null,
				null, null, null);
		String result = "";

		int iFirstName = c.getColumnIndex(KEY_FIRST_NAME);
		int iLastName = c.getColumnIndex(KEY_LAST_NAME);
		int iStartDay = c.getColumnIndex(KEY_START_DAY);
		int iStartMonth = c.getColumnIndex(KEY_START_MONTH);
		int iStartYear = c.getColumnIndex(KEY_START_YEAR);
		int iExamDay = c.getColumnIndex(KEY_EXAM_DAY);
		int iExamMonth = c.getColumnIndex(KEY_EXAM_MONTH);
		int iExamYear = c.getColumnIndex(KEY_EXAM_YEAR);
		int iAlarmHr = c.getColumnIndex(KEY_HOURS);
		int iAlarmMin = c.getColumnIndex(KEY_MINUTES);
		int iTotal = c.getColumnIndex(KEY_TOTAL);
		int iPresent = c.getColumnIndex(KEY_PRESENT);
		

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

			result = result + c.getString(iFirstName) + " " + c.getString(iLastName) + " " + c.getString(iStartDay)+ " " + c.getString(iStartMonth)+ " " + c.getString(iStartYear) + " " + c.getString(iExamDay)+ " " + c.getString(iExamMonth)+ " " + c.getString(iExamYear)+ " " + c.getString(iAlarmHr)+ " " + c.getString(iAlarmMin)+ " " + c.getString(iTotal)+ " " + c.getString(iPresent)
					+ "\n";

		}

		return result;

		}

	
	
	
	
	
	
}
