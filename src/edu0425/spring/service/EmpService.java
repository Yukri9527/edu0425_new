package edu0425.spring.service;

import java.util.List;

import edu0425.common.page.PaginationResult;
import edu0425.spring.vo.DeptInfo;
import edu0425.spring.vo.EmpInfo;

public interface EmpService {

	List<EmpInfo> getEmpList();

	EmpInfo EmpById(Integer empno); // 通过id 获取emptno

	Integer getEmpCount();

	PaginationResult<List<EmpInfo>> getEmpPage(Integer pageIndex, Integer pageSize);

	Integer addEmp(EmpInfo emp);

	Integer updateEmp(EmpInfo emp);

	Integer deleteEmp(Integer empno);
}
