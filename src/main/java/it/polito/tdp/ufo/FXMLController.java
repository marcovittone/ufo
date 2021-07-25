package it.polito.tdp.ufo;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.ufo.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Model m;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> txtMagicBox;

    @FXML
    private Button btnAvvistamenti;

    @FXML
    private Label label;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleAvvistamenti(ActionEvent event) {
    	
    	String forma= this.txtMagicBox.getValue();
    	
    	if(forma!=null)
    	{
    		this.txtResult.setText("AVVISTATI "+this.m.CountByShape(forma)+" UFO DI FORMA "+forma);
    	}
    	else
    		this.txtResult.setText("DEVI METTERE UNA FORMA SVEGLIA");

    }

    @FXML
    void initialize() {
        assert txtMagicBox != null : "fx:id=\"txtMagicBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAvvistamenti != null : "fx:id=\"btnAvvistamenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model m) {
		
		this.m=m;
		this.txtMagicBox.getItems().addAll(this.m.readShapes());
		
	}
}
