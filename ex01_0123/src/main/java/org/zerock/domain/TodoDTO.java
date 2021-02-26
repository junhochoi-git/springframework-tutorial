package org.zerock.domain;
/* p 136 */

import java.util.Date;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	private Date dueDate; // 문자열을 Date 타입으로.
}
