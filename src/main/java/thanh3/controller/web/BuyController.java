package thanh3.controller.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import thanh3.dao.CartDAO;
import thanh3.dao.OrderDAO;
import thanh3.dao.ProductDAO;
import thanh3.model.CartModel;
import thanh3.model.OrderModel;

@WebServlet(urlPatterns = {"/buy"})
public class BuyController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	OrderDAO orderDao = new OrderDAO();
	CartDAO cartDao = new CartDAO();
	ProductDAO productDao = new ProductDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		/* setDate */
		 Date date = new Date();	
		 SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		 String strdate = dateformat.format(date); 
		 /* End setDate */
		
		OrderModel model = new OrderModel();
		String maDH = "MDH" + (int) Math.floor(((Math.random() * 899999) + 100000));
		model.setMaDH(maDH);
		model.setNgayDatHang(strdate);
		model.setMaKH(req.getParameter("id"));
		model.setTongtien(Double.parseDouble(req.getParameter("total")));
		
		System.out.println(model.getMaDH() + " - " + model.getNgayDatHang() + " - " + model.getMaKH() + " - " + model.getTongtien());
		
		/* Cập nhật mã Đơn hàng */
		HttpSession session = req.getSession();
		List<CartModel> cart_list = (List<CartModel>) session.getAttribute("cart-list");
		
		List<CartModel> cartProduct = productDao.getCartProducts(cart_list);
		
		for (CartModel cartt : cartProduct) {
			cartt.setMaDH(maDH);
			cartt.setMaSP(cartt.getId());
			cartDao.addCartToDB(cartt);
		}
		
		orderDao.insert(model);
		
		resp.sendRedirect("cart");
	}
}
