package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Corso;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		
		
		StudenteDAO sdao = new StudenteDAO();
		
		//System.out.println(sdao.cercaStudentePerMatricola(154817));
		System.out.println(cdao.isStudenteIscrittoCorso(198592, new Corso("01NBAPG", 2, "sku", 3) ) );
	}

}
