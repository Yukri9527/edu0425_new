package edu0425.spring.service.impl;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import edu0425.common.util.MD5Util;
import edu0425.spring.dao.mapper.UserMapper;
import edu0425.spring.service.UserService;
import edu0425.spring.vo.LoginInfo;
import edu0425.spring.vo.UserInfo;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserInfo getUserByLoginId(String loginId) {
		// TODO Auto-generated method stub
		return userMapper.getUserByLoginId(loginId);
	}

	@Override
	public boolean loginValid(LoginInfo login, HttpSession session) {
		// 1.���жϵ�¼loginid �Ƿ�Ϊ��
		if (StringUtils.isBlank(login.getLoginId()))
			return false;

		// 2.���û��ܷ��ҵ�
		UserInfo user = getUserByLoginId(login.getLoginId());
		if (null != user) {
			// 3.�ж������Ƿ���ȷ
			if (user.getPassword().equals(MD5Util.textToMD5U16(login.getPassword()))) {
				// 4.���������ͬ
				login.setUsername(user.getUserName());
				session.setAttribute("USER_SESSION", login);
				return true;
			}

		}
		return false;
	}

	@Override
	public JSONArray getPermissions(String loginId) {
		Set<String> set=userMapper.getPermissions(loginId);
		JSONArray array= new JSONArray();
		for(String str:set) {
			
			array.add(str);
		};
		return array;
	}


	

	
	
	

}
