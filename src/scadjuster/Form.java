/*
 * The form for collection then forward for execution!
 */
package scadjuster;

/**
 *
 * @author Seumx Plus
 */

import smx.jfx.control.*;
import smx.jfx.layout.*;
import javafx.geometry.*;
//import javafx.collections.*;
import java.util.*;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
//import javafx.scene.image.*;

public class Form extends GridPane {
    
    protected Dialog ui;
    
    public ArrayList getCol(ArrayList u) {
        return u;
    }
    
    /**
     * The Initial creation of form
     * @param stg
     * @throws java.io.IOException
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Form(javafx.stage.Stage stg) throws java.io.IOException
    {
        SCAdjuster adi=new SCAdjuster();
        /*
        control.myTable tbg=new control.myTable();
        
        List<String> sio=Arrays.asList("Silas","Stephen","Paul","Timothy");
        control.AutoCompleteField ati=new control.AutoCompleteField(sio);
        //List<String> sio=Arrays.asList("Silas","Stephen","Paul","Timothy");
        ati.setItems(sio); ati.setDefStyle(adi.texd); ati.setHoverStyle(adi.texh);
        */
        TextField fd=new TextField(); fd.setPromptText("Enter Location Of Files here");
        fd.setDefStyle(adi.texd); fd.setHoverStyle(adi.texh); fd.setPrefWidth(517);
        
        TextArea ta=new TextArea(); ta.setPromptText("Replace What!");
        ta.setDefStyle(adi.texd); ta.setHoverStyle(adi.texh); ta.setPrefSize(517,317);
        
        TextArea t1=new TextArea(); t1.setPromptText("Replace With!");
        t1.setDefStyle(adi.texd); t1.setHoverStyle(adi.texh);  t1.setPrefSize(517,317);
        
        Button sub=new Button("Adjust!"); sub.setDefaultStyle(adi.def);
        sub.setHoverStyle(adi.hover);
        
        this.setPadding(new Insets(4,4,4,4)); this.setVgap(4); this.setHgap(4);
        this.setAlignment(Pos.CENTER); this.add(fd,0,0); this.add(ta,0,1); this.add(t1,0,2);
        this.add(sub,0,3);
        
        sub.setOnAction(ev->{
            
            if(checkFile(fd.getText(),ta.getText(),t1.getText())) {
                /*try {
                    
                Dialog ui=new Dialog(stg,true,false,600,438,
                        new javafx.scene.Scene(new control.myCharts().getBarChart()),"Charts!",
                        new javafx.scene.image.Image(new java.io.FileInputStream("smx.png")));
                
                ui.show();
                } catch (java.io.IOException ex) {
                    System.out.println(ex.getMessage());
                }*/
                
                try {
                
                javafx.scene.control.Label li=new javafx.scene.control.Label("Adjusting!");
                li.setStyle("-fx-font:normal 23px 'Cambria'; -fx-text-fill:darkslategrey;");
                
                ProgressBar prb=new ProgressBar(); prb.setPrefSize(381,57);
                prb.setDefStyle("-fx-background-color:whitesmoke; -fx-font:normal 16px 'Calibri'; "
                        + "-fx-text-fill:black;" +
"-fx-background-radius: 13px 13px 13px 13px; -fx-border-width: 5px; -fx-border-color: darkslategrey;" +
"-fx-border-radius: 8px 8px 8px 8px; -fx-accent: slategrey;");
                if(ui!=null){ui.close(); }
                ui=new Dialog(stg,false,false,387,91,
                        new javafx.scene.Scene(new javafx.scene.layout.VBox(li,prb)),"Working",
                        new javafx.scene.image.Image(new java.io.FileInputStream("smx.png")));
                
                ui.show(); sub.setVisible(false);
                
                //Real Act!
                String dir=fd.getText(),what=ta.getText(),with=t1.getText();
                //next after chaeck!
                java.io.File[] files=new java.io.File(dir).listFiles();
                
                Action act=new Action();
                act.setName("Replacer"); act.setData(files, what, with);
                act.start();
                
                smx.jfx.application.Application app=new smx.jfx.application.Application();
                app.trackProgress(act, prb);
                
        FadeTransition tra=new FadeTransition(Duration.millis(2137)); tra.setAutoReverse(false); 
        tra.setCycleCount(1);
        tra.setFromValue(0); tra.setToValue(1); tra.setNode(new GridPane()); tra.play();
        
        tra.setOnFinished(evu->{
            
            if(act.getProgress()==1) {System.out.println("Yes");
                ui.close(); sub.setVisible(true);
            } else {
                System.out.println("No"); tra.play();
            }
            
        });
        
                
                } catch (java.io.IOException ex) {
                    System.out.println(ex.getMessage());
                }
                
            } else {
                try {
                //Exception Throw!
                String error="System could not validate the Files'\nLocation Entered! Or Empty Input!\n"
                        + "\nPlease review the directory details\n,Input data and try again.";
                
                javafx.scene.control.Label l=new javafx.scene.control.Label(error);
                l.setStyle("-fx-font:normal 18px 'Cambria'; -fx-text-fill:darkred");
                if(ui!=null){ui.close(); }
                ui=new Dialog(stg,true,false,337,170,
                        new javafx.scene.Scene(new javafx.scene.layout.VBox(l)),"Error Finding DIR!",
                        new javafx.scene.image.Image(new java.io.FileInputStream("smx.png")));
                
                ui.show();
                
                } catch (java.io.IOException er) {
                    System.out.println(er.getMessage());
                }
                
            }
            
        });
        
    }
    
    /**
     * See if file exists!
     * @param file
     * @param ta
     * @param t1
     * @return 
     */
    protected boolean checkFile(String file, String ta, String t1) {
        
        boolean t=false;
        
        if(file!=null && new java.io.File(file).exists()) {
            
            if(ta.length()>0 && t1.length()>0) {
                t=true;
            }
        
        }
        
        return t;
    }
    
}
