
package school;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Chinyere
 */
public class Prompt {
   public static void think(){
    try{
        for(int i = 0;i<4;i++){
            Thread.sleep(300);
        }
    }catch(Exception fe){}
    }
    
    static boolean answer;
          Stage window = new Stage();

    public static boolean display(String title, String message){
       Stage window = new Stage();
       window.initModality(Modality.APPLICATION_MODAL);
       window.setTitle(title);
       window.getIcons().add(new Image(SCHOOL.class.getResourceAsStream("images/done.png")));
       window.setWidth(400);
       window.setResizable(false);
       Label label = new Label();
       label.setText(message);
       label.setStyle("-fx-text-fill: #FFFFFF");
       
       //Create two buttons
       
       VBox layout = new VBox(20);
       layout.setPadding(new Insets(10,10,10,10));
       layout.getChildren().addAll(label);
       layout.setStyle("-fx-background-color: #3D4956");
       layout.setAlignment(Pos.CENTER);
       
       Scene scene = new Scene(layout);
       window.setScene(scene);
       window.show();
       think();
       window.close();
       return answer;
    } 
}


