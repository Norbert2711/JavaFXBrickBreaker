package BrickBreaker;

import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class EndGame extends SubScene {


    public EndGame() {
        super(new AnchorPane(), 600, 700);
        String SUBSCENE_IMAGE = "BrickBreaker/resources/GameOverGif.gif";
        BackgroundImage backgroundImage = new BackgroundImage(new Image(SUBSCENE_IMAGE, 600, 400, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(backgroundImage));
        setLayoutX(0);
        setLayoutY(-400);

    }

}
