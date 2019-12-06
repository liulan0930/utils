package com.bw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bw.pojo.Brand;
import com.bw.pojo.Goods;
import com.bw.pojo.Kind;
import com.bw.service.MyService;
import com.bw.utils.FileUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class MyController {
	@Resource
	private MyService myService;
	
	//商品列表
	@RequestMapping("queryGoods")
	public String queryGoods(Model model,@RequestParam(defaultValue="1")Integer pageNum){
		Map<String,Object> map = new HashMap<String, Object>();
		
		PageHelper.startPage(pageNum,3);
		List<Goods> list = myService.queryGoods(map);
		
		PageInfo<Goods> page = new PageInfo<Goods>(list);
		model.addAttribute("page",page);
		return "list";
	}
	//查询品牌
	@RequestMapping("queryBrand")
	@ResponseBody
	public Map<String,Object> queryBrand(){
		Map<String,Object> map = new HashMap<String, Object>();
		
		List<Brand> brandList = myService.queryBrand();
		List<Kind> kindList = myService.queryKind();
		
		map.put("brandList", brandList);
		map.put("kindList", kindList);
		
		return map;
	}
	
	//添加
	@RequestMapping("add")
	public String add(Goods goods,MultipartFile file) throws IllegalStateException, IOException{
		
		String upload = FileUtils.upload(file);
		goods.setPicurl(upload);
		myService.add(goods);
		return "add";
	}
	
	@RequestMapping("lookImg")
	public void lookImg(String path,HttpServletRequest request,HttpServletResponse response){
		FileUtils.lookImg(path, request, response);
	}
}
