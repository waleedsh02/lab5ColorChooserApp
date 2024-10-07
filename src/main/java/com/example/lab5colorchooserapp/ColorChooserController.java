package com.example.lab5colorchooserapp;

// Fig. 13.9: ColorChooserController.java
// Controller for the ColorChooser app
// Fig. 13.9: ColorChooserController.java
// Controller for the ColorChooser app with bidirectional bindings
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorChooserController {
    // instance variables for interacting with GUI components
    @FXML private Slider redSlider;
    @FXML private Slider greenSlider;
    @FXML private Slider blueSlider;
    @FXML private Slider alphaSlider;
    @FXML private TextField redTextField;
    @FXML private TextField greenTextField;
    @FXML private TextField blueTextField;
    @FXML private TextField alphaTextField;
    @FXML private Rectangle colorRectangle;

    // instance variables for managing color components
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;

    public void initialize() { // this functions help to bond the sliders values to their text fields (bidirectionally)

        Bindings.bindBidirectional(redTextField.textProperty(), redSlider.valueProperty(), new javafx.util.converter.NumberStringConverter());
        Bindings.bindBidirectional(greenTextField.textProperty(), greenSlider.valueProperty(), new javafx.util.converter.NumberStringConverter());
        Bindings.bindBidirectional(blueTextField.textProperty(), blueSlider.valueProperty(), new javafx.util.converter.NumberStringConverter());
        Bindings.bindBidirectional(alphaTextField.textProperty(), alphaSlider.valueProperty(), new javafx.util.converter.NumberStringConverter());

        // Listeners to update Rectangle's fill based on slider changes
        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            red = newValue.intValue();
            updateRectangleFill();
        });

        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            green = newValue.intValue();
            updateRectangleFill();
        });

        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            blue = newValue.intValue();
            updateRectangleFill();
        });

        alphaSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            alpha = newValue.doubleValue();
            updateRectangleFill();
        });
    }

    // Updates the rectangle's fill color based on the slider values
    private void updateRectangleFill() {
        colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
    }
}
