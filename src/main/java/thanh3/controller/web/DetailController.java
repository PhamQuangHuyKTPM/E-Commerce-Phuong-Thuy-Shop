package thanh3.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thanh3.dao.CategoryDAO;
import thanh3.dao.ManagerDAO;
import thanh3.dao.ProductDAO;
import thanh3.model.CategoryModel;
import thanh3.model.ProductModel;

@WebServlet(urlPatterns = {"/chi-tiet-san-pham"})
public class DetailController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	CategoryDAO categoryDao = new CategoryDAO();
	ProductDAO productDao = new ProductDAO();
	ManagerDAO managerDao = new ManagerDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String status = req.getParameter("status");
		
		ProductModel product = productDao.getById(id);
		List<CategoryModel> categories = categoryDao.findAll();
		List<ProductModel> products = productDao.selectAll();
		
		if("update".equals(status)) {
			
		}
		
		req.setAttribute("products", products);
		req.setAttribute("categories", categories);
		req.setAttribute("product", product);
		
		
		req.getRequestDispatcher("/views/web/detail.jsp").forward(req, resp);
	}
	
	
}
