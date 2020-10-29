package sample;

import javafx.scene.Parent;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;

public class GameSubscene extends SubScene {


    public GameSubscene(Parent root, double width, double height) {
        super(root, width, height);
    }

    public GameSubscene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) {
        super(root, width, height, depthBuffer, antiAliasing);
    }
}
