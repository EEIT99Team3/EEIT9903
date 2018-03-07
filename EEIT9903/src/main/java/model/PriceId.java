package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PriceId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String stockId;
	private Date priceDate;

	public PriceId() {
	}

	@Override
	public String toString() {
		return "PriceId [stockId=" + stockId + ", priceDate=" + priceDate + "]";
	}

	public PriceId(String stockId, Date priceDate) {
		this.stockId = stockId;
		this.priceDate = priceDate;
	}

	@Column(name = "stock_id", nullable = false, length = 4)
	public String getStockId() {
		return this.stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	@Column(name = "price_date", nullable = false, length = 10)
	public Date getPriceDate() {
		return this.priceDate;
	}

	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PriceId))
			return false;
		PriceId castOther = (PriceId) other;

		return ((this.getStockId() == castOther.getStockId()) || (this.getStockId() != null
				&& castOther.getStockId() != null && this.getStockId().equals(castOther.getStockId())))
				&& ((this.getPriceDate() == castOther.getPriceDate()) || (this.getPriceDate() != null
						&& castOther.getPriceDate() != null && this.getPriceDate().equals(castOther.getPriceDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStockId() == null ? 0 : this.getStockId().hashCode());
		result = 37 * result + (getPriceDate() == null ? 0 : this.getPriceDate().hashCode());
		return result;
	}

}
