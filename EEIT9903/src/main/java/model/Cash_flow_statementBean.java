package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CASH_FLOW_STATEMENT")
public class Cash_flow_statementBean {
	
	@EmbeddedId
	private Cash_flow_statementPK cash_flow_statementPK;
	private Long operating_cash_flow;
	private Long investing_cash_flow;
	private Long financing_cash_flow;
	
	@Override
	public String toString() {
		return "Cash_flow_statementBean [cash_flow_statementPK=" + cash_flow_statementPK + ", operating_cash_flow="
				+ operating_cash_flow + ", investing_cash_flow=" + investing_cash_flow + ", financing_cash_flow="
				+ financing_cash_flow + "]";
	}
	
	public Cash_flow_statementPK getCash_flow_statementPK() {
		return cash_flow_statementPK;
	}
	public void setCash_flow_statementPK(Cash_flow_statementPK cash_flow_statementPK) {
		this.cash_flow_statementPK = cash_flow_statementPK;
	}
	public Long getOperating_cash_flow() {
		return operating_cash_flow;
	}
	public void setOperating_cash_flow(Long operating_cash_flow) {
		this.operating_cash_flow = operating_cash_flow;
	}
	public Long getInvesting_cash_flow() {
		return investing_cash_flow;
	}
	public void setInvesting_cash_flow(Long investing_cash_flow) {
		this.investing_cash_flow = investing_cash_flow;
	}
	public Long getFinancing_cash_flow() {
		return financing_cash_flow;
	}
	public void setFinancing_cash_flow(Long financing_cash_flow) {
		this.financing_cash_flow = financing_cash_flow;
	}
	
}
