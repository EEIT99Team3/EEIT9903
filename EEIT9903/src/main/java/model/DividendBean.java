package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DIVIDEND")
public class DividendBean {
	@Id
	private Integer div_year;
	private String stock_id;
	private Float div_cash;
	private Float div_stock;
	
	@Override
	public String toString() {
		return "DividendBean [stock_id=" + stock_id + ", div_year=" + div_year + ", div_cash=" + div_cash
				+ ", div_stock=" + div_stock + "]<br>";
	}
	
	public String getStock_id() {
		return stock_id;
	}
	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}
	public Integer getDiv_year() {
		return div_year;
	}
	public void setDiv_year(Integer div_year) {
		this.div_year = div_year;
	}
	public Float getDiv_cash() {
		return div_cash;
	}
	public void setDiv_cash(Float div_cash) {
		this.div_cash = div_cash;
	}
	public Float getDiv_stock() {
		return div_stock;
	}
	public void setDiv_stock(Float div_stock) {
		this.div_stock = div_stock;
	}
	
}
