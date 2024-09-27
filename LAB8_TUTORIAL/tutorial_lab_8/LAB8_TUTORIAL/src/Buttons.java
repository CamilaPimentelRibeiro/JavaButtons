import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Buttons extends Application {
	
	private Image img1, img2;

	@Override
	public void start(Stage primaryStage) {

		GridPane root = new GridPane();

        img1 = new Image("girl.png");
		img2 = new Image("boy.png");
		workGrid(root);
			
		Scene scene = new Scene(root);
		primaryStage.setTitle("TUTORIAL 8 | CAMILA: 100410712");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
private void workGrid(GridPane root){
	for (int i = 0; i<9; i++) {
		PhotoChanger listener = new PhotoChanger();
		ImageView img  = getImage();
		Button b1 = new Button();
		b1.setGraphic(img);
		b1.setPrefSize(img.getFitWidth(), img.getFitHeight());
		b1.setOnAction(listener);
		root.add(b1,
				i % 3,
				i/3+1);
	}
}
	private ImageView getImage(){
		int x = new Random().nextInt(100);
		if(x<50)
			return new ImageView(img1);
		return new ImageView(img2);
		
	}
	private class PhotoChanger implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			Button bf = (Button)e.getSource();
			ImageView theView= (ImageView)bf.getGraphic();
			Image img = theView.getImage();
			if(img == img1)
				theView.setImage(img2);
			else 
				theView.setImage(img1);
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
	
}
