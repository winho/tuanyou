package biz.winho.team;

import java.util.ArrayList;
import java.util.List;

import biz.winho.database.friendDb;
import biz.winho.entity.Friendentity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;

public class MainActivity extends Activity {
	ViewPager pages;
	RadioButton metting;
	RadioButton friend;
	RadioButton tuan;
	RadioButton setting;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		//绑定控件
		pages = (ViewPager) findViewById(R.id.views);
		metting = (RadioButton) findViewById(R.id.huihua);
		friend = (RadioButton) findViewById(R.id.friend);
		tuan = (RadioButton) findViewById(R.id.tuan);
		setting = (RadioButton) findViewById(R.id.setting);
		//按钮的按键转页
		metting.setOnClickListener(new mypageOnClickListener(0));
		friend.setOnClickListener(new mypageOnClickListener(1));
		tuan.setOnClickListener(new mypageOnClickListener(2));
		setting.setOnClickListener(new mypageOnClickListener(3));
		//将activity引人view
		LayoutInflater inflater=LayoutInflater.from(this);
		View ametting = inflater.inflate(R.layout.metting, null);
		View afriend = inflater.inflate(R.layout.friend, null);
		View atuan = inflater.inflate(R.layout.tuan, null);
		View asetting = inflater.inflate(R.layout.setting, null);
		//把页面放进arraylist里面
		final ArrayList<View> views = new ArrayList<View>();
		views.add(ametting);
		views.add(afriend);
		views.add(atuan);
		views.add(asetting);
		//viewpage的适配器
		PagerAdapter viewpage = new PagerAdapter() {

			@Override
			public void destroyItem(View container, int position, Object object) {
				// TODO Auto-generated method stub
				((ViewPager)container).removeView(views.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				((ViewPager)container).addView(views.get(position));
				return views.get(position);
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return views.size();
			}
		};
		pages.setAdapter(viewpage);

	}
	
	public class mypageOnClickListener implements View.OnClickListener{
		int a=0;
		
		public mypageOnClickListener(int a){
			this.a=a;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			pages.setCurrentItem(a);
			
		}
		
	}
	
	public void addfriend (View view){
		Friendentity person = new Friendentity(1, "sb", "meixinqing", "pengyou");
     	friendDb db = new friendDb(this);

		if (db.addfriend(person)) {
			Log.i("TAG", "ok");
	}
		List<Friendentity> a = db.friendlist();
		String k = a.get(0).getFriendname().toString();
		Log.i("TAG", k);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
