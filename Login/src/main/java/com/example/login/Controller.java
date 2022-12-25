package com.example.login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Statement;

public class Controller implements EventHandler<ActionEvent> {
    String str1,str2,str3,str4 ,str5,str6= null;
    String snet,sname,spension,stax,sgross;
    TextField lname,lid,ladr,ldp,thw,thr,totime,tday;

    TextArea ta;
    Alert al = new Alert(Alert.AlertType.INFORMATION);

    double h,r,ot=0,da,gross,tax,net,pension;
    Controller(TextField lname, TextField lid, TextField ldp, TextField ladr, TextField thw, TextField thr, TextField totime, TextField tday) {

        this.lname= lname;
          this.lid = lid;
           this.ldp = ldp;
           this.ladr = ladr;
            this.tday = tday;
            this.thw = thw;
            this.thr = thr;
           this.totime = totime;
             // this.ta = ta;

        ConnectionDB connectionDB=new ConnectionDB();
        connectionDB.conMethod();

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        str1 = lname.getText();
        str2 = ldp.getText();
        r = Double.parseDouble(thr.getText());
        h = Double.parseDouble(thw.getText());
        ot = Double.parseDouble(totime.getText());
        da = Double.parseDouble(tday.getText());
        gross = h*r*da;
        gross = gross+(ot*r);
      if(gross<=650){
          tax = 0;
         }
      else if (gross<=1650 && gross>650) {
          tax = ((gross*10)/100)-60;
      }
      else if (gross<=3200 && gross>1650) {
          tax = ((gross*15)/100)-142.5;
      }
      else if (gross<=5200 && gross>3200) {
          tax = ((gross*20)/100)-302.5;
      }
      else if (gross<=7800 && gross>5200) {
          tax = ((gross*25)/100)-565;
      } else if (gross<=10900 && gross>7800) {
          tax =((gross*30)/100)-955;
      } else if (gross>10900) {
          tax =((gross*35)/100)-1500;
      }
      pension = gross*0.07;
      net = gross-(tax+pension);
         str6 = Double.toString(net);
         str5 = Double.toString(pension);
         str4 = Double.toString(tax);
        str3 = Double.toString(gross);
        queryHandler();
    }
    private void queryHandler() {
        try {
            String query = "Insert into dbtable(name,department,gross_salary,Tax,pension,net) VALUES('" + str1 + "','" + str2 + "','"+str3+"','"+str4+"','"+str5+"','"+str6+"')";
            ConnectionDB db = new ConnectionDB();
            Connection connection = db.conMethod();
            Statement statement = connection.createStatement();
            boolean status = statement.execute(query);
            if (!status) {
                al.setContentText("successfuly inserted");
                al.showAndWait();
            } else {
                al.setContentText("Not successfuly inserted");
                al.showAndWait();
            }

        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }
}