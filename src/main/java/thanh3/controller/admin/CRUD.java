package thanh3.controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thanh3.dao.AccountDAO;
import thanh3.dao.CategoryDAO;
import thanh3.dao.ManagerDAO;
import thanh3.dao.ProductDAO;
import thanh3.model.AccountModel;
import thanh3.model.CategoryModel;
import thanh3.model.ManagerModel;
import thanh3.model.ProductModel;

@WebServlet(urlPatterns = { "/crud" })
public class CRUD extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ProductDAO dao = new ProductDAO();
	ManagerDAO managerDAO = new ManagerDAO();
	CategoryDAO categoryDAO = new CategoryDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String status = req.getParameter("status");
		String id = req.getParameter("id");

		if (status != null && status.equals("update")) {
			List<CategoryModel> categories = categoryDAO.findAll();
			ProductModel p = dao.getById(id);
			req.setAttribute("p", p);
			req.setAttribute("categories", categories);
			req.getRequestDispatcher("/views/admin/formUpdate.jsp").forward(req, resp);
		}
		if ("add".equals(status)) {
			List<CategoryModel> categories = categoryDAO.findAll();
			req.setAttribute("categories", categories);
			req.getRequestDispatcher("/views/admin/formAdd.jsp").forward(req, resp);
		}
		if ("delete".equals(status)) {
			System.out.println(id);
			dao.delete(id);
			resp.sendRedirect("trang-chu");
		}
		if ("doimk".equals(status)) {
			HttpSession session = req.getSession();
			Object o = session.getAttribute("username");

			String name = String.valueOf(o);

			req.getRequestDispatcher("/views/login/doimk.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String status = req.getParameter("status");

		if (status != null && status.equals("update")) {
			String id = req.getParameter("masp");
			String tensp = req.getParameter("tensp");

			String mota = req.getParameter("mota");
			double dongia = Double.parseDouble(req.getParameter("dongia").toString());
			String danhmuc = req.getParameter("danhmuc");
			int soluong = Integer.parseInt(req.getParameter("soluong").toString());
			String image = req.getParameter("image");

			ProductModel p = new ProductModel(id, tensp, mota, dongia, danhmuc, soluong, image);

			dao.update(p);
			resp.sendRedirect("trang-chu");
		}
		if (status != null && "add".equals(status)) {
			String id = "MSP" + (int) Math.floor(((Math.random() * 899999) + 100000));
			String tensp = req.getParameter("tensp");

			String mota = req.getParameter("mota");
			double dongia = Double.parseDouble(req.getParameter("dongia").toString());
			String danhmuc = req.getParameter("danhmuc");
			int soluong = Integer.parseInt(req.getParameter("soluong").toString());
			String image = req.getParameter("image");

			ProductModel p = new ProductModel(id, tensp, mota, dongia, danhmuc, soluong, image);
			dao.insert(p);
			resp.sendRedirect("trang-chu");
		}
		if (status != null && "doimk".contentEquals(status)) {
			String id_mk = req.getParameter("id");
			String username = req.getParameter("username");
			String password = req.getParameter("password").toString();
			String password_new = req.getParameter("password-new");
			String confirm = req.getParameter("confirm");

			ManagerModel a = managerDAO.findByID(id_mk);

			if(a.getPassword().equals(password)) {
				if(password_new.equals(confirm)) {
					HttpSession session = req.getSession();
					a.setPassword(confirm);
					session.setAttribute("manager", a);

					managerDAO.updatePassword(a);

					req.setAttribute("passwordSuccess", true);
					req.getRequestDispatcher("/views/login/doimk.jsp").forward(req, resp);
					
				} else {
					req.setAttribute("confirmFalse", true);
					req.getRequestDispatcher("/views/login/doimk.jsp").forward(req, resp);
				}
			}
			else{
				System.out.println(a.getPassword() + " != " + password);
				req.setAttribute("passwordFalse", true);
				req.getRequestDispatcher("/views/login/doimk.jsp").forward(req, resp);
			}

		}
	}

}
