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

	public Object addAddress(AddressParams ap, String token) {
		return addressService.addAddress(ap, token);
	}
}
