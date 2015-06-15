package com.oba.web.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oba.entity.SmsSendList;
import com.oba.entity.User;
import com.oba.service.SmsSendListService;
import com.oba.service.UserService;
import com.oba.web.comm.baseweb.BaseController;
import com.oba.web.util.DateUtil;
import com.oba.web.util.HttpUtils;
import com.oba.web.util.MD5Util;
import com.oba.web.util.StringTool;

/**
 * 管理员登录action
 * 
 * @author 文爽
 * 
 */
@Controller
@RequestMapping("/user")
public class LoginController extends BaseController {


	public Log logger = LogFactory.getLog(LoginController.class);

//	@Autowired
//	private SendMsgService sendMsgService;

	@Autowired
	private SmsSendListService smsSendListService;

	@Resource
	private UserService userService;
	

	/**
	 * 获取短信接口
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/getLoginMsg")
	public void getLoginMsg(ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String mobile = request.getParameter("mobile");
		if(StringUtils.isBlank(mobile)){
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("status", "fail");
			resMap.put("message", "参数错误");
			HttpUtils.outPrint(response, resMap);
			return;
	    }
		//String vCode = DataUtil.getRandNum(6);
		String vCode = "123456";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mobile", mobile);
		map.put("isDeal", "01");
		map.put("busiType", "000100");
		map.put("sortColumns", "create_time desc");
		String msg = "(" + vCode + ")德师傅手机登录验证码。【德师傅】";
		Map<String, Object> resMap = new HashMap<String, Object>();
		try {
			List<SmsSendList> smsList = smsSendListService
					.findPageBreakByCondition(map, 0, 1);
			SmsSendList smsSendList = null;
			if (smsList != null && smsList.size() > 0) {
				smsSendList = smsList.get(0);
				Date createTime = smsSendList.getCreateTime();
				if (new Date().getTime() - createTime.getTime() <= 600000) {
					vCode = smsSendList.getSendCode();
					// 往短信表里添加短信发送记录
					msg = "(" + vCode + ")德师傅手机登录验证码。【德师傅】";
				} else {
					smsSendList = new SmsSendList();
					Date currDate = new Date();
					smsSendList.setBeginTime(DateUtil
							.formatDate2LongString(currDate));
					Date endDate = DateUtils.addMinutes(currDate, 10);
					// 000100用户注册登录新规则
					smsSendList.setBusiType("000100");
					smsSendList
							.setCreateTime(new Timestamp(currDate.getTime()));
					smsSendList.setCreateUserId("");
					smsSendList.setEndTime(DateUtil
							.formatDate2LongString(endDate));
					smsSendList.setIsAvailability("1");
					smsSendList.setIsDeal("01");// 新建
					smsSendList.setIsDel("0");
					smsSendList.setMobile(mobile);
					smsSendList.setMsg(msg);
					String seq = System.currentTimeMillis() + ":"
							+ RandomStringUtils.randomAlphabetic(20);
					smsSendList.setMsgSeq(seq);
					smsSendList.setSendCode(vCode);
					smsSendList.setUpdateTime(smsSendList.getCreateTime());
					smsSendList.setUpdateUserId("");
					smsSendListService.save(smsSendList);
				}
			} else {
				smsSendList = new SmsSendList();
				Date currDate = new Date();
				smsSendList.setBeginTime(DateUtil
						.formatDate2LongString(currDate));
				Date endDate = DateUtils.addMinutes(currDate, 10);
				// 000100用户注册登录新规则
				smsSendList.setBusiType("000100");
				smsSendList.setCreateTime(new Timestamp(currDate.getTime()));
				smsSendList.setCreateUserId("");
				smsSendList.setEndTime(DateUtil.formatDate2LongString(endDate));
				smsSendList.setIsAvailability("1");
				smsSendList.setIsDeal("01");// 新建
				smsSendList.setIsDel("0");
				smsSendList.setMobile(mobile);
				smsSendList.setMsg(msg);
				String seq = System.currentTimeMillis() + ":"
						+ RandomStringUtils.randomAlphabetic(20);
				smsSendList.setMsgSeq(seq);
				smsSendList.setSendCode(vCode);
				smsSendList.setUpdateTime(smsSendList.getCreateTime());
				smsSendList.setUpdateUserId("");
				smsSendListService.save(smsSendList);
			}
			logger.info("【Dasmaster sms 】" + mobile + ">>" + vCode);
			boolean b = true;
		   // b = sendMsgService.sendMsg(mobile, msg,1);

			if (b) {
				logger.info("【Dasmaster sms success】" + mobile + ">>" + vCode);
				resMap.put("status", "ok");
				resMap.put("message", "获取验证码成功");
				resMap.put("mydata", "");
				HttpUtils.outPrint(response, resMap);
			} else {
				logger.info("【Dasmaster sms fail,vCode error】" + mobile + ">>" + vCode);
				resMap.put("status", "fail");
				resMap.put("message", "获取验证码失败");
				resMap.put("mydata", "");
				HttpUtils.outPrint(response, resMap);
			}
		} catch (Exception e) {
			logger.info("【Dasmaster sms fail】" + mobile + ">>" + vCode);
			resMap.put("status", "fail");
			resMap.put("message", "获取验证码失败");
			resMap.put("mydata", "");
			HttpUtils.outPrint(response, resMap);
		}
	}

	/**
	 * 用户登录
	 * 
	 * @param modelMap
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/login")
	public void login(ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String mobile = request.getParameter("mobile");
		String vCode = request.getParameter("verify_code");
		String resource = request.getParameter("resource");
		String name = request.getParameter("name");
		if(StringUtils.isBlank(mobile)||StringUtils.isBlank(vCode)){
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("status", "fail");
			resMap.put("message", "参数错误");
			HttpUtils.outPrint(response, resMap);
			return;
	    }
		logger.info("【Dasmaster login】" + mobile + ":" + vCode);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resMap = new HashMap<String, Object>();
		map.put("mobile", mobile);
		map.put("busiType", "000100");
		map.put("sendCode", vCode);
		map.put("isDeal", "01");
		map.put("sortColumns", "create_time desc");
		int num = smsSendListService.findNumberByCondition(map);
		SmsSendList smsSendList = null;
		if (num > 0) {
			List<SmsSendList> smsList = smsSendListService
					.findPageBreakByCondition(map, 0, num);
			smsSendList = smsList.get(0);
		}
		if (smsSendList == null) {// 用户登录失败
			logger.info("【Dasmaster login fail】" + mobile + ":" + vCode);
			resMap.put("status", "fail");
			resMap.put("message", "登录失败");
			resMap.put("mydata", "验证码错误");
			HttpUtils.outPrint(response, resMap);
			return;
		} else {// 用户登录成功，判断用户为老用户还是新用户
			Date createTime = smsSendList.getCreateTime();
			if (new Date().getTime() - createTime.getTime() >= 600000) {
				logger.info("【Dasmaster login fail】" + mobile + ":" + vCode);
				resMap.put("status", "fail");
				resMap.put("message", "登录失败");
				resMap.put("mydata", "验证码已失效");
				HttpUtils.outPrint(response, resMap);
				return;
			} else {// 登录成功
				String token = StringTool.getUUID32();
				logger.info("【Dasmaster login success】" + mobile + ":" + vCode);
				smsSendList.setIsDeal("11");
				smsSendListService.update(smsSendList);
				User user = userService.getByMobile(mobile);
				if (user == null) {//新用户直接注册
					user = new User();
					user.setToken(token);
					user.setMobile(mobile);
					user.setPassword("e10adc3949ba59abbe56e057f20f883e");
					user.setName(name);
					user.setStatus(0);
					user.setResource(resource);
					user.setCreateTime(new Date());
					userService.save(user);		
				}else{
					user.setToken(token);
				    userService.update(user);
				}
				Map<String, Object> userMap = new HashMap<String, Object>();
				userMap.put("mobile", user.getMobile());
				userMap.put("userid", user.getId());
				userMap.put("headerpic", user.getHeaderpic());
				userMap.put("name", user.getName());
				userMap.put("nick", user.getNick());
				userMap.put("token", user.getToken());
				userMap.put("pushStatus", user.getPushStatus());
				resMap.put("status", "ok");
				resMap.put("message", "登录成功");
				resMap.put("mydata", userMap);
				HttpUtils.outPrint(response, resMap);
			}
		}
	}

	/**
	 * 修改密码
	 * 
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/updatePwd")
	public void updatePwd(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String mobile = request.getParameter("mobile");
		String old_pwd = request.getParameter("password");
		String new_pwd = request.getParameter("password");
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (StringUtils.isBlank(mobile) || StringUtils.isBlank("pwd")) {
			resMap.put("status", "fail");
			resMap.put("message", "用户名密码不能为空");
			resMap.put("mydata", "修改密码失败");
			HttpUtils.outPrint(response, resMap);
		}
		User user = userService.getByMobile(mobile);
		if (user == null) {
			resMap.put("status", "fail");
			resMap.put("message", "用户名或密码错误");
			resMap.put("mydata", "修改密码失败");
			HttpUtils.outPrint(response, resMap);
		} else {
			if (MD5Util.compute(old_pwd).equals(user.getPassword())) {
				user.setPassword(MD5Util.compute(new_pwd));
				userService.update(user);
				resMap.put("status", "ok");
				resMap.put("mydata", "修改密码成功");
				HttpUtils.outPrint(response, resMap);
			} else {
				resMap.put("status", "fail");
				resMap.put("message", "原始密码错误");
				resMap.put("mydata", "修改密码失败");
				HttpUtils.outPrint(response, resMap);
			}
		}

	}

	/**
	 * app端登录
	 * 
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/loginApp")
	public void loginApp(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String mobile = request.getParameter("mobile");
		String pwd = request.getParameter("password");
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (StringUtils.isBlank(mobile) || StringUtils.isBlank("pwd")) {
			resMap.put("status", "fail");
			resMap.put("message", "用户名或密码错误");
			resMap.put("mydata", "登录失败");
			HttpUtils.outPrint(response, resMap);
		}
		User user = userService.getByMobile(mobile);
		if (user == null) {
			resMap.put("status", "fail");
			resMap.put("message", "用户名或密码错误");
			resMap.put("mydata", "登录失败");
			HttpUtils.outPrint(response, resMap);
		} else {
			if (MD5Util.compute(pwd).equals(user.getPassword())) {
				resMap.put("status", "ok");
				resMap.put("mydata", "登录成功");
				HttpUtils.outPrint(response, resMap);
			} else {
				resMap.put("status", "fail");
				resMap.put("message", "用户名或密码错误");
				resMap.put("mydata", "登录失败");
				HttpUtils.outPrint(response, resMap);
			}
		}
	}

	/**
	 * 用户注册
	 * 
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/register")
	public void register(HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String mobile = request.getParameter("mobile");
		String pwd = request.getParameter("password");
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (StringUtils.isBlank(mobile) || StringUtils.isBlank("pwd")) {
			resMap.put("status", "fail");
			resMap.put("message", "用户名或密码错误");
			resMap.put("mydata", "登录失败");
			HttpUtils.outPrint(response, resMap);
		}
		User user = userService.getByMobile(mobile);
		if (user == null) {
			resMap.put("status", "fail");
			resMap.put("message", "用户名或密码错误");
			resMap.put("mydata", "登录失败");
			HttpUtils.outPrint(response, resMap);
		} else {
			if (MD5Util.compute(pwd).equals(user.getPassword())) {
				resMap.put("status", "ok");
				resMap.put("mydata", "登录成功");
				HttpUtils.outPrint(response, resMap);
			} else {
				resMap.put("status", "fail");
				resMap.put("message", "用户名或密码错误");
				resMap.put("mydata", "登录失败");
				HttpUtils.outPrint(response, resMap);
			}
		}
	}
}
