/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocklogdyn;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author stanislav_vo
 */
public class Message {
    
    public static String message(String type) {
        String zprava;
        String type2 = "";
        if (null != type)switch (type) {
            case "MenuItem[id=mi_Start, styleClass=[menu-item]]":
                type2 = "Start - IT";
                break;
            case "MenuItem[id=mi_UserReport, styleClass=[menu-item]]":
                type2 = "Start - Uživatel";
                break;
            case "MenuItem[id=mi_MessTerm, styleClass=[menu-item]]":
                type2 = "Zpráva odeslnána na terminály";
                break;
            case "MenuItem[id=mi_MessSMS, styleClass=[menu-item]]":
                type2 = "Zpráva odeslnána SMS";
                break;   
            case "Button[id=bt_Supplier, styleClass=button]'Dodavatel'":
                type2 = "Předáno dodavateli";
                break;
            case "Button[id=bt_End, styleClass=button]'Konec'":
                type2 = "Blokování vyřešeno";
                break;
            case "Button[id=bt_TimeStamp, styleClass=button]'TimeStamp'":
                type2 = " ";
                break;                  
            default:
                break;
        }
        zprava = (LocalDate.now() + " " + LocalTime.now() + " " + type2 + "\n");
        return zprava;
    }
    
    
}
