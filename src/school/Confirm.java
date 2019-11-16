/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Confirm{
    
   static boolean answer;
    Stage window = new Stage();
    
    public static boolean display(String title, String message){
        
       Stage window = new Stage();
       
       window.initModality(Modality.APPLICATION_MODAL);
       window.setTitle(title);
       window.getIcons().add(new Image(SCHOOL.class.getResourceAsStream("images/alert.png")));
        
       window.setWidth(400);
       window.setResizable(false);
       Label label = new Label();
       label.setText(message);
       label.setStyle("-fx-text-fill: #ffffff");
       
       //Create two buttons
       Button yesButton = new Button("Yes");
       yesButton.setStyle("-fx-background-color: #ffffff;"+"-fx-text-fill: #3D4956");
       yesButton.setPadding(new Insets(10,10,10,10));
       Button noButton = new Button("No");
       noButton.setStyle("-fx-background-color: #ffffff;"+"-fx-text-fill:  #3D4956");
       noButton.setPadding(new Insets(10,10,10,10));
       
       yesButton.setOnAction(e->{
           answer = true;
           window.close();
       });
       
       noButton.setOnAction(e->{
           answer = false;
           window.close();
       });
       
       VBox layout = new VBox(20);
       layout.setPadding(new Insets(10,10,10,10));
       layout.getChildren().addAll(label,yesButton,noButton);
       layout.setStyle("-fx-background-color:  #3D4956");
       layout.setAlignment(Pos.CENTER);
       
       Scene scene = new Scene(layout);
       window.setScene(scene);
       window.showAndWait();
       
       return answer;
    } 
}
