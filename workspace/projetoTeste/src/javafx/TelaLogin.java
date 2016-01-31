package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class TelaLogin extends Application {
	private static final int LARGURA = 200;
	private static final int ALTURA = 170;

	private AnchorPane pane;
	private Scene scene;

	private Label textoLogin;
	private Label textoSenha;

	private TextField login;
	private PasswordField senha;

	private Button entrar;
	private Button sair;

	public TelaLogin() {
		this.pane = new AnchorPane();
		this.scene = new Scene(this.pane, LARGURA, ALTURA);
		this.textoLogin = new Label("Login");
		this.textoSenha = new Label("Senha");
		this.login = new TextField();
		this.login.setPromptText("Digite o login");
		this.senha = new PasswordField();
		this.senha.setPromptText("Digite sua senha");
		this.entrar = new Button("Entrar");
		this.sair = new Button("Sair");

		adicionaItens();
		organizaTela();
	}

	private void adicionaItens() {
		this.pane.getChildren().add(this.textoLogin);
		this.pane.getChildren().add(this.textoSenha);
		this.pane.getChildren().add(this.login);
		this.pane.getChildren().add(this.senha);
		this.pane.getChildren().add(this.entrar);
		this.pane.getChildren().add(this.sair);
	}

	private void organizaTela() {
		posicionaItem(textoLogin, 10, 20);
		posicionaItem(textoSenha, 10, 70);
		posicionaItem(login, 10, 40);
		posicionaItem(senha, 10, 90);
		posicionaItem(entrar, 10, 130);
		posicionaItem(sair, 90, 130);
	}

	private void posicionaItem(Region item, double x, double y) {
		item.setLayoutX(x);
		item.setLayoutY(y);
	}
	
	private void erroEntrar(String campo) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("o campo " + campo + " foi digitado incorretamente!");
		alert.showAndWait();
	}
	
	private void acaoEntrar(Stage primaryStage) {
		this.entrar.setOnAction((acao) -> {
			if (this.login.getText().equals("123")) {
				if (this.senha.getText().equals("123")) {
					try {
						TelaBoasVindas tbv = new TelaBoasVindas();
						tbv.start(primaryStage);
					}catch (Exception erro) {
						System.out.println(erro.getMessage());
					}
				}else {
					erroEntrar("Senha");
				}
			}else {
				erroEntrar("Login");
			}
		});
	}
	
	private void acaoSair() {
		this.sair.setOnAction((acao) -> System.exit(0));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(this.scene);
		primaryStage.setTitle("Tela de login");
		primaryStage.show();
		
		acaoEntrar(primaryStage);
		acaoSair();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
