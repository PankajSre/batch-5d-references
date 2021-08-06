package com.amdocs.training.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.model.Admin;
import com.amdocs.training.model.User;
import com.amdocs.training.util.DBUtil;
import com.amdocs.training.util.DataSourceUtil;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Admin> findAll() {
		List<Admin> admins = new ArrayList<Admin>();
		String sql = "select * from admin";
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");

				Admin admin = new Admin(id, name, email, password);
				admins.add(admin);
			}
			return admins;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAdmin(Admin admin) {

		String query = "insert into admin values(?,?,?,?)";

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setLong(1, admin.getId());
			ps.setString(2, admin.getName());

			ps.setString(3, admin.getEmail());
			ps.setString(4, admin.getPassword());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
//
//	@Override
//	public User getUserById(Long id) {
//
//		String query = "select * from user where id=?";
//
//		try {
//			Connection conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setLong(1, id);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				User user = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//				return user;
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public boolean deleteUser(Long id) {
//
//		String query = "delete from user where id=?";
//
//		try {
//			Connection conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement(query);
//
//			ps.setLong(1, id);
//			ps.executeUpdate();
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//
//	}
//
//	@Override
//	public boolean updateUser(User user) {
//
//		String query = "update user set username=?, password=?, email=?, address=? where id=?";
//
//		try {
//			Connection conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement(query);
//
//			ps.setString(1, user.getUsername());
//			ps.setString(2, user.getPassword());
//			ps.setString(3, user.getEmail());
//			ps.setString(4, user.getAddress());
//			ps.setLong(5, user.getId());
//			ps.executeUpdate();
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}

}
