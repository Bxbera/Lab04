package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				// System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Crea un nuovo JAVA Bean Corso				
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(new Corso(codins, numeroCrediti, nome, periodoDidattico) );
			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) { // credo che dovrebbe essere string codins
		String codIns = corso.getCodIns();
		String sql = "" ;
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		String codIns = corso.getCodIns();
		String sql = "SELECT s.matricola, s.cognome, s.nome, s.CDS "
				+ "FROM studente s, iscrizione i "
				+ "WHERE s.matricola = i.matricola AND i.codins = ?";
		
		List<Studente> risultato = new ArrayList<>();
		
		Connection conn = ConnectDB.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codIns);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				risultato.add(new Studente(rs.getInt("matricola"), rs.getString("cognome"), 
						rs.getString("nome"), rs.getString("CDS") ) );
			}
			
			rs.close();
			st.close();
			conn.close();
			return risultato;
			
		} catch (SQLException e) {
			System.err.println("Errore connessione al db");
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}
	
	public List<Corso> getCorsiStudente(int matricola) {
		String sql = "SELECT c.codins, c.crediti, c.nome, c.pd "
				+ "FROM corso c, iscrizione i "
				+ "WHERE c.codins = i.codins and i.matricola = ?" ;
		
		Connection conn = ConnectDB.getConnection();
		List<Corso> corsi = new ArrayList<Corso>();
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				corsi.add(new Corso(rs.getString("codins"), rs.getInt("crediti"), 
						rs.getString("nome"), rs.getInt("pd") ) );
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return corsi;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}		
		
	}
	
	public boolean isStudenteIscrittoCorso(int matricola, Corso corso) {
		String codins = corso.getCodIns();
		String sql = "SELECT i.codins, i.matricola "
				+ "FROM iscrizione i "
				+ "WHERE i.codins = ? and i.matricola = ?";
		
		Connection conn = ConnectDB.getConnection();
		try {
			boolean find = false;
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codins);
			st.setInt(2, matricola);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				// se ci entra sono sicuro che il risultato c'è
				find = true;
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return find;		
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
