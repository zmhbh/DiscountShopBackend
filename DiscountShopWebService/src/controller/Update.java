package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Item;
import model.Retailer;
//already act as a web service
public class Update {
	private Connection connection = null;
	private Statement statement = null;
	private String sql = null;
	
	public void updateAddress(){
		
	}
	
	
	//for future usage just implemented as local functionality
	/*Update item's price of the retailer (Still not work)*/ 
	public void updateItemPrice(Retailer retailer, Item item, float newPrice) throws SQLException, IOException {
		

		
		/*1st: Search selected retailer from database*/
		statement = connection.createStatement();
		String sql= "SELECT id FROM retailers WHERE retailer_name = '" + retailer.getRetailerName() + "';";
		ResultSet keys = statement.executeQuery(sql);
		int retailer_id = 1;
	    while (keys.next()) {
	    	retailer_id = keys.getInt("id");
	    }
		
	    
	    /*2nd: Search selected item from the database and update the price*/
	    sql = "UPDATE items SET price =" + newPrice + " WHERE retailer_id =" + retailer_id + " AND item_name ='" + item.getItemName() + "';";
	    statement.executeUpdate(sql);
	    
	    System.out.println("Update complete!\n");
		statement.close();
		connection.close();
	    
	}
	
}
