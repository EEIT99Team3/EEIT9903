package model.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Tracking;
import model.TrackingDAO;
import model.TrackingId;
import model.dao.TrackMyFavoriteDAO_JDBC;

@Service
public class TrackingService {
	
	@Autowired
	private TrackingDAO dao;
	
	//加入我的最愛股價追蹤
	public int addMyfavorites(Tracking tracking) {
		if(tracking !=null) {
		   dao.insert(tracking);
		   return 1;
		}
	   return 0;
	}
	
	
	
	//列出我最愛的股票代號
	public String myFavorite(String account){
		LinkedList<HashMap<String, String>> l1 = new LinkedList<HashMap<String, String>>();
		List<Tracking> list = dao.select(account);
		for(Tracking p: list) {
			HashMap<String, String> m1 = new HashMap<String, String>();
			m1.put("stock_id", p.getId().getStockId());
			l1.add(m1);
		}
		String jsonString = JSONValue.toJSONString(l1);
		//System.out.println(jsonString);
		return jsonString;
	}
	
	//刪除我的最愛股價追蹤
	public int deleteMyFavorite(TrackingId trackingId) {
		if(trackingId.getMAccount() != null) {
			dao.delete(trackingId);
			return 1;	
		}
		return 0;
	}	
}
