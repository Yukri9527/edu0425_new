package edu0425.spring.dao.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.alibaba.fastjson.JSONArray;

import edu0425.spring.vo.UserInfo;

public interface UserMapper {
	@Select("select * from sys_users where loginId=#{id} and valid=1")
	@ResultMap("userInfoResult")
	UserInfo getUserByLoginId(@Param("id") String loginId);
	
	//set 集合不可重复
	Set<String> getRoles(@Param("loginId")String loginId);
	
	Set<String> getPermissions(@Param("loginId")String loginId);
	


//	JSONArray getPermissionsByLoginId(String loginId);
}
