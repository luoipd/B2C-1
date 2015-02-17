package net.yasite.api;

import java.util.List;

import net.yasite.api.params.Address;
import net.yasite.api.params.BaseHttpParam;
import net.yasite.api.params.Urls;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;

public class CreateOrderAPI extends BaseAPI {
	

	public CreateOrderAPI(Context context, List<NameValuePair> pm,
			Address address) {
		super(context, pm, address);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop
				+ "orderController/createOrder/");
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

}
