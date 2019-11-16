
package school;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class SCHOOL extends Application {
    Stage stages;
    @Override
    public void start(Stage stage) throws Exception {
        stages = stage;
        
        stages.setOnCloseRequest(e ->{
                e.consume();
                closeProgram();
                });
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stages.setScene(scene);
        stages.setTitle("Student Database Manager");
        stages.getIcons().add(new Image(SCHOOL.class.getResourceAsStream("images/icon.png")));
        stages.setResizable(false);
        stages.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
     public void closeProgram(){
            Boolean answer = Confirm.display("CONFIRM!","Are you sure you want to close");
            if (answer)
               stages.close();
    }
 
}
