package edu0425.spring.dao;

import java.util.List;

import edu0425.spring.vo.EmpInfo;

public interface EmpDAO {

	List<EmpInfo> getEmpList();

	EmpInfo EmpById(Integer empno); // ͨ��id ��ȡemptno

	Integer getEmpCount();

}
