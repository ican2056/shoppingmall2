package indi.goddess.shoppingmall2.controllers.user;

import indi.goddess.shoppingmall2.beans.TbUser;
import indi.goddess.shoppingmall2.service.user.UserService;
import indi.goddess.shoppingmall2.utils.user.Code;
import indi.goddess.shoppingmall2.utils.user.IndustrySMS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@Api(value = "/user", tags = "用户模块")
@RequestMapping("/foreground/user")
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
				//return "login";
			} else {
				request.setAttribute("errormsg", "注册失败");
			}

		}
		return  "login";
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
	public ModelAndView login(TbUser user, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		user = userService.find(user);
		if (user != null) {
			session.setAttribute("user", user);
			mav.setViewName("list");
			return mav;
		} else {
			request.setAttribute("errormsg", "用户名或密码错误");
		}
		mav.setViewName("login");
		return mav;

	}
}
