package edu0425.spring.service;

import java.util.List;

import edu0425.common.page.PaginationResult;
import edu0425.spring.vo.DeptInfo;

public interface DeptService {
	/*
	 * 获得部门列表
	 * 
	 */
	List<DeptInfo> getDeptList();

	DeptInfo getDeptById(Integer deptno); // 通过id 获取deptno

	Integer getDeptCount();

	PaginationResult<List<DeptInfo>> getDeptPage(Integer pageIndex, Integer pageSize);

	Integer addDept(DeptInfo dept);

	Integer updateDept(DeptInfo dept);
	
	Integer deleteDept(Integer deptno);
}
