package com.example.login;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    Stage window ;
    Stage ss;
    double h,r,ot=0,da,gross,tax,net,pension;
    public static TextField tname, tadr, tid,tdp,thw,thr,tday,totime;
            TextArea ta;
    String snet,sname;
    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        Label wel = new Label("welcome");
        wel.setLayoutX(120);
        wel.setLayoutY(20);
        wel.setFont(Font.font(30));
         Label userl = new Label("username:");
           userl.setLayoutX(30);
           userl.setLayoutY(100);
           userl.setFont(Font.font(20));
        TextField usert = new TextField();
        usert.setLayoutX(140);
        usert.setLayoutY(100);
        Label passl = new Label("password:");
        passl.setLayoutX(30);
        passl.setLayoutY(150);
        passl.setFont(Font.font(20));
        PasswordField passt = new PasswordField();
        passt.setLayoutX(140);
        passt.setLayoutY(150);
        Button b = new Button("Login");
        b.setLayoutX(150);
        b.setLayoutY(200);
        b.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        passt.setStyle("-fx-font:normal bold 20px 'serif'");
        usert.setStyle("-fx-font:normal bold 20px 'serif'");
        b.setOnAction(e ->
        {
            ConnectionDB connectionDB=new ConnectionDB();
            Connection cn =  connectionDB.conMethod();
            Statement pt;
            ResultSet r;
            String uname = usert.getText();
            String password = passt.getText();

         String  value = "select * from LOGIN where username = '"+uname+"'and password='"+password+"'";

         try {
             pt = cn.createStatement();
             r = pt.executeQuery(value);
             try {
                 if(r.next()){
                     Dagim();
                     window.close();
                 }
             } catch (SQLException ex) {
                 throw new RuntimeException(ex);
             }

         } catch (SQLException ex) {
             throw new RuntimeException(ex);
         }

        });
        Group gu = new Group();
        gu.getChildren().addAll(wel,userl,usert,passl,passt,b);
           Scene s1 = new Scene(gu,500,400,Color.GRAY);

        window.setScene(s1);

        window.setTitle("Login");
        window.show();

        }
    public  void Dagim() {
        ss = new Stage();
        Text tt = new Text("  Employee Payroll System  ");
        tt.setFont(Font.font(40));
        HBox hb = new HBox();
        hb.setBackground(Background.fill(Color.WHEAT));
        hb.setLayoutX(250);
        hb.setLayoutY(10);
        hb.getChildren().addAll(tt);
      GridPane gp = new GridPane();
      gp.setLayoutY(150);
      gp.setLayoutX(20);
      Label name = new Label("name:");
      name.setFont(Font.font(30));

       tname = new TextField();
        tname.setStyle("-fx-font:normal bold 15px 'serif'");
      Label adr = new Label("  addres:");
        adr.setFont(Font.font(30));
      tadr = new TextField();
        tadr.setStyle("-fx-font:normal bold 15px 'serif'");
        Label id = new Label("ID number:");
        id.setFont(Font.font(30));
        tid = new TextField();
        tid.setStyle("-fx-font:normal bold 15px 'serif'");
        Label dp = new Label("  department:");
        dp.setFont(Font.font(30));
         tdp = new TextField();
        tdp.setStyle("-fx-font:normal bold 15px 'serif'");
        Label hw = new Label("Hours worked:");
        hw.setFont(Font.font(30));
         thw = new TextField();
        thw.setStyle("-fx-font:normal bold 15px 'serif'");
        Label hr = new Label("  Hourly Rate:");
        hr.setFont(Font.font(30));
        thr = new TextField();
        thr.setStyle("-fx-font:normal bold 15px 'serif'");
        Label day = new Label("days per Mo:");
        day.setFont(Font.font(30));
        tday = new TextField();
        tday.setStyle("-fx-font:normal bold 15px 'serif'");
        Label otime = new Label("  over time:");
        otime.setFont(Font.font(30));
         totime = new TextField();
        totime.setStyle("-fx-font:normal bold 15px 'serif'");
      gp.add(name,0,0);
        gp.add(tname,1,0);
        gp.add(adr,2,0);
        gp.add(tadr,3,0);
        gp.add(id,0,1);
        gp.add(tid,1,1);
        gp.add(dp,2,1);
        gp.add(tdp,3,1);
        gp.add(hw,0,2);
        gp.add(thw,1,2);
        gp.add(hr,2,2);
        gp.add(thr,3,2);
        gp.add(day,0,3);
        gp.add(tday,1,3);
        gp.add(otime,2,3);
        gp.add(totime,3,3);
        TextArea ta = new TextArea();
        ta.setLayoutX(930);
        ta.setLayoutY(120);
        ta.setPrefWidth(250);
        ta.setPrefHeight(350);
        ta.setFont(Font.font("Arial",20));
       // ta.setText();


        Button bb1 = new Button("save");
        bb1.setLayoutX(60);
        bb1.setLayoutY(500);
        bb1.setPrefWidth(120);
        bb1.setPrefHeight(50);
        bb1.setFont(Font.font(20));
        bb1.setBackground(Background.fill(Color.WHEAT));
        Button bb2 = new Button("view payslip");
        bb2.setLayoutX(200);
        bb2.setLayoutY(500);
        bb2.setPrefWidth(150);
        bb2.setPrefHeight(50);
        bb2.setFont(Font.font(20));
        bb2.setBackground(Background.fill(Color.WHEAT));
        Button bb3 = new Button("delete");
        bb3.setLayoutX(370);
        bb3.setLayoutY(500);
        bb3.setPrefWidth(180);
        bb3.setPrefHeight(50);
        bb3.setFont(Font.font(20));
        bb3.setBackground(Background.fill(Color.WHEAT));
        bb3.setOnAction(e->{
            bilen();
        });
        Button bb4 = new Button("Exit system");
        bb4.setLayoutX(570);
        bb4.setLayoutY(500);
        bb4.setPrefWidth(180);
        bb4.setPrefHeight(50);
        bb4.setFont(Font.font(20));
        bb4.setBackground(Background.fill(Color.WHEAT));

        //gp.setBackground(Background.fill(Color.AQUA));
        bb4.setOnAction(e ->{
            window.show();
            ss.close();
        });
        Group root= new Group();
        root.getChildren().addAll(hb,gp,ta,bb1,bb2,bb3,bb4);
        Scene s2 = new Scene(root,1200,600, Color.GRAY);
        bb1.setOnAction(new Controller(tname,tid,tdp,tadr,thw,thr,totime,tday));
        bb2.setOnAction(e ->
        {
            sname = tname.getText();
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
            snet = Double.toString(net);
           String stax = Double.toString(tax);
            String spension = Double.toString(pension);
            String sgross = Double.toString(gross);
            String xx1 = "\n\n"+"Name :    "+sname+"\n";
            String xx2 = "gross salary :  "+sgross+"\n";
            String xx3 = "Tax :    "+stax+"\n";
            String xx4 = "pension :   "+spension+"\n";
           String xx5 = "net :      "+snet;
            ta.setText(xx1+xx2+xx3+xx4+xx5);


        });
        ss.setScene(s2);
        ss.show();

    }
    public void bilen(){
        ss.close();
        Stage dstage = new Stage();
        Label dl = new Label("Enter Name:");
        dl.setLayoutX(20);
        dl.setLayoutY(20);
        dl.setFont(Font.font(20));
        TextField dt = new TextField();
        dt.setLayoutX(150);
        dt.setLayoutY(20);
        Button db = new Button("Delete");
        db.setLayoutX(150);
        db.setLayoutY(100);
        Button db1 = new Button("exit");
        db1.setLayoutX(250);
        db1.setLayoutY(100);
        db1.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        db.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        db1.setOnAction(e->
        {
            ss.show();
            dstage.close();

        });
        db.setOnAction(e->
        {
           String ds = dt.getText();
            Statement sts = null;
            try {
                String query = "DELETE FROM DBTABLE WHERE NAME='" +ds+ "'";
                ConnectionDB connectionDB = new ConnectionDB();
                Connection c = connectionDB.conMethod();
                sts = c.createStatement();
                sts.execute(query);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        Group dg = new Group();
        dg.getChildren().addAll(dl,dt,db,db1);
        Scene ds = new Scene(dg,400,200,Color.GRAY);
        dstage.setScene(ds);
        dstage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}