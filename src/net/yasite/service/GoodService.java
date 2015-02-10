package net.yasite.service;

import net.yasite.api.BaseAPI;
import net.yasite.api.GoodListAPI;
import net.yasite.entity.GoodListEntity;
import android.content.Context;

public class GoodService extends BaseService {

	public GoodService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public GoodListEntity getGoodList(String page,String id){
		BaseAPI api = new GoodListAPI(context, page, id);
		try {
			if(api.doGet()){
				return (GoodListEntity) api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
