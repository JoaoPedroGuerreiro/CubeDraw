package org.codeforall.cubedraw;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.HashSet;

public class PlayerCube {
    private Rectangle cubeSprite;
    private Rectangle cubeDraw;

    String filePath = "save.txt";
    private HashSet<Rectangle> painted = new HashSet<>();


    public PlayerCube() {
        cubeSprite = new Rectangle(5, 5, 20, 20);
        cubeSprite.draw();
        cubeSprite.setColor(Color.BLUE);
        cubeSprite.fill();
    }

    public void moveUp() {
        if (cubeSprite.getY() - 20 >= 5) {
            cubeSprite.translate(0, -20);
        }
    }

    public void moveDown() {
        if (cubeSprite.getY() + 20 < 700) {
            cubeSprite.translate(0, 20);
        }
    }

    public void moveRight() {
        if (cubeSprite.getX() + 20 < 700) {
            cubeSprite.translate(20, 0);
        }
    }

    public void moveLeft() {
        if (cubeSprite.getX() - 20 >= 5) {
            cubeSprite.translate(-20, 0);
        }
    }

    public void draw() {
        cubeDraw = new Rectangle(cubeSprite.getX(), cubeSprite.getY(), 20, 20);
        painted.add(cubeDraw);
        //System.out.println(painted);
        cubeDraw.setColor(Color.BLACK);
        cubeDraw.fill();
    }

    public void delete() {

        for (Rectangle current : painted) {
            if (cubeSprite.getX() == current.getX() && cubeSprite.getY() == current.getY()) {
                current.delete();
                painted.remove(current);
                break;
            }
        }
    }

    public void reset() {
        for (Rectangle list : painted) {
            list.delete();
        }
    }

    public void save() throws IOException {

        try {
            FileWriter fWriter = new FileWriter(filePath);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            //try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath)) {

            bWriter.write(String.valueOf(painted));
            bWriter.flush();
            bWriter.close();
        } catch (IOException e) {
            System.out.println("");
        }
    }
    public String load(){
        StringBuilder result = new StringBuilder();
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader("filePath"));
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                result.append(line);
            }
            bufferedReader.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        } finally {
            try{
                if (bufferedReader != null){
                    bufferedReader.close();
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return result.toString();
    }
}

