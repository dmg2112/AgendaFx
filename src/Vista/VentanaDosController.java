package Vista;

import Modelo.Persona;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class VentanaDosController {
	@FXML
	private Button cancelar;
	@FXML 
	private  Button aceptar;
	@FXML
	private TextField fNameTxt;
	@FXML
	private TextField lNameTxt;
	@FXML
	private TextField emailTxt;
	private Persona item;
	
	
	private Stage ventana;
	private Main ProgramaPrincipal;

	public void setStagePrincipal(Stage ventana) {

		this.ventana = ventana;
	}
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		
		 this.ProgramaPrincipal = ProgramaPrincipal;
		}
	public void cerrar() {
		if(this.item!=null) {
			this.ProgramaPrincipal.añade(this.item);
		}
		this.ventana.close();
	}
	public void actualia() {
		this.getData();
		this.ventana.close();
	}
	
	
	
	public void setFName(String value) {
		fNameTxt.setText(value);
	}
	
	public void setLName(String value) {
		lNameTxt.setText(value);
	}
	
	public void setEmail(String value) {
		emailTxt.setText(value);
	}
	
	public void getData() {
		Persona contacto = new Persona(this.fNameTxt.getText(),this.lNameTxt.getText(),this.emailTxt.getText());
		this.ProgramaPrincipal.añade(contacto);
		
	}
	public void setData(Persona item) {
		this.setEmail(item.getEmail());
		this.setFName(item.getFirstName());
		this.setLName(item.getLastName());
		
	}
	
	public void setItem(Persona item) {
		this.item = item;
	}
	public void clearItem() {
		this.item = null;
		
	}
}