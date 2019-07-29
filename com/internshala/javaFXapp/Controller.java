package com.internshala.javaFXapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

//The controller class is another part of a javafx app containing all the stuff required during the working of the app
//This implements the interface called Initiazable containing the abstract method called initialize
//which does what it really means i.e. initializing the scene with certain objects and ready to launch methods

/*      IMPORTANT
avoid mistake of taking the things like Button and lable from java.awt while working with javafx,it might be cause of
a bug that might not be easily determinable*/

public class Controller implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public javafx.scene.control.TextField userInputField;

	@FXML
	public javafx.scene.control.Button convertButton;

	private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
	private static final String F_TO_C_TEXT = "Fahrenheit to Celsius";

	private boolean isC_TO_F = true;
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_C_TEXT);

		choiceBox.setValue(C_TO_F_TEXT);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
			if(newValue.equals(C_TO_F_TEXT)){isC_TO_F=true;}
			else {isC_TO_F=false;}
		});

		convertButton.setOnAction((actionEvent) -> convert());
	}


    //The main logic part
	private void convert(){
		String input = userInputField.getText(); //we get the temperature as string
		float enteredTemperature=0.0f;

		try{
			enteredTemperature = Float.parseFloat((input));
		} catch(Exception exception){
			warnUser();
			return;
		}

		float newTemperature = 0.0f;
		if (isC_TO_F){
			newTemperature = (enteredTemperature* 9/5)+32;
		}	else {
			newTemperature = (enteredTemperature - 32)*5/9;
		}

		display(newTemperature);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText("Invalid input");
		alert.show();
	}

	private void display(float newTemperature) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		String unit=isC_TO_F?" F":" C";
		alert.setContentText("The converted temperature is "+newTemperature+unit);
		System.out.println("new temperature is "+ newTemperature+unit);
		alert.show();
	}
}
