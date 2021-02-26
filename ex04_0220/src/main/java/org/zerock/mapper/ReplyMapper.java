package org.zerock.mapper;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo); // use foreign key bet. pk tbl_board(bno) and tbl_reply(bno)
	
}
