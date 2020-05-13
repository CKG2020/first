package com.mapper;



import com.pojo.Dept;

import java.util.HashMap;
import java.util.List;

//import com.inspur.attd.pojo.Dept;

public interface DeptMapper {
	List<Dept> deptFind(HashMap<String, Object> map);
	void AddDept(Dept dept);
	void deletedept(String[] ids);
	Dept getdeptById(int id);
	void updateDept(Dept dept);
}
