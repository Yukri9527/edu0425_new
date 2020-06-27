package edu0425.spring.service;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;

import edu0425.common.page.PaginationResult;
import edu0425.spring.vo.ClubInfo;
import edu0425.spring.vo.LoginInfo;
import edu0425.spring.vo.NationInfo;
import edu0425.spring.vo.PlayerInfo;
import edu0425.spring.vo.UserInfo;

public interface UserService {
	
	UserInfo getUserByLoginId(String loginId);
	
	boolean loginValid(LoginInfo login, HttpSession session);
	
	JSONArray getPermissions(String loginId);

	

	
}
