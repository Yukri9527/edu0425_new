package edu0425.spring.vo;

public class DeptInfo {

	// 属性私有化封装
	private Integer deptno;

	private String dname;

	private String loc;
	// 动作->方法 get方法 set方法

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) { // 传进去变成私有变量
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public DeptInfo(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	@Override // 覆盖副类object
	public String toString() {
		return "DeptInfo [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

	public DeptInfo() {
		// 无参构造函数
	}
}
