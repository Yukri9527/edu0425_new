package edu0425.spring.vo;

import java.util.Date;

public class EmpInfo {

	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate; // Date type
	private Integer sal;
	private Integer deptno;

	// 含参构造函数
	public EmpInfo(Integer empno, String ename, String job, Integer mgr, Date hiredate, Integer sal, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.deptno = deptno;
	}

	@Override
	public String toString() { // 覆盖Object的副类
		return "EmpInfo [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate="
				+ hiredate + ", sal=" + sal + ", deptno=" + deptno + "]";
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Integer getSal() {
		return sal;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	// 无参构造函数
	public EmpInfo() {

	}

}
