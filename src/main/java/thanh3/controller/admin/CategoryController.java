package thanh3.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import thanh3.dao.CategoryDAO;
import thanh3.model.CategoryModel;

@WebServlet(urlPatterns = {"/category"})
public class CategoryController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	CategoryDAO categoryDao = new CategoryDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String status = req.getParameter("status");
		if("add".equals(status)) {
			req.getRequestDispatcher("/views/admin/category/formAdd.jsp").forward(req, resp);
		}
		if("update".equals(status)) {
			String id = req.getParameter("id");
			CategoryModel category = categoryDao.getById(id);
			req.setAttribute("category", category);
			req.getRequestDispatcher("/views/admin/category/formUpdate.jsp").forward(req, resp);
		}
		if("delete".equals(status)) {
			int id = Integer.parseInt(req.getParameter("id"));
			
			categoryDao.delete(id);
	
		}
		
		List<CategoryModel> categories = categoryDao.findAll();
		req.setAttribute("categories", categories);
		req.getRequestDispatcher("/views/admin/category/category.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String status = req.getParameter("status");
		if("add".equals(status)) {
			String image = req.getParameter("image");
			String ten = req.getParameter("ten");
			categoryDao.insert(ten, image);
			List<CategoryModel> categories = categoryDao.findAll();
			req.setAttribute("categories", categories);
			req.getRequestDispatcher("/views/admin/category/category.jsp").forward(req, resp);
		}
		if("update".equals(status)) {
			int id = Integer.parseInt(req.getParameter("id"));
			String ten = req.getParameter("ten");
			String image = req.getParameter("image");
			CategoryModel m = new CategoryModel(id, ten, image);
			
			categoryDao.update(m);
			resp.sendRedirect("category");
		}
		
	}

}
