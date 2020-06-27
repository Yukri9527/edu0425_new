package edu0425.spring.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import edu0425.spring.dao.DeptDAO;
import edu0425.spring.vo.DeptInfo;

public class DeptDAOImpl implements DeptDAO {
	private static String url = "jdbc:mysql://localhost:3306/edu20200415";
	private static String user = "root";
	private static String password = "root";

	@Override
	public List<DeptInfo> getDeptList() {
		
		List<DeptInfo> deptList = new ArrayList<DeptInfo>(); // 新建arrayList<DeptInfo>
		
		try {
			// 注册驱动
			Class.forName("com.mysql.jdbc.Driver"); 
			// 获取连接
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			// 创建statement(矿车)
			Statement stmt = (Statement) conn.createStatement();
			// 查询返回结果集
			ResultSet rs = stmt.executeQuery("select * from dept");
			while (rs.next()) {
				DeptInfo dept = new DeptInfo(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));

				deptList.add(dept);
			}

			for (DeptInfo dept : deptList) { // 打印dept表
				System.out.println(dept);
			}


			stmt.close(); // 关闭矿车
			conn.close(); // 关闭连接

		} catch (Exception e) {
			// 直接捕获总异常 而不是ClassNotFound异常
			e.printStackTrace();
		}

		return deptList;
	}

	@Override
	public DeptInfo getDeptById(Integer deptno) {

		return null;
	}

	@Override
	public Integer getDeptCount() {

		return null;
	}

}
