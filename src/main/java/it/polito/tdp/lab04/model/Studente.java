package it.polito.tdp.lab04.model;

public class Studente {
	
	private Integer matricola;
	private String cognome;
	private String nome;
	private String cDS;

	public Studente(Integer matricola, String cognome, String nome, String cDS) {
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.cDS = cDS;		
	}

	public Integer getMatricola() {
		return matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getcDS() {
		return cDS;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", cognome=" + cognome + ", nome=" + nome + ", cDS=" + cDS + "]";
	}
}
