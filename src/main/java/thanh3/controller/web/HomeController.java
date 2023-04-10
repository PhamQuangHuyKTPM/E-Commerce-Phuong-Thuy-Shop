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
import thanh3.dao.ProductDAO;
import thanh3.model.CategoryModel;
import thanh3.model.ProductModel;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	CategoryDAO categoryDao = new CategoryDAO();
	ProductDAO productDao = new ProductDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String status = req.getParameter("status");
		
		if("logout".equals(status)) {
			HttpSession session = req.getSession();
			session.removeAttribute("manager");
		}
		
		List<ProductModel> products = productDao.selectAll();
		List<CategoryModel> categories = categoryDao.findAll();
		req.setAttribute("categories", categories);
		req.setAttribute("products", products);
		req.getRequestDispatcher("/views/web/index.jsp").forward(req, resp);
	}
	
	
}
