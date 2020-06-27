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
		
		List<DeptInfo> deptList = new ArrayList<DeptInfo>(); // �½�arrayList<DeptInfo>
		
		try {
			// ע������
			Class.forName("com.mysql.jdbc.Driver"); 
			// ��ȡ����
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			// ����statement(��)
			Statement stmt = (Statement) conn.createStatement();
			// ��ѯ���ؽ����
			ResultSet rs = stmt.executeQuery("select * from dept");
			while (rs.next()) {
				DeptInfo dept = new DeptInfo(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));

				deptList.add(dept);
			}

			for (DeptInfo dept : deptList) { // ��ӡdept��
				System.out.println(dept);
			}


			stmt.close(); // �رտ�
			conn.close(); // �ر�����

		} catch (Exception e) {
			// ֱ�Ӳ������쳣 ������ClassNotFound�쳣
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
