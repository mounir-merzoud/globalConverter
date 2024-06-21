package Graphic;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Interface extends Application{
    @Override
    public void start(Stage stage)
    {
 
        try {
 
            // set title for the stage
            stage.setTitle("BorderPane");
 
            // create a label
            Label label = new Label("this is BorderPane example");

            Button button = new Button("Quit");
            button.setOnAction(e -> System.exit(0));
 
            // create a BorderPane
            BorderPane border_pane = new BorderPane(label, null, null, button, null);
 
            // create a scene
            Scene scene = new Scene(border_pane, 400, 300);
 
            // set the scene
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
