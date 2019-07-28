package com.internshala.javaFXapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

//in a javafx desktop app the class containing main method extends Application class which is part of javafx .
//Application class consists of one abstract method which must be overridden i.e. the "start" method
public class myMain extends Application {

	public static void main(String[] args){
		launch(args);
	}


	//life cycle of javaFX  "init-start-stop"  but still main method is executed first as soon as the application starts


    //'@' symbol acts as an address specifier 
	@Override
	public void init() throws Exception {
        //the code present in this method is executed as soon as the application loads that is even before it starts
		super.init();          //super keyword invokes the init methods as per the definition in the Application class
        
	}


	/*makes application visible to user ,it is the abstract method of Applications class which in must in order to
    execute the application
    In laymen terms Stage is the complete window that pops up in front of the user as soon as the application
    starts,the window alongwith the minimize maximize and close buttons
    while scene is the part of stage other than the top bar containing the three buttons.
    scene is the part which can show some dynamic stuff.*/

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		Scene scene = new Scene(rootNode);
        
        Pane menuPane= (Pane) rootNode.getChildren().get(0);
		menuPane.getChildren().add(createMenubar());

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Convertor");
		//primaryStage.setResizable(false);  to make sure application is not resizable
		primaryStage.show();
	}

	private MenuBar createMenubar() {
		Menu fileMenu = new Menu("file");
		Menu helpMenu = new Menu("Help");

		MenuItem aboutApp = new MenuItem("About App");
		aboutApp.setOnAction(actionEvent -> aboutApp());

		helpMenu.getItems().add(aboutApp);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}


	//creating a dilague box through menu
	public static void aboutApp(){
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My first java Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I'm a beginner and soon i'll be a pro");

		//to make custom buttons
		ButtonType yesBtn = new ButtonType("yes");
		ButtonType noBtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

		//to perform click event on buttons of the dilague box that opens and make buttons
		Optional<ButtonType> clickBtn=alertDialog.showAndWait();
		if(clickBtn.isPresent()&&clickBtn.get()==yesBtn){
			// code .......
		}
		if(clickBtn.get()==noBtn){
			//code..........
		}

		alertDialog.show();
	}


	//called and after some time application shuts down
	@Override
	public void stop() throws Exception {
		super.stop();
	}

}
