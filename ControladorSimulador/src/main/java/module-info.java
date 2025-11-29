module com.mycompany.controladorsimuladorv1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;
    
    
    
    opens com.mycompany.controladorsimuladorv1 to javafx.fxml;
    exports com.mycompany.controladorsimuladorv1;
    
    
    
}
