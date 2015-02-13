package net.yasite.test;

import net.yasite.net.HandlerHelp;
import android.content.Context;
import android.os.Message;

public class AddAddressActivity extends BaseNewActivity {

	@Override
	public void setupView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_addaddress);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}

	class AddressHandler extends HandlerHelp {

		public AddressHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub

		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub

		}
	}
}
