package sample;

import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class Main extends Application {

    private static final int HEIGHT = 700;
    private static final int WIDTH = 600;
    private AnchorPane mainPane;
    private Stage stage;
    private static final String BACKGROUND = "sample/resources/brickBackground.png";
    private static final String FONT = "sample/resources/kenvector_future.ttf";
    private GameSubscene startSubscene;
    private GameSubscene helpSubscene;
    private GameSubscene plaftormChoser;
    private GameSubscene sceneToHide;
    private MediaPlayer mediaPlayer;

    public Main() {

        mainPane = new AnchorPane();
        Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Break Breaker");
        createBackground();
        addLogo();
        createCursor();
        stage.show();
        addAllButtons();
        createSubscene();

    }

    @Override
    public void start(Stage stage) throws Exception {
        //music();
    }

    private void createBackground() {

        Image image = new Image(BACKGROUND);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(backgroundImage));

    }

    private void addAllButtons() {

        addStartButton();
        addHelpButton();
        addExitButton();
    }

    private void addLogo() {

        ImageView logo = new ImageView("/sample/resources/logoBrick.png");
        logo.setLayoutY(378);
        logo.setLayoutX(90);
        logo.setRotate(-15);
        mainPane.getChildren().add(logo);

    }

    private void createCursor() {
        Image cursor = new Image("sample/resources/cursorBall.png");
        mainPane.setCursor(new ImageCursor(cursor));
    }

    private void addStartButton() {
        GameButtons gameButtonStart = new GameButtons("START");
        gameButtonStart.setLayoutX(100);
        gameButtonStart.setLayoutY(300);
        gameButtonStart.setOnMouseEntered(mouseEvent -> gameButtonStart.setEffect(new SepiaTone()));
        gameButtonStart.setOnMouseExited(mouseEvent -> gameButtonStart.setEffect(null));
        gameButtonStart.setOnMouseClicked(mouseEvent -> gameButtonStart.setEffect(new Bloom()));

        gameButtonStart.setOnAction(actionEvent -> {
            Gameplay gameplay = new Gameplay();
            gameplay.createNewGameAfterClickPlay(stage);
        });

        mainPane.getChildren().add(gameButtonStart);

    }

    private void addHelpButton() {
        GameButtons gameHelpButton = new GameButtons("HELP");
        gameHelpButton.getEffect();
        gameHelpButton.setLayoutX(300);
        gameHelpButton.setLayoutY(300);
        gameHelpButton.setOnMouseEntered(mouseEvent -> gameHelpButton.setEffect(new SepiaTone()));
        gameHelpButton.setOnMouseExited(mouseEvent -> gameHelpButton.setEffect(null));
        gameHelpButton.setOnMouseClicked(mouseEvent -> gameHelpButton.setEffect(new Bloom()));
        gameHelpButton.setOnMouseClicked(mouseEvent -> showSubscene(helpSubscene));
        mainPane.getChildren().add(gameHelpButton);
    }

    private void createHelpScene() {

        helpSubscene = new GameSubscene();
        mainPane.getChildren().add(helpSubscene);
        TextLabel helpLabel = new TextLabel("Control is simple!" + "\n" + " Use arrow keys" + "\n" + " <--- LEFT" + "\n" +
                " and " + "\n" + " RIGHT ---> " + "\n" + "on your keyboard");
        helpLabel.setLayoutX(110);
        helpLabel.setLayoutY(25);

        String CONTROL_EFFECT = "sample/resources/arrows.gif";
        ImageView arrows = new ImageView(CONTROL_EFFECT);
        arrows.setLayoutX(350);
        arrows.setLayoutY(250);

        helpSubscene.getPane().getChildren().add(arrows);
        helpSubscene.getPane().getChildren().add(helpLabel);

    }


    private void addExitButton() {
        GameButtons gameExitButton = new GameButtons("EXIT");
        gameExitButton.getEffect();
        gameExitButton.setLayoutX(195);
        gameExitButton.setLayoutY(355);
        gameExitButton.setOnMouseEntered(mouseEvent -> gameExitButton.setEffect(new SepiaTone()));
        gameExitButton.setOnMouseExited(mouseEvent -> gameExitButton.setEffect(null));
        gameExitButton.setOnMouseClicked(mouseEvent -> gameExitButton.setEffect(new Bloom()));
        gameExitButton.setOnMouseClicked(mouseEvent -> stage.close());
        mainPane.getChildren().add(gameExitButton);
    }


    private void createSubscene() {

        helpSubscene = new GameSubscene();
        mainPane.getChildren().add(helpSubscene);
        createHelpScene();

        startSubscene = new GameSubscene();
        mainPane.getChildren().add(startSubscene);


    }

    private void showSubscene(GameSubscene subscene) {

        if (sceneToHide != null) {
            sceneToHide.moveSubscene();

        }

        subscene.moveSubscene();
        sceneToHide = subscene;

    }

//    public void music() {
//
//        String music = "music.mp3";
//        Media media = new Media(Paths.get(music).toUri().toString());
//        mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.play();
//
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
