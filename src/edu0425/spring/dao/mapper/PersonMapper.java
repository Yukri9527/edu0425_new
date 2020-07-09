package edu0425.spring.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import edu0425.spring.vo.ChartData;
import edu0425.spring.vo.ClubInfo;
import edu0425.spring.vo.NationInfo;
import edu0425.spring.vo.PersonInfo;
import edu0425.spring.vo.PlayerInfo;

public interface PersonMapper {

	@Select("select count(*) from japan_person")
	Integer getTotalCount();

	@Select("select * from japan_person limit #{cursor},#{offset}")
	@RequestMapping("personInfoResult")
	List<PersonInfo> getPerson(@Param("cursor") Integer cursor, @Param("offset") Integer offset);
	
	
	
	
	
}
