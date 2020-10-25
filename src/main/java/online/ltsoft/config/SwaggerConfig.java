package online.ltsoft.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.enabled}")
    private boolean enableSwagger;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            //是否开启(true:开启,false隐藏)
            .enable(enableSwagger)
            .apiInfo(apiInfo())
            .select()
            //扫描的路径包(设置basePackage会将包下的所有被@Api标记类的所有方法作为api)
            .apis(RequestHandlerSelectors.basePackage("online.ltsoft.common.swagger"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            //文档标题
            .title("cnrds-report项目接口测试工具界面")
            //服务条款
            .termsOfServiceUrl("http://www.ltsoft.online/silence")
            //联系信息
            .contact("ltworkmail@163.com")
            //版本号
            .version("1.0.0")
            .build();
    }
}