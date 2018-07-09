package top.evolutionary.securitydemo.web.filter;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author richey
 * 过滤器可以拿到原始的http请求和返回信息，但是拿不到真正处理请求的方法的信息
 */
//@Component   通过配置的方式去设置过滤的url等
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        Long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("time filter 耗时:" + (System.currentTimeMillis() - start));
        System.out.println("time filter end");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
