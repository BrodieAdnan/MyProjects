package ScacchiX4;

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/********************************************************
 *@title SCACCHI X4
 *@package ScacchiX4
 *@author Gazi Adnan Latif
 *@author Condurache Alexandre Petronel
 *@author Xu Vittorio
 *@author Casarin Alessandro
 *@brief Simula il gioco degli Scacchi per 4 giocatori.
 *@date Inizio: 15/11/2017
 *@date Fine: 15/05/2018
********************************************************/

public class main extends Application {

    /*******************************************
    *START
    *@brief 
    *******************************************/
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

//        FileInputStream input = new FileInputStream("\\scacchiera.PNG");
//        Image image = new Image(input);
//        ImageView imageView = new ImageView(image);
//
//        StackPane root = new StackPane();
//        root.getChildren().add(imageView);
//
//        Scene scene = new Scene(root, 200, 100);
//        primaryStage.setTitle("ScacchiX4");
//        primaryStage.setScene(scene);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Inserisci le poszioni per muovere un pezzo");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label partenza = new Label("Coordinate partenza:");
        grid.add(partenza, 0, 1);
        
        TextField partenzaText = new TextField();
        grid.add(partenzaText, 1, 1);
        
        Label destinazione = new Label("Coordinate destinazione:");
        grid.add(destinazione, 0, 2);
        
        TextField destinazioneText = new TextField();
        grid.add(destinazioneText, 1, 2);

        Button btn = new Button("Invia");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Coordinate inviate");
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    /*******************************************
    *MAIN
    *@brief 
    *******************************************/
    public static void main(String[] args) {
        launch(args);
    }
}
