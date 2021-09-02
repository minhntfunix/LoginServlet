package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import model.*;
public class UserRegisterDAO {
	Connection conn=null;
	PreparedStatement stm=null;
	ResultSet rs=null;
	
	public boolean exist(Account acc) {
		String query="select * from Account where user_mail =?";
		
		try {
			conn = new DBContext().getConnection();
			PreparedStatement stm= conn.prepareStatement(query);
			stm.setString(1, acc.getEmail());
			ResultSet rs= stm.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
		
	public void insert(Account acc) {
		String query="insert into Account values (?,?,?,?,?,?)";
		//INSERT INTO [dbo].[Account]
//        ([user_mail]
//        ,[password]
//        ,[account_role]
//        ,[user_name]
//        ,[user_address]
//        ,[user_phone])
		try {
			conn = new DBContext().getConnection();
			PreparedStatement stm= conn.prepareStatement(query);
			stm.setString(1, acc.getEmail());
			stm.setString(2, acc.getPwd());
			stm.setInt(3, 1);
			stm.setString(4, acc.getName());
			stm.setString(5, acc.getAddress());
			stm.setString(6, acc.getPhone());
			stm.executeUpdate();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
