/*
 * Table Study!
 */
package control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Seumx Plus
 */
public class myTable extends javafx.scene.layout.GridPane {
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public myTable()
    {
        scadjuster.SCAdjuster adi=new scadjuster.SCAdjuster();
        
        @SuppressWarnings("Convert2Diamond")
        javafx.scene.control.TableColumn<Person,String> firstNameCol = 
                new javafx.scene.control.TableColumn<Person,String>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        
        @SuppressWarnings("Convert2Diamond")
        javafx.scene.control.TableColumn<Person,String> lastNameCol = 
                new javafx.scene.control.TableColumn<Person,String>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));
        
        @SuppressWarnings("Convert2Diamond")
        javafx.scene.control.TableColumn<Person,String> contact = 
                new javafx.scene.control.TableColumn<Person,String>("Contact");
        contact.setCellValueFactory(new PropertyValueFactory("contact"));
        
        @SuppressWarnings("Convert2Diamond")
        javafx.scene.control.TableColumn<Person,String> address = 
                new javafx.scene.control.TableColumn<Person,String>("Address");
        address.setCellValueFactory(new PropertyValueFactory("address"));
        
        Person sil=new Person(); sil.setFirstName("Muwanguzi");
        sil.setLastName("Silas"); sil.setContact("+256 704 029 977");
        sil.setAddress("Namwendwa, Kamuli, Uganda");
        
        Person iz=new Person(); iz.setFirstName("Muwereza");
        iz.setLastName("Isaac"); iz.setContact("+256 702 043 057");
        iz.setAddress("Namwendwa, Kamuli, Uganda");
        
        Person vic=new Person(); vic.setFirstName("Mwesigwa");
        vic.setLastName("Victory/V0178"); vic.setContact("+256 702 043 057");
        vic.setAddress("Namwendwa, Kamuli, Uganda");
        
        ObservableList<Person> ob=FXCollections.observableArrayList(sil,iz,vic);
        
        @SuppressWarnings("Convert2Diamond")
        javafx.scene.control.TableView<Person> tbg = new javafx.scene.control.TableView<Person>();
        tbg.setStyle(adi.texd); tbg.getColumns().addAll(firstNameCol,lastNameCol,contact,address);
        tbg.setItems(ob);
        
        this.setPadding(new javafx.geometry.Insets(0,0,0,0)); this.setVgap(0); this.setHgap(0);
        this.setAlignment(Pos.CENTER); this.add(tbg,0,0);
    }
    
}
