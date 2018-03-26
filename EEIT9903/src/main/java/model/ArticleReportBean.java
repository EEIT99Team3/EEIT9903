package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REPORT")
public class ArticleReportBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer report_number;
	private Integer article_number;
	private String m_account;
	private String type_of_report;
	private String report_content;
	private java.util.Date report_date;
	private boolean processed;
	private String article_title;
	
	
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	@Override
	public String toString() {
		return "ArticleReportBean [report_number=" + report_number + ", article_number=" + article_number
				+ ", m_account=" + m_account + ", type_of_report=" + type_of_report + ", report_content="
				+ report_content + ", report_date=" + report_date + ", processed=" + processed + "]";
	}
	public Integer getReport_number() {
		return report_number;
	}
	public void setReport_number(Integer report_number) {
		this.report_number = report_number;
	}
	public Integer getArticle_number() {
		return article_number;
	}
	public void setArticle_number(Integer article_number) {
		this.article_number = article_number;
	}
	public String getM_account() {
		return m_account;
	}
	public void setM_account(String m_account) {
		this.m_account = m_account;
	}
	public String getType_of_report() {
		return type_of_report;
	}
	public void setType_of_report(String type_of_report) {
		this.type_of_report = type_of_report;
	}
	public String getReport_content() {
		return report_content;
	}
	public void setReport_content(String report_content) {
		this.report_content = report_content;
	}
	public java.util.Date getReport_date() {
		return report_date;
	}
	public void setReport_date(java.util.Date report_date) {
		this.report_date = report_date;
	}
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
	
}
