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

@WebServlet(urlPatterns = {"/categoryWeb"})
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	CategoryDAO categoryDao = new CategoryDAO();
	ProductDAO productDao = new ProductDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		
		if(id != null && name != null) {
			List<ProductModel> products = productDao.selectAllByCategory(name);
			List<CategoryModel> categories = categoryDao.findAll();
			CategoryModel category = categoryDao.getById(id);
			
			req.setAttribute("category", category);
			req.setAttribute("categories", categories);
			req.setAttribute("products", products);
			req.getRequestDispatcher("/views/web/category-web.jsp").forward(req, resp);
		}
		
		
		
	}

}
