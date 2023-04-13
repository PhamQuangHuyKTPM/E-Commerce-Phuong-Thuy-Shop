package thanh3.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thanh3.dao.CategoryDAO;
import thanh3.dao.ProductDAO;
import thanh3.model.CategoryModel;
import thanh3.model.ProductModel;

@WebServlet(urlPatterns = {"/search"})
public class SearchController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ProductDAO productDao = new ProductDAO();
	CategoryDAO categoryDao = new CategoryDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String name = req.getParameter("name");
		
		List<ProductModel> products = productDao.searchLikeName(name);
		req.setAttribute("products", products);
		
		List<CategoryModel> categories = categoryDao.findAll();
		req.setAttribute("categories", categories);
		
		req.getRequestDispatcher("/views/web/category-web.jsp").forward(req, resp);
		
	}

}
