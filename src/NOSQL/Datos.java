import java.awt.Insets;
import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import javax.swing.JOptionPane;

import javafx.application.Application;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.scene.control.Label;

import javafx.scene.control.Menu;

import javafx.scene.control.MenuBar;

import javafx.scene.control.MenuItem;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javafx.stage.Stage;



public class Main extends Application {

	private MenuBar rootmenu;

	private Menu archivo;

	private MenuItem cargar;
	private MenuItem cerrar;

	private FileChooser fileChooser = new FileChooser();

	private File selectedFile;

	private GridPane gridpane;

	

    public static void main(String[] args) {

        launch(args);

    }



    @Override

    public void start(Stage primaryStage) {
    	
        primaryStage.setTitle("CSV");
      

        

        archivo=new Menu("Documento");

        

        cargar=new MenuItem("Seleccionar");

        cerrar=new MenuItem("Cerrar");

        archivo.getItems().add(cargar);
        archivo.getItems().add(cerrar);

        cerrar.setOnAction(new EventHandler<ActionEvent>() { 

            public void handle(ActionEvent e) 

            { 
System.exit(0);

            } 

        });

        cargar.setOnAction(new EventHandler<ActionEvent>() { 

            public void handle(ActionEvent e) 

            { 

            		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("File CSV", "*.csv"));

            		selectedFile = fileChooser.showOpenDialog(primaryStage);

            		readCSV(selectedFile);	

            } 

        });

        

        rootmenu=new MenuBar();

        rootmenu.getMenus().add(archivo);

        



        gridpane=new GridPane();

        gridpane.setVgap(5);

        gridpane.setHgap(5);

        gridpane.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

        VBox vBox = new VBox(rootmenu,gridpane);

        

        ScrollPane scrollpane=new ScrollPane();

        scrollpane.setContent(vBox);

        

        Scene scene = new Scene(scrollpane, 500, 400);

       
      
        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        

        primaryStage.show();

    }

    

    

    

    private void readCSV(File file){

    	BufferedReader br;

    	try {

    		

    		br = new BufferedReader(new FileReader(file));

    		if(br.readLine()!=null) {

    			int fila=0;

    			String line;

    			while((line = br.readLine()) !=null) {

    				int col=0;

    				String [] x=line.split(";");

    				for(String i:x) {

    					gridpane.add(new Label(i),col,fila);

    					col++;

    				}

    				fila++;}

    			}

    		else {

    			JOptionPane.showMessageDialog(null, "Introduzca un archivo valido");

    		}

    		}

    		catch(Exception e) {

    		
    			JOptionPane.showMessageDialog(null, "Error");

    		}

    }

}
