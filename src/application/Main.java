package application;

import java.io.IOException;

import Modelo.Persona;
import Vista.VentanaDosController;
import Vista.VentanaPrincipalController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private static Stage stagePrincipal;
	private AnchorPane rootPane;
	private VentanaPrincipalController controller;
	

	@Override
	public void start(Stage stagePrincipal) throws Exception {
		Main.stagePrincipal = stagePrincipal;
		System.out.println(System.getProperty("user.dir"));
		mostrarVentanaPrincipal();
	}


	public static void main(String[] args) {
		launch(args);
	}


	public void mostrarVentanaPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/VentanPrincipal.fxml"));
			rootPane = (AnchorPane) loader.load();
			Scene scene = new Scene(rootPane);
			stagePrincipal.setTitle("Ventana Principal");
			stagePrincipal.setScene(scene);
			/*
			 * Añadimos las llamadas del main al Controlador y del controlador al main
			 ***/
			controller = loader.getController();
			controller.setProgramaPrincipal(this);
			stagePrincipal.show();
		} catch (Exception e) {
			System.out.println(e.toString());
		
		}
	}

	/*
	 * Este método es llamado cuando se presiona el botón de la ventana principal Lo
	 * llama el controlador de la vista principal
	 */
	public void mostrarVentanaSecundaria() {
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/VentanaDos.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
			/* Creamos la segunda ventana como otro stage */
			Stage ventana = new Stage();
			ventana.setTitle("Venta Dos");
			/* Le decimos a la ventana quién es la ventana original */
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaDos);
			ventana.setScene(scene);
			VentanaDosController controller2 = loader.getController();
			controller2.setStagePrincipal(ventana);
			controller2.setProgramaPrincipal(this);
			controller2.clearItem();
			ventana.show();
			
		} catch (Exception e) {
			// tratar la excepción
		}
	}
	
	public void mostrarVentanaSecundaria(Persona item) {
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/VentanaDos.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
			/* Creamos la segunda ventana como otro stage */
			Stage ventana = new Stage();
			ventana.setTitle("Venta Dos");
			/* Le decimos a la ventana quién es la ventana original */
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaDos);
			ventana.setScene(scene);
			VentanaDosController controller2 = loader.getController();
			controller2.setStagePrincipal(ventana);
			controller2.setProgramaPrincipal(this);
			controller2.setData(item);
			controller2.setItem(item);
			ventana.show();
		} catch (Exception e) {
			// tratar la excepción
		}
	}


	public void añade(Persona contacto) {
		controller.añade(contacto);
		
	}
	


	


	


	
}