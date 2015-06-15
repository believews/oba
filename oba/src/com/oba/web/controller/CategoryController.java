package com.oba.web.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oba.entity.Category;
import com.oba.entity.Categorylv1;
import com.oba.entity.Categorylv2;
import com.oba.service.Categorylv1Service;
import com.oba.service.Categorylv2Service;
import com.oba.web.comm.baseweb.BaseController;
import com.oba.web.util.HttpUtils;


@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

	public Log logger = LogFactory.getLog(CategoryController.class);
	
	@Resource
	private Categorylv1Service categorylv1Service;
	
	@Resource
	private Categorylv2Service categorylv2Service;
	 
	
	@RequestMapping(value = "/getCategory")
	public void getCategory(HttpServletResponse response) throws Exception{
		try{
			Map<String,Object> maps = new HashMap<String, Object>();
			maps.put("status", "1");
			List<Categorylv1> categorylv1List = categorylv1Service.findPageBreakByCondition(maps, 0, 10);
			//List<Categorylv1> categorylv1List1 = categorylv1Service.listCategorylv1();
			Map<String, Object> resMap = new HashMap<String, Object>();
			List<Category> categoryList = new ArrayList<Category>();
			if(categorylv1List!=null&&categorylv1List.size()>0){
				for(Categorylv1 categorylv1 : categorylv1List){
					Long categorylv1Id = categorylv1.getCategorylv1Id();
					String categorylv1Name = categorylv1.getCategoryName();
					Map<String,Object> parma = new HashMap<String, Object>();
					parma.put("categorylv1Id", categorylv1Id);
					List<Categorylv2> listCategorylv2 = categorylv2Service.findPageBreakByCondition(parma, 0, 100);
					Category category = new Category();
					category.setCategorylv1Id(categorylv1Id);
					category.setCategorylv1Name(categorylv1Name);
					category.setImgType(categorylv1.getImgType());
					category.setListCategorylv2(listCategorylv2);
					categoryList.add(category);
				}
			}		
			resMap.put("status", "ok");
			resMap.put("mydata",categoryList);
			HttpUtils.outPrint(response, resMap);
		} catch (Exception e) {
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("status", "fail");
			resMap.put("message", "请联系管理员");
			HttpUtils.outPrint(response, resMap);
			e.printStackTrace();
		}
	}
	

	@RequestMapping(value = "/saveCategroy")
	public void saveCategroy(HttpServletResponse response) throws Exception{
		    Categorylv1 categorylv1 = new Categorylv1();
		    categorylv1.setCategoryName("家政");
		    categorylv1.setCity(1);
		    categorylv1.setCreateTime(new Date());
		    categorylv1.setStatus(1);
		    categorylv1Service.save(categorylv1);
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("status", "ok");
			resMap.put("mydata","");
			HttpUtils.outPrint(response, resMap);
	}
	
	@RequestMapping(value = "/listCategorylv1")
	public void listCategorylv1(HttpServletResponse response) throws Exception{
		    List<Categorylv1> categorylv1List1 = categorylv1Service.listCategorylv1();
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("status", "ok");
			resMap.put("mydata",categorylv1List1);
			HttpUtils.outPrint(response, resMap);
	}
}
