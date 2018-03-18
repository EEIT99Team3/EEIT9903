package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Member;
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
	public String doGetMyFavorite(HttpSession session) {
		TrackMyFavoriteDAO_JDBC myFavorite = new TrackMyFavoriteDAO_JDBC();
		//session.getAttribute("user");
		Member memberInfo = (Member) session.getAttribute("user");
	//	System.out.println(session.getAttribute("user"));
		String result = myFavorite.TrackMyFavorite(memberInfo.getMAccount());
		// System.out.println(result);
		return result;

	}

	@RequestMapping("/*/stockDelete.do")
	@ResponseBody
	public String delete(@RequestParam("stock_id") String stockId, HttpSession session) {
		TrackingId trackingId = new TrackingId();
		Member memberInfo = (Member) session.getAttribute("user");
		trackingId.setStockId(stockId);
		trackingId.setMAccount(memberInfo.getMAccount());
		int delete = trackingService.deleteMyFavorite(trackingId);
		if (delete > 0) {
			return "Delete Success";
		}
		return "Delete Fail";

	}

	@RequestMapping("/*/stockAdd.do")
	@ResponseBody
	public String insert(@RequestParam("stock_id") String stockId, HttpSession session) {
		Tracking tracking = new Tracking();
		TrackingId trackingId = new TrackingId();
		Member memberInfo = (Member) session.getAttribute("user");
		trackingId.setMAccount(memberInfo.getMAccount());
		trackingId.setStockId(stockId);
		tracking.setId(trackingId);
		tracking.setAlertHigh(Integer.valueOf(123));   //塞入假的資料,預防nullpointerexception
		tracking.setAlertLow(Integer.valueOf(123));    //塞入假的資料
		int i = trackingService.addMyfavorites(tracking);
		if (i > 0) {
			return "Add Success";
		}
		return "Add Fail";
	}

}
