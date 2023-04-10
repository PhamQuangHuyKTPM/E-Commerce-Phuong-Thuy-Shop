package thanh3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import thanh3.model.AccountModel;
import thanh3.model.ProductModel;

public class AccountDAO extends AbtractDAO {
	
	public AccountModel findUserAndPass(String user) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from account where username=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel m = new AccountModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
				return m;
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	public void update(AccountModel a) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "update account set username=?, password=? where id=?";

		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, a.getUser());
			ps.setString(2, a.getPass());
			ps.setInt(3, a.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
