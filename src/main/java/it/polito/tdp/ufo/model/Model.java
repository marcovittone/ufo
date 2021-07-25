package it.polito.tdp.ufo.model;

//import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.ufo.db.SightingDAO;

public class Model {
	
	List <String> forme = null;
	
	public List<String> readShapes(){
		
		if(this.forme==null)
		{
			SightingDAO sd = new SightingDAO();
			
			this.forme=sd.readShapes();
		}
		
		return this.forme;
	}
	
	
	public int CountByShape(String shape) {
		
		SightingDAO sd = new SightingDAO();
		return sd.CountByShape(shape);
	}

}
