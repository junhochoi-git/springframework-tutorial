package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO { /* 테이블 설계를 기준으로 작성한다.  */
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
	/*getter setter 등*/
	/*
	 * public Long getBno() { return bno; } public void setBno(Long bno) { this.bno
	 * = bno; } public String getTitle() { return title; } public void
	 * setTitle(String title) { this.title = title; } public String getContent() {
	 * return content; } public void setContent(String content) { this.content =
	 * content; } public String getWriter() { return writer; } public void
	 * setWriter(String writer) { this.writer = writer; } public Date getRegdate() {
	 * return regdate; } public void setRegdate(Date regdate) { this.regdate =
	 * regdate; } public Date getUpdataDate() { return updataDate; } public void
	 * setUpdataDate(Date updataDate) { this.updataDate = updataDate; }
	 */
	

	
	
}
