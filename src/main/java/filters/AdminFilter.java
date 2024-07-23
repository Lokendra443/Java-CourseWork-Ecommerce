package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserDao;
import utils.PageURL;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/AdminFilter")
public class AdminFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public AdminFilter() {
        super();
    }

	
	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Typecasting ServletRequest into HttpServletRequest because request is type of ServletRequest
				HttpServletRequest req = (HttpServletRequest)request;
				
				// storing current session s into s ()
				HttpSession s = req.getSession();		
				
				
				// feching user attribute					//keys
				User user=(User)s.getAttribute("user");
				
				//if user is not null and role =1 it mean user is type user 
				if(user != null && user.getRoleId()==2) {
					//forward request for futher processing
					chain.doFilter(request, response);
				}
				
				else {
		            request.getRequestDispatcher(PageURL.LOGIN.getUrl()).forward(request, response);
				}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
