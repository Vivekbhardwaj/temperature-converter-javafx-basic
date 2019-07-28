package com.internshala.javaFXapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class myMain extends Application {

	public static void main(String[] args){
		launch(args);
	}


	//life cycle of javaFX init-start-stop   but still main method is executed first
	//simply creates application
	@Override
	public void init() throws Exception {
		super.init();
	}


	//makes application visible to user
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Convertor");
		//primaryStage.setResizable(false);  to make sure application is not resizable
		primaryStage.show();
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
