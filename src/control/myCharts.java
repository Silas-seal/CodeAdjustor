/*
 * Charts!
 */
package control;

/**
 *
 * @author Seumx Plus
*/

import javafx.scene.chart.*;
import javafx.collections.*;

public class myCharts extends javafx.scene.layout.GridPane {
    
    /**
     * The generates Pie!
     * @return 
     */
    public javafx.scene.layout.HBox getPieChart() {
        
        //Preparing ObservbleList object         
      ObservableList<PieChart.Data> pieChartData = 
      FXCollections.observableArrayList( 
         new PieChart.Data("Iphone 5S", 13), 
         new PieChart.Data("Samsung Grand", 25), 
         new PieChart.Data("MOTO G", 10),
         new PieChart.Data("Techno", 20),
         new PieChart.Data("Itel", 30),
         new PieChart.Data("Nokia Lumia", 22)); 
       
       //Creating a Pie chart 
       PieChart pieChart = new PieChart(pieChartData); 
              
       //Setting the title of the Pie chart 
       pieChart.setTitle("Mobile Sales"); 
       
       //setting the direction to arrange the data 
       pieChart.setClockwise(true); 
       
      //Setting the length of the label line 
       pieChart.setLabelLineLength(20); 
  
  
       //Setting the labels of the pie chart visible  
       pieChart.setLabelsVisible(true); 
       
       //Setting the start angle of the pie chart  
       pieChart.setStartAngle(180);
       
       //set some style!
       pieChart.setStyle("-fx-font:normal 12px 'Century GOTHIC';");
       
       return new javafx.scene.layout.HBox(pieChart);
        
    }
    
    /**
     * Line Chart
     * @return 
     */
    public javafx.scene.layout.HBox getLineChart() {
        
        //Defining the x axis             
       NumberAxis xAxis = new NumberAxis(1960, 2030, 10); 
       xAxis.setLabel("Years"); 
        
       //Defining the y axis   
       NumberAxis yAxis = new NumberAxis(0, 400, 50); 
       yAxis.setLabel("No.of schools"); 
        
       //Creating the line chart 
       LineChart linechart = new LineChart(xAxis, yAxis);  
        
       //Prepare XYChart.Series objects by setting data 
       XYChart.Series series = new XYChart.Series();
       series.setName("No of schools in an year"); 
        
       series.getData().add(new XYChart.Data(1970, 15)); 
       series.getData().add(new XYChart.Data(1980, 30)); 
       series.getData().add(new XYChart.Data(1990, 60)); 
       series.getData().add(new XYChart.Data(2000, 120)); 
       series.getData().add(new XYChart.Data(2013, 240)); 
       series.getData().add(new XYChart.Data(2014, 300)); 
       
       //Prepare XYChart.Series objects by setting data 
       XYChart.Series series2 = new XYChart.Series();
       series2.setName("No of Hospitals in an year"); 
        
       series2.getData().add(new XYChart.Data(1978, 21)); 
       series2.getData().add(new XYChart.Data(1984, 41)); 
       series2.getData().add(new XYChart.Data(1995, 64));
       series2.getData().add(new XYChart.Data(2010, 97)); 
       series2.getData().add(new XYChart.Data(2016, 215)); 
       series2.getData().add(new XYChart.Data(2020, 341)); 
            
       //Setting the data to Line chart    
       linechart.getData().addAll(series,series2);
       
       //set some style!
       linechart.setStyle("-fx-font:normal 12px 'Century GOTHIC';");
       
       return new javafx.scene.layout.HBox(linechart);
        
    }
    
    /**
     * Returns AreaChart!
     * @return 
     */
    public javafx.scene.layout.HBox getAreaChart()
    {
        CategoryAxis cat=new CategoryAxis();
        cat.setLabel("Months");
        
        NumberAxis numa=new NumberAxis(0,100,5);
        numa.setLabel("Popularity");
        
        AreaChart<String, Number> achart=new AreaChart<>(cat,numa);
        achart.setTitle("Java Vs Python 2020!");
        
        XYChart.Series series=new XYChart.Series();
        series.setName("Java");
        
        series.getData().add(new XYChart.Data("January",87));
        series.getData().add(new XYChart.Data("February",91));
        series.getData().add(new XYChart.Data("March",84));
        series.getData().add(new XYChart.Data("April",79));
        series.getData().add(new XYChart.Data("May",75));
        series.getData().add(new XYChart.Data("June",82));
        series.getData().add(new XYChart.Data("July",85));
        series.getData().add(new XYChart.Data("August",89));
        series.getData().add(new XYChart.Data("September",93));
        series.getData().add(new XYChart.Data("October",95));
        series.getData().add(new XYChart.Data("November",94));
        series.getData().add(new XYChart.Data("December",99));
        
        XYChart.Series series2=new XYChart.Series();
        series2.setName("Python");
        
        series2.getData().add(new XYChart.Data("January",71));
        series2.getData().add(new XYChart.Data("February",75));
        series2.getData().add(new XYChart.Data("March",84));
        series2.getData().add(new XYChart.Data("April",74));
        series2.getData().add(new XYChart.Data("May",75));
        series2.getData().add(new XYChart.Data("June",71));
        series2.getData().add(new XYChart.Data("July",69));
        series2.getData().add(new XYChart.Data("August",64));
        series2.getData().add(new XYChart.Data("September",71));
        series2.getData().add(new XYChart.Data("October",70));
        series2.getData().add(new XYChart.Data("November",75));
        series2.getData().add(new XYChart.Data("December",62));
        
        achart.getData().addAll(series,series2);
        
        achart.setStyle("-fx-font:normal 12px 'Century GOTHIC'");
        
        return new javafx.scene.layout.HBox(achart);
    }
    
    /**
     * Returns BarChart!
     * @return 
     */
    public javafx.scene.layout.HBox getBarChart() 
    {
        
        CategoryAxis cat=new CategoryAxis();
        cat.setLabel("Category");
        
        NumberAxis num=new NumberAxis(0,100,5);
        num.setLabel("Reputation");
        
        BarChart<String,Number> bchart=new BarChart<>(cat,num);
        bchart.setTitle("Car Rating!");
        
        XYChart.Series lambo=new XYChart.Series();
        lambo.setName("Lamborgini");
        
        lambo.getData().add(new XYChart.Data("Rating",81));
        lambo.getData().add(new XYChart.Data("Sales",31));
        lambo.getData().add(new XYChart.Data("Speed",94));
        lambo.getData().add(new XYChart.Data("Price",75));
        lambo.getData().add(new XYChart.Data("Handling",64));
        
        XYChart.Series benz=new XYChart.Series();
        benz.setName("Mercedes Benz");
        
        benz.getData().add(new XYChart.Data("Rating",61));
        benz.getData().add(new XYChart.Data("Sales",54));
        benz.getData().add(new XYChart.Data("Speed",87));
        benz.getData().add(new XYChart.Data("Price",64));
        benz.getData().add(new XYChart.Data("Handling",49));
        
        XYChart.Series toyo=new XYChart.Series();
        toyo.setName("Toyota");
        
        toyo.getData().add(new XYChart.Data("Rating",71));
        toyo.getData().add(new XYChart.Data("Sales",74));
        toyo.getData().add(new XYChart.Data("Speed",57));
        toyo.getData().add(new XYChart.Data("Price",44));
        toyo.getData().add(new XYChart.Data("Handling",39));
        
        XYChart.Series fiat=new XYChart.Series();
        fiat.setName("Fiat");
        
        fiat.getData().add(new XYChart.Data("Rating",41));
        fiat.getData().add(new XYChart.Data("Sales",54));
        fiat.getData().add(new XYChart.Data("Speed",64));
        fiat.getData().add(new XYChart.Data("Price",28));
        fiat.getData().add(new XYChart.Data("Handling",74));
        
        
        bchart.getData().addAll(lambo,benz,toyo,fiat);
        
        bchart.setStyle("-fx-font:normal 12px 'Lucida Fax'");
        
        return new javafx.scene.layout.HBox(bchart);
        
    }
    
}
