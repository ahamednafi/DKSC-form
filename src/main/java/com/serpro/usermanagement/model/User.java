package com.serpro.usermanagement.model;

public class User {
		
	protected int id;
	protected String name;
	protected String unit;
	protected String taluk;
	protected String district;
	protected String fatherName;
	protected String address;
	protected String adhaarNo;
	protected String mobNo;
	
	public User() {
		
	}

	public User(String name, String unit, String taluk, String district, String fatherName, String address,
			String adhaarNo, String mobNo) {
		this.name = name;
		this.unit = unit;
		this.taluk = taluk;
		this.district = district;
		this.fatherName = fatherName;
		this.address = address;
		this.adhaarNo = adhaarNo;
		this.mobNo = mobNo;
	}

	public User(int id, String name, String unit, String taluk, String district, String fatherName, String address,
			String adhaarNo, String mobNo) {
		this.id = id;
		this.name = name;
		this.unit = unit;
		this.taluk = taluk;
		this.district = district;
		this.fatherName = fatherName;
		this.address = address;
		this.adhaarNo = adhaarNo;
		this.mobNo = mobNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdhaarNo() {
		return adhaarNo;
	}

	public void setAdhaarNo(String adhaarNo) {
		this.adhaarNo = adhaarNo;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

}

