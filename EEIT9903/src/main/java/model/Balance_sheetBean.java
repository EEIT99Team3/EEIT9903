package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BALANCE_SHEET")
public class Balance_sheetBean {
	
	@EmbeddedId
	private Balance_sheetPK balance_sheetPK;
	private Long account_receivables;
	private Long inventories;
	private Long current_assets;
	private Long non_current_assets;
	private Long total_assets;
	private Long account_payables;
	private Long current_liabilities;
	private Long non_current_liabilities;
	private Long total_liabilities;
	private Long captial_stock;
	private Long total_equity;

	@Override
	public String toString() {
		return "Balance_sheetBean [balance_sheetPK=" + balance_sheetPK + ", account_receivables=" + account_receivables
				+ ", inventories=" + inventories + ", current_assets=" + current_assets + ", non_current_assets="
				+ non_current_assets + ", total_assets=" + total_assets + ", account_payables=" + account_payables
				+ ", current_liabilities=" + current_liabilities + ", non_current_liabilities="
				+ non_current_liabilities + ", total_liabilities=" + total_liabilities + ", captial_stock="
				+ captial_stock + ", total_equity=" + total_equity + "]";
	}
	
	public Balance_sheetPK getBalance_sheetPK() {
		return balance_sheetPK;
	}
	public void setBalance_sheetPK(Balance_sheetPK balance_sheetPK) {
		this.balance_sheetPK = balance_sheetPK;
	}
	public long getAccount_receivables() {
		return account_receivables;
	}
	public void setAccount_receivables(Long account_receivables) {
		this.account_receivables = account_receivables;
	}
	public long getInventories() {
		return inventories;
	}
	public void setInventories(Long inventories) {
		this.inventories = inventories;
	}
	public long getCurrent_assets() {
		return current_assets;
	}
	public void setCurrent_assets(Long current_assets) {
		this.current_assets = current_assets;
	}
	public long getNon_current_assets() {
		return non_current_assets;
	}
	public void setNon_current_assets(Long non_current_assets) {
		this.non_current_assets = non_current_assets;
	}
	public long getTotal_assets() {
		return total_assets;
	}
	public void setTotal_assets(Long total_assets) {
		this.total_assets = total_assets;
	}
	public long getAccount_payables() {
		return account_payables;
	}
	public void setAccount_payables(Long account_payables) {
		this.account_payables = account_payables;
	}
	public long getCurrent_liabilities() {
		return current_liabilities;
	}
	public void setCurrent_liabilities(Long current_liabilities) {
		this.current_liabilities = current_liabilities;
	}
	public long getNon_current_liabilities() {
		return non_current_liabilities;
	}
	public void setNon_current_liabilities(Long non_current_liabilities) {
		this.non_current_liabilities = non_current_liabilities;
	}
	public long getTotal_liabilities() {
		return total_liabilities;
	}
	public void setTotal_liabilities(Long total_liabilities) {
		this.total_liabilities = total_liabilities;
	}
	public long getCaptial_stock() {
		return captial_stock;
	}
	public void setCaptial_stock(Long captial_stock) {
		this.captial_stock = captial_stock;
	}
	public long getTotal_equity() {
		return total_equity;
	}
	public void setTotal_equity(Long total_equity) {
		this.total_equity = total_equity;
	}
	
}
