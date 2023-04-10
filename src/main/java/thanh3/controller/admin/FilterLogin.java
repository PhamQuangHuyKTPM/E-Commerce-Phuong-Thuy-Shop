package thanh3.controller.admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

import thanh3.dao.ManagerDAO;
import thanh3.model.ManagerModel;

@WebFilter(urlPatterns = "/filter-login")
public class FilterLogin implements Filter{

	ManagerDAO dao = new ManagerDAO();
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ManagerModel a = new ManagerModel();
		a.setUsername(username);
		a.setPassword(password);
		
		ManagerModel manager = dao.findUserAndPass(a);
		
		if(manager != null) {
			if(manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
					chain.doFilter(request, response);
			}else {
				request.setAttribute("error", "display : block;");
				request.getRequestDispatcher("/views/login/index.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("error", "display : block;");
			request.getRequestDispatcher("/views/login/index.jsp").forward(request, response);
		}
		
	}


}
