package top.evolutionary.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import top.evolutionary.security.browser.authentication.EvolutionaryAuthenticationFailureHandler;
import top.evolutionary.security.browser.authentication.EvolutionaryAuthenticationSuccessHandler;
import top.evolutionary.security.properties.SecurityProperties;

/**
 * @author richeyss
 */

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private EvolutionaryAuthenticationSuccessHandler evolutionaryAuthenticationHandler;

    @Autowired
    private EvolutionaryAuthenticationFailureHandler evolutionaryAuthenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //        http.httpBasic();  http Basic的认证方式
        http.formLogin()  //表单登录
//                .loginPage("/evolutionary-loginIn.html")
                .loginPage("/authentication/require") //如果需要身份认证则跳转到这里
                .loginProcessingUrl("/authentication/form")
                .successHandler(evolutionaryAuthenticationHandler)
                .failureHandler(evolutionaryAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require", securityProperties.getBrower().getLoginPage())
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable();

    }
}
