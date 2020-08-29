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
	
	private static final String FARMILY = "Farmily";
	private static final String FARMILYLIST = "ListFarmilys";
	
	@RequestMapping("/listOfFarmily")
	public String showListOfFarmilys(Model model){
		model.addAttribute("farmilyList", farmilyMapper.getAllFarmilys());
		return FARMILYLIST;
	}
	
	@RequestMapping("/showFormForAdd")
	public String addFarmily(Model model){
		model.addAttribute("farmily", new Farmily());
		return FARMILY;
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
		model.addAttribute("farmily", farmilyMapper.findFarmilyById(farmilyId));
		return FARMILY;
	}
	
	@RequestMapping("/displayDeleteForm")
	public String deleteFarmily(@RequestParam("farmilyId") int farmilyId){
		farmilyMapper.deleteFarmily(farmilyId);
		return "redirect:/farmily/listOfFarmily";
	}
}
