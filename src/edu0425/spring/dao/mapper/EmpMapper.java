package edu0425.spring.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import edu0425.spring.vo.EmpInfo;

public interface EmpMapper {

	@Select("select * from emp")
	@RequestMapping("empInfoResult")
	List<EmpInfo> getEmpList();

	@Select("select * from emp where empno=#{empno}")
	@RequestMapping("empInfoResult")
	EmpInfo getEmpById(@Param("empno") Integer empno); // 通过id 获取deptno

	@Select("select count(*) from emp")
	Integer getEmpCount();

	@Select("select * from emp limit #{cursor}, #{offset}")
	@RequestMapping("empInfoResult")
	List<EmpInfo> getEmpPage(@Param("cursor") Integer cursor, @Param("offset") Integer offset);

	Integer addEmp(EmpInfo emp);

	Integer updateEmp(EmpInfo emp);

	@Delete("delete from emp where empno=#{empno}")
	Integer deleteEmp(@Param("empno") Integer empno);

}
