package demoevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private Circle circle = new Circle(25);
    private Rectangle rect = new Rectangle(10, 10, 50, 50);
    private HBox pane1 = new HBox(20, circle, rect);

    private Label label = new Label("Click the shap to add");
    private HBox pane2 = new HBox(label);

    private HBox pane3 = new HBox(20);

    private VBox pane = new VBox(20, pane1, pane2, pane3);
    private Scene scene = new Scene(pane, 300, 200);
    
    
    @Override
    public void start(Stage primaryStage) {

        circle.setOnMouseClicked((e) -> {
            pane3.getChildren().add(addCircle(15));
        });

        rect.setOnMouseClicked((e) -> {
            pane3.getChildren().add(addRectangle(25));
        });

        circle.setOnMouseEntered((e) -> {
//            circle.setFill(Color.TEAL);
            circle.setFill(Color.color(Math.random(),Math.random(),Math.random()));
        });

        circle.setOnMouseExited((e) -> {
            circle.setFill(Color.BLACK);
        });
        
        primaryStage.setOnCloseRequest((e)->{
            Alert dlgInfo = new Alert(Alert.AlertType.INFORMATION);
            dlgInfo.setHeaderText("Closing Primary Stage");
            dlgInfo.show();
        });

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Circle addCircle(int size) {
        Circle c1 = new Circle(size);
//        c1.setFill(Color.MAGENTA);
        c1.setFill(Color.color(Math.random(),Math.random(),Math.random()));
        return c1;
    }

    public Rectangle addRectangle(int size) {
        Rectangle r1 = new Rectangle(10, 10, size, size);
        r1.setFill(Color.AQUA);
        return r1;
    }

    public static void main(String[] args) {
        launch(args);
    }

}

/*
JavaFX Event Example

1.	Create a JavaFX project called DemoEvent
2.	Above the start method add
a.	A private Circle object called circle with a radius of 25 pixels;
b.	A private Rectangle object called rect(10,10,50,50)
c.	A private HBox object called pane1 that 
i.	Uses a spacing of 20 pixels
ii.	References circle and rect objects
d.	A private Label object called label with the text “click the shap to add”
e.	A private HBox pane2 that 
i.	References the label object
f.	A private VBox object called pane that
i.	Uses a spacing of 20 pixels
ii.	References the pane1 and pane2 objects
g.	A private Scene object called scene that
i.	References the pane object
ii.	Is 300 pixels wide
iii.	Is 200 pixels high
iv.	Is referenced by the primary stage
3.	Below the start method, add a private method called addCircle that 
a.	Takes an integer parameter called size
b.	Creates a Circle object with its radius set to size
c.	Style the circle object
d.	Returns the circle object
4.	In the start method, add a event handler that 
a.	Adds a Circle object to pane3 whenever the user clicks the circle
5.	Whenever the user clicks the rect object, a rectangle should be added to pane3
6.	Whenever the mouse is over the circle object, the circle color changes
7.	Whenever the mouse exits the circle object, the circle color is black
8.	Whenever that user clicks the x of the primary stage, a dialog appears with the text “Closing Primary Stage”

*/