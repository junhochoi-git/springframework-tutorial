package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	//spring 4.3 이상에서 자동 처리
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		log.info("register....."+board);
		mapper.insertSelectKey(board); // 나중에 생성된 게시물의 번호를 확인 할 수 있게 
	}

	@Override
	public BoardVO get(Long bno) { // 9.2.3 조회 작업의 구현
		log.info("get........"+bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) { //9.2.4
		log.info("modify......."+board);
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove......"+bno);
		return mapper.delete(bno)==1;
	}

	/*
	 * @Override public List<BoardVO> getList() { log.info("getList........");
	 * 
	 * return mapper.getList(); }
	 */
	
	/* p299 13.2 to handle paging, i revised my code to get Criteria instance as a parameter */
	@Override
	public List<BoardVO> getList(Criteria cri){
		log.info("get List with criteria : " +cri);
		return mapper.getListWithPaging(cri);
	}
	
	/*p323 전체 실제 게시글 수 구하기*/
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}
	

}
