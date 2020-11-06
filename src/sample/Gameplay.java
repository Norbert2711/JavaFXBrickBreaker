package sample;

import javafx.animation.AnimationTimer;
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
    private Circle ball;
    private boolean gameStarted;
    private int ballXdir = -2;
    private int ballYdir = -4;
    private int ballPosX = 120;
    private int ballPosY = 350;
    private int platformPossX = 300;
    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;

    private ImageView[] green;
    private ImageView[] grey;
    private ImageView[] purple;
    private ImageView[] yellow;
    private ImageView[] red;
    public Random choseBrickColor;


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


    }

    public void showPlatformOnPane() {

        platform = new Rectangle(100, 20);
        platform.setX(platform.getX());
        platform.setY(platform.getY() + 650);
        Image platformImage = new Image("sample/resources/paddleRed.png");
        platform.setFill(new ImagePattern(platformImage));
        gamePane.getChildren().add(platform);

    }

    public void showBallInGameAndMove() {
        ball = new Circle(12);
        Image ballImage = new Image("sample/resources/ballGrey.png");
        ball.setFill(new ImagePattern(ballImage));
        ball.setCenterX(ball.getLayoutX());
        ball.setCenterY(ball.getLayoutY());
        gamePane.getChildren().add(ball);
        gameStarted = true;
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

        AnimationTimer gameTimer = new AnimationTimer() {

            @Override
            public void handle(long now) {

                createPlatformMove();
                //showBallInGameAndMove();
                createBallMove();
                createBricksInGame();
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

        if (gameStarted) {

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

        }

        if (ball.getLayoutY() > height) {
            gameStage.close();
            menuStage.show();
        }

    }

    private void createBricksInGame() {

        ArrayList<Rectangle> rectangleArrayList = new ArrayList<>();

        String brickBlue = "sample/resources/element_blue_rectangle_glossy.png";
        String brickGrey = "sample/resources/element_grey_rectangle_glossy.png";
        String brickPurple = "sample/resources/element_purple_rectangle_glossy.png";
        String brickYellow = "sample/resources/element_red_rectangle_glossy.png";
        String brickRed = "sample/resources/element_yellow_rectangle_glossy.png";

        if (gameStarted) {
            Rectangle blue1 = new Rectangle(80, 40);
            Image blueBrick = new Image(brickBlue);
            blue1.setFill(new ImagePattern(blueBrick));
            blue1.setX(blue1.getX() + 100);
            blue1.setY(blue1.getY() + 30);
            //rectangleArrayList.add(blue1);

            if (ball.getBoundsInParent().intersects(blue1.getBoundsInParent())) {
                gamePane.getChildren().removeAll(blue1);
                ballYdir = -ballYdir;
                // rectangleArrayList.remove(blue1);

            }

            Rectangle blue2 = new Rectangle(80, 40);
            blue2.setFill(new ImagePattern(blueBrick));
            blue2.setX(blue2.getX() + 180);
            blue2.setY(blue2.getY() + 30);
            // rectangleArrayList.add(blue2);
            gamePane.getChildren().add(blue2);

            if (ball.getBoundsInParent().intersects(blue2.getBoundsInParent())) {
                gamePane.getChildren().remove(blue2);
                ballYdir = -ballYdir;

                // rectangleArrayList.remove(blue2);
            }

            Rectangle blue3 = new Rectangle(80, 40);
            blue3.setFill(new ImagePattern(blueBrick));
            blue3.setX(blue3.getX() + 260);
            blue3.setY(blue3.getY() + 30);
            //rectangleArrayList.add(blue3);
            gamePane.getChildren().add(blue3);

            if (ball.getBoundsInParent().intersects(blue3.getBoundsInParent())) {
                gamePane.getChildren().remove(blue3);
                ballYdir = -ballYdir;

                // rectangleArrayList.remove(blue3);
            }

            Rectangle blue4 = new Rectangle(80, 40);
            blue4.setFill(new ImagePattern(blueBrick));
            blue4.setX(blue4.getX() + 340);
            blue4.setY(blue4.getY() + 30);
            //rectangleArrayList.add(blue4);
            gamePane.getChildren().add(blue4);

            if (ball.getBoundsInParent().intersects(blue4.getBoundsInParent())) {
                gamePane.getChildren().remove(blue4);
                ballYdir = -ballYdir;

                // rectangleArrayList.remove(blue4);
            }

            Rectangle blue5 = new Rectangle(80, 40);
            blue5.setFill(new ImagePattern(blueBrick));
            blue5.setX(blue5.getX() + 420);
            blue5.setY(blue5.getY() + 30);
            //rectangleArrayList.add(blue5);
            gamePane.getChildren().add(blue5);

            if (ball.getBoundsInParent().intersects(blue5.getBoundsInParent())) {
                gamePane.getChildren().remove(blue5);
                ballYdir = -ballYdir;

                // rectangleArrayList.remove(blue5);
            }

//        if(rectangleArrayList.size() == 0){
//            gameStage.close();
//        }


        }
    }
}
