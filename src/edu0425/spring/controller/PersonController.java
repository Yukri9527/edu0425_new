package edu0425.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu0425.common.page.PaginationResult;
import edu0425.spring.service.PersonService;
import edu0425.spring.vo.PersonInfo;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	
	// http://localhost:8080/edu0425_new/person/page?pageIndex=1&pageSize=10
	// http://localhost:8080/edu0425_new/person/index?pageIndex=1&pageSize=10
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	@ResponseBody
	public PaginationResult<List<PersonInfo>> getPage(Integer pageIndex, Integer pageSize) {
		return personService.getPersonPage(pageIndex, pageSize);
	}
}
