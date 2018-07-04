/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocklogdyn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author stanislav_vo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private MenuItem mi_Start;
    @FXML
    private MenuItem mi_UserReport;
    @FXML
    private MenuItem mi_MessTerm;
    @FXML
    private MenuItem mi_MessSMS;
    @FXML
    private Button bt_Supplier;
    @FXML
    private Button bt_End;
    @FXML
    private Button bt_Export;
    @FXML
    private Button bt_TimeStamp;
    @FXML
    private TextArea ta_Message;
    @FXML
    private Label lb_Time;
    @FXML
    private Label lb_Name;
    @FXML
    private SplitMenuButton smb_Start;
    @FXML
    private SplitMenuButton smb_Report;
    
    /**
     *
     * @param event
     */

    @FXML
    public void actionBt (ActionEvent event){
        String type = String.valueOf(event.getSource());
        ta_Message.appendText(Message.message(type));
        ta_Message.requestFocus();
    }
    
    @FXML
    public void actionBtExport (ActionEvent event) throws IOException{
        FileWriter fw = null;
                
        StackPane sp = new StackPane();
        Scene sc = new Scene(sp);
        Stage st = new Stage();
        st.setScene(sc);
        
        FileChooser filePicker = new FileChooser();
        filePicker.getExtensionFilters().add(new FileChooser.ExtensionFilter("text file", "*.txt"));
        File selectedFile = filePicker.showSaveDialog(st);
        
        if (selectedFile != null){
            try {    
                fw = new FileWriter(selectedFile);
                fw.write(ta_Message.getText());
            }
            catch (IOException e){
                System.out.println(e);
            } 
            finally {
                if (fw != null){
                    fw.close();
                }
            }
            if (InfoLog.info_YesNo ("InfoLog", "Vyčistit pole pro logování?\n\n")){
                ta_Message.setText("");
                ta_Message.requestFocus();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }      
}
