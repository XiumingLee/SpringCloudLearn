package cn.xiuminglee.boot.clientone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Xiuming Lee
 * description
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 相当于禁用了安全性。
        http.authorizeRequests().anyRequest().permitAll()
                .and().csrf().disable();
    }
}
