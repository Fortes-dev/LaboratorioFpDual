package fortes.fpdual.javafx;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Text textoBienvenida = new Text("Bienvenido");
		textoBienvenida.setFont(new Font(40));
		textoBienvenida.setX(50);
		textoBienvenida.setY(75);

		Line line = new Line();
		line.setStartX(100.0); 
		line.setStartY(150.0); 
		line.setEndX(500.0); 
		line.setEndY(150.0);
		line.setFill(Color.AZURE);
		
		
		Group root = new Group(line);

		ObservableList<Node> listaHijos = root.getChildren();

		listaHijos.add(textoBienvenida);

		Scene scene = new Scene(root, 600, 300);
		
		primaryStage.setTitle("Sample Application");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}