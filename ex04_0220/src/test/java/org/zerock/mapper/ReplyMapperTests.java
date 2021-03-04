package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	/* 테스트 전 해당 번호의 게시물이 존재하는지 반드시 확인. */
	private Long[] bnoArr = { 1310764L, 1310763L, 1310762L, 1310741L, 1310725L };

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Test
	public void testMapper() {
		log.info(mapper); /* Test whether it is available to use an object of ReplyMapper */
	}

	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();

			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("replyer" + i);

			mapper.insert(vo);

		});
	}

	@Test
	public void testRead() {
		Long targetBno = 5L; // Bno =5 인걸 Read() 할래
		ReplyVO vo = mapper.read(targetBno);
		log.info(vo);
	}

	@Test
	public void testDelete() {
		Long targetRno = 1L; // Rno = 1 인걸
		mapper.delete(targetRno);
	}

	@Test 
	public void testUpdate() {
		Long targetRno = 10L;
		
		ReplyVO vo = mapper.read(targetRno); // update object ReplyVO referenced as vo
		
		vo.setReply("Update Reply");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT: "+ count );
	}
	
	@Test 
	public void testList() {
		Criteria  cri = new Criteria();
		//ex. bnoArr[0] 
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply->log.info(reply)); // 해당 bno의 reply들을 전부 가져옴
	}
	
	
	
}
