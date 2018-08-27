package indi.goddess.shoppingmall2.controllers.foreground;

import indi.goddess.shoppingmall2.beans.TbUser;
import indi.goddess.shoppingmall2.service.foreground.UserService;
import indi.goddess.shoppingmall2.utils.user.Code;
import indi.goddess.shoppingmall2.utils.user.IndustrySMS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Api(value = "/user", tags = "用户模块")
@RequestMapping("/user")
public class UserController {
	@Resource(name = "userServiceImpl")
	private UserService userService;

	@ApiOperation(value = "用户注册", notes = "方法的提示：用户注册")
	//@ApiImplicitParam(name = "user",value = "User对象",paramType = "path",required = true,dataTypeClass = TbUser.class)
	@RequestMapping("user_register.action")
	public String register(HttpServletRequest request, HttpSession session,String smscode,TbUser user) {
		System.out.println("---------");
		String code = session.getAttribute("code").toString();
		if (!smscode.equals(code)) {
			request.setAttribute("errormsg", "验证码错误");
		} else {
			int result = userService.add(user);
			if (result > 0) {
				request.setAttribute("msg", "注册成功");
				System.out.println("success");
				return "{\"path\":\"/foreground/login.html\"}";
			} else {
				request.setAttribute("errormsg", "注册失败");
			}
		}
		return  "{\"path\":\"/foreground/register.html\"}";
	}


	@RequestMapping("user_sendCode.action")
	@ResponseBody
	public void sendCode(HttpServletRequest request, HttpSession session,String phone){
		Code.testCode(session);
		String code=session.getAttribute("code").toString();
		//System.out.println("================");
		IndustrySMS.execute(code,phone);
	}


	@ApiOperation(value = "用户登陆", notes = "方法的提示：用户登陆")
	@RequestMapping("user_login.action")
	public ModelAndView login(TbUser user, HttpServletRequest request, HttpSession session,ModelMap map) {
		ModelAndView mav = new ModelAndView();
		user = userService.find(user);
		if (user != null) {
			session.setAttribute("user", user);
			System.out.println("存用户信息发送到前台页面");
			//request.setAttribute("user",user);
			map.put("user",user);
			map.put("name","lbw");
			mav.setViewName("index");
		} else {
			request.setAttribute("errormsg", "用户名或密码错误");
			mav.setViewName("redirect:login.html");
		}
		return mav;
	}
}
