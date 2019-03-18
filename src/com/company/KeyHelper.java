package com.company;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class KeyHelper {

    public static void addKeyListener(Scene scene, Board board) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case B:
                        System.out.println("New ball");
                        board.addBall();
                        break;
                    case S:
                        System.out.println("New square");
                        board.addSquare();
                        break;
                    case T:
                        System.out.println("New triangle");
                        board.addTriangle();
                        break;

                    case HOME:
                        System.out.println("Selected next");
                        board.selectNext();
                        break;
                    case END:
                        System.out.println("Selected prev");
                        board.selectPrevious();
                        break;

                    case DIGIT1:
                        System.out.println("Selected 1");
                        board.selectByIndex(1);
                        break;
                    case DIGIT2:
                        System.out.println("Selected 2");
                        board.selectByIndex(2);
                        break;
                    case DIGIT3:
                        System.out.println("Selected 3");
                        board.selectByIndex(3);
                        break;
                    case DIGIT4:
                        System.out.println("Selected 4");
                        board.selectByIndex(4);
                        break;
                    case DIGIT5:
                        System.out.println("Selected 5");
                        board.selectByIndex(5);
                        break;
                    case DIGIT6:
                        System.out.println("Selected 6");
                        board.selectByIndex(6);
                        break;

                    case LEFT:
                        System.out.println("LEFT");
                        board.move(-5, 0);
                        break;
                    case RIGHT:
                        System.out.println("RIGHT");
                        board.move(5, 0);
                        break;
                    case UP:
                        System.out.println("UP");
                        board.move(0, -5);
                        break;
                    case DOWN:
                        System.out.println("DOWN");
                        board.move(0, 5);
                        break;

                    case PAGE_UP:
                        System.out.println("zoom in");
                        board.selectedZoomIn();
                        break;
                    case PAGE_DOWN:
                        System.out.println("zoom out");
                        board.selectedZoomOut();
                        break;

                    case D:
                        System.out.println("DeleteShape");
                        board.delete();
                        break;
                    case G:
                        System.out.println("AddInGroup");
                        board.addInGroup();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
