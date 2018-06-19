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
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

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
    private AnchorPane ap_Name;
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
    }
    
    @FXML
    public void actionBtExport (ActionEvent event) throws IOException{
        FileWriter fw = null;
        try {    
            File exportTxt = new File ("BlockLog.txt");
            fw = new FileWriter(exportTxt);
            fw.write(ta_Message.getText());
            System.out.println(ta_Message.getText());
        }
        catch (IOException e){
            System.out.println(e);
        } 
        finally {
            if (fw != null){
                fw.close();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
}
