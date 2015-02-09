package net.yasite.model;

import net.yasite.service.RegistService;
import android.content.Context;

public class RegistModel extends Model {

	RegistService registService ;
	
	public RegistModel(Context context){
		this.context = context;
		registService = new RegistService(context);
	}
	
	public Object RequestPost(String username,String pwd){
		return registService.regist(username, pwd);
	}
}
