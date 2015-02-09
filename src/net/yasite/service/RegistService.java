package net.yasite.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import net.yasite.api.BaseAPI;
import net.yasite.api.RegistAPI;
import android.content.Context;
import android.util.Log;

public class RegistService extends BaseService {

	public RegistService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public Object regist(String username,String pwd){
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(getValue("name", username));
		params.add(getValue("pwd", pwd));
		BaseAPI api = new RegistAPI(context, params);
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
