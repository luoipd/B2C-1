package net.yasite.model;

import net.yasite.api.params.AddressParams;
import net.yasite.service.AddressService;
import android.content.Context;

public class AddressModel extends Model {

	AddressService addressService;
	
	public AddressModel(Context context) {
		this.context = context;
		addressService = new AddressService(context);
	}
	
	public void addAddress(AddressParams params,String token){
		addressService.addAddress(params, token);
	}
}
