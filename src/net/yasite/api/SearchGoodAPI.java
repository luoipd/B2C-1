package net.yasite.api;

import net.yasite.api.params.Urls;
import net.yasite.entity.GoodListEntity;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.content.Context;

public class SearchGoodAPI extends BaseAPI {
	/**
	 * 按名称查询商品
	 */
	public SearchGoodAPI(Context context, String name) {
		super(context);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop + Urls.GOODS
				+ "searchGoodList/" + name + "/");
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), GoodListEntity.class);
	}

}
