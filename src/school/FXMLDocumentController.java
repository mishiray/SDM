
package school;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.util.Duration;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.geometry.*;
import javafx.animation.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.*;
import javafx.stage.*;

public class FXMLDocumentController implements Initializable {
    
    ObservableList<String> gender = FXCollections.observableArrayList("M","F");
    
    public Stage stage;
    public Label label;
    public Button button_sd,button_pd,bn_opennew,btn_read,log;
    public AnchorPane ap_front,ap_sd,ap_pd,ap_rd,s3;
    public VBox s2;
    public HBox s4;
    public ChoiceBox<String> sd_gen;
    public DatePicker sd_dob;  
    public MediaView mediaView;
    public MediaPlayer mediaPlayer;
    public TextField path,path2,filename,check;
    public TextField sd_an,sd_fn,sd_ln,sd_on,sd_soa,sd_coa,sd_fnum,sd_fnum2,sd_mnum,sd_mnum2;
    public TextArea sd_add;
    public TextField pd_ffn,pd_fln,pd_fon,pd_fem,pd_foc,pd_fadd;
    public TextField pd_mfn,pd_mln,pd_mon,pd_mem,pd_moc,pd_madd;
    public ImageView img_sd,img_pd,img_close;
    public TableView<record> tableview;
    public Text msg;
    public TableColumn col1,col2,col3,col4,col5,col6,col7,col8,col9,col10,col11,col12,col13,col14,col15,col16,col17,col18,col19,col20,col21,col22,col23,col24,col25;

    FileWriter fw;
    FileReader fr;
    BufferedWriter bw;
    BufferedReader br;
    
    String pathway=null,createdpath=null;
    String san = " ",sfn=" ",sln = " ",son = " ", sdob = " ", sgen = " " , scoa = " ", ssoa = " ", sfp1 = " ",sfp2 = " ",smp1 = " ",smp2 = " ",sadd = " ";
    String ffn = " ",fln = " ",fon = " ",fem = " ",focc = " ",fadd = " ";
    String mfn = " ",mln = " ",mon = " ",mem = " ",mocc = " ",madd = " ";
    String x,y,z;
    String hotkey,c1,c2,p1;
    int count = 0;
    
    @FXML
    private BorderPane borderpane;
    
    @FXML
    public void filechoosercreate(){
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Select folder to save file");
        
        Stage stage = (Stage)borderpane.getScene().getWindow();
        File file = dc.showDialog(stage);
        
        try{
        pathway = file.getPath();
        path.setText(pathway);
        createdpath = pathway+"\\"+filename.getText()+".csv";
            System.out.println(createdpath);
            bn_opennew.setDisable(false);
        }
        catch(Exception e){
            path.setText("");
        }
        
    }
    
    public void  play(){
        
        
        String path = new File("src/school/videos/vid.mp4").getAbsolutePath();
        
        Media media = new Media(new File(path).toURI().toString());
        System.out.println("url inserted");
        mediaPlayer = new MediaPlayer(media);
        System.out.println("Its playing");
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);
        
    }
    
    public void filechooser(){
        FileChooser fc = new FileChooser();
        fc.setTitle("Select Database file (.csv)");
        
        Stage stage = (Stage)borderpane.getScene().getWindow();
        File file = fc.showOpenDialog(stage);
        
        try{
        pathway = file.getPath();
        path2.setText(pathway);
        }
        catch(Exception e){
            path.setText("Empty");
          //  error();
        }
        
    }
    
    public void clear(){
        
        ap_sd.setVisible(false);
        ap_pd.setVisible(false);
        ap_front.setVisible(true);
        ap_rd.setVisible(false);
        button_sd.setStyle("-fx-background-color: #3D4956");
        button_pd.setStyle("-fx-background-color: #3D4956");
        btn_read.setStyle("-fx-background-color:  #3D4956");
        sd_an.clear();
        check.clear();
        sd_fn.clear();
        sd_ln.clear();
        sd_on.clear();
        sd_soa.clear();
        sd_coa.clear();
        sd_fnum.clear();
        sd_fnum2.clear();
        sd_mnum.clear();
        sd_mnum2.clear();
        sd_add.clear();
        pd_ffn.clear();
        pd_fln.clear();
        pd_fon.clear();
        pd_fem.clear();
        pd_foc.clear();
        pd_fadd.clear();
        pd_mfn.clear();
        pd_mln.clear();
        pd_mon.clear();
        pd_mem.clear();
        pd_moc.clear();
        pd_madd.clear();
        tableview.getItems().clear();
    }
    
    public void animate(){
        
    msg.setText("Contact developer @ (woroumishael@gmail.com)");
    
    KeyValue initKeyValue = new KeyValue(msg.translateXProperty(), 189);
    KeyFrame initFrame = new KeyFrame(Duration.ZERO, initKeyValue);

    KeyValue endKeyValue = new KeyValue(msg.translateXProperty(), -1.0
        * 189);
    KeyFrame endFrame = new KeyFrame(Duration.seconds(10), endKeyValue);

    Timeline timeline = new Timeline(initFrame, endFrame);

    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
    }
    
    public void createsF()throws Exception{
    try{
        
        fw = new FileWriter(createdpath);
        bw = new BufferedWriter(fw);
        
        System.out.println("File Created");
        bw.write("Admission Num , First Name , Last Name , Other Name , Date Of Birth , Gender , Session On Admission , Class On Admission , Father Phone1 , Father Phone2 , Mother Phone1 , Mother Phone2 , Address , Father FirstName , Father LastName , Father OtherName , Father Email , Father Occupation , Father Address , Mother FirstName , Mother LastName , Mother OtherName , Mother Email , Mother Occupation , Mother Address");
        bw.newLine();
        System.out.println("Fields Created");
        Prompt.display("Welldone", "You have successfully created the file");
        filename.clear();
        path.clear();
        }
        catch(FileNotFoundException fe){
        System.out.println(fe.getMessage());
        }
        finally
        {
            bw.close();
            fw.close();
        }
    
    }
       
    public void writeF()throws Exception{
        
        san = sd_an.getText();
        sfn = sd_fn.getText().toLowerCase();
        sln = sd_ln.getText().toLowerCase();
        son = sd_on.getText().toLowerCase();
        try{
            sdob = sd_dob.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }catch(Exception e){
                sdob = "";
         }
        sgen = sd_gen.getValue();
        scoa = sd_coa.getText().toLowerCase();
        ssoa = sd_soa.getText();
        sfp1 = sd_fnum.getText();
        sfp2 = sd_fnum2.getText();
        smp1 = sd_mnum.getText();
        smp2 = sd_mnum2.getText();
        sadd = sd_add.getText().toLowerCase();
        ffn = pd_ffn.getText().toLowerCase();
        fln = pd_fln.getText().toLowerCase();
        fon = pd_fon.getText().toLowerCase();
        fem = pd_fem.getText().toLowerCase();
        focc = pd_foc.getText().toLowerCase();
        fadd = pd_fadd.getText().toLowerCase();
        mfn = pd_mfn.getText().toLowerCase();
        mln = pd_mln.getText().toLowerCase();
        mon = pd_mon.getText().toLowerCase();
        mem = pd_mem.getText().toLowerCase();
        mocc = pd_moc.getText().toLowerCase();
        madd = pd_madd.getText().toLowerCase();
           
        x = san+" , "+sfn+" , "+sln+" , "+son+" , "+sdob+" , "+sgen+" , "+ssoa+" , "+scoa+" , "+sfp1+" , "+sfp2+" , "+smp1+" , "+smp2+" , "+sadd+" , ";
        y = ffn+" , "+fln+" , "+fon+" , "+fem+" , "+focc+" , "+fadd+" , ";        
        z = mfn+" , "+mln+" , "+mon+" , "+mem+" , "+mocc+" , "+madd;
        try{
        fw=new FileWriter(pathway,true);
        bw=new BufferedWriter(fw);
        
        bw.write(x+y+z);
        bw.newLine();
        System.out.println("file saved");
        Prompt.display("Welldone", "You have successfully added a new record to the database");
        
        }
        
        catch(Exception e)
        {
            error("Error","Submit failed\nCheck Path Again");
        }
        
        finally
        {
            bw.close();
            fw.close();
        
        }
    }
    
    public void buildCell(){
     col1.setCellValueFactory( new PropertyValueFactory("f1"));
     col2.setCellValueFactory( new PropertyValueFactory("f2"));
     col3.setCellValueFactory( new PropertyValueFactory("f3"));
     col4.setCellValueFactory( new PropertyValueFactory("f4"));
     col5.setCellValueFactory( new PropertyValueFactory("f5"));
     col6.setCellValueFactory( new PropertyValueFactory("f6"));
     col7.setCellValueFactory( new PropertyValueFactory("f7"));
     col8.setCellValueFactory( new PropertyValueFactory("f8"));
     col9.setCellValueFactory( new PropertyValueFactory("f9"));
     col10.setCellValueFactory( new PropertyValueFactory("f10"));
     col11.setCellValueFactory( new PropertyValueFactory("f11"));
     col12.setCellValueFactory( new PropertyValueFactory("f12"));
     col13.setCellValueFactory( new PropertyValueFactory("f13"));
     col14.setCellValueFactory( new PropertyValueFactory("f14"));
     col15.setCellValueFactory( new PropertyValueFactory("f15"));
     col16.setCellValueFactory( new PropertyValueFactory("f16"));
     col17.setCellValueFactory( new PropertyValueFactory("f17"));
     col18.setCellValueFactory( new PropertyValueFactory("f18"));
     col19.setCellValueFactory( new PropertyValueFactory("f19"));
     col20.setCellValueFactory( new PropertyValueFactory("f20"));
     col21.setCellValueFactory( new PropertyValueFactory("f21"));
     col22.setCellValueFactory( new PropertyValueFactory("f22"));
     col23.setCellValueFactory( new PropertyValueFactory("f23"));
     col24.setCellValueFactory( new PropertyValueFactory("f24"));
     col25.setCellValueFactory( new PropertyValueFactory("f25"));
     
    }
    
    public  void ret() throws Exception{
        System.out.println("readF clicked");
       
        String fieldDelimiter = " , ";
        BufferedReader br = new BufferedReader(new FileReader(pathway));
        
        hotkey = new String();
        hotkey = br.readLine();
        int rw = 0;
       while((hotkey = br.readLine()) != null){
               rw++;
              String field[] = hotkey.split(fieldDelimiter, -1);
              record rec = new record(field[0],field[1],field[2],field[3],field[4],field[5],field[6],field[7],field[8],field[9],field[10],field[11],field[12],field[13],field[14],field[15],field[16],field[17],field[18],field[19],field[20],field[21],field[22],field[23],field[24]);
              
              datalist.add(rec);
              
              System.out.println(hotkey);
              
        }
       Prompt.display("Successful", rw +" records found");
    }
    
    public  void readF() throws Exception{
        System.out.println("readF clicked");
       
        String fieldDelimiter = " , ";
        BufferedReader br = new BufferedReader(new FileReader(pathway));
        
    
        hotkey = new String();
        hotkey = br.readLine();
        String checks;
        checks = check.getText();
        c1 = checks.toUpperCase();
        c2 = checks.toLowerCase();
        int rw = 0;
        
       while((hotkey = br.readLine()) != null){
          
          if((hotkey.contains(c1) || hotkey.contains(c2))){

              String field[] = hotkey.split(fieldDelimiter, -1);
              record rec = new record(field[0],field[1],field[2],field[3],field[4],field[5],field[6],field[7],field[8],field[9],field[10],field[11],field[12],field[13],field[14],field[15],field[16],field[17],field[18],field[19],field[20],field[21],field[22],field[23],field[24]);
              
              datalist.add(rec);
              
              System.out.println(hotkey);
             
              rw++;
           }
        }
       
          Prompt.display("Successful", rw +" records found");
         
    }
    
    public void button_sd(){
         button_pd.setStyle("-fx-background-color:  #3D4956");
        btn_read.setStyle("-fx-background-color:  #3D4956");
         button_sd.setStyle("-fx-background-color:  #170546");
            ap_sd.setVisible(true);
            ap_front.setVisible(false);
            ap_pd.setVisible(false);
            ap_rd.setVisible(false);
    }
    
    public void button_pd(){
        button_pd.setStyle("-fx-background-color:  #170546");
        btn_read.setStyle("-fx-background-color:  #3D4956");
            button_sd.setStyle("-fx-background-color:  #3D4956");
            ap_sd.setVisible(false);
            ap_front.setVisible(false);
            ap_pd.setVisible(true);
            ap_rd.setVisible(false);
   
    }
    
    public void btn_read(){
        btn_read.setStyle("-fx-background-color:  #170546");
            button_sd.setStyle("-fx-background-color:  #3D4956");
            button_pd.setStyle("-fx-background-color:  #3D4956");
            ap_sd.setVisible(false);
            ap_front.setVisible(false);
            ap_pd.setVisible(false);
            ap_rd.setVisible(true);
    }
    
    public void submitcheck(){
        Boolean answer = Confirm.display("CONFIRM!","Are you sure you want to submit");
            if (answer){
                System.out.println("You clicked yes and so you can writeF");
                
                try{
                    writeF();
                    }catch(Exception e){
                        e.getMessage();
                    }
            }
            else{
                error("Done","Records Were NOT Sent");
                System.out.println("NOPE");
            }
    }

    public void initialize(){
      
        path.setText(null);
        
        button_sd.setOnAction(e->{
           button_sd();
        });
        
        button_pd.setOnAction(e->{
            button_pd();
        });
        
        btn_read.setOnAction(e->{
            btn_read();
        });
        
        
        sd_gen.setItems(gender);
        buildCell();
        tableview.setItems(datalist);
        animate();
        
   }
    
    @FXML
    private void handleButtonAction(MouseEvent event) {
        if (event.getTarget()== img_sd){
            button_sd();
        }
        else if(event.getTarget()== img_pd){
            button_pd();
        }
        else if(event.getTarget()== img_close){
            clear();
        }
        
    }
      
    
    public void error(String title,String message){
       
        
       Stage window = new Stage();
       window.initModality(Modality.APPLICATION_MODAL);
       
       window.setTitle(title);
       window.setWidth(300);
       window.setResizable(false);
       Label label = new Label();
       label.setText(message);
       label.setStyle("-fx-text-fill: #000000");
       
       VBox layout = new VBox(20);
       layout.setPadding(new Insets(10,10,10,10));
       layout.getChildren().addAll(label);
       layout.setStyle("-fx-background-color: #FFFFFF");
       layout.setAlignment(Pos.CENTER);
       
       Scene scene = new Scene(layout);
       window.setScene(scene);
       window.getIcons().add(new Image(SCHOOL.class.getResourceAsStream("images/error.png")));
       window.showAndWait();
       
    } 
        
    public void Login(){
       
       Stage window = new Stage();
       window.initModality(Modality.APPLICATION_MODAL);
       
       window.setTitle("LOGIN");
       window.setWidth(250);
       window.setResizable(false);
       Label label = new Label();
       PasswordField p1 = new PasswordField();
       p1.setPromptText("Your Password");
       Button b1 = new Button("Login");
       b1.setStyle("-fx-background-color: #3D4956;"+"-fx-text-fill: #ffffff");
       label.setText("Enter Password");
       label.setStyle("-fx-text-fill: #3D4956");
       String pass = p1.getText();
       String p = "password";
       b1.setOnAction((ActionEvent e)->{
           System.out.println(pass);
           if(p1.getText().equals(p)){
               window.close();   
               Prompt.display("OK", "Login Successful");
               Open();
               play();
               log.setVisible(false);
           }
           else{
                    
                    error("Error","Wrong Password Try Again");
                   
                    
           }
           p1.clear();
       });
       
       VBox layout = new VBox(20);
       layout.setPadding(new Insets(10,10,10,10));
       layout.getChildren().addAll(label,p1,b1);
       layout.setStyle("-fx-background-color: #FFFFFF");
       layout.setAlignment(Pos.CENTER);
       
       Scene scene = new Scene(layout);
       window.setScene(scene);
       window.getIcons().add(new Image(SCHOOL.class.getResourceAsStream("images/lock.png")));
       window.showAndWait();
    } 

    public void Open(){
            s2.setVisible(true);
            s3.setVisible(true);
            s4.setVisible(true);
        }
    
    public class record{
        private SimpleStringProperty f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25;

        public String getF1() {
            return f1.get();
        }
        public String getF2() {
            return f2.get();
        }
        public String getF3() {
            return f3.get();
        }
        public String getF4() {
            return f4.get();
        }
        public String getF5() {
            return f5.get();
        }
        public String getF6() {
            return f6.get();
        }
        public String getF7() {
            return f7.get();
        }
        public String getF8() {
            return f8.get();
        }
        public String getF9() {
            return f9.get();
        }
        public String getF10() {
            return f10.get();
        }
        public String getF11() {
            return f11.get();
        }
        public String getF12() {
            return f12.get();
        }
        public String getF13() {
            return f13.get();
        }
        public String getF14() {
            return f14.get();
        }
        public String getF15() {
            return f15.get();
        }
        public String getF16() {
            return f16.get();
        }
        public String getF17() {
            return f17.get();
        }
        public String getF18() {
            return f18.get();
        }
        public String getF19() {
            return f19.get();
        }
        public String getF20() {
            return f20.get();
        }
        public String getF21() {
            return f21.get();
        }
        public String getF22() {
            return f22.get();
        }
        public String getF23() {
            return f23.get();
        }
        public String getF24() {
            return f24.get();
        }
        public String getF25() {
            return f25.get();
        }

        record(String f1,String f2,String f3,String f4,String f5,String f6,String f7,String f8,String f9,String f10,String f11,String f12,String f13,String f14,String f15,String f16,String f17,String f18,String f19,String f20,String f21,String f22,String f23,String f24,String f25){
        
            this.f1 = new SimpleStringProperty(f1);
            this.f2 = new SimpleStringProperty(f2);
            this.f3 = new SimpleStringProperty(f3);
            this.f4 = new SimpleStringProperty(f4);
            this.f5 = new SimpleStringProperty(f5);
            this.f6 = new SimpleStringProperty(f6);
            this.f7 = new SimpleStringProperty(f7);
            this.f8 = new SimpleStringProperty(f8);
            this.f9 = new SimpleStringProperty(f9);
            this.f10 = new SimpleStringProperty(f10);
            this.f11= new SimpleStringProperty(f11);
            this.f12 = new SimpleStringProperty(f12);
            this.f13 = new SimpleStringProperty(f13);
            this.f14 = new SimpleStringProperty(f14);
            this.f15 = new SimpleStringProperty(f15);
            this.f16 = new SimpleStringProperty(f16);
            this.f17 = new SimpleStringProperty(f17);
            this.f18 = new SimpleStringProperty(f18);
            this.f19 = new SimpleStringProperty(f19);
            this.f20 = new SimpleStringProperty(f20);
            this.f21 = new SimpleStringProperty(f21);
            this.f22 = new SimpleStringProperty(f22);
            this.f23 = new SimpleStringProperty(f23);
            this.f24 = new SimpleStringProperty(f24);
            this.f25 = new SimpleStringProperty(f25);
        }
    }
    
    private final ObservableList<record> datalist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initialize();
        Login();
        log.setOnAction(e-> Login());
        
        ContextMenu cm = new ContextMenu();
                MenuItem m1 = new MenuItem("Copy record (text)");
                cm.getItems().add(m1);
                MenuItem m2 = new MenuItem("Copy record (table)");
                cm.getItems().add(m2);
                 
         tableview.setOnMouseClicked((MouseEvent event) ->{
            if(event.getButton().equals(MouseButton.SECONDARY)){
                cm.show(tableview, event.getScreenX(),event.getScreenY());
            }
            m1.setOnAction(e->{
                int index = tableview.getSelectionModel().getSelectedIndex();
                record rec = tableview.getItems().get(index);
                String myString = "Admission Number: "+rec.getF1()+"\n"+"First Name: "+rec.getF2()+"\n"+"Last Name: "+rec.getF3()+"\n"+"Other Name: "+rec.getF4()+"\n"+"Date Of Birth: "+rec.getF5()+"\n"+"Gender: "+rec.getF6()+"\n"+"Session On Admission: "+rec.getF7()+"\n"+"Class On Admission: "+rec.getF8()+"\n"+"Father's Phone1: "+rec.getF9()+"\n"+"Father's Phone2: "+rec.getF10()+"\n"+"Mother's Phone1: "+rec.getF11()+"\n"+"Mothe's Phone2: "+rec.getF12()+"\n"+"House Address: "+rec.getF13()+"\n"+"Father's First Name: "+rec.getF14()+"\n"+"Father's Last Name: "+rec.getF15()+"\n"+"Father's Other Name: "+rec.getF16()+"\n"+"Father's Email: "+rec.getF17()+"\n"+"Father's Occupation: "+rec.getF18()+"\n"+"Father's Address: "+rec.getF19()+"\n"+"Mother's First Name: "+rec.getF20()+"\n"+"Mother's Last Name: "+rec.getF21()+"\n"+"Mother's Other Name: "+rec.getF22()+"\n"+"Mother's Email: "+rec.getF23()+"\n"+"Mother's Occupation: "+rec.getF24()+"\n"+"Mother's Address: "+rec.getF25();
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipBoard.setContents(stringSelection, null);
                Prompt.display("COPIED!", "Record has been copied");
                });
            
            m2.setOnAction(e->{
                    int index = tableview.getSelectionModel().getSelectedIndex();
                record rec = tableview.getItems().get(index);
                String myString = rec.getF1()+","+rec.getF2()+","+rec.getF3()+","+rec.getF4()+","+rec.getF5()+","+rec.getF6()+","+rec.getF7()+","+rec.getF8()+","+rec.getF9()+","+rec.getF10()+","+rec.getF11()+","+rec.getF12()+","+rec.getF13()+","+rec.getF14()+","+rec.getF15()+","+rec.getF16()+","+rec.getF17()+","+rec.getF18()+","+rec.getF19()+","+rec.getF20()+","+rec.getF21()+","+rec.getF22()+","+rec.getF23()+","+rec.getF24()+","+rec.getF25();
                myString.split(",", -1);
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipBoard.setContents(stringSelection, null);
                Prompt.display("COPIED!", "Record has been copied for table");
                });
        });
         
    }    
    
      
}
