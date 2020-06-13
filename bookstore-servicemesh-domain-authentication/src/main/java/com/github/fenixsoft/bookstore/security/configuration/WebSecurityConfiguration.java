package com.github.fenixsoft.bookstore.security.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security安全配置
 * <p>
 * 移除静态资源目录的安全控制，避免Spring Security默认禁止HTTP缓存的行为
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/8 0:09
 **/
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭HTTP Header中的Cache-Control:no-cache，允许缓存响应结果
        http.headers().cacheControl().disable();
    }

}
