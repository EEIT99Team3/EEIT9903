package model;
//import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY", schema = "dbo", catalog = "Project1")
public class Company implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String stockId;
	private String stockName;
	private String industry;
	private String chairman;
	private String manager;
	private Long captial;
	private String stockWebsite;
	private Integer taxNumber;
	private Set<Price> prices = new HashSet<Price>(0);
	private Set<Price> prices_1 = new HashSet<Price>(0);

	public Company() {
	}

	@Override
	public String toString() {
		return "Company [stockId=" + stockId + ", stockName=" + stockName + ", industry=" + industry + ", chairman="
				+ chairman + ", manager=" + manager + ", captial=" + captial + ", stockWebsite=" + stockWebsite
				+ ", taxNumber=" + taxNumber + ", prices=" + prices + ", prices_1=" + prices_1 + "]";
	}

	public Company(String stockId) {
		this.stockId = stockId;
	}

	public Company(String stockId, String stockName, String industry, String chairman,
			String manager, Long captial, String stockWebsite, Integer taxNumber,Set<Price> prices,Set<Price> prices_1) { 

		this.stockId = stockId;
		this.stockName = stockName;
		this.industry = industry;
		this.chairman = chairman;
		this.manager = manager;
		this.captial = captial;
		this.stockWebsite = stockWebsite;
		this.taxNumber = taxNumber;
		this.prices = prices;
		this.prices_1 = prices_1;
	}

	@Id
	@Column(name = "stock_id", unique = true, nullable = false, length = 4)
	public String getStockId() {
		return this.stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	@Column(name = "stock_name")
	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@Column(name = "industry")
	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Column(name = "chairman")
	public String getChairman() {
		return this.chairman;
	}

	public void setChairman(String chairman) {
		this.chairman = chairman;
	}

	@Column(name = "manager")
	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Column(name = "captial")
	public Long getCaptial() {
		return this.captial;
	}

	public void setCaptial(Long captial) {
		this.captial = captial;
	}

	@Column(name = "stock_website", length = 100)
	public String getStockWebsite() {
		return this.stockWebsite;
	}

	public void setStockWebsite(String stockWebsite) {
		this.stockWebsite = stockWebsite;
	}

	@Column(name = "tax_number")
	public Integer getTaxNumber() {
		return this.taxNumber;
	}

	public void setTaxNumber(Integer taxNumber) {
		this.taxNumber = taxNumber;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Price> getPrices() {
		return this.prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Price> getPrices_1() {
		return this.prices_1;
	}

	public void setPrices_1(Set<Price> prices_1) {
		this.prices_1 = prices_1;
	}
}
