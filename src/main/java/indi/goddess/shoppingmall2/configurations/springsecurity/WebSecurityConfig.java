package indi.goddess.shoppingmall2.configurations.springsecurity;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全控制中心
 */
@Configuration
@EnableWebSecurity//@EnableWebMvcSecurity 注解开启Spring Security的功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final UserDetailsService userDetailsService;
	public WebSecurityConfig(AnyUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	/**
	 * http.authorizeRequests()
	 * <p>
	 * .anyRequest().authenticated()
	 * <p>
	 * .and().formLogin().loginPage("/login")
	 * <p>
	 * //设置默认登录成功跳转页面
	 * <p>
	 * .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
	 * <p>
	 * .and()
	 * <p>
	 * //开启cookie保存用户数据
	 * <p>
	 * .rememberMe()
	 * <p>
	 * //设置cookie有效期
	 * <p>
	 * .tokenValiditySeconds(60 * 60 * 24 * 7)
	 * <p>
	 * //设置cookie的私钥
	 * <p>
	 * .key("")
	 * <p>
	 * .and()
	 * <p>
	 * .logout()
	 * <p>
	 * //默认注销行为为logout，可以通过下面的方式来修改
	 * <p>
	 * .logoutUrl("/custom-logout")
	 * <p>
	 * //设置注销成功后跳转页面，默认是跳转到登录页面
	 * <p>
	 * .logoutSuccessUrl("")
	 * <p>
	 * .permitAll();
	 *
	 * @param http
	 * @throws Exception
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()//authorizeRequests() 定义哪些URL需要被保护、哪些不需要被保护
				.antMatchers("/manager/admin/*").hasRole("ADMIN")//这就表示/whoim的这个资源需要有USER的这个角色才能访问。不然就会提示拒绝访问
				.anyRequest().permitAll()
				.and()
				.formLogin()
				.loginPage("/manager/login.html")
				.loginProcessingUrl("/login/form")
				.defaultSuccessUrl("/manager/admin/index.html", true)
				.and()
				.logout()
				.logoutUrl("/manager/logout")//设置登出请求
				.and()
				.csrf().disable()     //关闭csrf
				.headers().frameOptions().sameOrigin();//spring security安全框架设置了默认的X-Frame-Options为DENY,更改spring security配置为
		//http.headers().frameOptions().sameOrigin();参数如下
		/*X-Frame-Options 有三个值:
		DENY
		表示该页面不允许在 frame 中展示，即便是在相同域名的页面中嵌套也不允许。
		SAMEORIGIN
		表示该页面可以在相同域名页面的 frame 中展示。
		ALLOW-FROM uri
		表示该页面可以在指定来源的 frame 中展示。
		换一句话说，如果设置为 DENY，不光在别人的网站 frame 嵌入时会无法加载，在同域名页面中同样会无法加载。另一方面，如果设置为 SAMEORIGIN，那么页面就可以在同域名页面的 frame 中嵌套。*/

	}

}

