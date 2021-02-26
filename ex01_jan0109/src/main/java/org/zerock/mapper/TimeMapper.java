package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
/*
 *	p94 최소한의 코드를 작성하는 Mapper 인터페이스  
 * 
 * 
*/
public interface TimeMapper {
	
	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	/*page 99 XML 매퍼와 같이 쓰기
	 * 실제 SQL은 XML을 이용해 처리할 것임 goto TimeMapper.xml
	 * */
	public String getTime2();
}
