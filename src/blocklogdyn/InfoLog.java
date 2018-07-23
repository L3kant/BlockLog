/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocklogdyn;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

/**
 *
 * @author stanislav_vo
 */
public class InfoLog {
    

    static boolean answer;
        
    public static boolean info_YesNo (String title, String message){
               
        Button bt_Yes = new Button("Ano");
        Button bt_No = new Button("Ne");
        Label lb_Text = new Label(message);
        
        Insets insets = new Insets(20,20,5,20);
        
        Stage st_Info = new Stage ();
        
        StackPane sp_Info1 = new StackPane();
        sp_Info1.getChildren().add(lb_Text);
        
        bt_Yes.setOnAction(e -> {
            answer = true;
            st_Info.close();
        });
        bt_No.setOnAction(e -> {
            answer = false;
            st_Info.close();
        });
        st_Info.setOnCloseRequest(e -> answer = false);
        
        HBox hb_Info1 = new HBox(10);
        hb_Info1.setPadding(insets);
        hb_Info1.getChildren().addAll(bt_Yes,bt_No);
        hb_Info1.alignmentProperty().set(Pos.BASELINE_CENTER);
        
        VBox vb_Info1 = new VBox(10);
        vb_Info1.setPadding(insets);
        vb_Info1.getChildren().addAll(sp_Info1,hb_Info1);
        
        Scene sc_Info = new Scene(vb_Info1,250,100);
        
        st_Info.setScene(sc_Info);
        st_Info.setTitle(title);
        st_Info.setAlwaysOnTop(true);
        st_Info.showAndWait();
       
        return answer;
    }

    public static void input_Message (String title) {
        
        Button bt_Done = new Button("Hotovo");
        Label lb_Name = new Label("Jméno:");
        Label lb_Pass = new Label("Heslo:");
        Label lb_Message = new Label("Zpráva:");
        TextField tf_Name = new TextField();
        TextField tf_Pass = new TextField();
        TextField tf_Message = new TextField();

        
        VBox vb_Input = new VBox(10);
        vb_Input.setPadding(new Insets(20,20,20,20));
        vb_Input.getChildren().addAll(lb_Name,tf_Name,lb_Pass,tf_Pass,lb_Message,tf_Message,bt_Done);
        Scene sc_Input = new Scene(vb_Input,300,300);
        Stage st_Input = new Stage();
        st_Input.setScene(sc_Input);
        st_Input.setTitle(title);
        st_Input.showAndWait();
       
    }
}
