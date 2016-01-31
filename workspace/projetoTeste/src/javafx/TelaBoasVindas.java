package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaBoasVindas extends Application{
	private static final int LARGURA = 200;
	private static final int ALTURA = 170;

	private AnchorPane pane;
	private Scene scene;

	private Label texto;

	public TelaBoasVindas(){
		this.pane = new AnchorPane();
		this.scene = new Scene(this.pane, LARGURA, ALTURA);
		this.texto = new Label("Seja bem vindo!");
		this.pane.getChildren().add(this.texto);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(this.scene);
		primaryStage.setTitle("Tela de boas vindas");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
