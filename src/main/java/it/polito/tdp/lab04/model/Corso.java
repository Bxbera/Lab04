package it.polito.tdp.lab04.model;

public class Corso {
	private String codIns;
	private int crediti;
	private String nome;
	private int periodo;

	public Corso(String codIns, int crediti, String nome, int periodo) {
		this.codIns = codIns;
		this.crediti = crediti;
		this.nome = nome;
		this.periodo = periodo;		
	}

	@Override
	public String toString() {
		return "Corso [codIns=" + codIns + ", crediti=" + crediti + ", nome=" + nome + ", periodo=" + periodo + "]";
	}

	public String getCodIns() {
		return codIns;
	}

	public int getCrediti() {
		return crediti;
	}

	public String getNome() {
		return nome;
	}

	public int getPeriodo() {
		return periodo;
	}
}
