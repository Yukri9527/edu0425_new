package edu0425.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu0425.common.page.Pagination;
import edu0425.common.page.PaginationResult;
import edu0425.spring.dao.EmpDAO;
import edu0425.spring.dao.impl.EmpDAOImpl;
import edu0425.spring.dao.mapper.DeptMapper;
import edu0425.spring.dao.mapper.EmpMapper;
import edu0425.spring.service.EmpService;
import edu0425.spring.vo.DeptInfo;
import edu0425.spring.vo.EmpInfo;

@Component // ×¢Èë
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper empMapper;
	private EmpDAO empDAO;

	@Override
	public List<EmpInfo> getEmpList() {
//		empDAO = new EmpDAOImpl();
		return empMapper.getEmpList();
	}

	@Override
	public EmpInfo EmpById(Integer empno) {
		// TODO Auto-generated method stub
		return empMapper.getEmpById(empno);
	}

	@Override
	public Integer getEmpCount() {
		// TODO Auto-generated method stub
		return empMapper.getEmpCount();
	}

	@Override
	public PaginationResult<List<EmpInfo>> getEmpPage(Integer pageIndex, Integer pageSize) {
		Pagination pagination = new Pagination(pageIndex, pageSize);
		Integer totalCount = getEmpCount();
		pagination.setTotalCount(totalCount);

		// List<DeptInfo> list=getDeptList(); // all
		List<EmpInfo> list = empMapper.getEmpPage(pagination.getCursor(), pagination.getOffset());
		pagination.setCurrentPageCount(list.size());

		PaginationResult<List<EmpInfo>> result = new PaginationResult<List<EmpInfo>>(pagination, list);
		return result;
	}

	@Override
	public Integer addEmp(EmpInfo emp) {
		// TODO Auto-generated method stub
		return empMapper.addEmp(emp);
	}

	@Override
	public Integer updateEmp(EmpInfo emp) {
		// TODO Auto-generated method stub
		return empMapper.updateEmp(emp);
	}

	@Override
	public Integer deleteEmp(Integer empno) {
		// TODO Auto-generated method stub
		return empMapper.deleteEmp(empno);
	}

}
