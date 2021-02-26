package org.zerock.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import org.springframework.http.HttpStatus;

import lombok.extern.log4j.Log4j;

@ControllerAdvice // 해당 객체가 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시하는 용도
@Log4j
public class CommonExceptionAdvice {
	@ExceptionHandler(Exception.class) // ()에 들어가는 예외타입을 처리한다는 것을 의미함. 특정한 타입의 예외를 다루고 싶다면 구체적인 예외의 클래스를 지정해야함.
	public String except(Exception ex, Model model) {
		log.error("Exception....." + ex.getMessage());
		model.addAttribute("exception", ex);
		log.error(model);
		return "sample/error_page";
	}
	/*p159 404 error page*/
	@ExceptionHandler(NoHandlerFoundException.class) // import  org.springframework.web.servlet.NoHandlerFoundException;
	@ResponseStatus(HttpStatus.NOT_FOUND) //import org.springframework.web.bind.annotation.ResponseStatus; import org.springframework.http.HttpStatus;
	public String handle404(NoHandlerFoundException ex) {
		return "custom404";
	}
}
