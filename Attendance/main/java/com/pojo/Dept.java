package com.pojo;

public class Dept {
	int id;
	String departmentId;
	String departmentName;
	String manager;
	String totalUser;
	String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getTotalUser() {
		return totalUser;
	}

	public void setTotalUser(String totalUser) {
		this.totalUser = totalUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", manager=" + manager
				+ ", totalUser=" + totalUser + ", createTime=" + createTime
				+ "]";
	}

	

}
