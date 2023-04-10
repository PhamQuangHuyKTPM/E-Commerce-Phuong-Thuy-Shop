package thanh3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import thanh3.model.AccountModel;
import thanh3.model.ManagerModel;

public class ManagerDAO extends AccountDAO {

	public void register(ManagerModel p) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into person(id_user, hoten, diachi, sdt, ngaysinh, email, username, password, isadmin)"
				+ " values(?,?,?,?,?,?,?,?,?)";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, p.getId_user());
			ps.setString(2, p.getHoten());
			ps.setString(3, p.getDiachi());
			ps.setString(4, p.getSdt());
			ps.setString(5, p.getNgaysinh());
			ps.setString(6, p.getEmail());
			ps.setString(7, p.getUsername());
			ps.setString(8, p.getPassword());
			ps.setInt(9, p.getIsAdmin());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ManagerModel findUserAndPass(ManagerModel manager) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from person where username=? and password=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, manager.getUsername());
			ps.setString(2, manager.getPassword());
			rs = ps.executeQuery();
			while (rs.next()) {
				ManagerModel m = new ManagerModel(rs.getString("id_user"), rs.getString("hoten"),
						rs.getString("diachi"),rs.getString("sdt"),
						rs.getString("ngaysinh"), rs.getString("email"),
						rs.getString("username"), rs.getString("password"), rs.getInt("isadmin"));
				return m;
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	public ManagerModel findByID(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from person where id_user=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ManagerModel m = new ManagerModel(rs.getString("id_user"), rs.getString("hoten"),
						rs.getString("diachi"),rs.getString("sdt"),
						rs.getString("ngaysinh"), rs.getString("email"),
						rs.getString("username"), rs.getString("password"), rs.getInt("isadmin"));
				return m;
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	public void updateAllById(ManagerModel m) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "update person set hoten=?, diachi=?, sdt=?, ngaysinh=?, email=?, username=?  where id_user=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, m.getHoten());
			ps.setString(2, m.getDiachi());
			ps.setString(3, m.getSdt());
			ps.setString(4, m.getNgaysinh());
			ps.setString(5, m.getEmail());
			ps.setString(6, m.getUsername());
			ps.setString(7, m.getId_user());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void updatePassword(ManagerModel a) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "update person set username=?, password=? where id_user=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, a.getUsername());
			ps.setString(2, a.getPassword());
			ps.setString(3, a.getId_user());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
