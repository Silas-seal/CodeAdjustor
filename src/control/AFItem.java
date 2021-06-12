/*
 * AFItem!
 */
package control;

/**
 *
 * @author Seumx Plus
 */
public class AFItem extends javafx.scene.control.MenuItem {
    
    /**
     * Initialize text with graphic
     * @param text
     * @param graphic 
     */
    public AFItem(String text, javafx.scene.Node graphic) {
        
        this.setText(text); this.setGraphic(graphic);
        
    }
    
    public AFItem(String str) {
        
        this.setText(str);
        
    }
    
}
