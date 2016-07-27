package net.jdbc;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws DBException {

		ArrayList<Region> plist = RegionDAO.selectRegion();
		// String name = new Scanner(System.in).next();
//		for (Region region : plist) {
//			short parent = region.getRegion_id();
//			select(parent, plist);
//		}
		select((short)1, plist);
		// for (Region region : plist) {
		// if (region.getRegion_name().equals(name)) {
		// short id = region.getRegion_id();
		// for (Region r : plist) {
		// if (r.getParent_id() == id) {
		// System.out.println(r.getRegion_name());
		// }
		// }
		// }
		// }
	}

	public static void select(short parent, ArrayList<Region> plist) {
		for (Region r : plist) {
			if (r.getParent_id() == parent) {
				System.out.println(r.getRegion_name());
				select(r.getRegion_id(), plist);
			}
		}
	}

}
