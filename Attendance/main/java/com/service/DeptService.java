package com.service;

import com.pojo.Dept;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

//import com.inspur.attd.pojo.Dept;

@Resource
public interface DeptService {

	void AddDept(Dept dept);

	void deletedept(String[] ids);

	Dept getdeptById(int id);

	void updateDept(Dept dept);

	List<Dept> deptFind(HashMap<String, Object> map);

}
