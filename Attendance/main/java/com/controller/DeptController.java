package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Dept;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


@Controller
public class DeptController {
	@Autowired
	private DeptService deptService;





	@RequestMapping(value = "/deptFind")
	public String deptFind(HttpSession session,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			HttpServletRequest request) {
		PageHelper.startPage(pn, 5);
		List<Dept> deptList = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		String departmentName = request.getParameter("departmentName");
		map.put("departmentName", departmentName);
		deptList = deptService.deptFind(map);

		PageInfo<Dept> pageInfodept = new PageInfo<Dept>(deptList,
				deptList.size());

		if (pn > pageInfodept.getPages()) {
			pageInfodept = null;

		}
		session.setAttribute("pageInfodept", pageInfodept);

		return "/dept/deptSearch.jsp";
	}





	@RequestMapping(value = "/deptAdd")
	public String deptAdd(Dept dept, Model model) {

		Calendar today = Calendar.getInstance();
		String registerDay = String.valueOf(today.get(Calendar.YEAR)) + "-"
				+ String.valueOf(today.get(Calendar.MONTH) + 1) + "-"
				+ String.valueOf(today.get(Calendar.DAY_OF_MONTH));
		dept.setCreateTime(registerDay);


		deptService.AddDept(dept);
		model.addAttribute("message", "保存成功");
		model.addAttribute("saveFlag", "1");

		return "/dept/deptInsert.jsp";
	}




	@RequestMapping(value = "/deleteDept")
	public String deleteDept(String ids[]) {
		deptService.deletedept(ids);
		return "redirect:/deptFind";
	}





	@RequestMapping(value = "/modifyDept")
	public String modifyDept(String id, Model model) {
		Dept dept = new Dept();
		if (id != null && !"".equals(id))
			dept = deptService.getdeptById(Integer.parseInt(id));
		model.addAttribute("dept", dept);
		return "dept/deptUpdate.jsp";
	}



	@RequestMapping(value = "/UpdateDept")
	public String UpdateDept(Dept dept, Model model) {
		deptService.updateDept(dept);
		model.addAttribute("message","修改成功");
		model.addAttribute("saveFlag", "1");
		return "/dept/deptUpdate.jsp";

	}
}
