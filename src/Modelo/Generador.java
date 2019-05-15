package Modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Generador {
	public Generador() {
		
	}
	
	public ObservableList<Persona> genera(){
		Persona kurco = new Persona("Kurt","Cobain","nirvana@nevermind.com");
		Persona axl = new Persona("slash","rose","guns@roses.com");
		Persona slash = new Persona("slash","cooper","slash@band.com");
		Persona dio = new Persona("Ronald James","Padavona","RonnieJames@Dio.com");
		ObservableList<Persona> data = FXCollections.observableArrayList(kurco,axl,slash,dio);
		
		return data;
		
	}

}
