package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	StudenteDAO studenteDAO;
	CorsoDAO corsoDAO;
	
	public Model(){
		studenteDAO = new StudenteDAO();
		corsoDAO = new CorsoDAO();
	}
	
	public Studente cercaStudentePerMatricola(int matricola) {
		return studenteDAO.cercaStudentePerMatricola(matricola);
	}
	
	public List<Studente> cercaStudentiIscrittoCorso(Corso corso){
		return corsoDAO.getStudentiIscrittiAlCorso(corso);
	}
	
	public List<Corso> getCorsiStudente(int matricola){
		return corsoDAO.getCorsiStudente(matricola);
	}
	
	public boolean isStudenteIscrittoCorso(int matricola, Corso corso) {
		return corsoDAO.isStudenteIscrittoCorso(matricola, corso);
	}
	
	public List<Corso> getTuttiCorsi(){
		return corsoDAO.getTuttiICorsi();
	}
}
