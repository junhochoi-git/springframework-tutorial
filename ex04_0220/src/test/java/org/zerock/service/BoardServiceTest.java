package org.zerock.service;

import static org.junit.Assert.assertNotNull;

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
//Java Config @ContextConfiguration(classes={org.zerock.congfig.RootConfig.class}
@Log4j
public class BoardServiceTest {
	@Setter(onMethod_= {@Autowired})
	private BoardService service;
	
	@Test
	public void testExist() { /* 첫 테스트 : BoardService 객체가 제대로 주입이 가능한지 확인하는 작업.*/
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() { /*register 관련 테스트*/
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : "+ board.getBno()); // primary key bno!
	}
	
	@Test
	public void testGetList() { /*목록 리스트 작업의 구현과 테스트*/
		/* service.getList().forEach(board->log.info(board)); */
		service.getList(new Criteria(2,10)).forEach(board->log.info(board));
	}
	
	@Test 
	public void testGet() { /*조회 작업의 구현과 테스트 */
		log.info(service.get(1L));
	}
	@Test
	public void testUpdate() { /*수정 작업 구현과 테스트 */
		BoardVO board = service.get(1L); // 특정 게시물을 먼저 조회후, title 수정한다음, update
		if(board == null)
			return;
		
		board.setTitle("제목을 수정합니다.");
		log.info("MODIFY RESULT: " + service.modify(board));
	}
	@Test 
	public void testDelete() {
		//게시물의 번호의 존재 여부를 확인하고 테스트할 것.
		log.info("REMOVE RESULT: " + service.remove(2L));
		
	}
}

