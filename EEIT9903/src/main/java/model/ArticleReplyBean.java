package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="REPLY")
public class ArticleReplyBean {

	private Integer article_number;
	private java.util.Date reply_date;
	private String reply;
	private String m_account;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer reply_number;

	@Override
	public String toString() {
		return "ArticleReplyBean [article_number=" + article_number + ", reply_date=" + reply_date + ", reply=" + reply
				+ ", m_account=" + m_account + "]";
	}

	public Integer getArticle_number() {
		return article_number;
	}

	public void setArticle_number(Integer article_number) {
		this.article_number = article_number;
	}

	public java.util.Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(java.util.Date reply_date) {
		this.reply_date = reply_date;
	}

	public String getReply() {
		return reply;
	}
	
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	public String getM_account() {
		return m_account;
	}

	public void setM_account(String m_account) {
		this.m_account = m_account;
	}



	
	
	
}
