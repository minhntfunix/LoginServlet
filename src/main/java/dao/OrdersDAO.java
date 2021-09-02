package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;
import model.ProductOrders;

public class OrdersDAO {
	//insert info of Order to data sources, including list of product
	//in cart 'c' and info of buyer in Orders o
	Connection conn=null;
	PreparedStatement stm=null;
	ResultSet rs=null;
	public void insertOrder (Orders o, Cart c) throws Exception{
		
		
		//insert into table Orders in datasource
		String query1= "insert into Orders (user_mail,order_status,order_discount_code,order_address) values (?,?,?,?)";
		//,orderID not null,status int null, date not null, 
		//, 2, , ,"",null
		try {
			conn = new DBContext().getConnection();			
			stm = conn.prepareStatement(query1);
			stm.setString(1,o.getUserMail());			
			stm.setInt(2,o.getStatus());	
			stm.setString(3,o.getDiscount());
			stm.setString(4,o.getAddress());
			int i=stm.executeUpdate();	
			System.out.println(i+" records updated");  
			stm.close();
			conn.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		//get the latest order_id from datasource to insert into class Orders 
		//because order_id is identity(1,1) in database
		
		String query2 = "Select IDENT_CURRENT('Orders') as id ";
		Statement stm1 = null;
		conn = new DBContext().getConnection();			
		stm1 = conn.createStatement();
		rs= stm1.executeQuery(query2);
		int id=0;
		if (rs.next()){
			id= rs.getInt("id");
		}
		System.out.println("Latest order_id is " + id  );
		stm1.close();
		
		//update the attribute of class Orders
		
		List<ProductOrders> ls= new ArrayList<ProductOrders>();
		for (Product p:c.getitems()) {
			ls.add(new ProductOrders(id,p.getId(),p.getNumber(),p.getName() ));
		}
		o.setLp(ls);
		o.setOrderID(id);
		o.setPrice((float)c.getAmount());	
		
		Date date= new Date();		
		o.setOrderDate(date);
		
		
		System.out.println("Record in table Orders_detail" );
		for (ProductOrders pp:ls) {
			
			System.out.println("order_id : "+ pp.getOrderId()  );
			System.out.println("product_id : "+ pp.getProductId() );
			System.out.println("amount_product : " + pp.getAmountProduct() );
			
		}
		
		
	
	//insert INFO from Cart into table Orders_detail in datasource
		String query3;
		
		try {
			conn = new DBContext().getConnection();				
			for (Product p:c.getitems()) {
				query3="insert into Orders_detail values (?,?,?,?)";
				stm = conn.prepareStatement(query3);
				stm.setInt(1,id);
				stm.setInt(2,p.getId());
				stm.setInt(3,p.getNumber());
				stm.setFloat(4,Math.round(p.getPrice()*1000000));
				stm.executeUpdate();
				}
			stm.close();
			conn.close();
			}	catch (Exception e) {
				e.printStackTrace();
			}

			
			
		
	}
}
