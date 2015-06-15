package com.oba.web.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oba.entity.Category;
import com.oba.entity.Categorylv1;
import com.oba.entity.Categorylv2;
import com.oba.entity.Comment;
import com.oba.entity.Shop;
import com.oba.entity.ShopCategory;
import com.oba.service.Categorylv1Service;
import com.oba.service.Categorylv2Service;
import com.oba.service.CommentService;
import com.oba.service.ShopCategoryService;
import com.oba.service.ShopService;
import com.oba.web.comm.baseweb.BaseController;
import com.oba.web.util.HttpUtils;


@Controller
@RequestMapping("/shop")
public class ShopController extends BaseController {

	public Log logger = LogFactory.getLog(ShopController.class);
	
	@Resource
	private ShopService shopService;
	
	@Resource
	private ShopCategoryService shopCategoryService;
	
	@Resource
	private Categorylv2Service categorylv2Service;
	
	@Resource
	private CommentService commentService;
	
	 
	
	@RequestMapping(value = "/getShops")
	public void getShops(HttpServletResponse response,HttpServletRequest request,Long categorylv2id) throws Exception{
		try{
			if(categorylv2id==null){
				Map<String, Object> resMap = new HashMap<String, Object>();
				resMap.put("status", "fail");
				resMap.put("message", "参数错误");
				HttpUtils.outPrint(response, resMap);
				return;
		    }
			Map<String,Object> maps = new HashMap<String, Object>();
			maps.put("status", "1");
			List<ShopCategory> shopCategoryList = shopCategoryService.findPageBreakByCondition(maps, 0, 1000);
			List<Shop> listShops = new ArrayList<Shop>();
			if(shopCategoryList!=null&&shopCategoryList.size()>0){
				for(ShopCategory shopCategory : shopCategoryList){
					Long shopId = shopCategory.getShopId();
					Shop shop = shopService.getByID(shopId);
					Map<String,Object> commentmaps = new HashMap<String, Object>();
					commentmaps.put("shopId", shopId);
					commentmaps.put("sortColumns", "create_time desc");
					List<Comment> listComment = commentService.findPageBreakByCondition(commentmaps, 0, 1);
					if(listComment!=null&&listComment.size()>0){
						Comment comment = listComment.get(0);
						shop.setComment(comment);
					}
					listShops.add(shop);				
				}
			}		
			Map<String,Object> resMap = new HashMap<String, Object>();
			resMap.put("status", "ok");
			resMap.put("mydata",listShops);
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
