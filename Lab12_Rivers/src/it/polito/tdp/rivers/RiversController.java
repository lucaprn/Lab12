/**
 * Sample Skeleton for 'Rivers.fxml' Controller Class
 */

package it.polito.tdp.rivers;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.corba.se.impl.naming.cosnaming.InternalBindingKey;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import it.polito.tdp.rivers.db.CoppiaMisurazioni;
import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.ResultSimulation;
import it.polito.tdp.rivers.model.River;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class RiversController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxRiver"
    private ComboBox<River> boxRiver; // Value injected by FXMLLoader

    @FXML // fx:id="txtStartDate"
    private TextField txtStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtEndDate"
    private TextField txtEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumMeasurements"
    private TextField txtNumMeasurements; // Value injected by FXMLLoader

    @FXML // fx:id="txtFMed"
    private TextField txtFMed; // Value injected by FXMLLoader

    @FXML // fx:id="txtK"
    private TextField txtK; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    

    @FXML
    void OnSelect(ActionEvent event) {
    	River r = this.boxRiver.getValue();
    	try {
    	if(r==null) {
    		txtResult.setText("Seleziona un fiume!!");
    		return;
    	}
    	CoppiaMisurazioni c = model.getCoppiaMisurazioni(r);
    	this.txtStartDate.setText(""+c.getPrima());
    	this.txtEndDate.setText(""+c.getUltima());
    	this.txtNumMeasurements.setText(""+model.getNumero(r));
    	this.txtFMed.setText(String.format("%.2f", model.getMedie(r)));
    	
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    		this.txtResult.setText("Errore Database");
    	}
    }
    
    @FXML
    void OnSimula(ActionEvent event) {
    	txtResult.clear();
    	River r = this.boxRiver.getValue();
    	String sk = this.txtK.getText();
    	
    	try {
    		
    		int k = Integer.parseInt(sk);
    		
    		if(r==null) {
    			txtResult.setText("Errore: Seleziona un fiume per la simulazione!");
    			return;
    		}
    		if(k<=0) {
    			txtResult.setText("Errore: Seleziona un fattore di dimensionamento corretto!");
    			return;
    		}
  
    		
    		ResultSimulation rs =model.runSimulazione(k, r);
    		
    		txtResult.setText(String.format("Numero di normale servizio : %d\nNumero di mancato servizio : %d\n", rs.getNormaleServizio(),rs.getNumeroNoServizio()));
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    		return;
    	}
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Rivers.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		this.boxRiver.getItems().addAll(model.getAllRivers());
	}
}


