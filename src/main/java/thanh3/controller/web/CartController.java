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

@WebServlet(urlPatterns = "/cart")
public class CartController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CategoryDAO categoryDao = new CategoryDAO();
	ProductDAO productDao = new ProductDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		List<CategoryModel> categories = categoryDao.findAll();
		Double total = 0.0;
		req.setAttribute("categories", categories);

		String status = req.getParameter("status");
		if (status != null) {
			if ("add-to-cart".equals(status)) {
				String id = req.getParameter("id");

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
					total = cart.getTotalCart() * cart.getDongia();
					req.setAttribute("total", total);
					resp.sendRedirect("cart");
					
				} else if (cart_list != null) {
					list = cart_list;
					boolean exist = false; // exist de kiem tra san pham da ton tai hay chua

					for (CartModel cartModel : cart_list) {
						
						if (cartModel.getId().equals(id)) {
							exist = true;
							break;
						}
					}
					if (!exist) {
						cart_list.add(cart);
						for (CartModel cartModel : cart_list) {
							total += cartModel.getTongtien();
						}
						req.setAttribute("total", total);
					}
					resp.sendRedirect("cart");
				}
			
			}
			if("delete".equals(status)) {
				HttpSession session = req.getSession();
				List<CartModel> cart_list = (List<CartModel>) session.getAttribute("cart-list");
				String id = req.getParameter("id");
				productDao.removeCart(cart_list, id);
				resp.sendRedirect("cart");
			}
		}
		
		else {
			HttpSession session = req.getSession();
			List<CartModel> cart_list = (List<CartModel>) session.getAttribute("cart-list");
			
			List<CartModel> cartProduct = productDao.getCartProducts(cart_list);
			req.setAttribute("cartProduct", cartProduct);
			for (CartModel cartModel : cartProduct) {
				total += cartModel.getTongtien();
			}
			req.setAttribute("total", total);
			req.getRequestDispatcher("/views/web/cart.jsp").forward(req, resp);
		}
	}

}
