package com.qing.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 1. swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private boolean needToken = true;

    /**
     * 全局设置Content Type，默认是application/json
     * 如果想只针对某个方法，则注释掉改语句，在特定的方法加上下面信息
     *
     * @ApiOperation(consumes="application/x-www-form-urlencoded")
     */
    public static final HashSet<String> consumes = new HashSet<String>() {{
        add("application/x-www-form-urlencoded");
    }};


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否开启 (true 开启  false隐藏。生产环境建议隐藏)
                //.enable(false)
                .select()
                //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
                .apis(RequestHandlerSelectors.basePackage("com.qing.api.controller"))
                //指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(getTokenParams())
                .consumes(consumes);
    }


    /**
     * 接口测试全局token设置，JWT场景模式
     *
     * @return
     */
    public List<Parameter> getTokenParams() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();

        tokenPar.name("token")
                .description("Token信息")
                .modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        pars.add(tokenPar.build());
        return needToken ? pars : null;

    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档标题(API名称)
                .title("前端接口列表")
                //文档描述
                .description("出问题很正常,不要慌张,请联系赵汉青")
                //服务条款URL
//                .termsOfServiceUrl("http://localhost:8080/")
                //版本号
                .version("1.0.0")
                .build();
    }

}
