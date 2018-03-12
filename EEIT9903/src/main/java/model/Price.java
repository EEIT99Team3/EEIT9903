package model;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRICE", schema = "dbo", catalog = "Project1")
public class Price implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private PriceId id;
	private Company company;
	private BigDecimal priceOpen;
	private BigDecimal priceClose;
	private BigDecimal priceHighest;
	private BigDecimal priceLowest;
	private Long volume;
	private BigDecimal peRatio;
	private BigDecimal yieldRate;

	@Override
	public String toString() {
		return "Price [" + "priceOpen=" + priceOpen + ", priceClose=" + priceClose + ", priceHighest=" + priceHighest
				+ ", priceLowest=" + priceLowest + ", volume=" + volume + ", peRatio=" + peRatio + ", yieldRate="
				+ yieldRate + "]";
	}
	
	public Price() {
	}

	public Price(PriceId id, Company company) {
		this.id = id;
		this.company = company;
	}

	public Price(PriceId id, Company company, BigDecimal priceOpen, BigDecimal priceClose, BigDecimal priceHighest,
			BigDecimal priceLowest, Long volume, BigDecimal peRatio, BigDecimal yieldRate) {
		this.id = id;
		this.company = company;
		this.priceOpen = priceOpen;
		this.priceClose = priceClose;
		this.priceHighest = priceHighest;
		this.priceLowest = priceLowest;
		this.volume = volume;
		this.peRatio = peRatio;
		this.yieldRate = yieldRate;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "stockId", column = @Column(name = "stock_id", nullable = false, length = 4)),
			@AttributeOverride(name = "priceDate", column = @Column(name = "price_date", nullable = false, length = 10)) })
	public PriceId getId() {
		return this.id;
	}

	public void setId(PriceId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stock_id", nullable = false, insertable = false, updatable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = "price_open", scale = 1)
	public BigDecimal getPriceOpen() {
		return this.priceOpen;
	}

	public void setPriceOpen(BigDecimal priceOpen) {
		this.priceOpen = priceOpen;
	}

	@Column(name = "price_close", scale = 1)
	public BigDecimal getPriceClose() {
		return this.priceClose;
	}

	public void setPriceClose(BigDecimal priceClose) {
		this.priceClose = priceClose;
	}

	@Column(name = "price_highest", scale = 1)
	public BigDecimal getPriceHighest() {
		return this.priceHighest;
	}

	public void setPriceHighest(BigDecimal priceHighest) {
		this.priceHighest = priceHighest;
	}

	@Column(name = "price_lowest", scale = 1)
	public BigDecimal getPriceLowest() {
		return this.priceLowest;
	}

	public void setPriceLowest(BigDecimal priceLowest) {
		this.priceLowest = priceLowest;
	}

	@Column(name = "volume")
	public Long getVolume() {
		return this.volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	@Column(name = "pe_ratio")
	public BigDecimal getPeRatio() {
		return this.peRatio;
	}

	public void setPeRatio(BigDecimal peRatio) {
		this.peRatio = peRatio;
	}

	@Column(name = "yield_rate")
	public BigDecimal getYieldRate() {
		return this.yieldRate;
	}

	public void setYieldRate(BigDecimal yieldRate) {
		this.yieldRate = yieldRate;
	}

}
