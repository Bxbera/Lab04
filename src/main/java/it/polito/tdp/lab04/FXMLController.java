/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLController {
	
	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button btnCercaCorsiStudente;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private Button btnCompletaStudente;

    @FXML
    private Button btnIscrivi;

    @FXML
    private Button btnReset;

    @FXML
    private ComboBox<Corso> cmbElencoCorsi;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCercaCorsiStudente(ActionEvent event) {
    	String sMatricola = this.txtMatricola.getText();
    	try {	
	    	int matricola = Integer.parseInt(sMatricola);
	    	List<Corso> corsi = this.model.getCorsiStudente(matricola);
	    	if(corsi.size() != 0) {
	    		for(Corso c : corsi) {
	    			this.txtResult.appendText(c.toString()+"\n");
	    		}
	    	}
	    	else {
	    		this.txtResult.setText("Non è iscritto in nessun corso!");
	    	}
    	} catch (NumberFormatException e){
    		this.txtResult.setText("Errore nell'inserimento della matricola!");
    	}    	
    	
    }

    @FXML
    void doCercaIscrittoCorso(ActionEvent event) {
    	Corso c = this.cmbElencoCorsi.getValue();
    	if(c!=null) {
    		for(Studente s : this.model.cercaStudentiIscrittoCorso(c)) {
    			this.txtResult.appendText(s.toString()+"\n");
    		}
    	}
    	else {
    		this.txtResult.setText("Non hai selezionato nessun corso!");
    	}
    }

    @FXML
    void doCompletaStudente(ActionEvent event) {
    	
    	String sMatricola = this.txtMatricola.getText();
    	try {
	    	int matricola = Integer.parseInt(sMatricola);
	    	Studente s = model.cercaStudentePerMatricola(matricola);
	    	// non mi sono chiesto cosa rimanderebbe se lo studente non c'è nel db
	    	// da come ha reagito, da null se non trova uno studente
	    	if(s!=null) { // oppure instanceof ??
	    		this.txtCognome.setText(s.getCognome() );
	    		this.txtNome.setText(s.getNome() );
	    	}
	    	else {
	    		this.txtResult.setText("Lo studente non c'è!");
	    	}
    	} catch (NumberFormatException e) {
    		this.txtResult.setText("Errore nell'inserimento della matricola!");
    	}
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtResult.clear();
    	this.txtCognome.clear();
    	this.txtNome.clear();
    	this.txtMatricola.clear();
    	
    }
    
    @FXML
    void setCmbBox1(MouseEvent event) {
    	for(Corso c: this.model.getTuttiCorsi()) {
        	this.cmbElencoCorsi.getItems().add(c);
       }
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
    
    @FXML
    void setCmbBox(ActionEvent event) {
  
    }
    
     
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert btnCercaCorsiStudente != null : "fx:id=\"btnCercaCorsiStudente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCompletaStudente != null : "fx:id=\"btnCompletaStudente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbElencoCorsi != null : "fx:id=\"cmbElencoCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
       
        
    }
    
}