package com.thanhduyen.springmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thanhduyen.springmybatis.dao.FarmilyMapper;
import com.thanhduyen.springmybatis.entity.Farmily;


@Controller @RequestMapping("/farmily")
public class FarmilyController {

	@Autowired
	FarmilyMapper farmilyMapper;
	
	private static final String EMPLOYEE = "Farmily";
	private static final String EMPLOYEELIST = "ListFarmilys";
	
	@RequestMapping("/listOfEmployee")
	public String showListOfFarmilys(Model model){
		model.addAttribute("farmilyList", farmilyMapper.getAllFarmilys());
		return EMPLOYEELIST;
	}
	
	@RequestMapping("/showFormForAdd")
	public String addFarmily(Model model){
		model.addAttribute("farmily", new Farmily());
		return EMPLOYEE;
	}
	
	@RequestMapping("/saveProcess")
	public String saveFarmily(@ModelAttribute("farmily") Farmily farmily){
		if(farmily.getId() == null){
			farmilyMapper.saveFarmily(farmily);
		}else{
			farmilyMapper.updateFarmily(farmily);
		}
		
		return "redirect:/farmily/listOfFarmily";
	}
	
	@RequestMapping("/displayUpdateForm")
	public String showUpdateForm(@RequestParam("farmilyId") int farmilyId, Model model){
		model.addAttribute("farmily", farmilyMapper.findById(farmilyId));
		return EMPLOYEE;
	}
	
	@RequestMapping("/displayDeleteForm")
	public String deleteFarmily(@RequestParam("farmilyId") int farmilyId){
		farmilyMapper.deleteFarmily(farmilyId);
		return "redirect:/farmily/listOfFarmily";
	}
}
