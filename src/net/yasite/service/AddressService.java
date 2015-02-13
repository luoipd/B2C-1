package net.yasite.service;

import net.yasite.api.AddAddressAPI;
import net.yasite.api.BaseAPI;
import net.yasite.api.params.AddressParams;
import android.content.Context;

public class AddressService extends BaseService {

	public AddressService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public Object addAddress(AddressParams params,String token){
		BaseAPI api = new AddAddressAPI(context, params, token);
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
