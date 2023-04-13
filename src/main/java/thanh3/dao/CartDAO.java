package thanh3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import thanh3.model.CartModel;

public class CartDAO extends AbtractDAO {

	public void addCartToDB(CartModel model) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into cart(maGioHang, maDH, maSP, soluong, tongtien) value(?,?,?,?,?)";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, model.getMaGioHang());
			ps.setString(2, model.getMaDH());
			ps.setString(3, model.getMaGioHang());
			ps.setInt(4, model.getTotalCart());
			ps.setDouble(5, model.getTongtien());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
