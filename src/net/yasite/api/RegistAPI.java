package net.yasite.api;

import java.util.List;
import net.yasite.api.params.Urls;
import net.yasite.entity.RegistEntity;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.content.Context;

public class RegistAPI extends BaseAPI {

	public RegistAPI(Context context, List<NameValuePair> pm) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH+Urls.Shop+Urls.USER+Urls.Register);
	}

	@Override
	public RegistEntity handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), RegistEntity.class);
	}

}
