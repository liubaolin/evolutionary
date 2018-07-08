package top.evolutionary.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import top.evolutionary.security.browser.authentication.EvolutionaryAuthenticationFailureHandler;
import top.evolutionary.security.browser.authentication.EvolutionaryAuthenticationSuccessHandler;
import top.evolutionary.security.properties.SecurityProperties;
import top.evolutionary.security.validate.code.ValidateCodeFilter;

import javax.sql.DataSource;

/**
 * @author richey
 */

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private EvolutionaryAuthenticationSuccessHandler evolutionaryAuthenticationHandler;

    @Autowired
    private EvolutionaryAuthenticationFailureHandler evolutionaryAuthenticationFailureHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        //第一次启动的时候自动创建表
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(evolutionaryAuthenticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()  //表单登录
                    .loginPage("/authentication/require") //如果需要身份认证则跳转到这里
                    .loginProcessingUrl("/authentication/form")//登录请求的url
                    .successHandler(evolutionaryAuthenticationHandler)
                    .failureHandler(evolutionaryAuthenticationFailureHandler)
                    .and()
                .rememberMe()
                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(securityProperties.getBrower().getRememberSeconds())
                    .userDetailsService(userDetailsService)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",
                        securityProperties.getBrower().getLoginPage(),
//                        "/code/image")
                        "/code/*") //code开头的都可以不经过验证访问
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable();

    }
}
