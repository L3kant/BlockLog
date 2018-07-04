/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocklogdyn;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

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
        
        Stage st_Info1 = new Stage ();
        
        StackPane sp_Info1 = new StackPane();
        sp_Info1.getChildren().add(lb_Text);
        
        bt_Yes.setOnAction(e -> {
            answer = true;
            st_Info1.close();
        });
        bt_No.setOnAction(e -> {
            answer = false;
            st_Info1.close();
        });
        st_Info1.setOnCloseRequest(e -> answer = false);
        
        HBox hb_Info1 = new HBox();
        hb_Info1.getChildren().addAll(bt_Yes,bt_No);
        hb_Info1.alignmentProperty().set(Pos.BASELINE_CENTER);
        
        VBox vb_Info1 = new VBox();
        vb_Info1.getChildren().addAll(sp_Info1,hb_Info1);
        
        Scene sc_Info1 = new Scene(vb_Info1,250,100);
        
        st_Info1.setScene(sc_Info1);
        st_Info1.setTitle(title);
        st_Info1.setAlwaysOnTop(true);
        st_Info1.showAndWait();
       
        return answer;
    }    
}
