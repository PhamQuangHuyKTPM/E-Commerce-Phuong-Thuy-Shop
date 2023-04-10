package thanh3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import thanh3.model.CategoryModel;
import thanh3.model.ProductModel;

public class CategoryDAO extends AbtractDAO{
	
	public List<CategoryModel> findAll(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from category";
		List<CategoryModel> list = new ArrayList<CategoryModel>();

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CategoryModel p = new CategoryModel(rs.getInt("id"), rs.getString("ten"),rs.getString("image"));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	public CategoryModel getById(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from category where id=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				CategoryModel p = new CategoryModel(rs.getInt("id"), rs.getString("ten"), rs.getString("image"));
				return p;
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void update(CategoryModel p) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "update category set ten=?, image=? where id=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, p.getTen());
			ps.setString(2, p.getImage());
			ps.setInt(3, p.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "delete from category where id=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insert(String ten, String image){
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into category(ten, image) values(?,?)";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, ten);
			ps.setString(2, image);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
