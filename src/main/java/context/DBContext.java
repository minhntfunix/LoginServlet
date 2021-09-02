package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	private final String serverName="DESKTOP-G5NDJT3";
	private final String dbName= "ShoppingDB";
	private final String portNumber= "1433";
	private final String instance="";
	private final String userID="sa";
	private final String password= "minhphuong";
	
	public Connection getConnection() throws Exception {
	String url ="jdbc:sqlserver://"+serverName+":"+portNumber+"\\"+instance+";databaseName="+ dbName;
	if(instance ==null || instance.trim().isEmpty()) {
		url= "jdbc:sqlserver://" + serverName+":"+portNumber+";databaseName="+ dbName;
	}
	
	
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	
	
	return DriverManager.getConnection(url,userID,password);
	}
	
	
	
//	  public static void main(String[] args) {
//	  
//	  try { System.out.println(new DBContext().getConnection()); } catch (Exception
//	  e) { // TODO Auto-generated catch block e.printStackTrace(); }
//	  
//	  }
	 
	
	
	
}
