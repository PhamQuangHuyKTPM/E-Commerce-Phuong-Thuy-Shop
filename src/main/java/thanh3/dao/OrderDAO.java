package thanh3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import thanh3.model.OrderModel;

public class OrderDAO extends AbtractDAO {

	public void insert(OrderModel o) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into donhang(maDH, ngayDatHang, maKH, tongtien) value(?,?,?,?)";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, o.getMaDH());
			ps.setString(2, o.getNgayDatHang());
			ps.setString(3, o.getMaKH());
			ps.setDouble(4, o.getTongtien());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
