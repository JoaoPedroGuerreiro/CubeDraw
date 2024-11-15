package org.codeforall.cubedraw;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.graphics.Canvas;

import java.awt.*;
import java.io.IOException;

public class MyKeyboardHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private PlayerCube picasso;

    public MyKeyboardHandler(PlayerCube picasso){
        keyboard = new Keyboard(this);
        setKeyboardEvents();
        this.picasso = picasso;
    }
    private void setKeyboardEvents(){
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent paint = new KeyboardEvent();
        paint.setKey(KeyboardEvent.KEY_SPACE);
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paint);

        KeyboardEvent erase = new KeyboardEvent();
        erase.setKey(KeyboardEvent.KEY_E);
        erase.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(erase);

        KeyboardEvent reset = new KeyboardEvent();
        reset.setKey(KeyboardEvent.KEY_R);
        reset.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(reset);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

            if (keyboardEvent.getKey() == keyboardEvent.KEY_LEFT) {
                picasso.moveLeft();
            }
            if (keyboardEvent.getKey() == keyboardEvent.KEY_RIGHT) {
                picasso.moveRight();
            }
            if (keyboardEvent.getKey() == keyboardEvent.KEY_UP) {
                picasso.moveUp();
            }
            if (keyboardEvent.getKey() == keyboardEvent.KEY_DOWN) {
                picasso.moveDown();
            }
            if (keyboardEvent.getKey() == keyboardEvent.KEY_SPACE) {
                picasso.draw();
            }
            if (keyboardEvent.getKey() == keyboardEvent.KEY_E){
                picasso.delete();
            }
            if (keyboardEvent.getKey() == keyboardEvent.KEY_R){
                picasso.reset();
            }
            if (keyboardEvent.getKey() == keyboardEvent.KEY_S){
                try {
                    picasso.save();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            if (keyboardEvent.getKey() == keyboardEvent.KEY_L){
                //picasso.load();
            }

        }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}
}
