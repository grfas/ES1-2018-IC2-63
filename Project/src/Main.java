import Facebook.InicializadorFacebook;
import Twitter.TwitterApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import xico.ReadEmail;

public class Main extends Application{
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
		TwitterApp twitt = new TwitterApp();
		InicializadorFacebook iniciaFace = new InicializadorFacebook();
		ReadEmail mail= new ReadEmail() ;
		
		mail.iniciaMail();
		twitt.iniciaTwitter();
		iniciaFace.IniciaFace();
		launch(arg0);
		
		
	}

	
}
