package fr.isika.cda24.P1Annuaiiire.program;

import fr.isika.cda24.P1Annuaiiire.entitees.Stagiaire;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeuxiemeFenetre extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setAlignment(Pos.CENTER);
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS);
		gridPane.getColumnConstraints().add(column1);
		
// Création de la TableView
		TableView<Stagiaire> tableView = creerTableView();
		
// Etape 01: Les créations et instanciations des variables pour la HBox en haut:
		
		Label lbl1 = new Label("Login : ");
		TextField tf1 = new TextField("Login");
		Label lbl2 = new Label("Mot de passe : ");
		PasswordField pf1 = new PasswordField();
		Button btn1 = new Button("Valider");
		HBox hBox = new HBox();
		hBox.getChildren().addAll(lbl1, tf1, lbl2, pf1, btn1);
		hBox.setPrefSize(800, 25);
		hBox.setStyle("-fx-background-color:#fffff0");
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(10);
		hBox.setPadding(new Insets(10));
		
// Etape 02: Les créations et instanciations des éléments de recherche à gauche:
		
		Label lbl3 = new Label("Nom :");
		TextField tf2 = new TextField("Nom");
		Label lbl4 = new Label("Prénom :");
		TextField tf3 = new TextField("Prénom");
		Label lbl5 = new Label("Départ. :");
		TextField tf4 = new TextField("Département");
		Label lbl6 = new Label("Année :");
		TextField tf5 = new TextField("Année");
		Label lbl7 = new Label("Promotion :");
		TextField tf6 = new TextField("Promotion");
		Button btn2 = new Button("Rechercher");
		Button btn3 = new Button("Imprimer   ");
		Button btn4 = new Button("Modifier    ");
		Button btn5 = new Button("Supprimer ");
		
// VBox pour contenir les boutons à gauche de la fenêtre
		
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setMaxWidth(200);
		vBox.setAlignment(Pos.CENTER_LEFT);
		vBox.getChildren().addAll(lbl3, tf2, lbl4, tf3, lbl5, tf4, lbl6, tf5, lbl7, tf6, btn2, btn3, btn4, btn5);
		vBox.setPrefSize(200, 200);
		vBox.setStyle("-fx-background-color:#fffff0");
		
// Ajout de la VBox et de la hBox au GridPane
// GridPane.setConstraints(node, colonne, ligne)
		
		GridPane.setConstraints(hBox, 1, 0);
		gridPane.getChildren().add(hBox);
		GridPane.setConstraints(vBox, 0, 1);
		gridPane.getChildren().add(vBox);
		GridPane.setConstraints(tableView, 1, 1);
		
		gridPane.getChildren().add(tableView);
		gridPane.setStyle("-fx-background-color:#fffff0; -fx-font-family:'serif';");
		Scene scene = new Scene(gridPane, 900, 650);
		stage.setScene(scene);
		stage.setTitle("Annuaire - Page de consultation");
		stage.show();
	}

	private TableView<Stagiaire> creerTableView() {
		TableView<Stagiaire> tableView = new TableView<>();
		TableColumn<Stagiaire, String> nomColonne = new TableColumn<>("Nom");
		nomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
		nomColonne.setMinWidth(100);
		TableColumn<Stagiaire, String> prenomColonne = new TableColumn<>("Prénom");
		prenomColonne.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		prenomColonne.setMinWidth(100);
		TableColumn<Stagiaire, String> departementColonne = new TableColumn<>("Département");
		departementColonne.setCellValueFactory(new PropertyValueFactory<>("departement"));
		departementColonne.setMinWidth(100);
		TableColumn<Stagiaire, String> promotionColonne = new TableColumn<>("Promotion");
		promotionColonne.setCellValueFactory(new PropertyValueFactory<>("promotion"));
		promotionColonne.setMinWidth(100);
		TableColumn<Stagiaire, Integer> anneeColonne = new TableColumn<>("Année");
		anneeColonne.setCellValueFactory(new PropertyValueFactory<>("annee"));
		anneeColonne.setMinWidth(100);
// Ajout des colonnes à la TableView
		tableView.getColumns().addAll(nomColonne, prenomColonne, departementColonne, promotionColonne, anneeColonne);
// Ajustement de la largeur des colonnes pour supprimer l’espace inutile à droite de la dernière colonne
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		return tableView;
	}
}
