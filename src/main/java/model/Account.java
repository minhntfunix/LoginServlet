package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
	private String email,pwd;
	private int role;
	private String name, address, phone;
	private int check;
	private Connection conn;	
	

	public Account(Connection conn) {
		
		this.conn = conn;
	}



	public Account(String email, String pwd, int role, String name, String address, String phone, int check) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.check = check;
	}
	public Account(String email, String pwd, int role, String name, String address, String phone) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
		
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	
	public boolean exist(String email) {
		if (getEmail().equals(email) ) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public boolean login (String email, String password) throws SQLException {
		String sql= "select count(*) as count from users where email=? and pass=? ";
		
			PreparedStatement stm= conn.prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2, password);
			
			ResultSet rs= stm.executeQuery();
			int count=0;
			if (rs.next()) {
				count= rs.getInt("count");
				
			}
			
			if (count ==0) {
				return false;
			}else {
				return true;
			}
	}
	
	public void create (String email, String password ) throws SQLException{
		String sql= "insert into users values(?,?)";
		PreparedStatement stm= conn.prepareStatement(sql);
		stm.setString(1, email);
		stm.setString(2, password);
		
		
		
	}
		
			
			
		
		
		
	
	
	
}
