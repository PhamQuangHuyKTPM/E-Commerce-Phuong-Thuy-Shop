package thanh3.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thanh3.dao.CategoryDAO;
import thanh3.dao.ManagerDAO;
import thanh3.model.CategoryModel;
import thanh3.model.ManagerModel;

@WebServlet(urlPatterns = {"/thong-tin-ca-nhan"})
public class AboutMeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	CategoryDAO categoryDao = new CategoryDAO();
	ManagerDAO managerDao = new ManagerDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String status = req.getParameter("status");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		if("update".equals(status)) {
			String id = req.getParameter("id_user");
			String hoten = req.getParameter("hoten");
			String diachi = req.getParameter("diachi");
			String sdt = req.getParameter("sdt");
			String ngaysinh = req.getParameter("ngaysinh");
			String email = req.getParameter("email");
			String user = req.getParameter("user");
			String password = req.getParameter("password");
			
			ManagerModel manager = managerDao.findByID(id);
			
			System.out.println(password + " == " +manager.getPassword());
			
			if(password.equals(manager.getPassword())) {
				req.setAttribute("passIsTrue", true);
				req.getRequestDispatcher("/views/web/about_me.jsp").forward(req, resp);
				HttpSession session = req.getSession();
				
				manager = new ManagerModel(user, hoten, diachi, sdt, ngaysinh, email, user, password);
				managerDao.updateAllById(manager);
				session.setAttribute("manager", manager);
				
			}
			if(password != manager.getPassword()) {
				req.setAttribute("passIsTrue", false);
				req.getRequestDispatcher("/views/web/about_me.jsp").forward(req, resp);
			}
		}
		
		List<CategoryModel> categories = categoryDao.findAll();
		req.setAttribute("categories", categories);
		
		req.getRequestDispatcher("/views/web/about_me.jsp").forward(req, resp);
	}

}
