package Vista;

import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Modelo.*;

public class VentanaPrincipalController implements Initializable {
	private Main ProgramaPrincipal;
	private Generador gen = new Generador();
	@FXML
	private TableView<Persona> table;
	@FXML
	private Button btnNuevo;
	@FXML
	private Button btnEditar;
	@FXML
	private Button btnBorrar;
	@FXML
	private TableColumn<Persona, String> fName;

	@FXML
	private TableColumn<Persona, String> lName;

	@FXML
	private TableColumn<Persona, String> email;

	private ObservableList<Persona> Contactos;

	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.ProgramaPrincipal = ProgramaPrincipal;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Contactos = gen.genera();
		table.setItems(Contactos);
		fName.setCellValueFactory(new PropertyValueFactory("firstName"));
		lName.setCellValueFactory(new PropertyValueFactory("lastName"));
		email.setCellValueFactory(new PropertyValueFactory("email"));

	}

	@FXML
	private void nueva() {
		this.ProgramaPrincipal.mostrarVentanaSecundaria();
	}

	@FXML
	public void edita() {

		Boolean seleccionado = table.getItems().isEmpty();
		if (!seleccionado) {
			Persona item = table.getSelectionModel().getSelectedItem();

			this.quita(item);

			this.ProgramaPrincipal.mostrarVentanaSecundaria(item);

		}
		

	}
	public void elimina() {
		Boolean seleccionado = table.getItems().isEmpty();
		if (!seleccionado) {
			Persona item = table.getSelectionModel().getSelectedItem();

			this.quita(item);
			this.actualiza();

		

		}
	}

	public void nuevoContacto(Persona item) {
		this.añade(item);
		this.actualiza();

	}

	public void añade(Persona contacto) {
		Contactos.add(contacto);

	}

	private void quita(Persona item) {
		Contactos.remove(item);
	}

	private void actualiza() {
		table.setItems(Contactos);
	}

}