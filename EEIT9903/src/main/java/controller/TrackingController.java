package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.TrackingId;
import model.service.TrackingService;

@Controller
public class TrackingController {
	
	@Autowired
	private TrackingService trackingService;

	@RequestMapping("/p/tracking.do")
	@ResponseBody
	public String doGetMyFavorite() {
		String result = trackingService.myFavorite("kitty");		
		return result;
		
	}
	
	@RequestMapping("stockDelete.do")
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
	
	
}
