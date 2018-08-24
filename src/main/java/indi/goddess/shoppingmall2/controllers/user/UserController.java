package indi.goddess.shoppingmall2.controllers.user;

import indi.goddess.shoppingmall2.beans.TbUser;
import indi.goddess.shoppingmall2.service.user.UserService;
import indi.goddess.shoppingmall2.utils.user.IndustrySMS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@Api(value = "/user", tags = "用户模块")
@RequestMapping("/user")
@RestController
public class UserController {
	@Resource(name = "userServiceImpl")
	private UserService userService;

	@ApiOperation(value = "用户注册", notes = "方法的提示：用户注册")
	//@ApiImplicitParam(name = "user",value = "User对象",paramType = "path",required = true,dataTypeClass = TbUser.class)
	@PostMapping("/user_register.action")
	public ModelAndView register(TbUser user, HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		StringBuilder str = new StringBuilder();//定义变长字符串
		Random random = new Random();
		//随机生成数字，并添加到字符串
		for (int i = 0; i < 6; i++) {
			str.append(random.nextInt(10));
		}
		//将字符串转换为数字并输出
		int num = Integer.parseInt(str.toString());
		IndustrySMS.execute("num", "17873436212");
		int code = num;
		String controls = session.getAttribute("controls").toString();
		if (!controls.equals(code)) {
			request.setAttribute("errormsg", "验证码错误");
		} else {
			userService.add(user);
		}
		mav.setViewName("register");
		return mav;
	}


	@ApiOperation(value = "用户登陆", notes = "方法的提示：用户登陆")
	@PostMapping("/user_login.action")
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
