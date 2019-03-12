package com.company;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHelper {

    public static void addKeyListener(Scene scene, Board board) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.B) {
                    System.out.println("new ball");
                    board.addBall();
                }
                if (event.getCode() == KeyCode.S) {
                    System.out.println("new square");
                    board.addSquare();
                }
                if (event.getCode() == KeyCode.DIGIT1) {
                    System.out.println("new square");
                    board.select(1);
                }
                if (event.getCode() == KeyCode.DIGIT2) {
                    System.out.println("new square");
                    board.select(2);
                }
                if (event.getCode() == KeyCode.DIGIT3) {
                    System.out.println("new square");
                    board.select(3);
                }

                if (event.getCode() == KeyCode.LEFT) {
                    System.out.println("LEFT");
                    board.move(-5, 0);
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    System.out.println("RIGHT");
                    board.move(5, 0);
                }
                if (event.getCode() == KeyCode.UP) {
                    System.out.println("UP");
                    board.move(0, -5);
                }
                if (event.getCode() == KeyCode.DOWN) {
                    System.out.println("DOWN");
                    board.move(0, 5);
                }
            }
        });
    }
}
