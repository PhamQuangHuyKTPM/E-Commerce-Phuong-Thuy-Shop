package thanh3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import thanh3.model.CartModel;
import thanh3.model.ProductModel;

public class ProductDAO extends AbtractDAO {

	public List<ProductModel> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from sanpham";
		List<ProductModel> list = new ArrayList<ProductModel>();

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel p = new ProductModel(rs.getString("masp"),
						rs.getString("tensp"),
						rs.getString("mota"),
						rs.getDouble("dongia"),
						rs.getString("danhmuc"),
						rs.getInt("soluong"),
						rs.getString("image"));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<CartModel> getCartProducts(List<CartModel> list){
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<CartModel> products = new ArrayList<>();
		
		try {
			if(list.size() >= 0) {
				for (CartModel items : list) {
					String sql = "select * from sanpham where masp = ?";
					con = getConnection();
					ps = con.prepareStatement(sql);
					ps.setString(1, items.getId());
					rs = ps.executeQuery();
					while(rs.next()) {
						CartModel cart = new CartModel();
						cart.setId(rs.getString("masp"));
						cart.setMaGioHang(rs.getString("masp"));
						cart.setTen(rs.getString("tensp"));
						cart.setImage(rs.getString("image"));
						cart.setDanhmuc(rs.getString("danhmuc"));
						cart.setDongia(rs.getDouble("dongia"));
						cart.setTotalCart(items.getTotalCart());
						cart.setTongtien(rs.getDouble("dongia") * items.getTotalCart());
						
						products.add(cart);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return products;
		
	}
	
	public void removeCart(List<CartModel> list, String id) {
		if(list.size() > 0) {
			for (CartModel items : list) {
				if(items.getId().equals(id)) {
					list.remove(items);
					break;
				}
			}
		}
	}
	
	public List<ProductModel> selectAllByCategory(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from sanpham where danhmuc=?";
		List<ProductModel> list = new ArrayList<ProductModel>();

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel p = new ProductModel(rs.getString("masp"),
						rs.getString("tensp"),
						rs.getString("mota"),
						rs.getDouble("dongia"),
						rs.getString("danhmuc"),
						rs.getInt("soluong"),
						rs.getString("image"));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	public ProductModel getById(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from sanpham where masp=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel p = new ProductModel(rs.getString("masp"),
						rs.getString("tensp"),
						rs.getString("mota"),
						rs.getDouble("dongia"),
						rs.getString("danhmuc"),
						rs.getInt("soluong"),
						rs.getString("image"));
				return p;
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<ProductModel> searchLikeName(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from sanpham where tensp like '"+ name +"%'";
		List<ProductModel> list = new ArrayList<ProductModel>();

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel p = new ProductModel(rs.getString("masp"),
						rs.getString("tensp"),
						rs.getString("mota"),
						rs.getDouble("dongia"),
						rs.getString("danhmuc"),
						rs.getInt("soluong"),
						rs.getString("image"));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void update(ProductModel p) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "update sanpham set tensp=?, mota=?, dongia=?, danhmuc=?, soluong=?, image=? where masp=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, p.getTen());
			ps.setString(2, p.getMota());
			ps.setDouble(3, p.getDongia());
			ps.setString(4, p.getDanhmuc());
			ps.setInt(5, p.getSoluong());
			ps.setString(6, p.getImage());
			ps.setString(7, p.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(String id) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "delete from sanpham where masp=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void insert(ProductModel p){
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into sanpham(masp, tensp, mota, dongia, danhmuc, soluong, maph) values(?,?,?,?,?,?,?)";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, p.getId());
			ps.setString(2, p.getTen());
			ps.setString(3, p.getMota());
			ps.setDouble(4, p.getDongia());
			ps.setString(5, p.getDanhmuc());
			ps.setInt(6, p.getSoluong());
			ps.setString(7, " ");
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
