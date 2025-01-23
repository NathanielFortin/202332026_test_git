package org.calma.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Paysage du Québec avec Dromadaire, Orignal et Poutine Volante");

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

        // Orignal
        drawMoose(gc, 100, 400);

        // Poutine Volante
        drawFlyingPoutine(gc, 400, 100);

        // Soleil
        drawSun(gc, 700, 100);

        // Nuages
        drawCloud(gc, 200, 100);
        drawCloud(gc, 500, 150);
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

    private void drawMoose(GraphicsContext gc, double x, double y) {
        // Corps de l'orignal
        gc.setFill(Color.BROWN);
        gc.fillOval(x, y, 120, 60);

        // Tête de l'orignal
        gc.fillOval(x + 90, y - 30, 40, 40);

        // Pattes de l'orignal
        gc.fillRect(x + 20, y + 60, 10, 40);
        gc.fillRect(x + 80, y + 60, 10, 40);

        // Bois de l'orignal
        gc.setFill(Color.SIENNA);
        gc.fillPolygon(new double[]{x + 100, x + 90, x + 110}, new double[]{y - 50, y - 30, y - 30}, 3);
        gc.fillPolygon(new double[]{x + 120, x + 110, x + 130}, new double[]{y - 50, y - 30, y - 30}, 3);
    }

    private void drawFlyingPoutine(GraphicsContext gc, double x, double y) {
        // Base de la poutine (frites)
        gc.setFill(Color.GOLDENROD);
        gc.fillRect(x, y, 60, 20);

        // Sauce
        gc.setFill(Color.SADDLEBROWN);
        gc.fillOval(x - 10, y, 80, 30);

        // Fromage en grains
        gc.setFill(Color.WHITE);
        gc.fillOval(x + 10, y + 5, 10, 10);
        gc.fillOval(x + 30, y + 10, 10, 10);
        gc.fillOval(x + 50, y + 5, 10, 10);

        // Ailes (pour voler)
        gc.setFill(Color.LIGHTGRAY);
        gc.fillOval(x - 20, y - 20, 30, 20);
        gc.fillOval(x + 50, y - 20, 30, 20);
    }

    private void drawSun(GraphicsContext gc, double x, double y) {
        gc.setFill(Color.YELLOW);
        gc.fillOval(x, y, 80, 80);
    }

    private void drawCloud(GraphicsContext gc, double x, double y) {
        gc.setFill(Color.LIGHTGRAY);
        gc.fillOval(x, y, 60, 40);
        gc.fillOval(x + 20, y - 20, 60, 40);
        gc.fillOval(x + 40, y, 60, 40);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
