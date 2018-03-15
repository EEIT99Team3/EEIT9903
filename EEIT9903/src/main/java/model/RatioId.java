package model;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RatioId implements java.io.Serializable {
	@Override
	public String toString() {
		return "RatioId [stockId=" + stockId + ", ratYear=" + ratYear + ", ratSeason=" + ratSeason + "]";
	}
	private static final long serialVersionUID = 1L;
	private String stockId;
	private Integer ratYear;
	private Integer ratSeason;

	public RatioId() {
	}

	public RatioId(String stockId, Integer ratYear, Integer ratSeason) {
		this.stockId = stockId;
		this.ratYear = ratYear;
		this.ratSeason = ratSeason;
	}

	@Column(name = "stock_id", nullable = false, length = 4)
	public String getStockId() {
		return this.stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	@Column(name = "rat_year", nullable = false)
	public Integer getRatYear() {
		return this.ratYear;
	}

	public void setRatYear(Integer ratYear) {
		this.ratYear = ratYear;
	}

	@Column(name = "rat_season", nullable = false)
	public Integer getRatSeason() {
		return this.ratSeason;
	}

	public void setRatSeason(Integer ratSeason) {
		this.ratSeason = ratSeason;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RatioId))
			return false;
		RatioId castOther = (RatioId) other;

		return ((this.getStockId() == castOther.getStockId()) || (this.getStockId() != null
				&& castOther.getStockId() != null && this.getStockId().equals(castOther.getStockId())))
				&& (this.getRatYear() == castOther.getRatYear()) && (this.getRatSeason() == castOther.getRatSeason());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStockId() == null ? 0 : this.getStockId().hashCode());
		result = 37 * result + this.getRatYear();
		result = 37 * result + this.getRatSeason();
		return result;
	}

}
