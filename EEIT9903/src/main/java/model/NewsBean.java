package model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NEWS")
@Embeddable
public class NewsBean {

	@Id
	private String news_website;
	private String stock_id;
	private Date news_date;
	private String news_source;

	@Override
	public String toString() {
		return "NewsBean [stock_id=" + stock_id + ", news_date=" + news_date + ", news_website=" + news_website
				+ ", news_source=" + news_source + "]<br>";
	}
	
	public String getStock_id() {
		return stock_id;
	}
	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
	public Date getNews_date() {
		return news_date;
	}
	public void setNews_date(Date news_date) {
		this.news_date = news_date;
	}
	public String getNews_website() {
		return news_website;
	}
	public void setNews_website(String news_website) {
		this.news_website = news_website;
	}
	public String getNews_source() {
		return news_source;
	}
	public void setNews_source(String news_source) {
		this.news_source = news_source;
	}
}
