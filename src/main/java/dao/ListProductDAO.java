package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.*;


public class ListProductDAO {
	
	//return the list of products by product name
	Connection conn=null;
	PreparedStatement stm=null;
	ResultSet rs=null;
	
	
	
	  	public List<Product> search (String characters) throws Exception{
		List<Product> list = new ArrayList<>();
		String query= "select * from Products where product_name like ?";
		
		try {
			conn = new DBContext().getConnection();			
			stm = conn.prepareStatement(query);
			stm.setString(1, "%"+characters+"%");
			rs=stm.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getFloat(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return list;
	}
	  	
	public int count (String search) {
	  	String query= "select count(*) from Products where product_name like ? ";
	  	try {
	  		conn = new DBContext().getConnection();			
			stm = conn.prepareStatement(query);
			stm.setString(1, "%"+search+"%");
			rs=stm.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	  	return 0;
	}
	
	public List<Product> pagedivide(String search,int pageindex, int size ){
		String query= "with x as (select ROW_NUMBER() over (order by product_id ) as r, \r\n"
				+ "*from Products  where product_name like ?)\n"
				+ "select * from x where r between ?*?-? and ?";  //pageindex*size - (size-1) and pageindex *size
		List<Product> ls= new ArrayList<>();
		
		try {
	  		conn = new DBContext().getConnection();			
			stm = conn.prepareStatement(query);
			stm.setString(1, "%"+search+"%");
			stm.setInt(2, pageindex);
			stm.setInt(3,size);
			stm.setInt(4,size-1);
			stm.setInt(5,pageindex*size);
			rs=stm.executeQuery();
			
			while(rs.next()) {
				ls.add(new Product(rs.getInt(2),
									rs.getString(3),
									rs.getString(4),
									rs.getFloat(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8)));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ls;
	}
	
	
	
	
	
	
//	public static void main(String[] args) throws Exception {
//		ListProductDAO dao= new ListProductDAO();
//		List<Product> ls= dao.pagedivide("",1,6);
//		for (Product o:ls) {
//			System.out.println(o);
//		}
//		
//	}
	
	public Product getProduct(int id) throws Exception{
		String query= "select * from Products where product_id=?";
		Product p= null;
		try {
			conn = new DBContext().getConnection();			
			stm = conn.prepareStatement(query);
			stm.setInt(1,id);
			rs=stm.executeQuery();
			if(rs.next()) {
				p=  new Product (rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getFloat(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return p;
	}
	
	/*
	 * public static void main(String[] args) throws Exception { Product p= new
	 * ListProductDAO().getProduct(2);
	 * 
	 * System.out.println(p); }
	 */
	 
	
	
	
}



