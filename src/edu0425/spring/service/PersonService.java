package edu0425.spring.service;

import java.util.List;

import edu0425.common.page.PaginationResult;
import edu0425.spring.vo.PersonInfo;

public interface PersonService {

	Integer getTotalCount();

	PaginationResult<List<PersonInfo>> getPersonPage(Integer pageIndex, Integer pageSize);

}
