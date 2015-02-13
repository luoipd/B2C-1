package net.yasite.test;

import net.yasite.util.ActivityUtil;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class AddressListActivity extends BaseNewActivity {

	/**
	 * 收货地址
	 */
	ListView listView;
	Button btn_add;
	
	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		listView = getListView(R.id.listview_addresslist);
		btn_add = getButton(R.id.btn_add_addresslist);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_addresslist);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		btn_add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context,AddAddressActivity.class);
				startActivityForResult(intent, 2);
			}
		});
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		if(arg0 == 2 && arg1 == 2){
			ActivityUtil.showToast(context, "ok");
		}
		super.onActivityResult(arg0, arg1, arg2);
	}
}
