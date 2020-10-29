package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    private static final int HEIGHT = 700;
    private static final int WIDTH = 600;
    private AnchorPane mainPane;
    private Stage stage;
    private static final String BACKGROUND = "sample/resources/brickBackground.png";
    private static final String FONT = "sample/resources/kenvector_future.ttf";
    private GameSubscene startSubscene;
    private GameSubscene helpSubscene;
    private GameSubscene exitSubscene;
    private List<GameButtons> gameButtonsList;

    public Main() {

        mainPane = new AnchorPane();
        Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Break Breaker");
        createBackground();
        addLogo();
        gameButtonsList = new ArrayList<>();
        stage.show();
        addAllButtons();
    }

    @Override
    public void start(Stage stage) throws Exception {

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
        logo.setLayoutY(50);
        logo.setLayoutY(50);
        mainPane.getChildren().add(logo);

    }

    private void addStartButton() {
        GameButtons gameButtonStart = new GameButtons("START");
        gameButtonStart.setLayoutX(100);
        gameButtonStart.setLayoutY(300);
        gameButtonStart.setOnMouseEntered(mouseEvent -> gameButtonStart.setEffect(new SepiaTone()));
        gameButtonStart.setOnMouseExited(mouseEvent -> gameButtonStart.setEffect(null));
        mainPane.getChildren().add(gameButtonStart);

    }

    private void addHelpButton() {
        GameButtons gameHelpButton = new GameButtons("HELP");
        gameHelpButton.getEffect();
        gameHelpButton.setLayoutX(300);
        gameHelpButton.setLayoutY(300);
        gameHelpButton.setOnMouseEntered(mouseEvent -> gameHelpButton.setEffect(new SepiaTone()));
        gameHelpButton.setOnMouseExited(mouseEvent -> gameHelpButton.setEffect(null));
        mainPane.getChildren().add(gameHelpButton);
    }

    private void addExitButton() {
        GameButtons gameExitButton = new GameButtons("EXIT");
        gameExitButton.getEffect();
        gameExitButton.setLayoutX(195);
        gameExitButton.setLayoutY(355);
        gameExitButton.setOnMouseEntered(mouseEvent -> gameExitButton.setEffect(new SepiaTone()));
        gameExitButton.setOnMouseExited(mouseEvent -> gameExitButton.setEffect(null));
        gameExitButton.setOnMouseClicked(mouseEvent ->
                stage.close());
        mainPane.getChildren().add(gameExitButton);
    }


    private void createSubscene() {


    }


    public static void main(String[] args) {
        launch(args);
    }
}
