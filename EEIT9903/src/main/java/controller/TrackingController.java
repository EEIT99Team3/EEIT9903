package controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Tracking;
import model.service.TrackingService;

@Controller
public class TrackingController {
	
	@Autowired
	private TrackingService trackingService;

	@RequestMapping("/p/tracking.do")
	@ResponseBody
	public String doGet() {
		List<Tracking> list = new ArrayList<Tracking>();
		list = trackingService.myFavorite("kitty");
		System.out.println(list);
		String jsonString = JSONValue.toJSONString(list);
		
		return jsonString;
		
	}
}
