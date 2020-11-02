package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class GameSubscene extends SubScene {

    private boolean isHidden = true;

    public GameSubscene() {

        super(new AnchorPane(), 600, 400);

        String SUBSCENE_IMAGE = "sample/resources/subscene.jpg";
        BackgroundImage backgroundImage = new BackgroundImage(new Image(SUBSCENE_IMAGE, 600, 400, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        AnchorPane root2 = (AnchorPane) this.getRoot();

        root2.setBackground(new Background(backgroundImage));

        setLayoutX(0);
        setLayoutY(-400);

    }

    public void moveSubscene() {

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(0.2));
        translateTransition.setNode(this);

        if (isHidden) {
            translateTransition.setToY(295);
            isHidden = false;

        } else {
            translateTransition.setToY(0);
            isHidden = false;

        }

        translateTransition.play();

    }

    public AnchorPane getPane() {
        return (AnchorPane) getRoot();
    }


}
