package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public Studente cercaStudentePerMatricola(int matricola) {
		String sql = "SELECT * "
				+ "FROM studente s "
				+ "WHERE s.matricola = ?" ;
		
		Studente stud = null;
		Connection conn = ConnectDB.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, matricola);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				stud = new Studente(rs.getInt("matricola"), rs.getString("cognome"), 
						rs.getString("nome"), rs.getString("cds") );
			}
			
			rs.close();
			ps.close();
			conn.close();
			
			return stud;
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Problem with studenteDAO");
			return null;
		}
		
	}
	
	
}
