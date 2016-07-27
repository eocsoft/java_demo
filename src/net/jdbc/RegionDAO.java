package net.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RegionDAO {
	public static ArrayList<Region> selectRegion() throws DBException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		ArrayList<Region> plist = new ArrayList<Region>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM ecs_region";
			res = stmt.executeQuery(sql);
			while (res.next()) {
				Region region = new Region();
				region.setRegion_id(res.getShort("region_id"));
				region.setParent_id(res.getShort("parent_id"));
				region.setRegion_name(res.getString("region_name"));
				region.setRegion_type(res.getByte("region_type"));
				region.setAgency_id(res.getShort("agency_id"));
				plist.add(region);
			}

		} catch (Exception e) {
			throw new DBException("数据库访问异常");
		} finally {
			DBUtil.close(conn, stmt, res);
		}

		return plist;
	}
}
