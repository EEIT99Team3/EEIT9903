package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class CompanyBean {
	
	@Id
	private String stock_id;
	private String stock_name;
	private String chairman;
	private String manager;
	private Long captial;
	private String stock_website;
	private String tax_number;
	
	@Override
	public String toString() {
		return "CompanyBean [stock_id=" + stock_id + ", stock_name=" + stock_name + ", chairman="
				+ chairman + ", manager=" + manager + ", captial=" + captial + ", stockWebsite=" + stock_website
				+ ", taxNumber=" + tax_number + "]<br>";
	}
	
	public String getStockId() {
		return stock_id;
	}
	public void setStockId(String stock_id) {
		this.stock_id = stock_id;
	}
	public String getStockName() {
		return stock_name;
	}
	public void setStockName(String stock_name) {
		this.stock_name = stock_name;
	}
	
	public String getChairman() {
		return chairman;
	}
	public void setChairman(String chairman) {
		this.chairman = chairman;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Long getCaptial() {
		return captial;
	}
	public void setCaptial(Long captial) {
		this.captial = captial;
	}
	public String getStockWebsite() {
		return stock_website;
	}
	public void setStockWebsite(String stock_website) {
		this.stock_website = stock_website;
	}
	public String getTaxNumber() {
		return tax_number;
	}
	public void setTaxNumber(String tax_number) {
		this.tax_number = tax_number;
	}
}
