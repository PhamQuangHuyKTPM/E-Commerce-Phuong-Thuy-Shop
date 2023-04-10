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

@WebServlet(urlPatterns = {"/san-pham"})
public class ProductsController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	CategoryDAO categoryDao = new CategoryDAO();
	ProductDAO productDao = new ProductDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<ProductModel> products = productDao.selectAll();
		List<CategoryModel> categories = categoryDao.findAll();
		req.setAttribute("categories", categories);
		req.setAttribute("products", products);
		
		
		req.getRequestDispatcher("/views/web/products.jsp").forward(req, resp);
	}
	
	
}
