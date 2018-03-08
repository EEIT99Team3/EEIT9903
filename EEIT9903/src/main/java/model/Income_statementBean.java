package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="INCOME_STATEMENT")
public class Income_statementBean {
	
	@EmbeddedId
	private Income_statementPK income_StatementPK;
	private Long revenues;
	private Long costs;
	private Long gross_profit;
	private Long operating_expense;
	private Long operating_income;
	private Long other_revenues;
	private Long before_tax_income;
	private Long tax_expense;
	private Long net_income;
	
	@Override
	public String toString() {
		return "Income_statementBean [income_StatementPK=" + income_StatementPK + ", revenues=" + revenues + ", costs="
				+ costs + ", gross_profit=" + gross_profit + ", operating_expense=" + operating_expense
				+ ", operating_income=" + operating_income + ", other_revenues=" + other_revenues
				+ ", before_tax_income=" + before_tax_income + ", tax_expense=" + tax_expense + ", net_income="
				+ net_income + "]";
	}
	
	public Income_statementPK getIncome_StatementPK() {
		return income_StatementPK;
	}
	public void setIncome_StatementPK(Income_statementPK income_StatementPK) {
		this.income_StatementPK = income_StatementPK;
	}
	public Long getRevenues() {
		return revenues;
	}
	public void setRevenues(Long revenues) {
		this.revenues = revenues;
	}
	public Long getCosts() {
		return costs;
	}
	public void setCosts(Long costs) {
		this.costs = costs;
	}
	public Long getGross_profit() {
		return gross_profit;
	}
	public void setGross_profit(Long gross_profit) {
		this.gross_profit = gross_profit;
	}
	public Long getOperating_expense() {
		return operating_expense;
	}
	public void setOperating_expense(Long operating_expense) {
		this.operating_expense = operating_expense;
	}
	public Long getOperating_income() {
		return operating_income;
	}
	public void setOperating_income(Long operating_income) {
		this.operating_income = operating_income;
	}
	public Long getOther_revenues() {
		return other_revenues;
	}
	public void setOther_revenues(Long other_revenues) {
		this.other_revenues = other_revenues;
	}
	public Long getBefore_tax_income() {
		return before_tax_income;
	}
	public void setBefore_tax_income(Long before_tax_income) {
		this.before_tax_income = before_tax_income;
	}
	public Long getTax_expense() {
		return tax_expense;
	}
	public void setTax_expense(Long tax_expense) {
		this.tax_expense = tax_expense;
	}
	public Long getNet_income() {
		return net_income;
	}
	public void setNet_income(Long net_income) {
		this.net_income = net_income;
	}
	
	

}
