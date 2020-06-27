package edu0425.spring.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import edu0425.spring.service.UserService;
import edu0425.spring.vo.LoginInfo;
import edu0425.spring.vo.UserInfo;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{loginId}", method = RequestMethod.GET)
	@ResponseBody
	public UserInfo getUserInfoByLoginId(@PathVariable String loginId) {
		return userService.getUserByLoginId(loginId);

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.put("user", new LoginInfo());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginInfo user, HttpSession session, ModelMap modelMap) {
		// ����ɹ���ת��index
		if (userService.loginValid(user, session)) {
			return "redirect:player/index?pageIndex=1&pageSize=10";
		}
		// ����ɹ� ��ת��indexҳ�� ���򷵻ص�¼ҳ�� ��ʾ�˺��������
		user.setPassword(null);
		modelMap.put("user", user);
		modelMap.put("msg", "�˺Ż��������");
		return "login";
	}

	@RequestMapping(value = "/permission/{loginId}", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray getPermissions(@PathVariable String loginId) {
		// TODO ����loginID ��ѯ����û�����Ȩ�޹ؼ��� ��json����ĸ�ʽ����
		return userService.getPermissions(loginId);
	}

}
