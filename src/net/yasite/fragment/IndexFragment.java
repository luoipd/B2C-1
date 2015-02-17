package net.yasite.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import net.yasite.adapter.GoodsListAdapter;
import net.yasite.entity.GoodListEntity;
import net.yasite.model.GoodModel;
import net.yasite.test.GoodInfoActivity;
import net.yasite.test.R;
import net.yasite.view.XListView;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

public class IndexFragment extends Fragment {

	ViewPager vp_ad;
	List<View> views;
	XListView listView;
	GoodsListAdapter adapter;
	GoodListEntity goodList;
	GoodModel goodModel;
	Button btn;
	EditText ed_name;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_index, null);

		vp_ad = (ViewPager) view.findViewById(R.id.vp_ad);

		init();
		
		btn = (Button) view.findViewById(R.id.btn_serach);
		ed_name = (EditText) view.findViewById(R.id.ed_serach);

		vp_ad.setAdapter(new PagerAdapter() {

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

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// TODO Auto-generated method stub
				container.addView(views.get(position));
				return views.get(position);
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// TODO Auto-generated method stub
				container.removeView(views.get(position));
			}
		});

		Timer timer = new Timer();
		TimerTask tast = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				handler.sendEmptyMessage(1);
			}
		};
		timer.schedule(tast, 2000, 2000);

		listView = (XListView) view.findViewById(R.id.list_ad);
		adapter = new GoodsListAdapter(getActivity());
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(getActivity(), GoodInfoActivity.class);
				intent.putExtra("info", goodList.getData().get(position - 1));
				startActivity(intent);
			}
		});
		
		goodModel = new GoodModel(getActivity());
		new Thread(){
			public void run() {
				goodList = goodModel.RequestGoodList(1+"", 0+"");
				handler.sendEmptyMessage(2);
			};
		}.start();
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String name = ed_name.getText().toString().trim();
				new Thread(){
					public void run() {
						goodList = (GoodListEntity) goodModel.searchGood(name);
						handler.sendEmptyMessage(3);
					};
				}.start();
			}
		});
		
		return view;
	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if(msg.what == 1){
				if (vp_ad.getCurrentItem() == views.size() - 1) {
					vp_ad.setCurrentItem(0);
				} else {
					vp_ad.setCurrentItem(vp_ad.getCurrentItem() + 1);
				}
			}else if(msg.what == 2){
				adapter.setList(goodList.getData());
				adapter.notifyDataSetChanged();
			}else if(msg.what == 3){
				adapter.setList(goodList.getData());
				adapter.notifyDataSetChanged();
			}
			
		}
	};

	private void init() {
		views = new ArrayList<View>();
		int[] ids = new int[] { R.drawable.ad1, R.drawable.ad2, R.drawable.ad3 };
		for (int i : ids) {
			View v = new View(getActivity());
			v.setBackgroundResource(i);
			views.add(v);
		}
	}
}
