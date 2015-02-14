package net.yasite.test;

import net.yasite.adapter.AddressListAdapter;
import net.yasite.entity.AddressListEntity;
import net.yasite.model.AddressModel;
import net.yasite.model.RegistModel;
import net.yasite.net.HandlerHelp;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class AddressListActivity extends BaseNewActivity {

	/**
	 * 收货地址列表
	 */
	ListView listView;
	Button btn_add;
	AddressModel addressModel;
	AddressListEntity addressListEntity;
	AddressListAdapter adapter;

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
		addressModel = new AddressModel(context);
		new MyHanlder(context).execute();
		adapter = new AddressListAdapter(context);
		listView.setAdapter(adapter);
		btn_add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, AddAddressActivity.class);
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
		if (arg0 == 2 && arg1 == 2) {
			new MyHanlder(context).execute();
			adapter.notifyDataSetChanged();
		}
		super.onActivityResult(arg0, arg1, arg2);
	}

	class MyHanlder extends HandlerHelp {

		public MyHanlder(Context context) {
			super(context);
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			adapter.setList(addressListEntity.getData());
			adapter.notifyDataSetChanged();
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			String user_id = new RegistModel(context).getSp("user_id");
			String token = new RegistModel(context).getToken();
			addressListEntity = (AddressListEntity) addressModel
					.getAddressList(token, user_id);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub

		}

	}
}
