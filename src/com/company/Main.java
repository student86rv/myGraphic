package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int BOARD_WIDTH = 800;
    private static final int BOARD_HEIGHT = 500;
    private static final int FPS = 60;

    private boolean closed;
    private Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SimpleGame");
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        Logger.log("Game started");

        GraphicsContext gc = canvas.getGraphicsContext2D();
        board = new Board(gc);
        board.draw();

        KeyHelper.addKeyListener(scene, board);
//        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                if (event.getCode() == KeyCode.B) {
//                    System.out.println("new ball");
//                    board.addBall();
//                }
//                if (event.getCode() == KeyCode.S) {
//                    System.out.println("new square");
//                    board.addSquare();
//                }
//                if (event.getCode() == KeyCode.DIGIT1) {
//                    System.out.println("new square");
//                    board.select(1);
//                }
//                if (event.getCode() == KeyCode.DIGIT2) {
//                    System.out.println("new square");
//                    board.select(2);
//                }
//                if (event.getCode() == KeyCode.DIGIT3) {
//                    System.out.println("new square");
//                    board.select(3);
//                }
//
//                if (event.getCode() == KeyCode.LEFT) {
//                    System.out.println("LEFT");
//                    board.move(-5, 0);
//                }
//                if (event.getCode() == KeyCode.RIGHT) {
//                    System.out.println("RIGHT");
//                    board.move(5, 0);
//                }
//                if (event.getCode() == KeyCode.UP) {
//                    System.out.println("UP");
//                    board.move(0, -5);
//                }
//                if (event.getCode() == KeyCode.DOWN) {
//                    System.out.println("DOWN");
//                    board.move(0, 5);
//                }
//            }
//        });

        new Thread(this::runMainGameLoopInThread).start();
    }

    @Override
    public void stop() {
        closed = true;
    }

    private void runMainGameLoopInThread() {
        while (!closed) {
            // run in UI thread
            Platform.runLater(this::drawFrame);
            try {
                int pauseBetweenFramesMillis = 1000 / FPS;
                Thread.sleep(pauseBetweenFramesMillis);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void drawFrame() {
        board.draw();
        //board.move();
    }
}
