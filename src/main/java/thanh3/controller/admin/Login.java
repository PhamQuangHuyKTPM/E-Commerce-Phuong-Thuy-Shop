package thanh3.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thanh3.dao.AccountDAO;
import thanh3.dao.ManagerDAO;
import thanh3.model.AccountModel;
import thanh3.model.ManagerModel;

@WebServlet(urlPatterns = { "/login", "/filter-login" })
public class Login extends HttpServlet {

	AccountDAO dao = new AccountDAO();
	ManagerDAO managerDao = new ManagerDAO();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String status = req.getParameter("status");
		
		String path = "/views/login/index.jsp";
		
		if ("logout".equals(status)) {
			HttpSession session = req.getSession();
			session.removeAttribute("manager");
			resp.sendRedirect("home");
		}
		if ("register".equals(status)) {
			path = "/views/login/register.jsp";
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String status = req.getParameter("status");
		
		if("register".equals(status)) {
			String id = "DTC" + (int) Math.floor(((Math.random() * 899999) + 100000));
			String hoten = getUrl("hoten", req);
			String address = getUrl("diachi", req);
			String phone = getUrl("sdt", req);
			String ngaysinh = getUrl("ngaysinh", req);
			String email = getUrl("email", req);
			String confirm = getUrl("confirm", req);
			int isAdmin = 0;
			ManagerModel m = new ManagerModel(id, hoten, address, phone, ngaysinh, email, username, password, isAdmin);
			managerDao.register(m);
			req.getRequestDispatcher("/views/login/index.jsp").forward(req, resp);
		}		
	
		ManagerModel a = new ManagerModel();
		a.setUsername(username);
		a.setPassword(password);
		
		String path = "trang-chu";
		
		ManagerModel manager = managerDao.findUserAndPass(a);
		if(manager.getIsAdmin() == 0) {
			path = "home";
		}
		HttpSession session = req.getSession();
		session.setAttribute("manager", manager);

		resp.sendRedirect(path);
	}
	
	public String getUrl(String name,HttpServletRequest req) {
		
		return req.getParameter(name);
	}

}
