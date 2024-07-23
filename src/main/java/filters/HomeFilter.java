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


@WebFilter("/HomeFilter")
public class HomeFilter extends HttpFilter implements Filter {
   

	private static final long serialVersionUID = 1L;

	public HomeFilter() {
        super();
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		HttpSession s = req.getSession();		

		User user=(User)s.getAttribute("user");

		//if user is not null and role =1 it mean user is type user 
				if(user == null || (user.getRoleId()==1 ))  {
					chain.doFilter(request, response);
				}
				
				else {
		            request.getRequestDispatcher(PageURL.DASHBOARD.getUrl()).forward(request, response);
				}
		
			
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
