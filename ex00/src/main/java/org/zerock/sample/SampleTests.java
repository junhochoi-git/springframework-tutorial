package org.zerock.sample;
/**
 * 
* FileName : SampleTest.java
* Comment  : spring-test 모듈을 이용해서 간단하게 스프링을 가동시키고, p60에서 설명하는 동작을 일어나게함.
* @author  : ajchoi
* @date    : 2021. 1. 6.
* @version : 1.0
* @encoded : UTF-8
 */
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	@Setter(onMethod_= {@Autowired})
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("--------------------------");
		log.info(restaurant.getChef());
	}
}
