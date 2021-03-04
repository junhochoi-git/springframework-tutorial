package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo); // use foreign key bet. pk tbl_board(bno) and tbl_reply(bno)
	
	/*p384 Read*/
	public ReplyVO read(Long bno); 
	
	/*p385 Delete */
	public int delete(Long bno);
	
	/*p386 Update*/
	public int update(ReplyVO reply);
	
	/*p387 use @Param to pass more than two datas as parameters */
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri , @Param("bno") Long bno);
	
}
