package Graphic;
import BackEnd.GlobalConverter;
import BackEnd.CaesarCipher;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Interface extends Application{
    @Override
    public void start(Stage stage)
    {
        try { 
            stage.setTitle("Global Converter");


            Label label = new Label("Enter a string to convert : ");
            TextField stringToConvert = new TextField();
            Button hexadecimal = new Button("Hexadecimal");
            Button octal = new Button("Octal");
            Button decimal = new Button("Decimal");
            Button binary = new Button("Binary");
            Button text = new Button("Text");

            Button caesar = new Button("Caesar Cipher");
            Label CaesarLabel = new Label("Enter an increment value : ");
            TextField CaesarValue = new TextField();

            Label label2 = new Label("Result : ");
            Label result = new Label();

            setButtonAction(hexadecimal, "hexadecimal", stringToConvert, result);
            setButtonAction(octal, "octal", stringToConvert, result);
            setButtonAction(decimal, "decimal", stringToConvert, result);
            setButtonAction(binary, "binary", stringToConvert, result);
            setButtonAction(text, "text", stringToConvert, result);
            setCaesarButtonAction(caesar, CaesarValue, stringToConvert, result);
 
            HBox input_box = new HBox(label, stringToConvert, label2, result);
            input_box.setSpacing(10);
            input_box.setAlignment(Pos.CENTER);

            HBox caesar_box = new HBox(CaesarLabel, CaesarValue, caesar);
            caesar_box.setSpacing(10);
            caesar_box.setAlignment(Pos.CENTER);

            VBox button_box = new VBox(hexadecimal, octal, decimal, binary, text);
            button_box.setSpacing(10);
            button_box.setAlignment(Pos.CENTER);

            BorderPane border_pane = new BorderPane();
            border_pane.setTop(input_box);
            border_pane.setCenter(caesar_box);
            border_pane.setBottom(button_box);
 
            Scene scene = new Scene(border_pane, 800, 800);
 
            stage.setScene(scene);
 
            stage.show();
        }
 
        catch (Exception e) {
 
            System.out.println(e.getMessage());
        }
    }

    public void setButtonAction (Button button, String type, TextField stringToConvert, Label result) {
        button.setOnAction(e -> {
            String input = stringToConvert.getText();
            int[] asciiValues = GlobalConverter.convertToASCII(input);
            String convertedString = GlobalConverter.convertFromASCII(asciiValues, type);
            result.setText(convertedString);
        });
    }

    public void setCaesarButtonAction (Button button, TextField CaesarValue, TextField stringToConvert, Label result) {
        button.setOnAction(e -> {
            String input = stringToConvert.getText();
            int key = Integer.parseInt(CaesarValue.getText());
            String encryptedString = CaesarCipher.encrypt(input, key);
            result.setText(encryptedString);
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
