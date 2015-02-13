package net.yasite.api;

import net.yasite.api.params.BaseHttpParam;
import net.yasite.api.params.Urls;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class AddAddressAPI extends BaseAPI {

	public AddAddressAPI(Context context, BaseHttpParam pm,String token) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop + Urls.USER + Urls.addAddress+token);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

}
