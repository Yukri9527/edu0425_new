package edu0425.spring.servlet;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu0425.spring.service.DeptService;
import edu0425.spring.service.impl.DeptServiceImpl;
import edu0425.spring.vo.DeptInfo;

public class DeptServlet extends HttpServlet {

	private DeptService deptService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPost(req, resp);
	}

	@Override  //doGet й╣ож
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		deptService = new DeptServiceImpl();
		List<DeptInfo> list = deptService.getDeptList();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/dept.jsp").forward(req, resp);
	}
	
}
