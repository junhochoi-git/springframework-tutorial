package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/*6.3 Controller의 파라미터 수집 - 객체 리스트*/

@Data
public class SampleDTOList {
	private List<SampleDTO> list;
	
	public SampleDTOList() {
		list = new ArrayList<>();//<SampleDTO>
	}
}
