package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
/**
 * 
* FileName : Restaurant.java
* Comment  : Part1. 
* @author  : ajchoi
* @date    : 2021. 1. 6.
* @version : 1.0
* @encoded : UTF-8
 */
@Component // 스프링에게 해당 클래스가 스프링에서 관리해야하는 대상임을 표시하는 어노테이션.
@Data
public class Restaurant { // p56, Restaurant 클래스의 객체는 Chef 클래스 타입의 객체를 필요로한다는 상황.
	@Setter(onMethod_ = @Autowired) // 자동으로 setChef()를 컴파일시 생성하는 어노테이션(lombok라이브러리)
	private Chef chef;
	
}
