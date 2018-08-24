package indi.goddess.shoppingmall2.controllers.manager;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("manager")
public class LoginController {

	@RequestMapping("/login/name")
	public Map name(){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Map<String,String> map=new HashMap<>();
		map.put("loginName",name);
		//System.out.println(map+">>>>>>>>>>");
		return map;
	}

}
