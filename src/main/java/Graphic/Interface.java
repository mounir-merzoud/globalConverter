package Graphic;
import BackEnd.GlobalConverter;
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
            TextField string = new TextField();
            Button hexadecimal = new Button("Hexadecimal");
            Button octal = new Button("Octal");
            Button decimal = new Button("Decimal");
            Button binary = new Button("Binary");
            Button text = new Button("Text");
            Label label2 = new Label("Result : ");
            Label result = new Label();

            hexadecimal.setOnAction(e -> {
                String input = string.getText();
                int[] asciiValues = GlobalConverter.convertToASCII(input);
                String convertedString = GlobalConverter.convertFromASCII(asciiValues, "hexadecimal");
                result.setText(convertedString);
            });
 
            HBox input_box = new HBox(label, string, label2, result);
            input_box.setSpacing(10);
            input_box.setAlignment(Pos.CENTER);

            VBox button_box = new VBox(hexadecimal, octal, decimal, binary, text);
            button_box.setSpacing(10);
            button_box.setAlignment(Pos.CENTER);

            BorderPane border_pane = new BorderPane();
            border_pane.setTop(input_box);
            border_pane.setCenter(button_box);
 
            Scene scene = new Scene(border_pane, 800, 800);
 
            stage.setScene(scene);
 
            stage.show();
        }
 
        catch (Exception e) {
 
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
