package dad.javafx.divisa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DivisaApp extends Application {

	private TextField textoPrimero;
	private TextField textoSegundo;
	private ComboBox<Divisa> combo;
	private ComboBox<Divisa> comboDos;
	private Button cambio;
	Alert fallo = new Alert(AlertType.ERROR);
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Divisa euro = new Divisa("Euro", 1.0);
		Divisa libra = new Divisa("Libra", 0.8873);
		Divisa dolar = new Divisa("Dolar", 1.2007);
		Divisa yen = new Divisa("Yen", 133.59);
		
		textoPrimero = new TextField();
		textoPrimero.setPromptText("0");
		textoSegundo = new TextField();
		textoSegundo.disabledProperty();
		combo= new ComboBox <Divisa>();
		combo.getItems().addAll(
			euro,libra,dolar,yen
       );
		combo.getSelectionModel().select(1);
		
		comboDos= new ComboBox <Divisa>();
		comboDos.getItems().addAll(
			euro,libra,dolar,yen
       );
		comboDos.getSelectionModel().select(2);
		
		cambio = new Button("Cambiar");
		cambio.setDefaultButton(true);
		cambio.setOnAction(e -> onCambiarButton());
		
		HBox primero = new HBox();
		primero.setSpacing(5);
		primero.setAlignment(Pos.CENTER);
		primero.getChildren().addAll(textoPrimero, combo);
		
		HBox segundo = new HBox();
		segundo.setSpacing(5);
		segundo.setAlignment(Pos.CENTER);
		segundo.getChildren().addAll(textoSegundo, comboDos);
		
		VBox caja = new VBox();
		caja.setSpacing(5);
		caja.setAlignment(Pos.CENTER);
		caja.getChildren().addAll(primero, segundo, cambio);
		
		
		Scene scene = new Scene(caja, 480, 320);
		primaryStage.setTitle("Cambiar divisa");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	private void onCambiarButton() {
		
		try {
			Divisa divisaEntrada = combo.getSelectionModel().getSelectedItem();
			Divisa divisaSalida = comboDos.getSelectionModel().getSelectedItem();
			double cantidad = Double.parseDouble(textoPrimero.getText());
			Divisa.fromTo(divisaEntrada, divisaSalida,cantidad);
			textoSegundo.setText(Divisa.fromTo(divisaEntrada, divisaSalida,cantidad).toString());
			
		}catch(Exception a) {
			fallo.setTitle("Error.");
			fallo.setHeaderText("Ha habido un error.");
			fallo.showAndWait();
		}
		
	}

	public static void main(String[] args) {

		
		
		launch(args);

	}

}
