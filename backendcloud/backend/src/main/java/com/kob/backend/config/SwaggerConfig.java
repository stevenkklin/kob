package com.kob.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration // 标明是配置类
@EnableSwagger2 //开启swagger功能
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }


//    @Bean
//    public Docket createRestApi(){
//        Docket docket = new Docket(DocumentationType.SWAGGER_2);
//        //ApiInfoBuilder 用于在Swagger界面上添加各种信息
//        ApiInfoBuilder builder = new ApiInfoBuilder();
//        builder.title("KOB");
//        ApiInfo apiInfo = builder.build();
//        docket.apiInfo(apiInfo);
//        //ApiSelectorBuilder 用来设置哪一些类中的方法会生成到REST API中
//        ApiSelectorBuilder selectorBuilder = docket.select();
//        selectorBuilder.paths(PathSelectors.any());//所有包下的类
//        //使用@ApiOpeation的方法会被提取到REST API中
//
//        //selectorBuilder.apis(RequestHandlerSelectors.withClassAnnotation(ApiOperation.class));
//        selectorBuilder.apis(RequestHandlerSelectors.basePackage("com.kob.backend.controller"));
//        docket = selectorBuilder.build();
//        /*
//         * 下面的语句是开启对JWT的支持，当用户用Swagger调用受JWT认证保护的方法，
//         * 必须要先提交参数（例如令牌）
//         */
//        //存储用户必须提交的参数
//        List<ApiKey> apiKey = new ArrayList<>();
//        //规定用户需要输入什么参数
//        apiKey.add(new ApiKey("token","token","header"));
//        docket.securitySchemes(apiKey);
//        //如果用户JWT认证通过，则在Swagger中全局有效
//        AuthorizationScope scope = new AuthorizationScope("global","accessEverything");
//        AuthorizationScope[] scopeArray = {scope};
//        //存储令牌和作用域
//        SecurityReference reference = new SecurityReference("token", scopeArray);
//        List refList = new ArrayList();
//        refList.add(reference);
//        SecurityContext context = SecurityContext.builder().securityReferences(refList).build();
//        List cxtList = new ArrayList();
//        cxtList.add(context);
//        docket.securityContexts(cxtList);
//        return docket;
//    }

    /**
     * 用于定义API主界面的信息，比如可以声明所有的API的总标题、描述、版本
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("KOB") //  可以用来自定义API的主标题
                .description("KOB SwaggerAPI管理") // 可以用来描述整体的API
                .termsOfServiceUrl("") // 用于定义服务的域名
                .version("1.0") // 可以用来定义版本。
                .build(); //
    }
}
