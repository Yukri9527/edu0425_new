package edu0425.spring.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu0425.spring.service.EmpService;
import edu0425.spring.service.impl.EmpServiceImpl;
import edu0425.spring.vo.EmpInfo;

public class EmpServlet extends HttpServlet {

	private EmpService empService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		empService = new EmpServiceImpl();
		List<EmpInfo> list = empService.getEmpList();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/emp.jsp").forward(req, resp);
	}
}
