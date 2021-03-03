package org.zerock.mapper;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo); // use foreign key bet. pk tbl_board(bno) and tbl_reply(bno)
	
	/*p384 Read*/
	public ReplyVO read(Long bno); 
	
	/*p385 Delete */
	public int delete(Long bno);
	
	/*p386 Update*/
	public int update(ReplyVO reply);
}
