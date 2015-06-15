package com.oba.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oba.entity.Circle;
import com.oba.entity.CircleTheme;
import com.oba.service.Categorylv2Service;
import com.oba.service.CircleService;
import com.oba.service.CircleThemeService;
import com.oba.web.comm.baseweb.BaseController;
import com.oba.web.util.HttpUtils;


@Controller
@RequestMapping("/circle")
public class CircleController extends BaseController {

	public Log logger = LogFactory.getLog(CircleController.class);
	
	@Resource
	private CircleService circleService;
	
	@Resource
	private Categorylv2Service categorylv2Service;
	
	@Resource
	private CircleThemeService circleThemeService;
	 
	
	@RequestMapping(value = "/getCategory")
	public void getCategory(HttpServletResponse response) throws Exception{
		try{
			Map<String,Object> maps = new HashMap<String, Object>();
			maps.put("status", "1");
			List<Circle> circleList = circleService.findPageBreakByCondition(maps, 0, 10);
			Map<String,Object> thememaps = new HashMap<String, Object>();
			maps.put("status", "1");
			List<CircleTheme> listCircleTheme = circleThemeService.findPageBreakByCondition(thememaps, 0, 10);
			JSONObject json = new JSONObject();
			json.put("circleList", circleList);
			json.put("listCircleTheme", listCircleTheme);
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("status", "ok");
			resMap.put("mydata",json);
			HttpUtils.outPrint(response, resMap);
		} catch (Exception e) {
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("status", "fail");
			resMap.put("message", "请联系管理员");
			HttpUtils.outPrint(response, resMap);
			e.printStackTrace();
		}
	}
}
