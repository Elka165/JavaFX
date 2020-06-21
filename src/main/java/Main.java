import javafx.animation.*;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;

public class Main  extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
//        try {
//            Pane root = new Pane();
//            Text text = new Text("Shadow");
//            text.setStrokeWidth(2);
//            text.setStroke(Color.BLACK);
//            text.setFill(Color.DEEPSKYBLUE);
//            text.setFont(Font.font(null, FontWeight.BOLD, 40));
//            text.setX(50);
//            text.setY(75);
//            FillTransition ft = new FillTransition(Duration.millis(2000), text,
//                    Color.DEEPSKYBLUE, Color.RED);
//            ft.setCycleCount(2);
//            ft.setAutoReverse(true);
//            //-
//            Text text1 = new Text("Shadow");
//            text1.setStrokeWidth(2);
//            text1.setStroke(Color.BLACK);
//            text1.setFill(Color.DEEPSKYBLUE);
//            text1.setFont(Font.font(null, FontWeight.BOLD, 40));
//            text1.setX(250);
//            text1.setY(75);
//            FadeTransition fat = new FadeTransition(Duration.millis(2000),
//                    text1);
//            fat.setFromValue(0.2);
//            fat.setToValue(0.8);
//            fat.setCycleCount(2);
//            fat.setAutoReverse(true);
//            //-
//            Text text2 = new Text("Shadow");
//            text2.setStrokeWidth(2);
//            text2.setStroke(Color.BLACK);
//            text2.setFill(Color.DEEPSKYBLUE);
//            text2.setFont(Font.font(null, FontWeight.BOLD, 40));
//            text2.setX(50);
//            text2.setY(155);
//            ScaleTransition sct = new ScaleTransition(Duration.millis(2000),
//                    text2);
//            sct.setFromX(1);
//            sct.setToX(0.5);
//            sct.setFromY(1);
//            sct.setToY(-0.5);
//            sct.setCycleCount(2);
//            sct.setAutoReverse(true);
//            //-
//            Text text3 = new Text("Shadow");
//            text3.setStrokeWidth(2);
//            text3.setStroke(Color.BLACK);
//            text3.setFill(Color.DEEPSKYBLUE);
//            text3.setFont(Font.font(null, FontWeight.BOLD, 40));
//            text3.setX(250);
//            text3.setY(155);
//            RotateTransition rt = new RotateTransition(Duration.millis(2000),
//                    text3);
//            rt.setByAngle(15.0);
//            rt.setCycleCount(2);
//            rt.setAutoReverse(true);
//            //-
//            ParallelTransition seq = new ParallelTransition(ft, fat, sct, rt);
//            seq.play();
//            //-
//            root.getChildren().addAll(text, text1, text2, text3);
//            Scene scene = new Scene(root, 550, 240);
//            stage.setScene(scene);
//            stage.setTitle("ScaleTransition");
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            GridPane root = new GridPane();
            root.setHgap(10);
            root.setVgap(10);

            Button but = new Button("Zamknij okno główne");
            but.setCursor(Cursor.HAND);
            but.setOnAction(e -> stage.close());
            Tooltip tooltip=new Tooltip("kliknij tutaj");
            Tooltip.install(but, tooltip);
//            but.setTooltip(tooltip);

            root.setConstraints(but, 0, 0, 2, 1);
            root.setMargin(but, new Insets(5, 5, 5, 5));
//
//            but.relocate(10,30);
//            but.setPrefSize(150,20);
            Image image =new Image(new FileInputStream("C:\\Users\\Elżbieta Dolna\\Desktop\\javaFX1\\src\\main\\resources\\dragon16.png"));
            stage.getIcons().add(image);




            Circle circle=new Circle(350,80,30);
            circle.setId("koloko");
            circle.relocate(100,100);
            root.setConstraints(circle, 2, 0, 1, 1);
            root.setMargin(circle, new Insets(5, 5, 5, 5));

            DatePicker cp = new DatePicker(LocalDate.now());
            Callback<DatePicker, DateCell> dateCellFactory = param -> new HolyDateCell();
            cp.setDayCellFactory(dateCellFactory);
            root.setConstraints(cp, 3, 0, 1, 1);
            root.getChildren().addAll(but, cp);

            root.getStyleClass().add("body");
            root.getStylesheets().add("test.css");
//            root.setStyle( "-fx-background-color: #3C4346;" +
//                    "-fx-padding: 5px 15px;" +
//                    "-fx-border-radius: 2px;" +
//                    "-fx-text-align: center;" +
//                    "-fx-margin: 1.0em;" +
//                    "-fx-margin-left: 0em;" +
//                    "-fx-margin-right: 0em;" +
//                    "-fx-position: relative;" +
//                    "-fx-right: 2px;" );
            root.getChildren().add(circle);
            Circle c=(Circle) root.lookup("#koloko");
            c.setFill(Color.BLUE);

            Scene scene = new Scene(root, 800,500);
            scene.setCursor(Cursor.HAND);

            stage.setScene(scene);
            stage.setFullScreen(true);
            ObjectProperty<String> op=stage.fullScreenExitHintProperty();
            stage.setTitle("Okno na scenę");
            stage.show();

            //zablokowanie możliwości zmiany rozmiaru okna
//            stage.setResizable(false);



            //
//            Stage stage1 = new Stage();
//            stage1.initOwner(stage);
//            stage1.initModality(Modality.APPLICATION_MODAL);
//            VBox root1 = new VBox();
//            Button but1 = new Button("Zamknij okno drugorzędne");
//            but1.setOnAction(e -> stage1.close());
//            but1.relocate(50,100);
//            root1.getChildren().add(but1);
//            Scene scene1 = new Scene(root1, 200, 135);
//            stage1.setScene(scene1);
//            stage1.setTitle("Okno na scenę 2");
//            stage1.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
