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
                        board.addBall();
                        break;
                    case S:
                        board.addSquare();
                        break;
                    case T:
                        board.addTriangle();
                        break;

                    case HOME:
                        board.selectNext();
                        break;
                    case END:
                        board.selectPrevious();
                        break;

                    case LEFT:
                        board.move(-5, 0);
                        break;
                    case RIGHT:
                        board.move(5, 0);
                        break;
                    case UP:
                        board.move(0, -5);
                        break;
                    case DOWN:
                        board.move(0, 5);
                        break;

                    case PAGE_UP:
                        board.selectedZoomIn();
                        break;
                    case PAGE_DOWN:
                        board.selectedZoomOut();
                        break;

                    case D:
                        board.delete();
                        break;
                    case G:
                        board.addInGroup();
                        break;
                    case U:
                        board.disconnectGroup();
                        break;

//                    case F5:
//                        board.save();
                    default:
                        break;
                }
            }
        });
    }
}
