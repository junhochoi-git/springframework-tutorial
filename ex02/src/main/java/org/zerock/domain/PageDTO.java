package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	/* view 에서 페이징 처리를 위한 클래스 */
	private int startPage;
	private int endPage;
	private boolean prev, next;

	private int total;
	private Criteria cri;

	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;

		// It is easier to define endPage first
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;

		this.startPage = this.endPage - 9;

		int realEnd = (int) (Math.ceil(total * 1.0) / cri.getAmount()); // to count realEndPage

		this.endPage = realEnd <= endPage ? realEnd : endPage;

		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;

	}

}
