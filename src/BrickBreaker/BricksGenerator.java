package BrickBreaker;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class BricksGenerator extends Rectangle {

    public int[][] map;
    public int brickWidth;
    public int brickHeight;
    public Rectangle brick;
    private AnchorPane gamePane;

    public BricksGenerator(int row, int column) {
        map = new int[row][column];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
            }
        }

        brickWidth = 540 / column;
        brickHeight = 150 / row;

    }

    public void drawBricks(){

        Random number = new Random(30);

        Image brickBlue = new Image("BrickBreaker/resources/element_blue_rectangle_glossy.png");
        Image brickGreen = new Image("BrickBreaker/resources/element_green_rectangle_glossy.png");
        Image brickGrey = new Image("BrickBreaker/resources/element_grey_rectangle_glossy.png");
        Image brickPurple = new Image("BrickBreaker/resources/element_purple_rectangle_glossy.png");
        Image brickYellow = new Image("BrickBreaker/resources/element_red_rectangle_glossy.png");
        Image brickRed = new Image("BrickBreaker/resources/element_yellow_rectangle_glossy.png");


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if(map[i][j] > 0 ){

                    //brick = new Rectangle(j * brickWidth +80, i * brickHeight + 50, brickWidth,brickHeight);

                    if(number.nextInt() > 5) {
                        brick = new Rectangle(j * brickWidth +80, i * brickHeight + 50, brickWidth,brickHeight);
                        brick.setFill(new ImagePattern(brickBlue));
                    }
                    else if(number.nextInt() > 10) {
                        brick = new Rectangle(j * brickWidth +80, i * brickHeight + 50, brickWidth,brickHeight);
                        brick.setFill(new ImagePattern(brickGreen));
                    }
                    else if(number.nextInt() > 15) {
                        brick = new Rectangle(j * brickWidth +80, i * brickHeight + 50, brickWidth,brickHeight);
                        brick.setFill(new ImagePattern(brickGrey));
                    }
                    else if(number.nextInt() > 20) {
                        brick = new Rectangle(j * brickWidth +80, i * brickHeight + 50, brickWidth,brickHeight);
                        brick.setFill(new ImagePattern(brickPurple));
                    }
                    else if(number.nextInt() > 25) {
                        brick = new Rectangle(j * brickWidth +80, i * brickHeight + 50, brickWidth,brickHeight);
                        brick.setFill(new ImagePattern(brickYellow));
                    }
                    if (number.nextInt() > 30) {
                        brick = new Rectangle(j * brickWidth +80, i * brickHeight + 50, brickWidth,brickHeight);
                        brick.setFill(new ImagePattern(brickRed));
                    }


                }

            }
        }
    }

}
