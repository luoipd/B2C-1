package net.yasite.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import net.yasite.api.AddGoodAPI;
import net.yasite.api.BaseAPI;
import net.yasite.api.CarListAPI;
import android.content.Context;

public class CarService extends BaseService {

	public CarService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void addGood(String user_id, String goods_id, String goods_sn,
			String goods_name, String market_price, String goods_price,
			String goods_number, String token) {
		List<NameValuePair> pm = new ArrayList<NameValuePair>();
		pm.add(getValue("user_id", user_id));
		pm.add(getValue("goods_id", goods_id));
		pm.add(getValue("goods_sn", goods_sn));
		pm.add(getValue("goods_name", goods_name));
		pm.add(getValue("market_price", market_price));
		pm.add(getValue("goods_price", goods_price));
		pm.add(getValue("goods_number", goods_number));
		BaseAPI api = new AddGoodAPI(context, pm, token);
		try {
			if (api.doPost()) {
				api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object getCarList(String id,String token){
		List<NameValuePair> pm = new ArrayList<NameValuePair>();
		pm.add(getValue("token", token));
		BaseAPI api = new CarListAPI(context, pm, id);
		try {
			if(api.doPost()){
				return api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
