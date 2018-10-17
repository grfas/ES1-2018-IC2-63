import Facebook.InicializadorFacebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent root = FXMLLoader.load(getClass().getResource("/application/GUI.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("MyTitle");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] arg0){
		// TODO Auto-generated method stub
		InicializadorFacebook iniciaFace = new InicializadorFacebook();
		
		iniciaFace.IniciaFace();
		launch(arg0);
		
		
	}

	
}
