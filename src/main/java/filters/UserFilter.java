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
import utils.PageURL;




@WebFilter(asyncSupported = true, urlPatterns = { "/UserFilter" })
public class UserFilter extends HttpFilter implements Filter {
       

	private static final long serialVersionUID = 1L;

	public UserFilter() {
        super();
    }

	
	public void destroy() {
		
		
	}

// this method filters unauthorized and unauthenticated request	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// Typecasting ServletRequest into HttpServletRequest because request is type of ServletRequest
		HttpServletRequest req = (HttpServletRequest)request;
		
		// storing current session s into s ()
		HttpSession s = req.getSession();		
		
		
		// feching user attribute					//keys
		User user=(User)s.getAttribute("user");
		
		//if user is not null and role =1 it mean user is type user 
		if(user != null && (user.getRoleId()==1))  {
			
			//forward request for futher processing
			chain.doFilter(request, response);
		}
		
		else {
			
            request.getRequestDispatcher(PageURL.LOGIN.getUrl()).forward(request, response);
			System.out.println("Not Login");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
