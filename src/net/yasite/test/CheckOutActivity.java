package net.yasite.test;

import java.util.List;

import net.yasite.adapter.CheckOutAdapter;
import net.yasite.entity.CarItemEntity;
import net.yasite.util.ActivityUtil;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CheckOutActivity extends BaseNewActivity {

	ListView listView;
	Button btn_confirm,btn_select;
	EditText ed_name,ed_address;
	TextView text_sum;
	CarItemEntity carItemEntity;
	List<CarItemEntity> list;
	CheckOutAdapter adapter;
	MyReceiver receiver;
	
	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		listView = getListView(R.id.listview_checkout);
		btn_confirm = getButton(R.id.btn_checkout);
		btn_select = getButton(R.id.btn_select_address);
		ed_name = getEdit(R.id.ed_select_name);
		ed_address = getEdit(R.id.ed_select_address);
		text_sum = getTextView(R.id.text_checksum);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_checkout);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		adapter = new CheckOutAdapter(context);
		adapter.setList(list);
		listView.setAdapter(adapter);
		receiver = new MyReceiver();
		registerReceiver(receiver, new IntentFilter("net.yasite.adapter.checkoutsum"));
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		list = (List<CarItemEntity>) getIntent().getSerializableExtra("info");
		if(list!= null){
			return true;
		}else{
			ActivityUtil.showToast(context, "请选择要购买的商品");
			return false;
		}
	}
	
	public class MyReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			double sum = intent.getDoubleExtra("sum", 0);
			text_sum.setText("合计："+sum+"元");
		}
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(receiver);
	}

}
