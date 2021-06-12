
package scadjuster;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.util.*;
import javafx.animation.*;
import javafx.scene.image.*;

import java.io.*;
import javafx.scene.paint.Color;

/**
 * @author Seumx Plus
 */

public class SCAdjuster extends Application {
    
    private double xoff,yoff;
    
    public String texd="-fx-font:normal 19px 'monospaced'; -fx-accent:darkslategrey; -fx-focus-faint-color:darkslategrey;"
                + "-fx-focus-color:darkslategrey; -fx-border-radius:0px 13px 0px 13px; "
            + "-fx-background-radius:0px 25px 0px 25px; -fx-border-width:5px; -fx-border-color:slategrey;"
            + "-fx-control-inner-background:lightgrey;",
            texh="-fx-font:normal 19px 'monospaced'; -fx-accent:darkslategrey; -fx-focus-faint-color:darkslategrey;"
                + "-fx-focus-color:darkslategrey; -fx-border-radius:0px 13px 0px 13px;"
            + "-fx-background-radius:0px 25px 0px 25px; -fx-border-width:5px; -fx-border-color:grey;"
            + "-fx-control-inner-background:lightgrey;";
    
    public String def="-fx-background-color:darkslategrey; -fx-font:normal 23px 'Cambria'; -fx-text-fill:white;"
            + "-fx-border-width:11px; -fx-border-color:lightgrey; -fx-border-radius:0px 21px 0px 21px;",
            hover="-fx-background-color:black; -fx-font:normal 23px 'Cambria'; -fx-text-fill:white;"
            + "-fx-border-width:11px; -fx-border-color:whitesmoke; -fx-border-radius:0px 21px 0px 21px;";
    
    private final String bg1="-fx-background-color:darkslategrey;-fx-background-radius:31px 0px 31px 0px";
    
    @Override
    public void init() throws Exception {
        
        System.out.println("Starting application...");
        /*
        String hy=new Action().makeNEQ("How are you?\nWhata your name$");
        System.out.println(hy+"\n"+new Action().makeNOQ(hy));
        */
    }
    
    @Override
    public void start(Stage Stage) throws Exception {
        
        Image icon=new Image(new FileInputStream("smx.png"));
        
        //starting animation
        Stage.initStyle(StageStyle.TRANSPARENT); Stage.setWidth(718); Stage.setHeight(471); Stage.setResizable(false); 
        Stage.setTitle("Adjustor"); Stage.getIcons().addAll(icon);
        
        Label l=new Label("Code\nAdjustor");
        l.setStyle("-fx-font:bold 37px 'COPPERPLATE GOTHIC BOLD'; -fx-text-fill:azure");
        Label l2=new Label("v1.0.3 : Premium");
        l2.setStyle("-fx-font:bold 21px 'COPPERPLATE GOTHIC BOLD'; -fx-text-fill:azure");
        
        ImageView vw2=new ImageView(icon);
        vw2.setFitWidth(153); vw2.setFitHeight(153);
        
        com.gluonhq.charm.glisten.animation.FlipInXTransition bin2=
                new com.gluonhq.charm.glisten.animation.FlipInXTransition(vw2,true,Duration.millis(15000));
        bin2.setAutoReverse(true); bin2.setCycleCount(4); bin2.setRate(7.1); bin2.play();
        
        GridPane g=new GridPane(); g.setPadding(new Insets(0,0,0,0)); g.setVgap(0); g.setHgap(0); g.setStyle(bg1);
        g.setAlignment(Pos.CENTER); g.add(vw2,0,0); g.add(l,1,0); g.add(l2,1,1);
        
        smx.jfx.layout.Dialog pre=new smx.jfx.layout.Dialog(null, false, false, 413, 217, new Scene(g), "", 
                icon);  pre.initStyle(StageStyle.TRANSPARENT);
        pre.show();
        
        bin2.setOnFinished(ev->{
            if(pre.isShowing()) {
                bin2.play();
            }
        });
        
        FadeTransition fd=new FadeTransition(Duration.millis(7000)); fd.setAutoReverse(false); fd.setCycleCount(1);
        fd.setFromValue(0); fd.setToValue(1); fd.setNode(g); fd.play();
        
        //main window
        ImageView vw=new ImageView(icon);
        vw.setFitWidth(37); vw.setFitHeight(37);
        
        com.gluonhq.charm.glisten.animation.FlipInXTransition bin=
                new com.gluonhq.charm.glisten.animation.FlipInXTransition(vw,true,Duration.millis(15000));
        bin.setAutoReverse(true); bin.setCycleCount(2); bin.setRate(2.7); bin.play();
        /*
        com.gluonhq.charm.glisten.animation.TadaTransition fls=
                new com.gluonhq.charm.glisten.animation.TadaTransition(vw, Duration.millis(9000));
        fls.setAutoReverse(false); fls.setCycleCount(2); fls.setRate(2.7); fls.play();
        */
        bin.setOnFinished(ev->{
            bin.play();
        });
        
        Label hy=new Label("CODE ADJUSTOR");
        hy.setStyle("-fx-font:bold 27px 'COPPERPLATE GOTHIC BOLD'; -fx-text-fill:azure");
        
        Label p=new Label("VERSION: 1.0.1\n\nRELEASE DATE: 18/9/2019\n\nCOMPANY: Seumx Plus\n\nDEVELOPER: Muwanguzi Silas\n\n"
                + "MAIL: Silas.seal7@gmail.com\n\nPHONE: 256 704029977");
        p.setStyle("-fx-text-fill:azure; -fx-font:bold 17px 'Cambria'");
        
        smx.jfx.control.Button close=new smx.jfx.control.Button("X"); 
        close.setDefaultStyle("-fx-background-color:darkslategrey; -fx-font:normal 18px 'Cambria'; -fx-text-fill:azure;");
        close.setHoverStyle("-fx-background-color:slategrey; -fx-font:normal 18px 'Cambria'; -fx-text-fill:azure;");
        
        //top
        BorderPane u=new BorderPane(); u.setPadding(new Insets(0,0,0,0)); u.setStyle(bg1);
        u.setLeft(vw); u.setCenter(hy); u.setRight(close);
        
        //center
        Form form=new Form(Stage);
        
        scadjuster.VBox t=new scadjuster.VBox(); t.setPadding(new Insets(9,9,9,9)); //t.setVgap(8); t.setHgap(8);
        t.setStyle(bg1); t.setAlignment(Pos.TOP_CENTER); t.addS(form);
        
        //bottom
        Label lso=new Label("© Seumx Plus 2021. All Rights Reserved.");
        lso.setStyle("-fx-font: normal 18px 'Cambria'; -fx-text-fill:white");
        
        GridPane j=new GridPane(); j.setPadding(new Insets(0,0,0,0)); j.setVgap(0); j.setHgap(0);
        j.setStyle(bg1); j.setAlignment(Pos.TOP_CENTER); j.add(lso,0,0);
        
        //full
        BorderPane n=new BorderPane(); n.setPadding(new Insets(3,3,3,3)); n.setStyle(bg1);
        n.setTop(u); n.setBottom(j);
        
        Scene sc=new Scene(n); sc.setFill(Color.TRANSPARENT); Stage.setScene(sc);
        
        n.setOnMousePressed(ev->{
            xoff=ev.getSceneX(); yoff=ev.getSceneY();
        });
        
        n.setOnMouseDragged(ev->{
            Stage.setX(ev.getScreenX() - xoff); Stage.setY(ev.getScreenY() - yoff);
        });
        
        fd.setOnFinished(ev->{
            pre.close(); Stage.show(); 
            
            FadeTransition fd4=new FadeTransition(Duration.millis(300)); fd4.setAutoReverse(false); 
            fd4.setCycleCount(1);
        fd4.setFromValue(0); fd4.setToValue(1); fd4.setNode(t); fd4.play();
        
        fd4.setOnFinished(we->{
            n.setCenter(t);
        });
        
        });
        
        //respe actions
        close.setOnAction(io->{
            Stage.close();
        });
        
    }
    
    @Override
    public void stop() {
        
        System.out.println("Here We Go!\nQuiting...");
        
    }
    
    /**
     * This Ignores UNS
     * @param str
     * @return 
     */
    public String IgnoreDS(String str)
    {
        String rtn="";
        
        char[] ch=str.toCharArray();
        int i=0,j=1;
        
        while(j<ch.length)
        {
            if(ch[i]=='\\' && ch[j]=='\\') {
                rtn+="\\"; i+=2; j+=2;
            } else if(ch[i]=='\\' && ch[j]=='$') {
                rtn+="$"; i+=2; j+=2;
            }
            else {
                rtn+=ch[i]; i++; j++;
            }
            
        }
        
        return rtn;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
