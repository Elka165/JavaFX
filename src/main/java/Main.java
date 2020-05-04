
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

public class Main  extends Application{
    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage stage){
        try {
//            1)
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

//            2)

            Parameters pp=this.getParameters();
            List<String> unParams= pp.getUnnamed();
            StackPane root = new StackPane();
            Scene scene = new Scene(root, Double.parseDouble(unParams.get(0)), Double.parseDouble(unParams.get(1)));
            stage.setScene(scene);
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
