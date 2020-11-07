package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Gameplay {

    private static final int width = 600; //x
    private static final int height = 700; //y
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage mainStage;
    public Stage menuStage;
    private Rectangle platform;
    private Rectangle ball;
    private int ballXdir = -4;
    private int ballYdir = -5;
    private int ballPosX = 120;
    private int ballPosY = 350;
    private int platformPossX = 300;
    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;
    private AnimationTimer gameTimer;

    private Rectangle blue1;
    private Rectangle blue2;
    private Rectangle blue3;
    private Rectangle blue4;
    private Rectangle blue5;

    private Rectangle grey1;
    private Rectangle grey2;
    private Rectangle grey3;
    private Rectangle grey4;
    private Rectangle grey5;

    private Rectangle purple1;
    private Rectangle purple2;
    private Rectangle purple3;
    private Rectangle purple4;
    private Rectangle purple5;

    private Rectangle yellow1;
    private Rectangle yellow2;
    private Rectangle yellow3;
    private Rectangle yellow4;
    private Rectangle yellow5;

    private Rectangle red1;
    private Rectangle red2;
    private Rectangle red3;
    private Rectangle red4;
    private Rectangle red5;

    public Gameplay() {

        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, width, height);  //szer/wys
        gameStage = new Stage();
        gameStage.getScene();
        gameStage.setTitle("Let's play!");
        gameStage.setScene(gameScene);
        createControlKeys();
        createGameBackground();

    }

    public void createNewGameAfterClickPlay(Stage menuStage) {

        this.menuStage = menuStage; //wymagane do poruszania sie platformy
        this.menuStage.hide();      // wymagane do poruszania sie platformy
        gameStage.show();
        showPlatformOnPane();
        showBallInGameAndMove();
        createAnimations();
        showBlueBricksInGame();

    }

    public void showPlatformOnPane() {

        platform = new Rectangle(100, 20);
        platform.relocate(platform.getX() + 200, platform.getY() + 650);
        Image platformImage = new Image("sample/resources/paddleRed.png");
        platform.setFill(new ImagePattern(platformImage));
        gamePane.getChildren().add(platform);

    }

    public void showBallInGameAndMove() {
        ball = new Rectangle(20, 20);
        Image ballImage = new Image("sample/resources/ballGrey.png");
        ball.setFill(new ImagePattern(ballImage));

        ball.setY(ball.getY());
        ball.relocate(ball.getX(), 600);
        gamePane.getChildren().add(ball);
        boolean gameStarted = true;
        System.out.println("start");
    }

    public void createGameBackground() {

        Image background = new Image("sample/resources/background.png", 600, 700, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, null);
        gamePane.setBackground(new Background(backgroundImage));

    }

    public void createControlKeys() {

        gameScene.setOnKeyPressed(keyEvent -> {

            if (keyEvent.getCode() == KeyCode.LEFT) {
                isLeftKeyPressed = true;

            } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                isRightKeyPressed = true;

            }
        });

        gameScene.setOnKeyReleased(keyEvent -> {

            if (keyEvent.getCode() == KeyCode.LEFT) {
                isLeftKeyPressed = false;

            } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                isRightKeyPressed = false;

            }
        });

    }

    public void createAnimations() {

        gameTimer = new AnimationTimer() {

            @Override
            public void handle(long now) {

                createPlatformMove();
                //showBallInGameAndMove();
                createBallMove();
                removeBrick();
            }
        };

        gameTimer.start();

    }

    public void createPlatformMove() {

        if (isLeftKeyPressed && !isRightKeyPressed) {

            if (platform.getLayoutX() > 2) {
                platform.setLayoutX(platform.getLayoutX() - 5);
            }

        }

        if (isRightKeyPressed && !isLeftKeyPressed) {

            if (platform.getLayoutX() < 495) {
                platform.setLayoutX(platform.getLayoutX() + 5);
            }

        }

    }

    public void createBallMove() {

        if (platform.getBoundsInParent().intersects(ball.getBoundsInParent())) {
            ballYdir = -ballYdir;

        }

        ball.setLayoutX(ball.getLayoutX() + ballXdir);
        ball.setLayoutY(ball.getLayoutY() + ballYdir);

        if (ball.getLayoutX() < 0) {
            ballXdir = -ballXdir;
        }

        if (ball.getLayoutY() < 0) {
            ballYdir = -ballYdir;
        }

        if (ball.getLayoutX() > 595) {
            ballXdir = -ballXdir;
        }

        if (ball.getLayoutY() > height) {
            gameTimer.stop();
            gameStage.close();
            menuStage.close();
            menuStage.show();
        }

    }

    private void showBlueBricksInGame() {

        ArrayList<Rectangle> rectangleArrayList = new ArrayList<>();

        String brickBlue = "sample/resources/element_blue_rectangle_glossy.png";
        Image blueBrick = new Image(brickBlue);

        blue1 = new Rectangle(80, 40);
        blue1.setFill(new ImagePattern(blueBrick));
        blue1.setX(blue1.getX() + 100);
        blue1.setY(blue1.getY() + 30);

        gamePane.getChildren().add(blue1);

        blue2 = new Rectangle(80, 40);
        blue2.setFill(new ImagePattern(blueBrick));
        blue2.setX(blue2.getX() + 180);
        blue2.setY(blue2.getY() + 30);

        gamePane.getChildren().add(blue2);

        blue3 = new Rectangle(80, 40);
        blue3.setFill(new ImagePattern(blueBrick));
        blue3.setX(blue3.getX() + 260);
        blue3.setY(blue3.getY() + 30);

        gamePane.getChildren().add(blue3);

        blue4 = new Rectangle(80, 40);
        blue4.setFill(new ImagePattern(blueBrick));
        blue4.setX(blue4.getX() + 340);
        blue4.setY(blue4.getY() + 30);

        gamePane.getChildren().add(blue4);

        blue5 = new Rectangle(80, 40);
        blue5.setFill(new ImagePattern(blueBrick));
        blue5.setX(blue5.getX() + 420);
        blue5.setY(blue5.getY() + 30);

        gamePane.getChildren().add(blue5);

        String brickGrey = "sample/resources/element_grey_rectangle_glossy.png";
        Image greyBrick = new Image(brickGrey);

        grey1 = new Rectangle(80, 40);
        grey1.setFill(new ImagePattern(greyBrick));
        grey1.setX(grey1.getX() + 120);
        grey1.setY(grey1.getY() + 70);

        gamePane.getChildren().add(grey1);

        grey2 = new Rectangle(80, 40);
        grey2.setFill(new ImagePattern(greyBrick));
        grey2.setX(grey2.getX() + 200);
        grey2.setY(grey2.getY() + 70);

        gamePane.getChildren().add(grey2);

        grey3 = new Rectangle(80, 40);
        grey3.setFill(new ImagePattern(greyBrick));
        grey3.setX(grey3.getX() + 280);
        grey3.setY(grey3.getY() + 70);

        gamePane.getChildren().add(grey3);

        grey4 = new Rectangle(80, 40);
        grey4.setFill(new ImagePattern(greyBrick));
        grey4.setX(grey4.getX() + 360);
        grey4.setY(grey4.getY() + 70);

        gamePane.getChildren().add(grey4);

        grey5 = new Rectangle(80, 40);
        grey5.setFill(new ImagePattern(greyBrick));
        grey5.setX(grey5.getX() + 440);
        grey5.setY(grey5.getY() + 70);

        gamePane.getChildren().add(grey5);

        String brickPurple = "sample/resources/element_purple_rectangle_glossy.png";
        Image purpleBrick = new Image(brickPurple);

        purple1 = new Rectangle(80, 40);
        purple1.setFill(new ImagePattern(purpleBrick));
        purple1.setX(purple1.getX() + 100);
        purple1.setY(purple1.getY() + 110);

        gamePane.getChildren().add(purple1);

        purple2 = new Rectangle(80, 40);
        purple2.setFill(new ImagePattern(purpleBrick));
        purple2.setX(purple2.getX() + 180);
        purple2.setY(purple2.getY() + 110);

        gamePane.getChildren().add(purple2);

        purple3 = new Rectangle(80, 40);
        purple3.setFill(new ImagePattern(purpleBrick));
        purple3.setX(purple3.getX() + 260);
        purple3.setY(purple3.getY() + 110);

        gamePane.getChildren().add(purple3);

        purple4 = new Rectangle(80, 40);
        purple4.setFill(new ImagePattern(purpleBrick));
        purple4.setX(purple4.getX() + 320);
        purple4.setY(purple4.getY() + 110);

        gamePane.getChildren().add(purple4);

        purple5 = new Rectangle(80, 40);
        purple5.setFill(new ImagePattern(purpleBrick));
        purple5.setX(purple5.getX() + 400);
        purple5.setY(purple5.getY() + 110);

        gamePane.getChildren().add(purple5);

        String brickYellow = "sample/resources/element_red_rectangle_glossy.png";
        Image yellowBrick = new Image(brickYellow);

        yellow1 = new Rectangle(80, 40);
        yellow1.setFill(new ImagePattern(yellowBrick));
        yellow1.setX(yellow1.getX() + 120);
        yellow1.setY(yellow1.getY() + 150);

        gamePane.getChildren().add(yellow1);

        yellow2 = new Rectangle(80, 40);
        yellow2.setFill(new ImagePattern(yellowBrick));
        yellow2.setX(yellow2.getX() + 200);
        yellow2.setY(yellow2.getY() + 150);

        gamePane.getChildren().add(yellow2);

        yellow3 = new Rectangle(80, 40);
        yellow3.setFill(new ImagePattern(yellowBrick));
        yellow3.setX(yellow3.getX() + 280);
        yellow3.setY(yellow3.getY() + 150);

        gamePane.getChildren().add(yellow3);

        yellow4 = new Rectangle(80, 40);
        yellow4.setFill(new ImagePattern(yellowBrick));
        yellow4.setX(yellow4.getX() + 360);
        yellow4.setY(yellow4.getY() + 150);

        gamePane.getChildren().add(yellow4);

        yellow5 = new Rectangle(80, 40);
        yellow5.setFill(new ImagePattern(yellowBrick));
        yellow5.setX(yellow5.getX() + 440);
        yellow5.setY(yellow5.getY() + 150);

        gamePane.getChildren().add(yellow5);

        String brickRed = "sample/resources/element_yellow_rectangle_glossy.png";
        Image redBrick = new Image(brickRed);

        red1 = new Rectangle(80, 40);
        red1.setFill(new ImagePattern(redBrick));
        red1.setX(red1.getX() + 100);
        red1.setY(red1.getY() + 190);

        gamePane.getChildren().add(red1);

        red2 = new Rectangle(80, 40);
        red2.setFill(new ImagePattern(redBrick));
        red2.setX(red2.getX() + 180);
        red2.setY(red2.getY() + 190);

        gamePane.getChildren().add(red2);

        red3 = new Rectangle(80, 40);
        red3.setFill(new ImagePattern(redBrick));
        red3.setX(red3.getX() + 260);
        red3.setY(red3.getY() + 190);

        gamePane.getChildren().add(red3);

        red4 = new Rectangle(80, 40);
        red4.setFill(new ImagePattern(redBrick));
        red4.setX(red4.getX() + 320);
        red4.setY(red4.getY() + 190);

        gamePane.getChildren().add(red4);

        red5 = new Rectangle(80, 40);
        red5.setFill(new ImagePattern(redBrick));
        red5.setX(red5.getX() + 400);
        red5.setY(red5.getY() + 190);

        gamePane.getChildren().add(red5);

    }

    private void removeBrick() {

        //blue
        boolean showBrick = true;
        if (ball.getBoundsInParent().intersects(blue1.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(blue1);
            blue1.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(blue2.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(blue2);
            blue2.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(blue3.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(blue3);
            blue3.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(blue4.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(blue4);
            blue4.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(blue5.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(blue5);
            blue5.relocate(1000, 1000);

        }
        //grey
        if (ball.getBoundsInParent().intersects(grey1.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(grey1);
            grey1.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(grey2.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(grey2);
            grey2.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(grey3.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(grey3);
            grey3.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(grey4.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(grey4);
            grey4.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(grey5.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(grey5);
            grey5.relocate(1000, 1000);

        }

        //purple
        if (ball.getBoundsInParent().intersects(purple1.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(purple1);
            purple1.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(purple2.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(purple2);
            purple2.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(purple3.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(purple3);
            purple3.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(purple4.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(purple4);
            purple4.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(purple5.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(purple5);
            purple5.relocate(1000, 1000);

        }
        //yellow
        if (ball.getBoundsInParent().intersects(yellow1.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(yellow1);
            yellow1.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(yellow2.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(yellow2);
            yellow2.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(yellow3.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(yellow3);
            yellow3.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(yellow4.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(yellow4);
            yellow4.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(yellow5.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(yellow5);
            yellow5.relocate(1000, 1000);

        }
//        //red
        if (ball.getBoundsInParent().intersects(red1.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(red1);
            red1.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(red2.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(red2);
            red2.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(red3.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(red3);
            red3.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(red4.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(red4);
            red4.relocate(1000, 1000);

        }

        if (ball.getBoundsInParent().intersects(red5.getBoundsInParent())) {
            showBrick = false;
            ballYdir = -ballYdir;
            gamePane.getChildren().remove(red5);
            red5.relocate(1000, 1000);

        }
    }
}

