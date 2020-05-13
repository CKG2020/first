package com.service.impl;

import com.mapper.DeptMapper;
import com.pojo.Dept;
import com.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;



@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<Dept> deptFind(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return deptMapper.deptFind(map);
	}

	@Override
	public void AddDept(Dept dept) {
		// TODO Auto-generated method stub
		deptMapper.AddDept(dept);
	}

	@Override
	public void deletedept(String[] ids) {
		// TODO Auto-generated method stub
		deptMapper.deletedept(ids);
	}

	@Override
	public Dept getdeptById(int id) {
		// TODO Auto-generated method stub
		return deptMapper.getdeptById(id);
	}

	@Override
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
		deptMapper.updateDept(dept);
	}
}
