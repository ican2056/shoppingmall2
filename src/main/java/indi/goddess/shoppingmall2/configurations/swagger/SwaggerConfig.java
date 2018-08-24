package indi.goddess.shoppingmall2.configurations.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration      //标明是配置类，让spring启动时加载
@EnableSwagger2     //启用Swagger2
public class SwaggerConfig {

	//创建多个方法并用Bean注解，这样就可以针对不同的Controller创建出各自的API文档，当创建多个API时，需要指定API的名称
	//这里如果函数上面不配置@Bean注解，那么Swagger只是启动了。没有创建API信息
	@Bean//IOC
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				//.groupName("cus")
				.apiInfo(apiInfo())//apiInfo()用来创建Api基本信息
				.select()  // 选择那些路径和api会生成document，返回一个Api
				.apis(RequestHandlerSelectors.basePackage("com.example.controllers")) // 对所有api进行监控
				.paths(PathSelectors.any()) // 对所有路径进行监控
				.build();
	}

	/**
	 * 创建Api信息
	 *
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("项目标题")
				.description("项目描述")
				.version("项目版本1.0")
				.build();
	}
}
