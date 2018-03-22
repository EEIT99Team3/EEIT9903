package model.service;

import model.Balance_sheetBean;
import model.Income_statementBean;

public class RatioServiceBean {
	@Override
	public String toString() {
		return "RatioServiceBean [income_statementBean=" + income_statementBean + ", balance_sheetBean="
				+ balance_sheetBean + ", income_statementBeanlast=" + income_statementBeanlast
				+ ", balance_sheetBeanlast=" + balance_sheetBeanlast + "]";
	}
	
	public Income_statementBean income_statementBean;
	public Balance_sheetBean balance_sheetBean;
	public Income_statementBean income_statementBeanlast;
	public Balance_sheetBean balance_sheetBeanlast;
	public RatioServiceBean() {}
	public RatioServiceBean(Income_statementBean income_statementBean,Balance_sheetBean balance_sheetBean,Income_statementBean income_statementBeanlast,Balance_sheetBean balance_sheetBeanlast) {
		this.income_statementBean = income_statementBean;
		this.balance_sheetBean = balance_sheetBean;
		this.income_statementBeanlast = income_statementBeanlast;
		this.balance_sheetBeanlast = balance_sheetBeanlast;
	}
}
