package edu0425.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu0425.common.page.Pagination;
import edu0425.common.page.PaginationResult;
import edu0425.spring.dao.mapper.PersonMapper;
import edu0425.spring.service.PersonService;
import edu0425.spring.vo.PersonInfo;

@Component
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper personMapper;

	@Override
	public Integer getTotalCount() {
		return personMapper.getTotalCount();
	}

	@Override
	public PaginationResult<List<PersonInfo>> getPersonPage(Integer pageIndex, Integer pageSize) {
		Pagination pagination = new Pagination(pageIndex, pageSize);
		Integer totalCount = getTotalCount();
		pagination.setTotalCount(totalCount);

		List<PersonInfo> list = personMapper.getPerson(pagination.getCursor(), pagination.getOffset());

		pagination.setCurrentPageCount(list.size());
		PaginationResult<List<PersonInfo>> result = new PaginationResult<List<PersonInfo>>(pagination, list);
		return result;
	}

}
