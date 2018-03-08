package model.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import model.Price;
import model.dao.PriceDAOHibernate;

@Service
public class HighStockService {
	
	@Autowired
	private PriceDAOHibernate priceDao; 
	
	public org.json.JSONArray select(String stockId){
		
	List<Price> list = priceDao.select(stockId);
	//	if(list!=null && !list.isEmpty()) {
			org.json.JSONArray outter = new org.json.JSONArray();
			for(Price temp : list) {
				org.json.JSONArray array = new org.json.JSONArray();
				array.put(temp.getId().getPriceDate().getTime());          // the date
				array.put(temp.getPriceOpen());                            // open
				array.put(temp.getPriceHighest());                         // high
				array.put(temp.getPriceLowest());                          // low
				array.put(temp.getPriceClose());                           // close
				array.put(temp.getVolume());                               //volume
				
				outter.put(array);
			}
			return outter;
	}
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.config.xml");
		
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		sessionFactory.getCurrentSession().beginTransaction();
		
		HighStockService service = (HighStockService) context.getBean("highStockService");
		
		
	//	sessionFactory.getCurrentSession().beginTransaction();
		
		org.json.JSONArray result = service.select("2330");
		System.out.println(result);
		
//		sessionFactory.getCurrentSession().getTransaction().commit();
//		sessionFactory.getCurrentSession().close();
		
		
		((ConfigurableApplicationContext) context).close();

	}
	
}
