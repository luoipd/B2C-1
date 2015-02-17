package net.yasite.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import net.yasite.api.BaseAPI;
import net.yasite.api.CancelOrderAPI;
import net.yasite.api.CreateOrderAPI;
import net.yasite.api.GetOrderListAPI;
import net.yasite.api.params.Address;
import android.content.Context;

public class OrderService extends BaseService {

	public OrderService(Context context) {
		super(context);
	}
/**
 * 创建订单
 */
	public Object createOrder(String user_id,String address){
		List<NameValuePair> pm = new ArrayList<NameValuePair>();
		pm.add(getValue("user_id", "99"));
		Address add= new Address();
		add.setUser_id("99");
		add.setConsignee("1");
		add.setCountry("2");
		add.setProvince("3");
		add.setCity("4");
		add.setDistrict("5");
		add.setAddress("6");
		add.setTel("7");
		add.setMobile("8");
		add.setEmail("9");
//		pm.add(getValue("address", address));
//		pm.add(getValue("consignee", ad.getConsignee()));
//		pm.add(getValue("country", ad.getCountry()));
//		pm.add(getValue("province", ad.getProvince()));
//		pm.add(getValue("city", ad.getCity()));
//		pm.add(getValue("district", ad.getDistrict()));
//		pm.add(getValue("address", ad.getAddress()));
//		pm.add(getValue("tel", ad.getTel()));
//		pm.add(getValue("mobile", ad.getMobile()));
//		pm.add(getValue("email", ""));
		BaseAPI api = new CreateOrderAPI(context,pm,add);
		try {
			if(api.doGet()){
				return api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 订单列表
	 */
	public Object getOrderList(String id){
		BaseAPI api = new GetOrderListAPI(context, id);
		try {
			if(api.doGet()){
				return api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 取消订单
	 * @param id
	 */
	public void cancelOrder(String id){
		BaseAPI api = new CancelOrderAPI(context, id);
		try {
			if(api.doGet()){
				api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
