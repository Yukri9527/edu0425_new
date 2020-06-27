package edu0425.spring.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import edu0425.spring.dao.EmpDAO;
import edu0425.spring.vo.EmpInfo;

public class EmpDAOImpl implements EmpDAO {
	private static String url = "jdbc:mysql://localhost:3306/edu20200415";
	private static String user = "root";
	private static String password = "root";

	@Override
	public List<EmpInfo> getEmpList() {
		
		List<EmpInfo> empList = new ArrayList<EmpInfo>();

		try {
			// 注册驱动
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());// 方法3
			// 获取连接
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			// 创建statement(矿车)
			Statement stmt = (Statement) conn.createStatement();
			// 查询返回结果集
			ResultSet rs = stmt.executeQuery("select * from emp");
			while (rs.next()) {
				EmpInfo emp = new EmpInfo(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"),
						rs.getInt("mgr"), rs.getDate("hiredate"), rs.getInt("sal"), rs.getInt("deptno"));
				empList.add(emp);
			}

			for (EmpInfo emp : empList) { // 打印emp表
				System.out.println(emp);
			}

			stmt.close(); // 关闭矿车
			conn.close(); // 关闭连接

		} catch (Exception e) {
			// 直接捕获总异常 而不是ClassNotFound异常
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public EmpInfo EmpById(Integer empno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getEmpCount() {
		// TODO Auto-generated method stub
		return null;
	}

}
