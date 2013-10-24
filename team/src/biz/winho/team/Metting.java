package biz.winho.team;

import java.util.List;

import biz.winho.database.friendDb;
import biz.winho.entity.Friendentity;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.TextView;

public class Metting extends Activity {
	private Button button;
	private TextView viewa;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.metting);
		button = (Button) findViewById(R.id.jiapengyou);
		viewa=(TextView)findViewById(R.id.xianshi);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewa.setText("fuck");
				Friendentity person = new Friendentity(1, "sb", "meixinqing",
				"pengyou");
		friendDb db=new friendDb(getApplicationContext());
		
		if(db.addfriend(person)){
			Log.i("TAG", "wrong");
		}
		List<Friendentity> a=db.friendlist();
		String k=a.get(0).getFriendname();
		Log.i("TAG", k);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.metting, menu);
		return true;
	}

}
