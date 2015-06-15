package com.oba.web.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oba.entity.Advert;
import com.oba.service.AdvertService;
import com.oba.web.comm.baseweb.BaseController;
import com.oba.web.util.HttpUtils;


@Controller
@RequestMapping("/ad")
public class AdController extends BaseController {

	public Log logger = LogFactory.getLog(AdController.class);
	
	@Resource
	private AdvertService advertService;
	 
	
	@RequestMapping(value = "/getAdverts")
	public void getAdverts(HttpServletResponse response) throws Exception{
		try{
			Map<String,Object> maps = new HashMap<String, Object>();
			maps.put("adUsed", "1");
			List<Advert> adList = advertService.findPageBreakByCondition(maps, 0, MAX_PAGE_SIZE);
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("status", "ok");
			resMap.put("mydata",adList);
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
