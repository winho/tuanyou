package biz.winho.adapter;

import java.util.List;

import biz.winho.entity.Friendentity;
import biz.winho.team.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Friendadapter extends BaseAdapter {
	private List<Friendentity> friendlist;
	private Context context;
	private LayoutInflater inf;
	
	public Friendadapter(Context context,List<Friendentity> friendlist){
		this.context=context;
		this.friendlist=friendlist;
		inf=LayoutInflater.from(context);
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return friendlist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View test=inf.inflate(R.layout.childlist, null);
		TextView text=(TextView)test.findViewById(R.id.childid);
		text.setText(friendlist.get(position).getFriendname());
		return test;
	}

}
