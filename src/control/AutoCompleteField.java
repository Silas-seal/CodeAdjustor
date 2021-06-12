/*
 * AutoComplete Field!
 */
package control;

/**
 *
 * @author Seumx Plus
 */

import javafx.scene.control.*;
import javafx.collections.*;
import java.util.*;
import javafx.geometry.Side;

public final class AutoCompleteField extends smx.jfx.control.TextField {
    
    private ContextMenu ctx=new ContextMenu(); 
    private ObservableList<AFItem> obervable=FXCollections.observableArrayList();
    
    /**
     * Default Construction!
     */
    public AutoCompleteField() {
        
        this.setOnKeyReleased(ij->{
            
            this.ctx.getItems().clear(); 
            
            this.ctx.getItems().addAll(getSortedOb(this.getText(),obervable));
            
            this.ctx.show(this, Side.BOTTOM, 37, 0);
        });
        
    }
    
    /**
     * Set 
     * @param mn 
     */
    public AutoCompleteField(ObservableList<AFItem> mn) {
        
        setItems(mn);
        
        this.setOnKeyReleased(ij->{
            
            this.ctx.getItems().clear(); 
            
            this.ctx.getItems().addAll(getSortedOb(this.getText(),obervable));
            
            this.ctx.show(this, Side.BOTTOM, 37, 0);
        });
        
    }
    
    /**
     * Set String List On Construction!
     * @param itm 
     */
    public AutoCompleteField(List<String> itm) {
        
        setItems(itm);
        
        this.setOnKeyReleased(ij->{
            
            this.ctx.getItems().clear(); 
            
            this.ctx.getItems().addAll(getSortedOb(this.getText(),obervable));
            
            this.ctx.show(this, Side.BOTTOM, 37, 0);
        });
        
    }
    
    /**
     * Set String list
     * @param items 
     */
    public void setItems(List<String> items) {
        
        this.ctx.getItems().clear(); 
        
        List<AFItem> yt=new ArrayList();
        
        for(String str:items) {
            
            AFItem iu=new AFItem(str);
            iu.setOnAction(er->{
                this.setText(str);
            });
            
            yt.add(iu);
            
        }
        
        this.obervable.clear();
        this.obervable.addAll(yt);
        
    }
    
    /**
     * Set Object Values!
     * @param obser 
     */
    public void setItems(ObservableList<AFItem> obser) {
        
        this.ctx.getItems().clear(); 
        
        for(AFItem atm:obser) {
            atm.setOnAction(er->{
                this.setText(atm.getText());
            });
        }
        
        this.obervable.clear();
        this.obervable.addAll(obser);
        
    }
    
    /**
     * Returns the sorted observable list sorted with argument text
     * @param query
     * @param orig
     * @return 
     */
    public ObservableList<AFItem> getSortedOb(String query, ObservableList<AFItem> orig) {
        
        ObservableList<AFItem> rtn=FXCollections.observableArrayList();
        
        for(AFItem aft:orig) {
            if(aft.getText().contains(query)) {
                rtn.add(aft);
            }
        }
        return rtn;
    }
    
}
