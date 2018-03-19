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

	private String stock_id;
	private String news_title;
	private Date news_date;
	@Id
	private String news_website;
	private String news_source;
	
	@Override
	public String toString() {
		return "NewsBean [stock_id=" + stock_id + ", news_title=" + news_title + ", news_date=" + news_date
				+ ", news_website=" + news_website + ", news_source=" + news_source + "]";
	}
	
	public String getStock_id() {
		return stock_id;
	}
	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
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
