package fr.isika.cda24.P1Annuaiiire.program;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PremiereFenetre extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		// Etape 01: Les créations et instantions des variables:

		GridPane root = new GridPane();
		Image logo = new Image("Image/Logo-Isika.png");
		ImageView imageView = new ImageView(logo);
		imageView.setFitWidth(300);
		imageView.setFitHeight(200); 
		imageView.preserveRatioProperty();
		
//// Ajout du logo en haut de la fenêtre
//		logo.setPreserveRatio(true);
//		logo.setFitWidth(500);
//		GridPane.setConstraints(logo, 0, 0, 2, 1, HPos.CENTER, VPos.CENTER);
//		gridPane.getChildren().add(logo);
		
//		Label label = new Label("Insérer l'image dans ce champ");
		Button btn1 = new Button("Consulter l'Annuaire");

		HBox hBox1 = new HBox(200);
		HBox hBox2 = new HBox(200);
		VBox vBox1 = new VBox(300);

		// Etape 02: Intégrer les variables avec le constructeur "obj.getChildren" :

		hBox1.getChildren().add(imageView);
		hBox2.getChildren().add(btn1);
		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.BOTTOM_CENTER);
		vBox1.getChildren().addAll(hBox1, hBox2);

//		vBox1.getChildren().addAll(label, btn1);
		vBox1.setMinSize(300, 300);
		vBox1.setAlignment(Pos.BOTTOM_CENTER);

		// Etape 03 :Tester:

		root.getChildren().addAll(vBox1);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color:#fffff0; -fx-font-family:'serif';");

		Scene scene = new Scene(root, 800, 600);

		stage.setScene(scene);

		stage.setTitle("Bienvenue à l'Annuaire");

		stage.show();
	}
}