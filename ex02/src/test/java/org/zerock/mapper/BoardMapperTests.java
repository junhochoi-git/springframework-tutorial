package org.zerock.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//Java Congig
//@ContextConfiguration(classes={org.zerock.config.RootConfig.class})
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board->log.info(board)); // List관련 오우 
		
	}
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("Test");
		board.setContent("Test");
		board.setWriter("Test");
		
		mapper.insert(board);
		
		log.info(board);
	}
	@Test 
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 selectt key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
		
	}
	@Test
	public void testRead() {
		//존재하는 게시물 번호로 테스트
		BoardVO board = mapper.read(5L);
		log.info(board);
	}
	
	@Test 
	public void testDelete() {
		log.info("DELETE COUNT : " + mapper.delete(3L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		//실행전 존재하는 번호인지 확인할 것
		board.setBno(5L);
		board.setTitle("수정된 번호");
		board.setContent("수정된 내용");
		board.setWriter("user00");	
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT : " + count);
	}
	/* testing whether paging is working */
	/*
	 * @Test public void testPaging() { Criteria cri = new Criteria(); List<BoardVO>
	 * list = mapper.getListWithPaging(cri); list.forEach(board->log.info(board)); }
	 */
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		//10개식 3페이지 
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board->log.info(board.getBno()));
		
	}
	/*ch15 test search paging*/
	@Test
	public void testSearchPaging() {

		Criteria cri = new Criteria();
		//10개식 3페이지 
		cri.setKeyword("Test");

		cri.setType("T");
		
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board->log.info(board));
		
	}
	
	/*p322 14.6 testGetTotalCount*/
	/*p336 test serach()*/
	@Test 
	public void testSearch() {
		/*BoardMapper인터페이스에서 멤버로 선언, BoardMapper.xml에서 구현, BoardMapperTest클래스에서 테스트*/
		Map<String, String> map = new HashMap<>();
		
		 map.put("T", "TTT"); map.put("C", "CCC"); map.put("W", "WWW");
		 
		//조건없을떄도 확인해줘야함
		
		Map<String, Map<String,String>> outer = new HashMap<>();
		outer.put("map", map); //map 안에 map 을 넣었네요
		List<BoardVO> list = mapper.searchTest(outer);
		
		log.info(list);
	}
	
}
