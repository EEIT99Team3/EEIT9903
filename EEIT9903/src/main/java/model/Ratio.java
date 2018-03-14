package model;
import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RATIO", schema = "dbo", catalog = "Project1")
public class Ratio implements java.io.Serializable {
	@Override
	public String toString() {
		return "Ratio [id=" + id + ", eps=" + eps + ", bvps=" + bvps + ", gpMargin=" + gpMargin + ", opMargin="
				+ opMargin + ", niMargin=" + niMargin + ", roe=" + roe + ", roa=" + roa + ", arTurnover=" + arTurnover
				+ ", invTurnover=" + invTurnover + ", apTurnover=" + apTurnover + ", debtRatio=" + debtRatio
				+ ", currentRatio=" + currentRatio + ", fcfGrowth=" + fcfGrowth + ", ocfGrowth=" + ocfGrowth
				+ ", revenuesGrowth=" + revenuesGrowth + "]";
	}
	private static final long serialVersionUID = 1L;
	private RatioId id;
	private BigDecimal eps;
	private BigDecimal bvps;
	private BigDecimal gpMargin;
	private BigDecimal opMargin;
	private BigDecimal niMargin;
	private BigDecimal roe;
	private BigDecimal roa;
	private BigDecimal arTurnover;
	private BigDecimal invTurnover;
	private BigDecimal apTurnover;
	private BigDecimal debtRatio;
	private BigDecimal currentRatio;
	private BigDecimal fcfGrowth;
	private BigDecimal ocfGrowth;
	private BigDecimal revenuesGrowth;

	public Ratio() {
	}

	public Ratio(RatioId id) {
		this.id = id;
	}

	public Ratio(RatioId id, BigDecimal eps, BigDecimal bvps, BigDecimal gpMargin, BigDecimal opMargin,
			BigDecimal niMargin, BigDecimal roe, BigDecimal roa, BigDecimal arTurnover, BigDecimal invTurnover,
			BigDecimal apTurnover, BigDecimal debtRatio, BigDecimal currentRatio, BigDecimal fcfGrowth,
			BigDecimal ocfGrowth, BigDecimal revenuesGrowth) {
		this.id = id;
		this.eps = eps;
		this.bvps = bvps;
		this.gpMargin = gpMargin;
		this.opMargin = opMargin;
		this.niMargin = niMargin;
		this.roe = roe;
		this.roa = roa;
		this.arTurnover = arTurnover;
		this.invTurnover = invTurnover;
		this.apTurnover = apTurnover;
		this.debtRatio = debtRatio;
		this.currentRatio = currentRatio;
		this.fcfGrowth = fcfGrowth;
		this.ocfGrowth = ocfGrowth;
		this.revenuesGrowth = revenuesGrowth;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "stockId", column = @Column(name = "stock_id", nullable = false, length = 4)),
			@AttributeOverride(name = "ratYear", column = @Column(name = "rat_year", nullable = false)),
			@AttributeOverride(name = "ratSeason", column = @Column(name = "rat_season", nullable = false)) })
	public RatioId getId() {
		return this.id;
	}

	public void setId(RatioId id) {
		this.id = id;
	}

	@Column(name = "eps", precision = 9)
	public BigDecimal getEps() {
		return this.eps;
	}

	public void setEps(BigDecimal eps) {
		this.eps = eps;
	}

	@Column(name = "bvps", precision = 9)
	public BigDecimal getBvps() {
		return this.bvps;
	}

	public void setBvps(BigDecimal bvps) {
		this.bvps = bvps;
	}

	@Column(name = "gp_margin", precision = 9)
	public BigDecimal getGpMargin() {
		return this.gpMargin;
	}

	public void setGpMargin(BigDecimal gpMargin) {
		this.gpMargin = gpMargin;
	}

	@Column(name = "op_margin", precision = 9)
	public BigDecimal getOpMargin() {
		return this.opMargin;
	}

	public void setOpMargin(BigDecimal opMargin) {
		this.opMargin = opMargin;
	}

	@Column(name = "ni_margin", precision = 9)
	public BigDecimal getNiMargin() {
		return this.niMargin;
	}

	public void setNiMargin(BigDecimal niMargin) {
		this.niMargin = niMargin;
	}

	@Column(name = "roe", precision = 9)
	public BigDecimal getRoe() {
		return this.roe;
	}

	public void setRoe(BigDecimal roe) {
		this.roe = roe;
	}

	@Column(name = "roa", precision = 9)
	public BigDecimal getRoa() {
		return this.roa;
	}

	public void setRoa(BigDecimal roa) {
		this.roa = roa;
	}

	@Column(name = "ar_turnover", precision = 9)
	public BigDecimal getArTurnover() {
		return this.arTurnover;
	}

	public void setArTurnover(BigDecimal arTurnover) {
		this.arTurnover = arTurnover;
	}

	@Column(name = "inv_turnover", precision = 9)
	public BigDecimal getInvTurnover() {
		return this.invTurnover;
	}

	public void setInvTurnover(BigDecimal invTurnover) {
		this.invTurnover = invTurnover;
	}

	@Column(name = "ap_turnover", precision = 9)
	public BigDecimal getApTurnover() {
		return this.apTurnover;
	}

	public void setApTurnover(BigDecimal apTurnover) {
		this.apTurnover = apTurnover;
	}

	@Column(name = "debt_ratio", precision = 9)
	public BigDecimal getDebtRatio() {
		return this.debtRatio;
	}

	public void setDebtRatio(BigDecimal debtRatio) {
		this.debtRatio = debtRatio;
	}

	@Column(name = "current_ratio", precision = 9)
	public BigDecimal getCurrentRatio() {
		return this.currentRatio;
	}

	public void setCurrentRatio(BigDecimal currentRatio) {
		this.currentRatio = currentRatio;
	}

	@Column(name = "fcf_growth")
	public BigDecimal getFcfGrowth() {
		return this.fcfGrowth;
	}

	public void setFcfGrowth(BigDecimal fcfGrowth) {
		this.fcfGrowth = fcfGrowth;
	}

	@Column(name = "ocf_growth")
	public BigDecimal getOcfGrowth() {
		return this.ocfGrowth;
	}

	public void setOcfGrowth(BigDecimal ocfGrowth) {
		this.ocfGrowth = ocfGrowth;
	}

	@Column(name = "revenues_growth", precision = 9)
	public BigDecimal getRevenuesGrowth() {
		return this.revenuesGrowth;
	}

	public void setRevenuesGrowth(BigDecimal revenuesGrowth) {
		this.revenuesGrowth = revenuesGrowth;
	}

}
