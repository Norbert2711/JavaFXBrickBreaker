package sample;


import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;

public class GameButtons extends Button {

    public GameButtons(String text) {

        setText(text);
        setButtonsFont();
        setPrefHeight(49);
        setPrefWidth(190);
        setButtonStyleAfterPress();

    }

    public void setButtonsFont() {

        String FONT_PAHT = "/sample/resources/kenvector_future.ttf";
        setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PAHT), 23));
    }

    private void setButtonStyleAfterPress() {

        DropShadow dropShadow = new DropShadow();
        String BUTTON_STYLE = " -fx-background-color: transparent; -fx-background-image: url('/sample/resources/buttonSelected.png');";
        setStyle(BUTTON_STYLE);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
        setEffect(dropShadow);

    }

}
