package GonPa.Grayshirts.Filters;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class  tokenFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (!((HttpServletRequest) request).getRequestURI().startsWith("/api/")){
            chain.doFilter(request , response);
            return;
        }

        String token = httpRequest.getHeader("token");
        if(token.equals("123456789")){
            chain.doFilter(request, response);
        }else{
            httpResponse.sendError(401);
        }
    }
}
