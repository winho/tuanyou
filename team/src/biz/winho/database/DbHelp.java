package biz.winho.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelp extends SQLiteOpenHelper {

	public DbHelp(Context context) {
		super(context, "tuanyou", null, 1);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		createfriend(db);
		Log.i("DBHelp", "friend ok");

	}

	private void createfriend(SQLiteDatabase db) {
		StringBuilder a = new StringBuilder();
		a.append("create table friend (");
		a.append("id integer primary key autoincrement,");
		a.append("friendid interger,");
		a.append("friendname varchar(20),");
		a.append("friendmood varchar(70),");
		a.append("friendteam varchar(20))");

		db.execSQL(a.toString());

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
