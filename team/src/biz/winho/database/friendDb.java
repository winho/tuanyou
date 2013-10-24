package biz.winho.database;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import biz.winho.entity.Friendentity;

public class friendDb {
	private DbHelp dbopenhelp;

	public friendDb(Context context) {
		this.dbopenhelp = new DbHelp(context);
	}

	/**
	 * 加朋友
	 * 
	 * @param person
	 *            朋友实体
	 * @return
	 */
	public boolean addfriend(Friendentity person) {

		SQLiteDatabase db = dbopenhelp.getWritableDatabase();
		try {
			db.execSQL(
					"insert into friend (friendid,friendname,friendmood,friendteam) values(?,?,?,?)",
					new Object[] { person.getFriendid(),
							person.getFriendname(), person.getFriendmood(),
							person.getFriendteam() });
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * 删朋友
	 * 
	 * @param id
	 *            朋友id
	 * @return
	 */

	public boolean delfriend(Integer id) {
		SQLiteDatabase db = dbopenhelp.getWritableDatabase();
		try {
			db.execSQL("delete from friend where friendid=?",
					new Object[] { id });

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 找朋友
	 * 
	 * @param id
	 *            朋友id
	 * @return
	 */

	public Friendentity find(Integer id) {
		SQLiteDatabase db = dbopenhelp.getReadableDatabase();
		try {
			Cursor cursor = db.rawQuery(
					"select * from friend where friendid=?",
					new String[] { id.toString() });
			if (cursor.moveToFirst()) {
				int friendid = cursor.getInt(cursor.getColumnIndex("friendid"));
				String friendname = cursor.getString(cursor
						.getColumnIndex("friendname"));
				String friendmood = cursor.getString(cursor
						.getColumnIndex("friendmood"));
				String friendteam = cursor.getString(cursor
						.getColumnIndex("friendteam"));
				return new Friendentity(friendid, friendname, friendmood,
						friendteam);
			}
		} catch (Exception e) {
			System.out.println("zhaocuo");

		}
		return null;
	}

	/**
	 * 朋友列表
	 * 
	 * @return
	 */

	public List<Friendentity> friendlist() {
		List<Friendentity> friendlist = new ArrayList<Friendentity>();
		SQLiteDatabase db = dbopenhelp.getReadableDatabase();
		try {
			Cursor cursor = db.rawQuery(
					"select * from friend order by friendid", null);
			while (cursor.moveToNext()) {
				int friendid = cursor.getInt(cursor.getColumnIndex("friendid"));
				String friendname = cursor.getString(cursor
						.getColumnIndex("friendname"));
				String friendmood = cursor.getString(cursor
						.getColumnIndex("friendmood"));
				String friendteam = cursor.getString(cursor
						.getColumnIndex("friendteam"));
				friendlist.add(new Friendentity(friendid, friendname,
						friendmood, friendteam));
			}
			return friendlist;

		} catch (Exception e) {
			System.out.println("zhaocuo");
		}
		return friendlist;
	}

}
