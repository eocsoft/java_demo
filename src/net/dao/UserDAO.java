package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {

	public static void createTable() throws DBException {
		Connection conn = null;
		Statement s = null;
		try {
			conn = DBConn.getConnection();
			s = conn.createStatement();
			s.executeUpdate("create table user(UID INT,USER_NAME VARCHAR(30),PASSWORD VARCHAR(30),LAST_TIME INT,primary key(UID))");
			DBConn.close(conn, s);
		} catch (Exception e) {
			DBConn.close(conn, s);
			throw new DBException("Excepion while accessing database");
		}

	}

	public static void dropTable() {
		Connection conn = null;
		Statement s = null;
		try {
			conn = DBConn.getConnection();
			s = conn.createStatement();
			s.executeUpdate("drop table User");
			DBConn.close(conn, s);
		} catch (Exception e) {
			DBConn.close(conn, s);
			e.printStackTrace();
		}
	}

	public static ArrayList<User> selectUser() throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		ArrayList<User> plist = new ArrayList<User>();
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement("select * from user");
			res = ps.executeQuery();
			if (res != null) {
				while (res.next()) {
					User pojo = new User();
					pojo.setUID(res.getInt(1));
					pojo.setUSER_NAME(res.getString(2));
					pojo.setPASSWORD(res.getString(3));
					pojo.setLAST_TIME(res.getInt(4));
					plist.add(pojo);
				}
			}
			DBConn.close(conn, ps, res);
		} catch (Exception e) {
			DBConn.close(conn, ps, res);
			throw new DBException("Excepion while accessing database");
		}
		return plist;
	}

	public static void insertRow(User pojo) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConnection();
			ps = conn
					.prepareStatement("insert into user (UID,USER_NAME,PASSWORD,LAST_TIME) values (?,?,?,?)");
			ps.setInt(1, pojo.getUID());
			ps.setString(2, pojo.getUSER_NAME());
			ps.setString(3, pojo.getPASSWORD());
			ps.setInt(4, pojo.getLAST_TIME());
			ps.executeUpdate();
			DBConn.close(conn, ps);
		} catch (Exception e) {
			DBConn.close(conn, ps);
			throw new DBException("Excepion while accessing database");
		}
	}

	public static void deleteRow(User pojo) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConnection();
			ps = conn
					.prepareStatement("delete from user where UID = ? and USER_NAME = ? and PASSWORD = ? and LAST_TIME = ?");
			ps.setInt(1, pojo.getUID());
			ps.setString(2, pojo.getUSER_NAME());
			ps.setString(3, pojo.getPASSWORD());
			ps.setInt(4, pojo.getLAST_TIME());
			ps.executeUpdate();
			ps.close();
			DBConn.close(conn, ps);
		} catch (Exception e) {
			DBConn.close(conn, ps);
			e.printStackTrace();
		}
	}

	public static void updateRow(User pojo1, User pojo2) throws DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConnection();
			ps = conn
					.prepareStatement("update user set UID=?,USER_NAME=?,PASSWORD=?,LAST_TIME=? where  UID=? and USER_NAME=? and PASSWORD=? and LAST_TIME=? ");
			ps.setInt(1, pojo1.getUID());
			ps.setString(2, pojo1.getUSER_NAME());
			ps.setString(3, pojo1.getPASSWORD());
			ps.setInt(4, pojo1.getLAST_TIME());
			ps.setInt(5, pojo2.getUID());
			ps.setString(6, pojo2.getUSER_NAME());
			ps.setString(7, pojo2.getPASSWORD());
			ps.setInt(8, pojo2.getLAST_TIME());
			ps.executeUpdate();
			DBConn.close(conn, ps);
		} catch (Exception e) {
			DBConn.close(conn, ps);
			throw new DBException("Excepion while accessing database");
		}
	}

}