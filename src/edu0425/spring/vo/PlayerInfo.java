package edu0425.spring.vo;

public class PlayerInfo {

	// ���к�
	private Integer rowId;
	// ��ԱID
	private Integer pid;
	// ��Ա����
	private String pname;
	// ����
	private Integer age;
	// ��Ƭ
	private String photo;
	// ����ID
	private Integer nid;
	// ����ֵ
	private Integer overall;
	// Ǳ��
	private Integer potential;
	// ���ֲ�ID
	private Integer cid;
	//���ֲ���Ϣ
	private ClubInfo club;
	//������Ϣ
	private NationInfo nation;
	
	
	public NationInfo getNation() {
		return nation;
	}



	public ClubInfo getClub() {
		return club;
	}



	public void setNation(NationInfo nation) {
		this.nation = nation;
	}



	public void setClub(ClubInfo club) {
		this.club = club;
	}



	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public Integer getOverall() {
		return overall;
	}

	public void setOverall(Integer overall) {
		this.overall = overall;
	}

	public Integer getPotential() {
		return potential;
	}

	public void setPotential(Integer potential) {
		this.potential = potential;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

}
