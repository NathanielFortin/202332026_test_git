package org.calma.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Paysage du Québec avec Dromadaire");

        Group root = new Group();
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawScene(gc);

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawScene(GraphicsContext gc) {
        // Ciel
        gc.setFill(Color.SKYBLUE);
        gc.fillRect(0, 0, 800, 600);

        // Montagnes
        gc.setFill(Color.DARKGRAY);
        gc.fillPolygon(new double[]{100, 300, 500}, new double[]{400, 200, 400}, 3);
        gc.fillPolygon(new double[]{300, 500, 700}, new double[]{400, 250, 400}, 3);

        // Lac
        gc.setFill(Color.DEEPSKYBLUE);
        gc.fillOval(200, 350, 400, 150);

        // Arbres
        gc.setFill(Color.DARKGREEN);
        gc.fillRect(250, 300, 20, 100);
        gc.fillPolygon(new double[]{240, 270, 300}, new double[]{300, 250, 300}, 3);

        gc.fillRect(550, 300, 20, 100);
        gc.fillPolygon(new double[]{540, 570, 600}, new double[]{300, 250, 300}, 3);

        // Dromadaire
        drawCamel(gc, 600, 400);
    }

    private void drawCamel(GraphicsContext gc, double x, double y) {
        // Corps
        gc.setFill(Color.SANDYBROWN);
        gc.fillRect(x, y, 80, 40);

        // Tête
        gc.fillOval(x + 70, y - 20, 30, 30);

        // Pattes
        gc.fillRect(x + 10, y + 40, 10, 40);
        gc.fillRect(x + 60, y + 40, 10, 40);

        // Bosses
        gc.fillArc(x + 10, y - 20, 30, 40, 0, 180, ArcType.ROUND);
        gc.fillArc(x + 40, y - 20, 30, 40, 0, 180, ArcType.ROUND);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

