package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Gameplay {
    private static final int width = 600;
    private static final int height = 700;
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage mainStage;
    public Stage menuStage;
    private ImageView platform;
    private ImageView ball;

    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;

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
        showBallInGame();
        showPlatformOnPane();
        createAnimations();
        gameStage.show();

    }

    public void showPlatformOnPane() {

        platform = new ImageView("sample/resources/paddleRed.png");
        platform.setLayoutX(width / 2);
        platform.setLayoutY(650);
        gamePane.getChildren().add(platform);

    }

    public void showBallInGame() {

        ImageView ball = new ImageView("sample/resources/ballGrey.png");
        ball.setLayoutX(width / 2);
        ball.setLayoutY(300);
        gamePane.getChildren().add(ball);

    }

    public void createGameBackground() {

        String BACKGROUND = "sample/resources/background.png";
        ImageView background = new ImageView(BACKGROUND);
        gamePane.getChildren().add(background);

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
                //createBallMove();

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
//    private void createBallMove(){
//
//        ball.setLayoutY(ball.getLayoutY() + 1);
//    }

}
