package edu0425.spring.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import edu0425.spring.vo.DeptInfo;

public interface DeptMapper {

	@Select("select * from dept")
	@RequestMapping("deptInfoResult")
	List<DeptInfo> getDeptList();
	
	@Select("select * from dept where deptno=#{deptno}")
	@RequestMapping("deptInfoResult")
	DeptInfo getDeptById(@Param("deptno") Integer deptno); // 通过id 获取deptno
	
	@Select("select count(*) from dept")
	Integer getDeptCount();

	@Select("select * from dept limit #{cursor}, #{offset}")
	@RequestMapping("deptInfoResult")
	List<DeptInfo> getDeptPage(@Param("cursor") Integer cursor, @Param("offset") Integer offset);

	Integer addDept(DeptInfo dept);

	Integer updateDept(DeptInfo dept);

	@Delete("delete from dept where deptno=#{deptno}")
	Integer deleteDept(@Param("deptno") Integer deptno);

}
