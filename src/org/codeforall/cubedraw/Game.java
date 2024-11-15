package org.codeforall.cubedraw;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Game {

    private final int PADDING = 5;

    public void init() {

        Canvas.setMaxY(700);
        Canvas.setMaxX(700);

        Rectangle rectangle = new Rectangle(5, 5, 700, 700);
        rectangle.draw();

        for (int i = 0; i < 35; i++) {
            for (int j = 0; j < 35; j++) {
                Rectangle mini = new Rectangle(i * 20 + PADDING, j * 20 + PADDING, 20, 20);
                mini.draw();
            }
        }
    }

    public void start() {
        PlayerCube picasso = new PlayerCube();
        new MyKeyboardHandler(picasso);

    }

}
