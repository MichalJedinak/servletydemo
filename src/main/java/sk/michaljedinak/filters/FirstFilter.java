package sk.michaljedinak.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = {"/*"} , filterName = "FirstFilter name",
            initParams = {@WebInitParam(name="Michal",value = "Michal Jedinak")})
public class FirstFilter implements Filter{

      @Override
      public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("Som vo filtry");
            System.out.println(filterConfig.getFilterName());
            System.out.println(filterConfig.getInitParameter("Michal"));
            filterConfig.getServletContext().setAttribute("filter","First filter context stored ");
      }

      @Override
      public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                  throws IOException, ServletException {

            // PrintWriter out = response.getWriter();
            // out.println("Som vo Filtry jedna :)  a stránka teraz nefunguje ");
            HttpServletRequest req = (HttpServletRequest)request;
            req.getSession().setAttribute("filterAtribute","presiel som cez prvy filter : FirstFilter");
            chain.doFilter(request, response);
      }    

      @Override
      public void destroy() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'destroy'");
      }
      
}
