package model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Tracking;
import model.TrackingDAO;
import model.TrackingId;

@Service
public class TrackingService {
	
	@Autowired
	private TrackingDAO dao;
	

	//加入我的最愛股價追蹤
	public int addMyfavorites(Tracking tracking) {
		if(tracking ==null) {
		   dao.insert(tracking);
		   return 1;
		}
	   return 0;
	}
	
	
	
	//列出我最愛的股票代號
	public List<Tracking> myFavorite(String account){
		return dao.select(account);
	}
	
	//刪除我的最愛股價追蹤
	public int deleteMyFavorite(TrackingId trackingId) {
		if(trackingId != null) {
			dao.delete(trackingId);
			return 1;	
		}
		return 0;
	}	
}
