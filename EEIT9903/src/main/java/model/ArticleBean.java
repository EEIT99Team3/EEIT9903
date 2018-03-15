package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Article")
public class ArticleBean {
	private String m_account;
	private java.util.Date article_date;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer article_number;
	private String article_title;
	private String article;


	public String getM_account() {
		return m_account;
	}

	@Override
	public String toString() {
		return "ArticleBean [m_account=" + m_account + ", article_date=" + article_date + ", article_number="
				+ article_number + ", article_title=" + article_title + ", article=" + article + "]";
	}

	public void setM_account(String m_account) {
		this.m_account = m_account;
	}

	public java.util.Date getArticle_date() {
		return article_date;
	}

	public void setArticle_date(java.util.Date article_date) {
		this.article_date = article_date;
	}

	public Integer getArticle_number() {
		return article_number;
	}

	public void setArticle_number(Integer article_number) {
		this.article_number = article_number;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle() {
		return article;
	}
	
	public void setArticle(String article) {
		this.article = article;
	}
	
	
}
