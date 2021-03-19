package web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@WebFilter(filterName="CORSFilter", asyncSupported=true, urlPatterns={"/*"})
public class CORSFilter implements Filter {
    private static final String[] allowedOrigins = {"http://localhost:3000","http://localhost:19006"};
    
    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        if(resp instanceof HttpServletResponse) {

            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;

            List<String> allowedOriginslist = Arrays.asList(allowedOrigins);
            String origin = request.getHeader("Origin");
            if (allowedOriginslist.contains(origin)) {
                response.addHeader("Access-Control-Allow-Origin", origin);
                response.addHeader("Access-Control-Allow-Methods", "GET, POST");
                response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, Token, Cookie, Set-Cookie");
                response.addHeader("Access-Control-Allow-Credentials", "true");
                response.addHeader("Access-Control-Max-Age", "1728000");
            }
        }

        chain.doFilter(req, resp);
    }
}