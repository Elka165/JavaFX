
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

import static javafx.stage.StageStyle.*;

public class Main  extends Application{
    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage stage){
        try {
//            1) add action
//            Label label=new Label("Witaj, świecie");
//            VBox root=new VBox();
//            Button stopButton=new Button("Żegnaj świecie");
//            stopButton.setOnAction(e->{
//                System.out.println("Kliknięto przycisk");
//                Platform.exit();
//            });
//            //dowolny rozkład przycisków
//            //StackPane root=new StackPane();
//            root.getChildren().addAll(label, stopButton);
//            Scene scene =new Scene(root, 300,200);
//            stage.setScene(scene);
//            stage.show();

//            2) add args


            StackPane root = new StackPane();
            Scene scene = new Scene(root, 500,500);
            //styl
            stage.initStyle(UNIFIED);
            stage.setScene(scene);
            //przezroczystość
//            stage.setOpacity(0.5);
            stage.sizeToScene();
            //centralizacja
            stage.centerOnScreen();
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }


}
