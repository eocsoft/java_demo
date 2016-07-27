package net.jdbc;

public class Region {
	private short region_id;
	private short parent_id;
	private String region_name;
	private byte region_type;
	private short agency_id;

	public short getRegion_id() {
		return region_id;
	}

	public void setRegion_id(short region_id) {
		this.region_id = region_id;
	}

	public short getParent_id() {
		return parent_id;
	}

	public void setParent_id(short parent_id) {
		this.parent_id = parent_id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public byte getRegion_type() {
		return region_type;
	}

	public void setRegion_type(byte region_type) {
		this.region_type = region_type;
	}

	public short getAgency_id() {
		return agency_id;
	}

	public void setAgency_id(short agency_id) {
		this.agency_id = agency_id;
	}

	@Override
	public String toString() {
		return "Region [region_id=" + region_id + ", parent_id=" + parent_id
				+ ", region_name=" + region_name + ", region_type="
				+ region_type + ", agency_id=" + agency_id + "]";
	}

}
