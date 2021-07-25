package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {
	
	
	public List <String> readShapes(){

		try {
			
			Connection c = DBConnect.getConnection();
			
			String sql="SELECT DISTINCT shape "
					+ "FROM sighting "
					+ "WHERE shape <> '' "
					+ "ORDER BY shape ASC";
			
			PreparedStatement ps= c.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<String> forme= new ArrayList<String>();
			
			while(rs.next())
			{
				forme.add(rs.getString("shape"));
			}
			
			rs.close();
			ps.close();
			c.close();
			return forme;
			
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error in readShapes", e) ;
		}
		
		
		
		
	}
	
	
	
	public int CountByShape (String shape) {
		try {
			Connection c=DBConnect.getConnection();
			
			String sql="SELECT COUNT(*) "
					   + "FROM sighting "
					   + "WHERE shape= ? ";
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, shape);
			
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			int cont=rs.getInt(1);
			rs.close();
			ps.close();
			c.close();
			
			return cont; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Database error in CountByShape", e) ;
		}
	}
	
	

}
