package org.zerock.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	/* instance fields for a number of the page AND hom many amount will be showed per one page*/
	private int pageNum;	
	private int amount;

	/*15.3 implement search */
	//t, tc, tcw, cw ... 
	private String type; 
	private String keyword;
	
	public Criteria() {
		this(1, 10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	// loop 돌 때 //글자 하나씩 쪼갬 // 동적 SQL문에서 not null 할 수도
	public String[] getTypeArr() {
		return type == null? new String[] {} : type.split("");
	}
}
