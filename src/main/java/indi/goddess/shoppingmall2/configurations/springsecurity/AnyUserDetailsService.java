package indi.goddess.shoppingmall2.configurations.springsecurity;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * 自定义 UserDetailsService
 */
@Service
class AnyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username == null||!username.equals("admin")){
			throw new UsernameNotFoundException("用户不存在");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		//对应的权限添加
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));//注意一定要以ROLE_打头，另外一边就要写.hasRole("ADMIN")
		AnyUser anyUser = new AnyUser(username, new BCryptPasswordEncoder().encode("admin"), authorities);
		anyUser.setId(1001L);
		return anyUser;
	}

}

