package dad.javafx.divisa;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Divisa {	

	private String nombre;
	private Double tasa;
	
	

	public Divisa(String nombre, Double tasa) {
		super();
		this.nombre = nombre;
		this.tasa = tasa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getTasa() {
		return tasa;
	}

	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	
	public Double fromEuro(Double euros) {
		return euros * tasa;
	}

	public Double toEuro(Double moneda) {
		return moneda / tasa;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	public static Double fromTo(Divisa from, Divisa to, Double cantidad) {
		return to.fromEuro(from.toEuro(cantidad));
	}

}
