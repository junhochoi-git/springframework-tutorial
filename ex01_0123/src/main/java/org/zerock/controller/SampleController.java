package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/* Part2 - ch6 p 127 예제 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;
import org.zerock.domain.TodoDTO2;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("basic..................");
	}
	
	/* 130p */
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(""+dto);
		
		return "ex01";
	}
	/* 132p */
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		
		return "ex02";
	}
	/* 133p */
	@GetMapping("/ex02List")
	public String ex03(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
	}
	/* 134p */
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos"+ list);
		return "ex02Bean";
	}
	
	/*137p initBinder 예제 */
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new
	 * CustomDateEditor(dateFormat, false));
	 * 
	 * }
	 */
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo : "+todo);
		return "ex03";
	}
	
	/* p 138 */
	@GetMapping("/ex03_2")
	public String ex03_2(TodoDTO2 todo) {
		log.info("todo : " + todo);
		return "ex03_2";
	}
	
	/* p141 */
	/*
	 * @GetMapping("/ex04") public String ex04(SampleDTO dto, int page) {
	 * log.info("dto : "+dto); log.info("page : " + page); return "/sample/ex04"; //
	 * 해당 jsp }
	 */
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page")int page) {
		log.info("dto: " + dto);
		log.info("page: " + page);
		return "/sample/ex04";
	}
	/*p146*/
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() { //import org.springframework.web.bind.annotation.ResponseBody;
		log.info("/ex06");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("최준호");
		return dto;
	}
	/*p148*/
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){ // import org.springframework.http.ResponseEntity<String>
		log.info("/ex07.....");
		//{"name":"홍길동"}
		String msg="{\"name\": \"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders(); // import org.springframework.http.ResponseEntity<String>
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg,header, HttpStatus.OK);
	}
	/*p150*/
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload.............");
	}
	/*p152*/
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) { // import org.springframework.web.multipart.MultipartFile
		files.forEach(file->{
			log.info("-------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : "+file.getSize());			
		});
		
	}
	
	
}
