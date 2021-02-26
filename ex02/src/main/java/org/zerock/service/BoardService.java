package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	/* public List<BoardVO> getList(); */
	
	/* p299 13.2 to handle paging, i revised my code to get Criteria instance as a parameter */
	public List<BoardVO> getList(Criteria cri);
	
	/* p323 전체 데이터 개수 처리*/
	public int getTotal(Criteria cri);
	
}
