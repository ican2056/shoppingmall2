package indi.goddess.shoppingmall2.configurations.springsecurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 自定义的 User 对象
 * 此 User 类不是我们的数据库里的用户类,是用来安全服务的
 */

//import org.springframework.security.core.userdetails.User;
public class AnyUser extends User {

	private Long id;
	AnyUser(
			String username,
			String password,
			Collection<? extends GrantedAuthority> authorities
	) {
		super(username, password, authorities);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

