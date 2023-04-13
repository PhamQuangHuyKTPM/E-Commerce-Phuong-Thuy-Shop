package thanh3.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thanh3.dao.CategoryDAO;
import thanh3.dao.ProductDAO;
import thanh3.model.CartModel;
import thanh3.model.CategoryModel;
import thanh3.model.ProductModel;

@WebServlet(urlPatterns = { "/categoryWeb" })
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

		String status = req.getParameter("status");

		if (status != null) {
			if ("add-to-cart".equals(status)) {
				id = req.getParameter("id");
				List<CartModel> list = new ArrayList<>();

				CartModel cart = new CartModel();
				cart.setId(id);
				cart.setMaGioHang(id);
				cart.setTotalCart(1);

				HttpSession session = req.getSession();
				List<CartModel> cart_list = (List<CartModel>) session.getAttribute("cart-list");

				if (cart_list == null) {
					list.add(cart);
					cart_list = list;
					session.setAttribute("cart-list", cart_list);
					resp.sendRedirect("cart");

				} else if (cart_list != null) {
					list = cart_list;
					boolean exist = false; // exist de kiem tra san pham da ton tai hay chua

					for (CartModel cartModel : cart_list) {
						if (cartModel.getId().equals(id)) {
							exist = true;
							req.setAttribute("text", "product is exist");
							break;
						}
					}
					if (!exist) {
						cart_list.add(cart);
						req.setAttribute("text", "product added");
					}
					resp.sendRedirect("cart");
				}
			}

		} else {
			if (id != null && name != null) {
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

}
