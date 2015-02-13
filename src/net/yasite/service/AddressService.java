package net.yasite.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import net.yasite.api.AddAddressAPI;
import net.yasite.api.BaseAPI;
import net.yasite.api.params.AddressParams;
import android.content.Context;

public class AddressService extends BaseService {

	public AddressService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public Object addAddress(AddressParams ap, String token) {
		List<NameValuePair> pm = new ArrayList<NameValuePair>();
		pm.add(getValue("consignee", ap.getConsignee()));
		pm.add(getValue("email", ap.getEmail()));
		pm.add(getValue("user_id", ap.getUser_id()));
		pm.add(getValue("country", ap.getCountry()));
		pm.add(getValue("province", ap.getProvince()));
		pm.add(getValue("city", ap.getCity()));
		pm.add(getValue("district", ap.getDistrict()));
		pm.add(getValue("address", ap.getAddress()));
		pm.add(getValue("tel", ap.getTel()));
		pm.add(getValue("mobile", ap.getMobile()));
		BaseAPI api = new AddAddressAPI(context, pm, token);
		try {
			if (api.doPost()) {
				return api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
