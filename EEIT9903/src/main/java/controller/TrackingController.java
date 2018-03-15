package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Tracking;
import model.TrackingId;
import model.dao.TrackMyFavoriteDAO_JDBC;
import model.service.TrackingService;

@Controller
public class TrackingController {
	
	@Autowired
	private TrackingService trackingService;

	@RequestMapping("/p/tracking.do")
	@ResponseBody
	public String doGetMyFavorite() {
		//String result = trackingService.myFavorite("kitty");		
		TrackMyFavoriteDAO_JDBC myFavorite = new TrackMyFavoriteDAO_JDBC();
		String result = myFavorite.TrackMyFavorite("kitty");
		System.out.println(result);		
		return result;
		
	}
	
	@RequestMapping("pages/stockDelete.do")
	@ResponseBody
	public String delete(@RequestParam("stock_id") String stockId) {
		TrackingId trackingId = new TrackingId();
		trackingId.setStockId(stockId);
		trackingId.setMAccount("kitty");
		int delete = trackingService.deleteMyFavorite(trackingId);
		if(delete > 0) {
			return "Delete Success";
		}
			return "Delete Fail";
		
	}
	
	@RequestMapping("pages/stockAdd.do")
	@ResponseBody
	public String insert(@RequestParam("stock_id") String stockId) {
		Tracking tracking = new Tracking();
		TrackingId trackingId = new TrackingId();
		trackingId.setMAccount("kitty");
		trackingId.setStockId(stockId);
		tracking.setId(trackingId);
		tracking.setAlertHigh(Integer.valueOf(123));
		tracking.setAlertLow(Integer.valueOf(125));
		int i = trackingService.addMyfavorites(tracking);
		if(i>0) {
			return "Add Success";	
		}
		return "Add Fail";
}
	
}
