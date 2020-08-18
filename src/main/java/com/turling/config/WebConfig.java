package com.turling.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * springmvc总配置
 */
@Configuration//创建一个空的配置文件
@ComponentScan("com.turling.controller")//扫描所有分控制的类
@EnableWebMvc//开启springmvc的所有注解
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置模板解析器
     * @param applicationContext
     * @return
     */
    @Bean
    public ITemplateResolver templateResolver(ApplicationContext applicationContext){
        //创建模板解析器
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        //设置上下文  IOC容器
        templateResolver.setApplicationContext(applicationContext);
        //设置前缀
        templateResolver.setPrefix("/");
        //设置后缀
        templateResolver.setSuffix(".html");
        //设置模板类型
        templateResolver.setTemplateMode(TemplateMode.HTML);
        //开发时为了调试方便，禁用页面缓存
        templateResolver.setCacheable(false);
        //设置编码
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    /**
     * 配置模板引擎
     * @param templateResolver
     * @return
     */
    @Bean
    public ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
        //创建spring模板引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        //设置支持spring的el表达式
        templateEngine.setEnableSpringELCompiler(true);
        //设置模板引擎的解析器
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    /**
     * 配置视图解析器
     * @param templateEngine
     * @return
     */
    @Bean
    public ViewResolver viewResolver(ISpringTemplateEngine templateEngine){
        //创建 Thymeleaf 的视图解析器
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        //设置模板引擎
        viewResolver.setTemplateEngine(templateEngine);
        //设置编码格式
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    /**
     * 开启访问静态资源
     * 重写方法
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
